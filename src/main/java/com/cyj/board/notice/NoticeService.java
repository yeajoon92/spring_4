package com.cyj.board.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cyj.board.BoardDTO;
import com.cyj.board.BoardService;
import com.cyj.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Inject
	private NoticeDAO noticeDAO;
	
	/*public NoticeService() { //used @Inject instead
		noticeDAO = new NoticeDAO();
	}*/
	
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		int totalCount = noticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		return noticeDAO.list(pager);
	}
	
	public BoardDTO select(int num) throws Exception {
		return noticeDAO.select(num);
	}
	
	public int insert(BoardDTO boardDTO) throws Exception {
		return noticeDAO.insert(boardDTO);
	}
	
	public int update(BoardDTO boardDTO) throws Exception {
		return noticeDAO.update(boardDTO);
	}
	
	public int delete(int num) throws Exception {
		return noticeDAO.delete(num);
	}
	
	
	/*public static void main(String[] args) { //??
		NoticeService noticeService = new NoticeService();
		noticeService.select(1);
	}
	
	//select
	public void select(int num) throws Exception {
		try {
			BoardDTO boardDTO = noticeDAO.select(num);
			System.out.println(boardDTO.getTitle());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}*/
	
}
