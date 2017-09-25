package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import project.domain.Station;
import project.parse.StationParse;
import project.util.DBUtil;

public class StationDAO {

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
	public static void main(String[] args) {
		try {
			int result = new StationDAO().add();
			if(result!=-1) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
