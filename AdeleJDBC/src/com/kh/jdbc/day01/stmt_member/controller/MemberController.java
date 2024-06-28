package com.kh.jdbc.day01.stmt_member.controller;

import java.util.List;

import com.kh.jdbc.day01.stmt_member.model.dao.MemberDAO;
import com.kh.jdbc.day01.stmt_member.model.vo.Member;

public class MemberController {
	private MemberDAO mDao;
	
	public MemberController() {
		mDao = new MemberDAO();
	}
	
	public void insertMember(Member member) {
		mDao.insertMember(member);
	}
	
	public List<Member> listMember() {
		return mDao.selectList();
	}

	public Member getOneMember(String memberId) {
		return mDao.selectOne(memberId);
	}
}
