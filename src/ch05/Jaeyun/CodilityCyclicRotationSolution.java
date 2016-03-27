package ch05.Jaeyun;

/*
 * https://codility.com/programmers/task/cyclic_rotation/ 
 * CyclicRotation 문제풀이
 */


// you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class CodilityCyclicRotationSolution {
 public int[] solution(int[] A, int K) {
     int[] result = new int[A.length];
     for(int i = 0; i < A.length; i++) {
         result[(K + i) % A.length] = A[i];
     }
     return result;
 }
}
