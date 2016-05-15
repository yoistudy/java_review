package OOPExercise.Jaeyun;

public class IPhone extends Product {
	
	private IOS os;

	IPhone(String id) {
		this.setId(id);
		this.setOs(new IOS());
	}
	
	public void login (String userId) {
		this.os.login(userId);
	}

	public void setCelluarInfo(CelluarInfo celluarInfo) {
		this.os.setCelluarInfo(celluarInfo);
	}
	
	public void makeCall(String phoneNumber) {
		this.os.makeCall(phoneNumber);
	}
	
	public void sendText(String phoneNumber, String message) {
		this.os.sendText(phoneNumber, message);
	}
	
	public void makeFacetimeCall(String userId) {
		this.os.makeFaceTimeCall(userId);
	}
	
	// getter, setter

	public IOS getOs() {
		return os;
	}

	public void setOs(IOS os) {
		this.os = os;
	}

}
