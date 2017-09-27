package project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.StationDAO;
import project.domain.Station;

@WebServlet("/search.do")
public class SearchController extends HttpServlet {
	
	//Station[Search] Service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if(command.equals("getList")) {
			table(request,response);
		}else if(command.equals("searchNum")) {
			detail(request,response);
		}
	}
	
	//Station[Search] Data List
	private void table(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Station> list = null;
		try {
			list = StationDAO.getInstance().table();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list==null) {
			request.setAttribute("error", "오류가 발생했습니다.");
		}else {
			request.setAttribute("searchList", list);
		}
		response.sendRedirect("Search/search.jsp");
				
	}
	
	//Station[Search] Detail
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Station station = null;
		try {
			station = StationDAO.getInstance().Detail(Integer.parseInt(request.getParameter("num")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(station==null) {
			request.setAttribute("error", "오류가 발생했습니다.");
		}else {
			if(station.getStationNum()==Integer.parseInt(request.getParameter("num"))) {
				request.setAttribute("stationDetail", station);
			}else {
				request.setAttribute("error", "오류가 발생했습니다.");
			}
		}
		request.getRequestDispatcher("Search/stationDetail.jsp").forward(request, response);
	}
}//end of SearchController