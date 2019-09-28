package tommy.spring.store.dao;

import tommy.spring.store.vo.Item;

public interface ItemDAO {
	Item findById(Integer itemId);
}
