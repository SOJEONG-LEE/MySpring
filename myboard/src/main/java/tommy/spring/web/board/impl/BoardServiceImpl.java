package tommy.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tommy.spring.web.board.BoardService;
import tommy.spring.web.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAOMybatis boardDAO;

//	@Autowired
//	private BoardDAOSpring boardDAO;

//	@Autowired
//	private BoardDAO boardDAO;

// AOP 적용하기 전 방식	
//	private LogAdvice log;
//	public BoardServiceImpl() {
//		log = new LogAdvice();
//	}

	@Override
	public void insertBoard(BoardVO vo) {
// AOP: after-throwing 실습
//		if (vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		}
		boardDAO.insertBoard(vo);
// Transaction 실습
//		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
