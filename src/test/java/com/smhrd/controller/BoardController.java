package com.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;



@Controller // 해당클래스가 Controller가 되기위한 명시
public class BoardController {
	
	
	@Autowired
	private BoardMapper mapper; 
	
   @RequestMapping("/boardList.do") // Client가 요청한 URL 맵핑
   public String boaedList(Model model) {
      System.out.println("게시글 전체보기 기능");
      // 게시글 정보 - 번호, 제목, 내용, 작성자 , 작성일 , 조회수
      List<Board> list = mapper.boardList();
      
      model.addAttribute("list", list);
      return "boardList";
   }
}