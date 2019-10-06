package tommy.spring.web.user;

public class UserVO {

	private String id;
	private String password;
	private String name;
	private String role;

	// getter, setter 추가 // Source -> Generate toString ... 선택 -> 모든 필드 체크 확인 및
	// Generate 클릭

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswrod() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
