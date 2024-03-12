package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.entity.Board;

@Mapper
public interface BoardMapper {
	// MyBatis와 Spring 사이를 연결해 실행하는 Class 
	
	
	
	public List<Board> boardList();
	
	public Board boardContent(int idx);

	public void boardInsert(Board vo);
	
	public void boardDelete(int idx);
	
}
