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
		request.setCharacterEncoding("EUC-KR");
		String pwd = request.getParameter("pwd");
		try {
			Member loginId = MemberDAO.getMember(request.getParameter("id"));
			if(loginId!=null&&loginId.getMemberPwd()==pwd) {
				request.getSession().setAttribute("id",loginId.getMemberMail());
				if(loginId.getMemberLevel()==0) {
					response.sendRedirect("main.jsp");
				}else {
					response.sendRedirect("admin.jsp");
				}
			}else {
				request.setAttribute("error","아이디/비밀번호가 일치하지 않습니다.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
