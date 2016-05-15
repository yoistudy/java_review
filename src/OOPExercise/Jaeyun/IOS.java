package OOPExercise.Jaeyun;

public class IOS extends OS implements Callable, TextMessageable, FaceTimeCallable{
	
	private CelluarInfo celluarInfo;
	
	public IOS() {
		this.setName("iOS");
		this.setBit("64");
	}
	
	@Override
	public void celluarConnect() {
		if (this.celluarInfo == null) {
			System.out.println("사용자의 통신사 정보 없음");
		} else {
			System.out.println("사용자가 " + this.celluarInfo.getCarrier() + " 통신사에 번호 " + this.celluarInfo.getNumber() + "로 셀룰러 커넥션");			
		}
	}

	@Override
	public void makeCall(String phoneNumber) {
		if (this.celluarInfo == null) {
			System.out.println("사용자의 통신사 정보 없음");
		} else if (phoneNumber == null) {
			System.out.println("전화할 상대 전화번호를 입력해주세요");
		} else {
			System.out.println("사용자가 " + this.celluarInfo.getNumber() + "로 " + phoneNumber + "에 전화");
		}
	}
	
	@Override
	public void sendText(String phoneNumber, String message) {
		if (this.celluarInfo == null) {
			System.out.println("사용자의 통신사 정보 없음");
		} else if (phoneNumber == null) {
			System.out.println("텍스트 메세지를 보낼 상대 전화번호를 입력해주세요");
		} else {
			System.out.println("사용자가 " + this.celluarInfo.getNumber() + "로 " + phoneNumber + "에 텍스트 메시지\n "
					+ "'" + message + "' 송신");
		}
		
	}
	
	@Override
	public void makeFaceTimeCall(String userId) {
		if (this.getUserId() == null) {
			System.out.println("사용자의 유저 정보 없음");
		} else if (userId == null) {
			System.out.println("상대 유저 입력해주세요");
		} else {
			System.out.println("사용자가 " + userId + "에게 페이스타임 걸기");
		}
	}
	
	// getter, setter
	
	public void setCelluarInfo(CelluarInfo celluarInfo) {
		this.celluarInfo = celluarInfo;
		celluarConnect();
	}
	
	public CelluarInfo getCelluarInfo() {
		return celluarInfo;
	}
	
}