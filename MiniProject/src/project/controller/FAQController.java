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

@WebServlet("/FAQ.do")
public class FAQController extends HttpServlet {
       
	//FAQ Service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if(command.equals("faqList")) {
			table(request,response);
		}else if(command.equals("faqDetail")) {
			faqNum(request,response);
		}
	}
	
	//FAQ Data List
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
		response.sendRedirect("FAQ/faq.jsp");
	}
	
	//FAQ DATA Detail
	private void faqNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FAQ faq = null;
		FAQDAO f = FAQDAO.getInstance();
		try {
			faq = f.detail(Integer.parseInt(request.getParameter("num")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(faq==null) {
			request.setAttribute("error", "오류가 발생했습니다.");
		}else {
			if(faq.getFaqNum()==Integer.parseInt(request.getParameter("num"))) {
				request.setAttribute("faqDetail", faq);
			}else {
				request.setAttribute("error", "오류가 발생했습니다.");
			}
		}
		request.getRequestDispatcher("faqDetail.jsp").forward(request, response);
	}
}//end of FAQController
