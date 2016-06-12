package ch11.KC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Daniel on 2016. 6. 11..
 */
public class ArrayListLinkedListTest2 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        LinkedList ll = new LinkedList();
        add(al);
        add(ll);

        System.out.println("=접근시간테스트");
        System.out.println("ArrayList : " + access(al));
        System.out.println("LinkedList: " + access(ll));



    }

    public static void add(List list){
        for (int i = 0; i < 100000; i++) {
            list.add(i + "");
        }
    }

    public static long access(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        return end-start;
    }

}
