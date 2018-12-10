package com.cyj.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.board.BoardDTO;
import com.cyj.board.BoardService;
import com.cyj.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		int totalCount = qnaDAO.totalCount(pager);
		//row
		pager.makeRow();
		
		//paging
		pager.makePage(totalCount);
		
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		
		return qnaDAO.select(num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.insert(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		
		return qnaDAO.delete(num);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		//부모의 ref, step, depth
		BoardDTO parentDTO = qnaDAO.select(qnaDTO.getNum());
		
		/*QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle(boardDTO.getTitle());*/ //이렇게 안 하고 Controller에서 QnaDTO로 만들어서 가져옴
		
		QnaDTO pQnaDTO = (QnaDTO)parentDTO;
		
		qnaDAO.replyUpdate(pQnaDTO);
		
		qnaDTO.setRef(pQnaDTO.getRef());
		qnaDTO.setStep(pQnaDTO.getStep()+1);
		qnaDTO.setDepth(pQnaDTO.getDepth()+1);
		
		return qnaDAO.reply(qnaDTO);
	}

}
