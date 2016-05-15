package OOPExercise.Jaeyun;

public interface TextMessageable extends CelluarServiceable {

	abstract void sendText(String phoneNumber, String message);

}
