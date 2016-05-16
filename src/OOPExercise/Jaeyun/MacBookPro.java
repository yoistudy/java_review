package OOPExercise.Jaeyun;

public class MacBookPro extends Mac {

	MacBookPro(String id) {
		this.setId(id);
		this.setOs(new MacOS());
	}
	
	public void login (String userId) {
		this.getOs().login(userId);
	}
	
	public void makeFacetimeCall(String userId) {
		this.getOs().makeFaceTimeCall(userId);
	}

}
