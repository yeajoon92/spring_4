package com.cyj.s4;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.cyj.board.BoardDTO;
import com.cyj.board.notice.NoticeDAO;
import com.cyj.board.notice.NoticeDTO;
import com.cyj.util.Pager;

public class NoticeDAOTest extends AbstractTestCase {
	
	@Inject
	private NoticeDAO noticeDAO;
	private BoardDTO boardDTO;
	
	@Test
	public void listTest() {
		try {
			Pager pager = new Pager();
			List<BoardDTO> ar = noticeDAO.list(pager);
			assertNotNull(ar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void selectOneTest() {
		try {
			boardDTO = noticeDAO.select(1);
			System.out.println(boardDTO.getTitle());
			System.out.println(boardDTO.getWriter());
			System.out.println(boardDTO.getContents());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void insertTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("title");
		noticeDTO.setWriter("writer");
		noticeDTO.setContents("contents");
		int result;
		try {
			result = noticeDAO.insert(noticeDTO);
			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void deleteTest() {
		int result;
		try {
			result = noticeDAO.delete(8);
			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
