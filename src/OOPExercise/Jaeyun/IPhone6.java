package OOPExercise.Jaeyun;

public class IPhone6 extends IPhone {

	IPhone6(String id) {
		this.setId(id);
		this.setOs(new IOS());
	}
	
	public void login (String userId) {
		this.getOs().login(userId);
	}

	public void setCelluarInfo(CelluarInfo celluarInfo) {
		this.getOs().setCelluarInfo(celluarInfo);
	}
	
	public void makeCall(String phoneNumber) {
		this.getOs().makeCall(phoneNumber);
	}
	
	public void sendText(String phoneNumber, String message) {
		this.getOs().sendText(phoneNumber, message);
	}
	
	public void makeFacetimeCall(String userId) {
		this.getOs().makeFaceTimeCall(userId);
	}
}
