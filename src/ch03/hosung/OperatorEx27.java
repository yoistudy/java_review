package ch03.hosung;

public class OperatorEx27 {
	public static void main(String[] args) {
		int x = 10;
		int y = -10;
		
		int absX = (x >= 0) ? x:-x;
		int absY = (y >= 0) ? y:-y;
		
		System.out.println("x= 10�� ��, x�� ��밪��  "+absX);
		System.out.println("y= -10�� ��, x�� ��밪��  "+absY);
	}
}
