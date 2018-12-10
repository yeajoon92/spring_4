package com.cyj.s4;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cyj.board.BoardDTO;
import com.cyj.board.notice.NoticeDTO;
import com.cyj.board.notice.NoticeService;
import com.cyj.util.Pager;

@Controller
@RequestMapping(value="/notice/**") //다른 속성 없이 value만 있을 경우 value 생략 가능
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList")
	public String list(Model model, Pager pager) throws Exception {
		List<BoardDTO> ar = noticeService.list(pager);
		model.addAttribute("board", "notice");
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/boardList";
	}
	
	@RequestMapping(value="noticeSelect")
	public String select(Model model, int num) throws Exception {
		BoardDTO boardDTO = noticeService.select(num);
		model.addAttribute("board", "notice");
		model.addAttribute("boardDTO", boardDTO);
		System.out.println(boardDTO.getTitle());
		return "board/boardSelect";
	}
	
	//write form
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	//write process
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String write(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		int result = noticeService.insert(boardDTO);
		if(result<1) {
			rd.addFlashAttribute("msg", "Insert Fail");
		}
		//System.out.println("write : " + boardDTO.getTitle());
		return "redirect:./noticeList";
	}
	
	//update form
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String update(Model model) {
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}
	
	//update process
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public void update(BoardDTO boardDTO) {
		System.out.println("update : " + boardDTO.getTitle());
	}
	
	//delete process
	@RequestMapping(value="noticeDelete", method=RequestMethod.POST)
	public void delete(int num) {
		System.out.println("delete : " + num);
	}

}
