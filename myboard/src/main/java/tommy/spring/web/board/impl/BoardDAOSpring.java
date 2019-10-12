package tommy.spring.web.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tommy.spring.web.board.BoardVO;
import tommy.spring.web.common.JDBCUtil;

@Repository("boardDAOSpring")
public class BoardDAOSpring {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content) "
			+ "values((select nvl(max(seq), 0)+1 from myboard), ?, ?, ?)";
// Transaction 실습
//	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content) "
//			+ "values(?, ?, ?, ?)";
	private final String BOARD_UPDATE = "update myboard set title=?, " + "content=? where seq=?";;
	private final String BOARD_DELETE = "delete myboard where seq=?";
	private final String BOARD_GET = "select * from myboard where seq=?";
	private final String BOARD_LIST = "select * from myboard order by seq desc";
	private final String BOARD_LIST_T = "select * from myboard where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from myboard where content like '%'||?||'%' order by seq desc";

	public void insertBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
// Transaction 실습
//		jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());

	}

	public void updateBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 getBoard() 기능 처리");
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("Spring JDBC로 getBoardList() 기능 처리");
//		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		Object[] args = { vo.getSearchKeyword() };
		if (vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		} else if (vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		return null;
		
	}

}