package com.adele.aop.member.store.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adele.aop.member.store.MemberStore;

@Repository
public class MemberStoreImpl implements MemberStore {
	@Autowired
	private SqlSession session;
}
