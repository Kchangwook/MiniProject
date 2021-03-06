package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.Car;
import project.util.DBUtil;

public class CarDAO {
	
	private static CarDAO car;
	private CarDAO() {}
	public static CarDAO getInstance() {
		if(car==null) {
			car = new CarDAO();
		}
		return car;
	}
	
	//Car List
	public List<Car> getCar() throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		Car car = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM car");
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Car(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7)));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	}
	
	//Car Detail
	public Car getCarNum(int num) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Car car = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM car WHERE car_num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				car = new Car(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return car;
	}
}//end of CarDAO