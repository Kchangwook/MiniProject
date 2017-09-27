package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.FAQ;
import project.domain.Station;
import project.parse.StationParse;
import project.util.DBUtil;

public class StationDAO {
	
	private static StationDAO station;
	private StationDAO() {}
	public static StationDAO getInstance() {
		if(station==null) {
			station = new StationDAO();
		}
		return station;
	}

	//Station Parse Data Insert
	public int add() throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		List<Station> list = null;
		pstmt = con.prepareStatement("INSERT INTO station VALUES(?,?,?,?,?,?,?,?,?,?)");
		list = new StationParse().parse();
		try {
		for (int i = 0; i < list.size(); i++) {
			pstmt.setInt(1, list.get(i).getStationNum());
			pstmt.setString(2, list.get(i).getStatingAddr());
			pstmt.setString(3, list.get(i).getStationCsnm());
			pstmt.setString(4, list.get(i).getStationCpnm());
			pstmt.setDouble(5, list.get(i).getStationLat());
			pstmt.setDouble(6, list.get(i).getStationLongi());
			pstmt.setInt(7, list.get(i).getStationCsid());
			pstmt.setInt(8, list.get(i).getStationCptp());
			pstmt.setInt(9, list.get(i).getStationCpstat());
			pstmt.setString(10, list.get(i).getStationStatUpdate());
			result = pstmt.executeUpdate();
		}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	//Station List
	public List<Station> table() throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Station> list = new ArrayList<Station>();
		try{
			pstmt = con.prepareStatement("SELECT * FROM station");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Station(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10)));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	}
	
	//Station Detail
	public Station Detail(int num) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Station station = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM station WHERE station_num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				station = new Station(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return station;
	}
}//end of StationDAO