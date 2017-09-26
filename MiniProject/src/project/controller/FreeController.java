package project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.FreeDAO;
import project.domain.Free;

@WebServlet("/free.do")
public class FreeController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String command = request.getParameter("command");
		if(command.equals("add")) {
			add(request,response);
		}else if(command.equals("list")) {
			list(request,response);
		}else if(command.equals("delete")) {
			delete(request,response);
		}else if(command.equals("update")) {
			update(request,response);
		}
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = -1;
			try {
				result = FreeDAO.getInstance().add(new Free(Integer.parseInt(request.getParameter("fNum")),request.getParameter("fTitle"),request.getParameter("fContent"),Integer.parseInt(request.getParameter("fNotice")),request.getParameter("id")));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(result==-1) {
				new Exception();
			}else {
				response.sendRedirect("freeList.jsp");
			}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Free> list = null;
		try {
			list = FreeDAO.getInstance().table();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list==null) {
			request.setAttribute("error", "오류가 발생했습니다.");
		}else {
			request.setAttribute("freeList", list);
		}
		request.getRequestDispatcher("freeList.jsp").forward(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;
		try {
			result = FreeDAO.getInstance().delete(Integer.parseInt(request.getParameter("fNum")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result==false) {
			request.setAttribute("error", "오류가 발생했습니다.");
		}else {
			request.setAttribute("freeDelete", result);
		}
		request.getRequestDispatcher("freeList.jsp").forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Free f = (Free) request.getSession().getAttribute("id");
		f.setFreeTitle(request.getParameter("fTitle"));
		f.setFreeContent(request.getParameter("fContent"));
		try {
			FreeDAO.getInstance().update(f);
		} catch (Exception e) {
			request.getSession().setAttribute("error", "오류가 발생했습니다.");
			e.printStackTrace();
			request.getRequestDispatcher("freeList.jsp").forward(request, response);
		}
	}
	
}
