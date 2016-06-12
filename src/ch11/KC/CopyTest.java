package ch11.KC;

import java.util.Arrays;

/**
 * Created by Daniel on 2016. 6. 11..
 */
public class CopyTest {
    public static void main(String[] args) {
        int[] data = {0,1,2,3,4,5};
        int[] sCopy = null;
        int[] dCopy = null;

        sCopy = shallowCopy(data);
        dCopy = deepCopy(data);

        System.out.println("Original : " + Arrays.toString(data));
        System.out.println("Shallow : " + Arrays.toString(sCopy));
        System.out.println("Deep : " + Arrays.toString(dCopy));
        System.out.println();

        data[0] = 5;
        System.out.println("Original : " + Arrays.toString(data));
        System.out.println("Shallow : " + Arrays.toString(sCopy));
        System.out.println("Deep : " + Arrays.toString(dCopy));
    }

    public static int[] shallowCopy(int[] arr){
        return arr;
    }

    public static int[] deepCopy(int[] arr){
        if (arr==null) return null;
        int[] result = new int[arr.length];

        System.arraycopy(arr,0,result,0,arr.length);
        return result;
    }
}
