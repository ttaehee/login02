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
		
		//HttepSession default true = session ������ ��ü ���� or ������ get 
		if(id==null) {
		    HttpSession session=req.getSession(true);
		
		    id=(String)session.getAttribute("id");
		    System.out.println("session�� ����� id ���� Ȯ�� : " +id);
		}
		
		UserVO userVO=new UserDAO().findUser(id);
		
		out.println("<html>");
		out.println("<head><title>������ ����</title></head>");
		out.println("<body>");
		
		out.println("<h2> ��û�Ͻ� ȸ������</h2>");
		
		if(userVO != null) {
			out.println("<li>���̵�:"+userVO.getId());
			out.println("<li>��й�ȣ:"+userVO.getPassword());
	
			out.println("<li>�̸�:"+userVO.getName());
			out.println("<li>����:"+userVO.getGender());
			out.println("<li>�������:"+userVO.getBirth());
			out.println("<li>����:"+userVO.getJob());
			out.println("<li>�޴���:"+userVO.getCellPhone());
			//System.out.println(userVO.getCellPhone());
			out.println("<li>�ּ�:"+userVO.getAddress());
		}else {
			out.println(id+"�� �ش��ϴ� data�� �����ϴ�.");
		}
		
		out.println("<p><p><a href='addUser.html'>�ڷ�</a>");
	
		out.println("</body>");
		out.println("</html>");
		}

}
