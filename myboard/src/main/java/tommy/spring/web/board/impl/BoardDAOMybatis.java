package tommy.spring.web.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tommy.spring.web.board.BoardVO;

// 2. SqlSessionTemplate을 bean에 등록 
@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void insertBoard(BoardVO vo) {
		System.out.println("---> MyBatis로 insertBoard() 기능 처리");
		sqlSessionTemplate.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("---> MyBatis로 updateBoard() 기능 처리");
		sqlSessionTemplate.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("---> MyBatis로 deleteBoard() 기능 처리");
		sqlSessionTemplate.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("---> MyBatis로 getBoard() 기능 처리");
		return (BoardVO) sqlSessionTemplate.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("---> MyBatis로 getBoardList() 기능 처리");
		return sqlSessionTemplate.selectList("BoardDAO.getBoardList", vo);
//		if (vo.getSearchCondition().equals("TITLE")) {
//			return sqlSessionTemplate.selectList("BoardDAO.getBoardList_T", vo);
//		} else if (vo.getSearchCondition().equals("CONTENT")) {
//			return sqlSessionTemplate.selectList("BoardDAO.getBoardList_C", vo);
//		}
//		return null;
	}
}

/*
 * 1. SqlSeesionDaoSupport를 상속받는 경우 public class BoardDAOMybatis extends
 * SqlSessionDaoSupport {
 * 
 * // SqlSessionDaoSupport 상속 받았을 때 메서드에 @Autowired를 붙일 수 있다.
 * 
 * @Autowired public void setSqlSessionFactory(SqlSessionFactory
 * sqlSessionFactory) { super.setSqlSessionFactory(sqlSessionFactory); }
 * 
 * public void insertBoard(BoardVO vo) {
 * System.out.println("---> MyBatis로 insertBoard() 기능 처리");
 * getSqlSession().insert("BoardDAO.insertBoard", vo); }
 * 
 * public void updateBoard(BoardVO vo) {
 * System.out.println("---> MyBatis로 updateBoard() 기능 처리");
 * getSqlSession().update("BoardDAO.updateBoard", vo); }
 * 
 * public void deleteBoard(BoardVO vo) {
 * System.out.println("---> MyBatis로 deleteBoard() 기능 처리");
 * getSqlSession().delete("BoardDAO.deleteBoard", vo); }
 * 
 * public BoardVO getBoard(BoardVO vo) {
 * System.out.println("---> MyBatis로 getBoard() 기능 처리"); return (BoardVO)
 * getSqlSession().selectOne("BoardDAO.getBoard", vo); }
 * 
 * public List<BoardVO> getBoardList(BoardVO vo) {
 * System.out.println("---> MyBatis로 getBoardList() 기능 처리"); return
 * getSqlSession().selectList("BoardDAO.getBoardList", vo); }
 * 
 * }
 */
