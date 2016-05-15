package OOPExercise.KC;

/**
 * Created by Daniel on 2016. 5. 15..
 */
public interface Callable {

    void callSend(Callable callableDevice);

    void callReceive(String senderPhoneNumber);

}
