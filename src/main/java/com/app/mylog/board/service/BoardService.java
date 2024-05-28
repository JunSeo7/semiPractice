package com.app.mylog.board.service;

import static com.kh.app.db.SqlSessionTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.app.mylog.board.dao.BoardDao;
import com.app.mylog.board.vo.BoardVo;

public class BoardService {
	
private final BoardDao dao;
	
	public BoardService() {
		dao = new BoardDao();
	}
	
	public int wrtieBoard(BoardVo vo) throws Exception {
		
		//Dao 호출
		SqlSession ss = getSqlSession();
		int result = dao.writeBoard(ss, vo);
		
		if(result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		
		return result;
		
	}
	
	public int deleteBoard(String no) throws Exception {
		
		//Dao 호출
		SqlSession ss = getSqlSession();
		
		int result = dao.deleteBoard(ss, no);
		
		if(result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}
	
	public int editBoard(BoardVo vo) throws Exception {
		SqlSession ss = getSqlSession();
		
		int result = dao.editBoard(ss, vo);
		
		if(result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	
	}

}
