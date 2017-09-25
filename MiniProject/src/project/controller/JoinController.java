package project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.MemberDAO;
import project.domain.Member;

@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int result = -1;
		try {
			result = MemberDAO.add(new Member(request.getParameter("memberID"),request.getParameter("memberPwd"),request.getParameter("memberName"),request.getParameter("memberAddr"),request.getParameter("memberPhone")));
			if(result==-1) {
				new Exception();
			}
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
