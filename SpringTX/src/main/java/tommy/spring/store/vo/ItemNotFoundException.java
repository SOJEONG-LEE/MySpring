package tommy.spring.store.vo;


// 예외클래스: 보안, 에러를 더 상세히 나타내기 위해서
public class ItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Integer itemId;

	public ItemNotFoundException(Integer itemId) {
		super("not found item : id = " + itemId);
		this.itemId = itemId;
	}

	public Integer getItemId() {
		return itemId;
	}

}
