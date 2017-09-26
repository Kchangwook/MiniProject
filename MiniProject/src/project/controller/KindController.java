package project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.CarDAO;
import project.domain.Car;

/**
 * Servlet implementation class KindController
 */
@WebServlet("/Kind.do")
public class KindController extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if(command.equals("getList")) {
			getList(request,response);
		}else if(command.equals("carNum")) {
			carNum(request,response);
		}
	}
	
	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> list = null;
		try {
			list = CarDAO.getCar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list==null) {
			request.setAttribute("error", "�삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎.");
		}else {
			request.setAttribute("carList", list);
		}
		request.getRequestDispatcher("Kind/kind.jsp").forward(request, response);
	}
	
	private void carNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Car car = null;
		try {
			car = CarDAO.getCarNum(Integer.parseInt(request.getParameter("num")));

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(car==null) {
			request.setAttribute("error", "�삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎.");
		}else {
			if(car.getCarNum()==Integer.parseInt(request.getParameter("num"))) {
				request.setAttribute("carDetail", car);
			}else {
				request.setAttribute("error", "�삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎.");
			}
		}
		request.getRequestDispatcher("carDetail.jsp").forward(request, response);
	}
}
