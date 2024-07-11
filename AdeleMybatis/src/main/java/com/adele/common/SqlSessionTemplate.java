package com.adele.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "mybatis-config.xml";
		/*
		 * 전에 겪었던 이슈
		 * 이클립스에서 resources 폴더를 classpath 에 추가하지 않으면
		 * Resources.getResourceAsStream 이 제대로 동작하지 않는 문제가 있었다.
		 * Project 우클릭 후 Build Path > Configure Build Path 로 이동후에
		 * source tab 으로 이동해서 resources 폴더를 추가하면 해결된다.
		 */
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sessionFactory = builder.build(is);
			session = sessionFactory.openSession(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
}
