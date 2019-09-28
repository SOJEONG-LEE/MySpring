package tommy.spring.guestbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import tommy.spring.guestbook.vo.GuestMessage;

public class NamedParamGuestMessageDAO implements GuestMessageDAO {

	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert insertMessage;

	// 방법 1. applicationContext.xml에서 NameParameterJdbcTemplate을 bean으로 생성할때 사용
//	public void setTemplate(NamedParameterJdbcTemplate template) {
//		this.template = template;
//	}

	// 방법 2. DataSource로 주입해서 객체를 매번 생성하는 경우
	public void setTemplate(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	// 방법 3. SimpleJdbcInsert
//	public NamedParamGuestMessageDAO(SimpleJdbcInsert insertMessage) {
//		this.insertMessage = insertMessage;
//		insertMessage.withTableName("GUESTBOOK");
//		insertMessage.usingColumns("MESSAGE_ID", "GUEST_NAME", "MESSAGE", "REGISTRY_DATE");
//	}
	
	// 방법 4.
	public NamedParamGuestMessageDAO(DataSource dataSource) {
		this.insertMessage = new SimpleJdbcInsert(dataSource);
		insertMessage.withTableName("GUESTBOOK");
		insertMessage.usingColumns("MESSAGE_ID", "GUEST_NAME", "MESSAGE", "REGISTRY_DATE");
	}

	@Override
	public int count() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return template.queryForObject("select count(*) from GUESTBOOK", paramMap, Integer.class);
	}

	@Override
	public int delete(int id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		return template.update("delete from GUESTBOOK where MESSAGE_ID = :id", paramMap);
	}

	// 방법 1.NamedParamJdbcInsert
//	@Override
//	public int insert(GuestMessage message) {
//		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(message);
//		int insertedCount = template
//				.update("insert into GUESTBOOK " + "(MESSAGE_ID, GUEST_NAME, MESSAGE, REGISTRY_DATE)"
//						+ " values(guest_seq.nextval, :guestName, :message, :registryDate)", paramSource);
//		if (insertedCount > 0) {
//			int id = template.queryForObject("select count(*) from GUESTBOOK", Collections.<String, Object>emptyMap(),
//					Integer.class);
//			message.setId(id);
//		}
//		return insertedCount;
//	}

	// 방법 2. SimpleJdbcInsert
	@Override
	public int insert(GuestMessage message) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		message.setId(nextVal());
		paramSource.addValue("MESSAGE_ID", message.getId());
		paramSource.addValue("GUEST_NAME", message.getGuestName());
		paramSource.addValue("MESSAGE", message.getMessage());
		paramSource.addValue("REGISTRY_DATE", message.getRegistryDate());
		return insertMessage.execute(paramSource);
	}

	public int nextVal() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return template.queryForObject("select guest_seq.nextval from dual", paramMap, Integer.class);
	}

	@Override
	public List<GuestMessage> select(int begin, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRowNum", begin);
		paramMap.put("count", end - begin + 1);
		return template.query("select * from (select ROWNUM rnum, MESSAGE_ID, "
				+ "GUEST_NAME, MESSAGE, REGISTRY_DATE from " + "(select * from GUESTBOOK order by MESSAGE_ID desc))"
				+ "where rnum>=:startRowNum and rnum<=:count", paramMap, new RowMapper<GuestMessage>() {
					@Override
					public GuestMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
						GuestMessage message = new GuestMessage();
						message.setId(rs.getInt("MESSAGE_ID"));
						message.setGuestName(rs.getString("GUEST_NAME"));
						message.setMessage(rs.getString("MESSAGE"));
						message.setRegistryDate(rs.getDate("REGISTRY_DATE"));
						return message;
					}
				});
	}

	@Override
	public int update(GuestMessage message) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("message", message.getMessage());
		paramSource.addValue("id", message.getId(), Types.INTEGER);
		return template.update("update GUESTBOOK set MESSAGE = :message" + " where MESSAGE_ID = :id", paramSource);
	}

}
