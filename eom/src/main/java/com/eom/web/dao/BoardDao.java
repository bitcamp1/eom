package com.eom.web.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.eom.web.vo.Board;
import com.eom.web.vo.Member;

public interface BoardDao {
	int insert(Board board);
	Board getDetail(int no);
	int update(Board board);
	int delete(Map<String,String> paramMap);
	Collection<Board> list();
}





