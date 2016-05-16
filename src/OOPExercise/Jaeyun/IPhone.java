package OOPExercise.Jaeyun;

public abstract class IPhone extends Product {
	
	private IOS os;
	
	public abstract void login (String userId);

	public abstract void setCelluarInfo(CelluarInfo celluarInfo);
	
	public abstract void makeCall(String phoneNumber);
	
	public abstract void sendText(String phoneNumber, String message);
	
	public abstract void makeFacetimeCall(String userId);
	
	// getter, setter

	public IOS getOs() {
		return os;
	}

	public void setOs(IOS os) {
		this.os = os;
	}

}
