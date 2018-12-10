package com.cyj.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.cyj.board.BoardDTO;
import com.cyj.board.notice.NoticeDAO;

public class MyTest extends AbstractTestCase {
	
	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() {
		try {
			BoardDTO boardDTO = noticeDAO.select(3);
			assertNull(boardDTO);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		BoardDTO boardDTO = new BoardDTO();
		try {
			int result = noticeDAO.insert(boardDTO);
			assertEquals(1, result);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
