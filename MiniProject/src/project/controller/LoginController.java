package project.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.MemberDAO;
import project.domain.Member;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	
    //Login Service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "";
		MemberDAO member = MemberDAO.getInstance();
			try {
//				if(member.login(request.getParameter("id"), request.getParameter("pwd"))) {
//					Member loginId = member.getMember(request.getParameter("email"));
//					request.getSession().setAttribute("loginId", loginId);
				Member m = member.getMember(request.getParameter("id"));
				if(m != null) {
					request.getSession().setAttribute("id", request.getParameter("id"));
				}else {
					url = "?msg=error";
				}
//			} 
//			catch (NoSuchAlgorithmException e) {
//				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
//		request.getRequestDispatcher("Domain/main.jsp").forward(request, response);
		response.sendRedirect("Domain/main.jsp"+url);
	}
}//end of LoginController