package project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.dao.MemberDAO;
import project.domain.Member;

@WebServlet("/update.do")
public class updateController extends HttpServlet {
	
    //Update Service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if(command.equals("mUpdate")) {
			update(request,response);
		}else if(command.equals("mDelete")) {
			delete(request,response);
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO member = MemberDAO.getInstance();
		Member m = (Member) request.getSession().getAttribute("id");
		m.setMemberPwd(request.getParameter("pwd"));
		m.setMemberAddr(request.getParameter("addr"));
		m.setMemberPhone(request.getParameter("phone"));
		try {
			member.update(m);
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		response.sendRedirect("Domain/main.jsp");
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MemberDAO.getInstance().delete(request.getParameter("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("test.jsp").forward(request, response);
	}
}//end of updateController
