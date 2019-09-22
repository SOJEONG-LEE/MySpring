package tommy.spring.board.dao;

import tommy.spring.board.vo.ArticleVO;

public class OracleArticleDAO implements ArticleDAO {

	@Override
	public void insert(ArticleVO article) {
		System.out.println("[핵심로직] MyOracleArticleDAO.insert() 실행");
	}

	@Override
	public void updateReadCount(int id, int i) {
		System.out.println("[핵심로직] MyOracleArticleDAO.updateReadCount() 실행");
	}

}
