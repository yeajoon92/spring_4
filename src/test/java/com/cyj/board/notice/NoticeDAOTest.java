package com.cyj.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cyj.board.BoardDTO;
import com.cyj.s4.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase {
	
	@Inject
	private NoticeDAO noticeDAO;
	
	@BeforeClass
	public static void start() {
		System.out.println("Start Test");
	}
	
	@AfterClass
	public static void finish() {
		System.out.println("Finish Test");
	}
	
	@Before
	public void before() {
		System.out.println("Before Test");
	}
	
	@After
	public void after() {
		System.out.println("After Test");
	}
	
	@Test
	public void listTest() {
		System.out.println("List Test");
		/*try {
			List<BoardDTO> ar = noticeDAO.list();
			assertNotEquals(0, ar.size());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	@Test
	public void selectTest() {
		try {
			BoardDTO boardDTO = noticeDAO.select(5);
			assertNotNull(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void insertTest() {
		/*BoardDTO boardDTO = new BoardDTO();
		try {
			int result = noticeDAO.insert(boardDTO);
			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		BoardDTO boardDTO = new BoardDTO();
		int result=0;
		try {
			result = noticeDAO.insert(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, result);
	}
	
	@Test
	public void updateTest() {
		BoardDTO boardDTO = new BoardDTO();
		try {
			int result = noticeDAO.update(boardDTO);
			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteTest() {
		try {
			int result = noticeDAO.delete(4);
			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
