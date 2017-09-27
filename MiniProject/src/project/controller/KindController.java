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

@WebServlet("/Kind.do")
public class KindController extends HttpServlet {
	
	//Kind[Car] Service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if(command.equals("getList")) {
			table(request,response);
		}else if(command.equals("carNum")) {
			detail(request,response);
		}
	}
	
	//Kind[Car] Data List
	private void table(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> list = null;
		try {
			list = CarDAO.getInstance().getCar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list==null) {
			request.setAttribute("error", "오류가 발생했습니다.");
		}else {
			request.setAttribute("carList", list);
		}
		request.getRequestDispatcher("Kind/kind.jsp").forward(request, response);
	}
	
	//Kind[Car] Detail
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		Car car = null;
		try {
			car = CarDAO.getInstance().getCarNum(Integer.parseInt(request.getParameter("num")));

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(car==null) {
			request.setAttribute("error", "오류가 발생했습니다.");
		}else {
			if(car.getCarNum()==Integer.parseInt(request.getParameter("num"))) {
				request.setAttribute("carDetail", car);
			}else {
				request.setAttribute("error", "오류가 발생했습니다.");
			}
		}
		request.getRequestDispatcher("Kind/carDetail.jsp").forward(request, response);
	}
}//end of KindController