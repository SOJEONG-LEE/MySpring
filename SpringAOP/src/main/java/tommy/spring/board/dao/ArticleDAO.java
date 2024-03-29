package tommy.spring.board.dao;

import tommy.spring.board.vo.ArticleVO;

public interface ArticleDAO {

	void insert(ArticleVO article);
	
	void updateReadCount(int id, int i);
	
	/**
	 * 여기에는 데이터베이스 연동의 모든 작업이 존재
	 * update(ArticleVO article)
	 * delete(int id, String pass)
	 * ArticleVO getAricle(int id)
	 * int getArticleCount()
	 * List<ArticleVO> getArticleList(int start, int end)
	 */

}
