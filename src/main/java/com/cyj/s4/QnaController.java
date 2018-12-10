package com.cyj.s4;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cyj.board.BoardDTO;
import com.cyj.board.qna.QnaDAO;
import com.cyj.board.qna.QnaDTO;
import com.cyj.board.qna.QnaService;
import com.cyj.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	//list
	@RequestMapping(value="qnaList")
	public String list(Model model, /*int curPage, String search, String kind*/ Pager pager) throws Exception {
		model.addAttribute("board", "qna");
		/*Pager pager = new Pager();
		pager.setCurPage(curPage);*/ //spring 필기 5번
		List<BoardDTO> ar = qnaService.list(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/boardList";
	}
	
	//select
	@RequestMapping(value="qnaSelect")
	public String select(Model model, int num, RedirectAttributes rd) throws Exception {
		model.addAttribute("board", "qna");
		BoardDTO boardDTO = qnaService.select(num);
		String path="";
		if(boardDTO != null) {
			path="board/boardSelect";
			model.addAttribute("DTO", boardDTO);
		}else {
			path="redirect:./qnaList";
			rd.addFlashAttribute("msg", "해당 글이 존재하지 않습니다.");
		}
		
		return path;
	}
	
	//write form
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	//write process
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		int result = qnaService.insert(boardDTO);
		if(result<1) {
			rd.addFlashAttribute("msg", "Write Fail");
		}
		//System.out.println("write : " + boardDTO.getTitle());
		return "redirect:./qnaList";
	}
	
	//update form
	@RequestMapping(value="qnaUpdate", method=RequestMethod.GET)
	public String update(Model model, int num) throws Exception {
		model.addAttribute("board", "qna");
		BoardDTO boardDTO = qnaService.select(num);
		model.addAttribute("dto", boardDTO);
		return "board/boardUpdate";
	}
	
	//update process
	@RequestMapping(value="qnaUpdate", method=RequestMethod.POST)
	public String update(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		int result = qnaService.update(boardDTO);
		if(result<1) {
			rd.addFlashAttribute("msg", "Update Fail");
		}
		//System.out.println("update : " + boardDTO.getTitle());
		return "redirect:./qnaSelect?num="+boardDTO.getNum();
	}
	
	//delete process
	@RequestMapping(value="qnaDelete", method=RequestMethod.POST)
	public String delete(int num, RedirectAttributes rd) throws Exception {
		int result = qnaService.delete(num);
		if(result<1) {
			rd.addFlashAttribute("msg", "Delete Fail");
		}
		//System.out.println("delete : " + num);
		return "redirect:./qnaList";
	}
	
	//reply form
	@RequestMapping(value="qnaReply", method=RequestMethod.GET)
	public String reply(Model model, int num) {
		model.addAttribute("board", "qna");
		model.addAttribute("num", num);
		return "board/boardReply";
	}
	
	//reply process
	@RequestMapping(value="qnaReply")
	public String reply(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.reply(qnaDTO);
		//System.out.println("reply : " + boardDTO.getTitle());
		return "redirect:./qnaSelect?num="+qnaDTO.getNum();
	}
	
}
