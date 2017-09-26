package project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.MemberDAO;
import project.domain.Member;

@WebServlet("/update.do")
public class updateController extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
		response.sendRedirect("index.jsp");
	}
	
}//end of updateController
