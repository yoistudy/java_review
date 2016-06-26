package ch11.KC;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Daniel on 2016. 6. 26..
 */
public class ComparatorEx1 {

    public static void main(String[] args) {
        TreeSet set1 = new TreeSet();
        TreeSet set2 = new TreeSet(new Descending());

        int[] scores=  {30,50,10,20,40};

        for (int i = 0; i < scores.length; i++) {
            set1.add(new Integer(scores[i]));
            set2.add(new Integer(scores[i]));
        }
        System.out.println("set1 : " + set1);
        System.out.println("set2 : " + set2);

    }
}

class Descending implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable){
            Comparable c1 = (Comparable)o1;
            Comparable c2 = (Comparable)o2;
            return c1.compareTo(c2) * -1;
        }
        return -1;
    }
}