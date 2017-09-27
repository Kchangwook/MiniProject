package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.FAQ;
import project.util.DBUtil;

public class FAQDAO {
	
	private static FAQDAO faq;
	private FAQDAO() {}
	public static FAQDAO getInstance() {
		if(faq==null) {
			faq = new FAQDAO();
		}
		return faq;
	}
	
	//FAQ List
	public List<FAQ> table() throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FAQ> list = new ArrayList<FAQ>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM faq");
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new FAQ(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	}
	
	//FAQ Detail
	public FAQ detail(int num) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FAQ faq = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM faq WHERE faq_num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				faq = new FAQ(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return faq;
	}
}//end of FAQDAO
