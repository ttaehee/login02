package presentationLayer;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import businessLogicLayer.UserDAO;
import businessLogicLayer.UserVO;

public class FindUser extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doPost(req,res);
	}
	

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out=res.getWriter();
		
		String id=req.getParameter("id");
		
		//HttepSession default true = session 없으면 객체 생성 or 있으면 get 
		if(id==null) {
		    HttpSession session=req.getSession(true);
		
		    id=(String)session.getAttribute("id");
		    System.out.println("session에 저장된 id 유무 확인 : " +id);
		}
		
		UserVO userVO=new UserDAO().findUser(id);
		
		out.println("<html>");
		out.println("<head><title>내정보 보기</title></head>");
		out.println("<body>");
		
		out.println("<h2> 요청하신 회원정보</h2>");
		
		if(userVO != null) {
			out.println("<li>아이디:"+userVO.getId());
			out.println("<li>비밀번호:"+userVO.getPassword());
	
			out.println("<li>이름:"+userVO.getName());
			out.println("<li>성별:"+userVO.getGender());
			out.println("<li>생년월일:"+userVO.getBirth());
			out.println("<li>직업:"+userVO.getJob());
			out.println("<li>휴대폰:"+userVO.getCellPhone());
			//System.out.println(userVO.getCellPhone());
			out.println("<li>주소:"+userVO.getAddress());
		}else {
			out.println(id+"에 해당하는 data는 없습니다.");
		}
		
		out.println("<p><p><a href='addUser.html'>뒤로</a>");
	
		out.println("</body>");
		out.println("</html>");
		}

}
