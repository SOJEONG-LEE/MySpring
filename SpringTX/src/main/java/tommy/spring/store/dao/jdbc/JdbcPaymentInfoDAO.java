package tommy.spring.store.dao.jdbc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import tommy.spring.store.dao.PaymentInfoDAO;
import tommy.spring.store.vo.PaymentInfo;

public class JdbcPaymentInfoDAO implements PaymentInfoDAO {

	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public JdbcPaymentInfoDAO(SimpleJdbcInsert insert) {
		this.insert = insert;
		insert.withTableName("PAYMENT_INFO").usingColumns("PAYMENT_INFO_ID", "PRICE");
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

	public int nextVal() {
		return namedJdbcTemplate.queryForObject("select payment_seq.nextval from dual", Collections.emptyMap(),
				Integer.class);
	}

	@Override
	public void insert(PaymentInfo paymentInfo) {
		Map<String, Object> paramValueMap = new HashMap<String, Object>();
		paymentInfo.setId(nextVal());
		paramValueMap.put("PAYMENT_INFO_ID", paymentInfo.getId());
		paramValueMap.put("PRICE", paymentInfo.getPrice());
		insert.execute(paramValueMap);
	}

}
