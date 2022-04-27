package businessLogicLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class UserDAO {

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void addUser(UserVO userVO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//findUser(findUserVO.getId());
			//if(findUserVO.isActive()) {
			//	System.out.println(findUserVO.getId()+"님은 이미 회원가입 되어있습니다.");
			//}else {
			
				InitialContext ic=new InitialContext();
				DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/ora");
	
				con=ds.getConnection();
					
				
					pstmt=con.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?,?,?,?)");
					pstmt.setString(1, userVO.getId());
					pstmt.setString(2, userVO.getPassword());
					pstmt.setString(3, userVO.getName());
					pstmt.setString(4, userVO.getGender());
					pstmt.setString(5, userVO.getBirth());
					pstmt.setString(6, userVO.getJob());
					pstmt.setString(7, userVO.getCellPhone());
					pstmt.setString(8, userVO.getAddress());
					
					rs=pstmt.executeQuery();
					userVO.setActive(true);
		
					System.out.println("데이터 insert 성공");
			//}
			
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패"+e.getMessage());
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e1) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e2) {}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e3) {}
			}
		}
	}
	
	public UserVO findUser(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserVO userVO=null;
		
		try {
			
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/ora");

			con=ds.getConnection();
			
			userVO=new UserVO();
			
			pstmt=con.prepareStatement("Select * FROM users WHERE id=?");
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				userVO.setActive(true);
				
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setName(rs.getString("name"));
				userVO.setGender(rs.getString("gender"));
				userVO.setBirth(rs.getString("birth"));
				userVO.setJob(rs.getString("job"));
				userVO.setCellPhone(rs.getString("cellphone"));
				userVO.setAddress(rs.getString("address"));
			}else {
				System.out.println("db에 "+userVO.getId() +"에 해당하는 자료가 없습니다.");
			}
			
			
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패"+e.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e1) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e2) {}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e3) {}
			}
		}
		return userVO;
	}
}
