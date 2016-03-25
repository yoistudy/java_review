package ch05.hosung;

public class Exercise5 {
	public static void main(String[] args) {
		/*5_1
		int[] arr;
		int[] arr2={1,2,3,};
		int[] arr3=new int[5];
		//int[] arr4=new int[5]{1,2,3,4,5};
		//int arr5[5];
		int[] arr6[]=new int[3][];
		
		int[] ballArr ={1,2,3,4,5,6,7,8,9};
		int[] ball3=new int[3];
		*/
		/*5_5
		for(int x=0; x<20; x++){
			int i=(int)(Math.random()*ballArr.length);
			int j=(int)(Math.random()*ballArr.length);
			int tmp=0;
			tmp=ballArr[i];
			ballArr[i]=ballArr[j];
			ballArr[j]=tmp;
		}
		
		System.arraycopy(ballArr, 0, ball3, 0, ball3.length);
		
		for(int i=0; i<ball3.length; i++){
			System.out.print(ball3[i]);
		}
		*/
		
		/*5_6
		int[] coinUnit={500,100,50,10};
		int money=2680;
		System.out.println("money="+money);
		
		for(int i=0; i<coinUnit.length;i++){
			int coin=money/coinUnit[i];
			System.out.println(coinUnit[i]+"원:"+coin);
			money-=(coinUnit[i]*coin);
		}
		*/
		
		/*5_7
		if(args.length!=1){
			System.out.println("Usage: java Exercise5_7 3120");
			System.exit(0);
		}
		
		int money=Integer.parseInt(args[0]);
		System.out.println("money="+money);
		 int[] coinUnit={500,100,50,10};
		 int[] coin={5,5,5,5};
		 
		 for(int i=0; i<coinUnit.length; i++){
			 int coinNum=0;
			 coinNum=money/coinUnit[i];
			 if(coinNum>coin[i]){
				 coinNum=coin[i];
			 }
			 money-=(coinUnit[i]*coinNum);
			 coin[i]-=coinNum;
			 System.out.println(coinUnit[i]+"원: "+coinNum);
		 }
		 
		 if(money>0){
			 System.out.println("거스름돈이 부족합니다.");
			 System.exit(0);
		 }
		 
		 System.out.println("=남은 동전의 개수 =");
		 for(int i=0;i<coinUnit.length;i++){
			 System.out.println(coinUnit[i]+"원:"+coin[i]);
		 }
		*/
		
		/*5_8  -- answer 배열의 숫자의 개수를 구하는 문제 1의 수,2의 수,3의 수,4의 개수
		int[] answer={1,4,4,3,1,4,4,2,1,3,2};
		int[] counter=new int[4];
		
		for(int i=0; i<answer.length;i++){
			counter[answer[i]-1]++;
		}
		
		for(int i=0; i<counter.length;i++){
			System.out.print(counter[i]);
			for(int j=0;j<counter[i];j++){
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		/*5_9*/
		char[][] star={
				{'*','*',' ',' ',' '}
				,{'*','*',' ',' ',' '}
				,{'*','*','*','*','*'}
				,{'*','*','*','*','*'}
		};
		
		char[][]result=new char[star[0].length][star.length];
		
		for(int i=0; i<star.length;i++){
			for(int j=0; j<star[i].length; j++){
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i<star.length;i++){
			for(int j=0; j<star[i].length; j++){
				result[j][star.length-1-i]=star[i][j];
			}
			System.out.println();
		}
		
		for(int i=0; i<result.length;i++){
			for(int j=0; j<result[i].length; j++){
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		
		/*5_10
		char[] abcCode={
				'`','!','@','#','$','%','^','&','*','(',')','-','_','+','=','|','[',']','{'
				,'}',';',':',',','.','/'
		};
		char[] numCode={
				'q','w','e','r','t','y','u','i','o','p'
		};
		
		String src="abc123";
		String result="";
		
		for(int i=0; i<src.length(); i++){
			char ch=src.charAt(i);
			if(ch>=97&&ch<=122){
				result+=abcCode[(int)(ch-97)];
			}else if(ch>=48&&ch<=57){
				result+=numCode[(int)(ch-48)];
			}
		}
		
		System.out.println("src:"+src);
		System.out.println("result:"+result);
		*/
		
		/*5_11
		int[][] score={
				{100,100,100}
				,{20,20,20}
				,{30,30,30}
				,{40,40,40}
				,{50,50,50}
		};
		int [][]result=new int[score.length+1][score[0].length+1];
		
		for(int i=0; i<score.length; i++){
			for(int j=0; j<score[i].length; j++){
				result[i][j]=score[i][j];
				result[i][score[i].length]+=result[i][j];
				result[score.length][j]+=result[i][j];
				result[score.length][score[0].length]+=result[i][j];
			}
		}
		
		for(int i=0; i<result.length; i++){
			for(int j=0; j<result[i].length;j++){
				System.out.printf("%4d",result[i][j]);
			}
			System.out.println();
		}
		*/
		/*
		int a=30;
		int b=20;
		System.out.println("a:"+a+"b:"+b);
		a^=b;//a=a^b;
		b^=a;//b=b^a;
		a^=b;//a=a^b;
		System.out.println("a:"+a+"b:"+b);
		*/
		//3차원 배열 선언 및 초기화!!!
		  int[][][] arr = {{{1,2,3},{4,5,6},{7,8,9}},{{1,2,3},{4,5,6},{7,8,9}},{{1,2,3},{4,5,6},{7,8,9}}};
		  
		  for(int i=0; i<arr.length; i++){//3차원 배열 출력!!!
		   for(int j=0; j<arr[i].length; j++){
		    for(int k=0; k<arr[i][j].length; k++){
		     System.out.print("arr[" + i + "][" + j + "][" + k + "] = " + arr[i][j][k] + "\t");
		    }
		    System.out.println();
		   }
		   System.out.println();
		  }
		
	}
}
