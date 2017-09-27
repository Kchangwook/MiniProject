package project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
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

		JSONObject jo = new JSONObject();
		Car car = null;
		try {
			car = CarDAO.getInstance().getCarNum(Integer.parseInt(request.getParameter("num")));

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(car==null) {
				jo.put("error", "오류가 발생했습니다.");
		}else {
				jo.put("car", car);
		}
		
		response.getWriter().println(jo);
	}
}//end of KindController