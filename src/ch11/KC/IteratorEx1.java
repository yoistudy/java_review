package ch11.KC;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Daniel on 2016. 6. 11..
 */
public class IteratorEx1 {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator it = list.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }


    }
}
