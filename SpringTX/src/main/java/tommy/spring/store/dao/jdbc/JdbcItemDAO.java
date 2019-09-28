package tommy.spring.store.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tommy.spring.store.vo.Item;
import tommy.spring.store.dao.ItemDAO;

public class JdbcItemDAO implements ItemDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcItemDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Item findById(Integer itemId) {
		return jdbcTemplate.queryForObject("select * from ITEM where ITEM_ID = ?", new Object[] { itemId },
				new RowMapper<Item>() {
					@Override
					public Item mapRow(ResultSet rs, int row) throws SQLException {
						Item item = new Item();
						item.setId(rs.getInt("ITEM_ID"));
						item.setPrice(rs.getInt("PRICE"));
						return item;
					}
				});
	}
}
