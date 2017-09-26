package project.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.Member;
import project.util.DBUtil;
import project.util.SHAUtil;

public class MemberDAO {
	
	private static MemberDAO member;
	
	public static MemberDAO getInstance() {
		if(member==null) {
			member = new MemberDAO();
		}
		return member;
	}
	private MemberDAO() {}
	
	//�쉶�썝媛��엯
	public int add(Member m) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			pstmt = con.prepareStatement("INSERT INTO member VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1,m.getMemberMail());
//			List<String> list = SHAUtil.encodePwd(m.getMemberPwd());
//			pstmt.setString(2,list.get(1));
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3,m.getMemberName());
			pstmt.setString(4,m.getMemberAddr());
			pstmt.setString(5,m.getMemberPhone());
			pstmt.setInt(6,0);//�씪諛섑쉶�썝 0 愿�由ъ옄 1
//			pstmt.setString(7, list.get(0));
			pstmt.setString(7, "11");
			result = pstmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
			throw new Exception("�쉶�썝 媛��엯�뿉 �떎�뙣�븯���뒿�땲�떎.");
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
		
	}
	
	//�쉶�썝�뀒�씠釉� 蹂닿린(愿�由ъ옄)
	public List<Member> table() throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			pstmt = con.prepareStatement("SELECT member_mail,member_name,member_addr,member_phone,member_level FROM member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Member(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	}
	
	//�쉶�썝 �궘�젣(愿�由ъ옄)
	public boolean delete(String memberMail) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			pstmt = con.prepareStatement("DELETE member WHERE member_mail LIKE ?@%");
			pstmt.setString(1, memberMail);
			result = pstmt.execute();
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	//�쉶�썝 濡쒓렇�씤
	public boolean login(String memberMail,String memberPwd) throws SQLException, NoSuchAlgorithmException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			pstmt = con.prepareStatement("SELECT member_name,member_pwd,member_salt FROM member WHERE member_mail LIKE ?");
			pstmt.setString(1, memberMail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = SHAUtil.decodePwd(rs, memberPwd);
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return result;
	}
	
	//�븘�씠�뵒�뿉 �빐�떦�븯�뒗 硫ㅻ쾭
	public Member getMember(String id) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member loginId = null;
		try{
			pstmt = con.prepareStatement("SELECT member_mail,member_name,member_addr,member_phone,member_level FROM member WHERE member_mail = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginId = new Member(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return loginId;
	}
	
	//�쉶�썝�젙蹂� �닔�젙
	public int update(Member m) throws Exception{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			pstmt = con.prepareStatement("UPDATE member SET member_pwd=?, member_addr=?, member_phone=?, member_salt=? WHERE member_mail=?");
			List<String> list = SHAUtil.encodePwd(m.getMemberPwd());
			pstmt.setString(1, list.get(1));
			pstmt.setString(2, m.getMemberAddr());
			pstmt.setString(3, m.getMemberPhone());
			pstmt.setString(4, list.get(0));
			pstmt.setString(5, m.getMemberMail());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("�쉶�썝 �젙蹂� �닔�젙�뿉 �떎�뙣�뻽�뒿�땲�떎.");
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
}//end of MemberDAO
