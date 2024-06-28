package com.kh.jdbc.day01.stmt_member.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.stmt_member.model.vo.Member;

public class MemberDAO {
	// JDBC를 이용하여
	// Oracle DB에 접속하는 클래스
	// JDBC 코딩이 있어야 함.
	
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "BENQJDBC";
	private final String PASSWORD = "BENQJDBC";
	
	public Member selectOne(String memberId) {
		Member member = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn =
					DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt
				= conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM MEMBER_TBL WHERE MEMBER_ID='" + memberId+"'");
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPw(rset.getString("MEMBER_PW"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setAge(rset.getInt("AGE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setHobby(rset.getString("HOBBY"));
				member.setRegDate(rset.getDate("REG_DATE"));
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	
	public List<Member> selectList() {
		/*
		 * 1. 드라이버 등록
		 * 2. DBMS 연결 생성
		 * 3. Statement 생성
		 * 4. 쿼리문 전송
		 * 5. 결과값 받기
		 * 6. 자원해제
		 */
		// 1. 왜 mList에 member가 들어가나요?
		// 2. rset은 왜 mList에 못들어가나요?
		// 3. rset을 member로 어떻게 바꾸나요?
		// 3.1. Member 클래스에는 필드와 게터/세터 필요
		// 3.2. ResultSet의 getString, getInt, getDate() 필요
		List<Member> mList = new ArrayList<>();
		try {
			// 1.
			Class.forName(DRIVER_NAME);
			// 2.
			Connection conn
				= DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// 3.
			Statement stmt = conn.createStatement();
			// 4. / 5.
			String query = "SELECT * FROM MEMBER_TBL";
			ResultSet rset = stmt.executeQuery(query);
			// 후처리
			while(rset.next()) {
				// rsetToMember
				mList.add(rsetToMember(rset));
//				System.out.println("이름 : " + rset.getString("MEMBER_NAME"));
//				System.out.println("아이디 : " + rset.getString("MEMBER_ID"));
//				System.out.println("이메일 : " + rset.getString("EMAIL"));
//				System.out.println("나이 : " + rset.getInt("AGE"));
//				System.out.println("등록일 : " + rset.getDate("REG_DATE"));
			}
			// 6.
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
	
	public void insertMember(Member member) {
		/*
		 * 1. 드라이버 등록
		 * 2. DBMS 연결 생성
		 * 3. Statement 생성
		 * 4. 쿼리문 전송
		 * 5. 결과값 받기
		 * 6. 자원해제
		 * 
		 */
		try {
			// 1.
			Class.forName(DRIVER_NAME);
			// 2.
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// 3.
			Statement stmt = conn.createStatement();
			// 4.
			String query = "INSERT INTO MEMBER_TBL VALUES ('"+
					member.getMemberId()+"', '"+
					member.getMemberPw()+"', '"+
					member.getMemberName()+"', '"+
					member.getGender()+"', "+
					member.getAge()+", '"+
					member.getEmail()+"', '"+
					member.getPhone()+"', '"+
					member.getAddress()+"', '"+
					member.getHobby()+"', DEFAULT)";
			// 5.
			// ResultSet rset = stmt.executeQuery(query); // SELECT 할때만 ResultSet은 Select의 결과
			int result = stmt.executeUpdate(query);// DML의 경우 호출하는 메소드(INSERT, UPDATE, DELETE)
			// 후처리
			if(result > 0) {
				// 성공 메시지 출력
				System.out.println("데이터 등록 성공!");
				// commit;
			} else {
				// 실패 메시지 출력
				System.out.println("데이터 등록 실패!");
				// rollback;
			}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Member rsetToMember(ResultSet rset) throws SQLException {
		Member member = new Member();
		member.setMemberId(rset.getString("MEMBER_ID"));
		member.setMemberPw(rset.getString("MEMBER_PW"));
		member.setMemberName(rset.getString("MEMBER_NAME"));
		member.setGender(rset.getString("GENDER"));
		member.setAge(rset.getInt("AGE"));
		member.setEmail(rset.getString("EMAIL"));
		member.setPhone(rset.getString("PHONE"));
		member.setAddress(rset.getString("ADDRESS"));
		member.setHobby(rset.getString("HOBBY"));
		member.setRegDate(rset.getDate("REG_DATE"));
		return member;
	}
}
