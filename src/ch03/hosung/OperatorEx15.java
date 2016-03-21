package ch03.hosung;

public class OperatorEx15 {
	public static void main(String[] args) {
		char c = 'a';
		for(int i=0; i<26; i++){
			System.out.print(c++);//'a'���� 26�� ���� ���
		}
		
		System.out.println();//�ٹٲ�
		
		c = 'A';
		for(int i=0; i<26; i++){
			System.out.print(c++);//'A'���� 26�� ���� ���
		}
		
		System.out.println();//�ٹٲ�
		
		c='0';
		for(int i=0; i<10; i++){
			System.out.print(c++);//'0'���� 10�� ���� ���
		}
		System.out.println();
	}
}
