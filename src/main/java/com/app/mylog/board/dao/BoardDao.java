package com.app.mylog.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.app.mylog.board.vo.BoardVo;

public class BoardDao {
	
	// 게시글 작성
	public int writeBoard(SqlSession ss, BoardVo vo) {
		return ss.insert("SearchMapper.writeBoard", vo);
	}
	
	// 게시글 삭제
	public int deleteBoard (SqlSession ss, String no) {
		return ss.update("SearchMapper.deleteBoard", no);
	}
	
	// 게시글 수정
	public int editBoard(SqlSession ss, BoardVo vo) {
		return ss.update("SearchMapper.editBoard", vo);
	}
	
	// 게시글 최신 조회
	public List<BoardVo> recentBoardCheck(SqlSession ss) {
		return ss.selectList("SearchMapper.recentBoardCheck");
	}

}
