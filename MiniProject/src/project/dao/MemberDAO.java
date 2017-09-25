package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.Member;
import project.util.DBUtil;

public class MemberDAO {
	//회원가입
	public static int MemberJoin(Member m) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			pstmt = con.prepareStatement("INSERT INTO member VALUES(?,?,?,?,?,?,?");
			pstmt.setString(1,m.getMemberID());
			pstmt.setString(2,m.getMemberPwd());
			pstmt.setString(3,m.getMemberName());
			pstmt.setString(4,m.getMemberMail());
			pstmt.setString(5,m.getMemberAddr());
			pstmt.setString(6,m.getMemberPhone());
			pstmt.setInt(7,m.getMemberLevel());
			result = pstmt.executeUpdate();
		}catch (SQLException e){
			throw new Exception("회원 가입에 실패하였습니다.");
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
		
	}
	
	//회원테이블 보기(관리자)
	public static List<Member> MemberTable() throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		//Q1)id를 메일로 합치는건 어떤지..
		try {
			pstmt = con.prepareStatement("SELECT id,name,mail,addr,phone,level FROM station");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Member(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	}
	
	//회원 삭제(관리자)
	public static boolean MemberDelete(String id) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			pstmt = con.prepareStatement("DELETE member where id = ?");
			pstmt.setString(1, id);
			result = pstmt.execute();
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
}//end of MemberDAO
