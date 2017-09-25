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

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				new StationDAO().add();
			} catch (Exception e) {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				e.printStackTrace();
				response.getWriter().println(e.getMessage());
			}
	}

}
