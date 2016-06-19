package ch11.Jaeyun;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer ("영어,국어,수학|국사|물리|체육" , ",|");
		while (st.hasMoreTokens()) {
		    System.out.println("과목 : "+ st.nextToken());
		}

	}

}
