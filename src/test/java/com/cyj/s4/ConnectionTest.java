package com.cyj.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectionTest extends AbstractTestCase {
	
	@Inject
	//private DriverManagerDataSource ds;
	private SqlSession sqlSession;
	
	@Test
	public void test() throws Exception{
		//assertNotNull(ds.getConnection());
		assertNotNull(sqlSession.getConnection());
	}
	
}
