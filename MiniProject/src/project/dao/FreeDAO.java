package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.Free;
import project.util.DBUtil;

public class FreeDAO {
	
	private static FreeDAO free;
	
	public static FreeDAO getInstance() {
		if(free==null) {
			free = new FreeDAO();
		}
		return free;
	}
	
	private FreeDAO() {}
	
	//자유게시판 생성자료 데이터베이스에 추가
	public int add(Free f) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			pstmt = con.prepareStatement("INSERT INTO free VALUES(?,?,?,?,?)");
			pstmt.setInt(1, f.getFreeNum());
			pstmt.setString(2, f.getFreeTitle());
			pstmt.setString(3, f.getFreeContent());
			pstmt.setInt(4, f.getFreeNotice());
			pstmt.setString(5, f.getMemberMail());
			result = pstmt.executeUpdate();
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	//자유게시판 자료 리스트 보여주기
	public List<Free> table() throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Free> list = new ArrayList<Free>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM free");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Free(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	}
	
	//자유게시판 자료 삭제(게시자&관리자)
	public boolean delete(int num) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			pstmt = con.prepareStatement("DELETE free WHERE free_num = ?");
			pstmt.setInt(1, num);
			result = pstmt.execute();
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	//자유게시판 자료 수정
	public int update(Free f) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
			try {
				pstmt = con.prepareStatement("UPDATE free SET free_title=?,free_content=? WHERE free_num=?");
				pstmt.setString(1, f.getFreeTitle());
				pstmt.setString(2, f.getFreeContent());
				pstmt.setString(3, f.getMemberMail());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception("게시판 수정에 실패했습니다.");
			}finally {
				DBUtil.close(con, pstmt);
			}
		return result;
	}
}//end of FreeDAO