package OOPExercise.Jaeyun;

abstract public class Product {

	private String id;
	
	private Spec spec;
	
	private OS os;
	
	// getter, setter
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Spec getSpec() {
		return spec;
	}

	public void setSpec(Spec spec) {
		this.spec = spec;
	}
	
	public OS getOs() {
		return os;
	}

	public void setOs(OS os) {
		this.os = os;
	}


	
}
