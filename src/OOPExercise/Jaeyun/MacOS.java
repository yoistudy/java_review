package OOPExercise.Jaeyun;

public class MacOS extends OS implements FaceTimeCallable{
	
	public MacOS() {
		this.setName("MacOS");
		this.setBit("64");
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

}
