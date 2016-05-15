package OOPExercise.Jaeyun;

public class Mac extends Product {

	private MacOS os;

	Mac(String id) {
		this.setId(id);
		this.setOs(new MacOS());
	}
	
	public void login (String userId) {
		this.os.login(userId);
	}
	
	public void makeFacetimeCall(String userId) {
		this.os.makeFaceTimeCall(userId);
	}
	
	// getter, setter

	public MacOS getOs() {
		return os;
	}

	public void setOs(MacOS os) {
		this.os = os;
	}
	
}