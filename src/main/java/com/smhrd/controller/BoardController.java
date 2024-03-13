package com.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.entity.Board;
import com.smhrd.entity.Reply;
import com.smhrd.mapper.BoardMapper;

@Controller // 해당클래스가 Controller가 되기위한 명시
public class BoardController {
	
	@Autowired
	private BoardMapper mapper; 
	// 추상/인터페이스는 객체를 생성할 수 없다 (추상메소드가 있기 때문에)
	// => 메소드가 구현되어야만 객체 생성이 가능(ex. 소화 기능(메소드)=>사람(객체)구현
	// 그런데 여기서는 객체를 받아옴 => 누군가 생성해둠 
	// 그렇다면 누가 만든 거지? => Spring이 실행되면 SqlSessionFactoryBean 클래스가 생성되고 얘가 Mapper를 찾아서 구현 ! 
	// 왜 추상메서드가 아니라 인터페이스로? => 다/중/상/속
	// => mapper가 여러개가 될 경우 다중상속이 가능하게 하도록 하기 위해서 interface로 구현 !! 
	
	@RequestMapping("/boardList.do") // Client가 요청한 URL 맵핑
	public String boaedList(Model model) {
		System.out.println("게시글 전체보기 기능");
		// 게시글 정보 - 번호, 제목, 내용, 작성자 , 작성일 , 조회수
		List<Board> list = mapper.boardList();
		
		model.addAttribute("list",list);
		return "boardList";
	}
	
	@RequestMapping("/boardContent.do")
	public String boardContent(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 상세보기 기능");
		
		// 조회수 올리는 기능
		mapper.boardCount(idx);
		Board vo = mapper.boardContent(idx);
		
		// 해당 게시글의 댓글 가져오기
		// 댓글의 boardnum == 게시글의 idx
		List<Reply> list = mapper.replyList(idx);
		
		
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		
		
		return "boardContent";
	}
	
	@RequestMapping("/boardForm.do")
	public String boardForm() {
		System.out.println("게시글 쓰기 페이지 이동 기능");
		
		return "boardForm";
	}
	
	@RequestMapping("/boardInsert.do")
	public String boardInsert(Board vo) {
		// Spring 내부 진행
		// Board vo = new Board(); 
		// String title = request.getParameter("title"); 
		// String content = request.getParameter("content"); 
		// String writer = request.getParameter("writer"); 
		// vo.setTitle(title);
		// vo.setContent(content);
		// vo.setWriter(writer);
		System.out.println("게시글 입력 기능");
		mapper.boardInsert(vo);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/boardDelete.do")
	public String boardDelete(@RequestParam("idx") int idx) {
		System.out.println("게시글 삭제 기능");
		mapper.boardDelete(idx);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/boardUpdateForm.do")
	public String boardUpdateForm(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 수정페이지 이동 기능");
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardUpdateForm";
	}
	
	@RequestMapping("/boardUpdate.do")
	public String boardUpdateForm(Board vo) {
		System.out.println("게시글 수정 기능");
		mapper.boardUpdate(vo);
		return "redirect:/boardContent.do?idx="+vo.getIdx();
	}
	
	@RequestMapping("/replyInsert.do")
	public String replyInsert(Reply vo) {
		System.out.println("댓글 작성 기능");
		mapper.replyInsert(vo);
		return "redirect:/boardContent.do?idx="+vo.getIdx();
	}
	
	
	
}
