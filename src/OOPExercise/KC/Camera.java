package OOPExercise.KC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 2016. 5. 15..
 */
public abstract class Camera implements Camerable{

    List<String> pictureList;

    public Camera() {
        pictureList = new ArrayList<String>();
    }

}
