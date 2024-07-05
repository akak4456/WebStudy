package com.adele.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.adele.common.JDBCTemplate;
import com.adele.member.model.dao.MemberDAO;
import com.adele.member.model.vo.Member;

public class MemberService {

	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}
	
	public int insertMember(Member member) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = mDao.insertMember(conn, member);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member checkLogin(Member member) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Member mOne = null;
		
		conn = JDBCTemplate.getConnection();
		mOne = mDao.checkLogin(conn, member);
		return mOne;
	}

}
