package OOPExercise.Jaeyun;

public abstract class Mac extends Product {

	private MacOS os;
	
	public abstract void login (String userId);
	
	public abstract void makeFacetimeCall(String userId);
	
	// getter, setter

	public MacOS getOs() {
		return os;
	}

	public void setOs(MacOS os) {
		this.os = os;
	}
	
}