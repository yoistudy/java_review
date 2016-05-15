package OOPExercise.Jaeyun;

public abstract class OS implements Logginable{
	private String name;
	
	private String bit;
	
	private String userId;
	
	@Override
	public void login(String userId) {
		this.setUserId(userId);
		System.out.println(this.getName() + "에 " + this.getUserId() + "로 로그인");
	};
	
	// getter, setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBit() {
		return bit;
	}

	public void setBit(String bit) {
		this.bit = bit;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
