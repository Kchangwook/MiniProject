package project.controller;

import java.io.IOException;
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
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO member = MemberDAO.getInstance();
			try {
//				if(member.login(request.getParameter("id"), request.getParameter("pwd"))) {
//					Member loginId = member.getMember(request.getParameter("email"));
//					request.getSession().setAttribute("loginId", loginId);
				Member m = member.getMember(request.getParameter("id"));
				if(m != null) {
					request.getSession().setAttribute("id", request.getParameter("id"));
				}else {
					request.setAttribute("error","�븘�씠�뵒/鍮꾨�踰덊샇媛� �씪移섑븯吏� �븡�뒿�땲�떎.");
				}
//			} 
//			catch (NoSuchAlgorithmException e) {
//				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher("Domain/main.jsp").forward(request, response);
	}

}
