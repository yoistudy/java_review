package ch11.KC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Daniel on 2016. 6. 11..
 */
public class ArrayListLinkedListTest {
    public static void main(String[] args) {
        ArrayList al = new ArrayList(1000000);
        LinkedList ll = new LinkedList();

        System.out.println("= 순차적으로 추가하기 =");
        System.out.println("ArrayList : " + add1(al));
        System.out.println("LinkedList : " + add1(ll));

        System.out.println();
        System.out.println("= 중간에 추가하기 =");
        System.out.println("ArrayList : " + add2(al));
        System.out.println("LinkedList : " + add2(ll));

        System.out.println();
        System.out.println("= 중간에 삭제하기 =");
        System.out.println("ArrayList : " + remove2(al));
        System.out.println("LinkedList : " + remove2(ll));

        System.out.println();
        System.out.println("= 순차적으로 삭제하기 =");
        System.out.println("ArrayList : " + remove1(al));
        System.out.println("LinkedList : " + remove1(ll));
    }

    public static long add1(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(i+"");
        }
        long end = System.currentTimeMillis();
        return end -start;
    }

    public static long add2(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.add(500, "X");
        }
        long end = System.currentTimeMillis();
        return end-start;
    }

    public static long remove1(List list){
        long start = System.currentTimeMillis();
        for (int i = list.size() - 1; i > 0; i--) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end -  start;

    }

    public static long remove2(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
