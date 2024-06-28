package com.kh.jdbc.day02.stmt_member.controller;

import java.util.List;

import com.kh.jdbc.day02.stmt_member.model.dao.MemberDAO;
import com.kh.jdbc.day02.stmt_member.model.vo.Member;

public class MemberController {
	private MemberDAO mDao;
	
	public MemberController() {
		this.mDao = new MemberDAO();
	}
	public void insertMember(Member member) {
		mDao.insertMember(member);
	}
	public List<Member> printAllMember() {
		// 여러개니까 List, 맴버니까 List<Member>
		List<Member> mList = mDao.selectList();
		// 호출한 곳에서 써야되니까 return, MemberView: 34
		return mList;
	}
	public Member printOneMember(String memberId) {
		// 한개니까 List없어도 됨, Member
		Member member = mDao.selectOne(memberId);
		return member;
	}
	public int removeMember(String memberId) {
		// DML의 결과는 int니까 int result
		// memberId 전달해야되니까 deleteMember(memberId)
		int result = mDao.deleteMember(memberId);
		return 0;
	}
	public int modifyMember(Member modifyInfo) {
		// DML의 결과는 int니까 int result
		// modifyInfo 전달해야되니까 updateMember(modifyInfo)
		int result = mDao.updateMember(modifyInfo);
		return result;
	}
	public boolean tryLogin(Member member) {
		Member logined = mDao.selectOne(member.getMemberId());
		return logined != null && logined.getMemberPw().equals(member.getMemberPw());
	}

}
