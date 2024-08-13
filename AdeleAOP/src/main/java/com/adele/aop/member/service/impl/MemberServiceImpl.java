package com.adele.aop.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adele.aop.member.service.MemberService;
import com.adele.aop.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberStore mStore;
}
