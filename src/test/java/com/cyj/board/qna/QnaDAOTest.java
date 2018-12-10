package com.cyj.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.cyj.board.BoardDTO;

public class QnaDAOTest {
	
	@Inject
	private QnaDAO qnaDAO;

	@Test
	public void list() {
		//List<BoardDTO> ar = qnaDAO.list(pager);
	}
	
	@Test
	public void select() {
		try {
			BoardDTO boardDTO = qnaDAO.select(1);
			assertNull(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		BoardDTO boardDTO = new BoardDTO();
		try {
			int result = qnaDAO.update(boardDTO);
			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void delete() {
		try {
			int result = qnaDAO.delete(5);
			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
