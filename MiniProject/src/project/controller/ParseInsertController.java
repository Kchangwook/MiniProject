package project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.StationDAO;

@WebServlet("/parse.do")
public class ParseInsertController extends HttpServlet {
	
	//Parse Service - Parse Data and Insert Data
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				StationDAO.getInstance().add();
			} catch (Exception e) {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				e.printStackTrace();
				response.getWriter().println(e.getMessage());
			}
	}
}//end of ParseInsertController