package OOPExercise.Jaeyun;

public class CelluarInfo {
	
	private String carrier;
	
	private String number;
	
	CelluarInfo (String carrier, String number) {
		this.setCarrier(carrier);
		this.setNumber(number);
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
