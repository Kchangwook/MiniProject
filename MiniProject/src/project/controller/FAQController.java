package project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.FAQDAO;
import project.domain.FAQ;

@WebServlet("/FAQ")
public class FAQController extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if(command.equals("faqList")) {
			table(request,response);
		}
	}
	
	private void table(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FAQ> list  = null;
		try {
			list = FAQDAO.getInstance().table();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list==null) {
			request.setAttribute("error", "오류가 발생했습니다.");
		}else {
			request.setAttribute("faqList", list);
		}
		request.getRequestDispatcher("faq.jsp").forward(request, response);
	}
}//end of FAQController
