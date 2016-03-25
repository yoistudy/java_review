Ch05. 배열(Array) - p126
===
## 배열(array)이란?

##### 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
##### 배열을 사용하면 많은 양의 데이터를 손쉽게 다룰 수 있다.

```java
// 배열을 사용하지 않은 경우
int score1=0,  score2=0,  score3=0,  score4=0,  score5=0;
// 배열을 사용 한 경우
int[] score = new int[5];
```

## 배열의 선언

##### 원하는 타입의 변수를 선언하고, 변수 또는 타입에 배열임의 의미하는 대괄호[]를 붙이면 된다.

```java
// 타입[] 변수이름;
int[] score;
String[] name;

//타입 변수이름[];
int[] score;
String[] name;
```

## 배열의 생성 - p127

##### 배열을 선언하는 것은 배열을 다루기 위한 참조변수를 위한 공간을 만드는 것.
##### 배열을 생성해야만 비로서 데이터를 저장할 수 있는 공간이 만들어지는 것이다.

```java
int[] score;	// 배열 선언 (사용될 참조 변수 선언)
score = new int[5];	// 배열 생성 (5개의 int값을 저장 할 수있는 공간생성)
```
> int[] score=new int[5]; //한 문장으로 가능

###### 배열도 객체이기 때문에 멤버변수와 메서드를 갖고있음.
###### 멤버변수 length는 배열의 크기에 대한 정보를 담고있다.
> 배열은 한번 생성되면 크기 변경 불가, length는 변하지 않는다.

-변수의 타입에 따른 기본값
 
|  자료형 | 기본값  |
|--------|--------|
|boolean |false   |
|char    |'\u0000'|
|byte |0   |
|short |0   |
|int |0   |
|long |0L   |
|float |0.0f   |
|double |0.0d 또는 0.0|
|참조형변수 |null   |

## 배열의 초기화

##### 배열은 생성과 동시에 자동적으로 자신의 타입에 해당하는 기본값으로 초기화
>배열을 사용하 전에 초기화를 해주지 않아도 됨.

- 원하는 값으로 초기화하기 위해서는 아래와 같음
```java
int[] score = new int[5];
score[0] = 100;
score[1] = 90;
score[2] = 80;
score[3] = 70;
score[4] = 60;
```

- 기본형이 아닌 참조형 배열을 생성하고 초기화하는 방법
```java
String[] name = new String[3];
name[0] = new String("Kim");
name[1] = new String("Park");
name[2] = new String("Yi");
```

- 배열의 크기를 따로 지정해주지 않으며, 주어진 값의 개수에 따라 자동으로 크기 결정
```java
int[] score = {100,90,80,70,60};
int[] score = new int[]{100,90,80,70,60};
String[] name = {new String("Kim"),new String("Park"),new String("Yi")};
String[] name = {"Kim", "Park", "Yi"};
String[] name = new String[]{new String("Kim"),new String("Park"),new String("Yi")};
```
> String은 클래스이므로 new 연산자를 통해 인스턴스를 생성해야하지만, ""큰 따옴표를 사용하는 것을 특별히 허용

- 선언과 초기화를 따로 해야 하는 경우
```java
int[] score;
score = {100,90,80,70,60};//에러 발생
int[] score;
score = new int[]{100,90,80,70,60};//OK
```

- 메서드를 호출해야 하는 경우
```java
int add(int[] arr){/* 내용 생략 */};
//
int result= add({100,90,80,70,60});//에러 발생
score = add(new int[]{100,90,80,70,60});//OK
```

## 배열의 활용

##### 배열의 각 저장공간에 값을 저장하고, 값을 읽어오기 위해서는 배열의 참조변수와 인덱스를 이용.
##### 배열의 익덱스는 배열의 각 저장공간에 자동적으로 주어지는 일련번호. 0부시작해서 1씩 증가.

- 배열의 index 범위를 넘어서는 경우(ArrayIndexOutOfBoundsException 예외 발생)
```java
int[] score = {100,90,80,70,60};
for(int i=0; i<6; i++){
	System.out.println(score[i]);
}
```

-배열의 멤버변수 length 사용
```java
int[] score = {100,90,80,70,60};
for(int i=0; i<score.length; i++){
	System.out.println(score[i]);
}
```

> 예제 ArrayEx1 ~ 9.java

## 다차원 배열

##### 자바에서는 1차원 배열뿐만 아니라 2차원 이상의 다차원 배열도 허용한다.
> 특별한 경우를 제외하고 2차원 배열을 사용하지 않는다. (*특별한 경우를 찾지 못함...)

-2차원 배열의 선언

|선언 방법|선언 예|
|---------------|
|타입[][] 변수이름;|int[][] score;|
|타입 변수이름[][];|int score[][];|
|타입[] 변수이름[];|int[] score;[]|

-2차원 배열 생성과 초기화 동시
```java
int [][] score=new int[][]{
			{100,100,100}
            ,{20,20,20}
            ,{30,30,30}
            ,{40,40,40}
            ,{50,50,50}
}
```
> score.length 값은 5
> score[0].length & score[1].length & score[2].length & score[3].length & score[4].length 값은 3

-for문을 이용한 2차원 배열 초기화
```java
for(int i=0;i<score.length;i++){
	for(int j=0; j<score[i].length; j++){
    	score[i][j]=10;
    }
}
```

> 예제 ArrayEx10.java

## 가변 배열

##### 2차원 이상 다차원 배열 생성시 전체 배열 차수 중 마지막 차수의 크기는 지정하지 않고, 유동적인 갑녀 배열 구성

```java
int[][] score = new int[5][];
score[0] = new int[4];
score[1] = new int[3];
score[2] = new int[2];
score[3] = new int[2];
score[4] = new int[3];
```
> p142 확인

## 배열의 복사

##### 배열은 한번 생성하면 크기 변경 불가.
##### 더 많은 저장 공간이 필요하다면, 큰 배열을 새로 만들어 복사해야함.

-for문 사용 예제 ArrayEx11.java

-arraycopy 예제 ArrayEx12.java
```java
System.arraycopy(arr1, 0, arr2, 0, arr1.length);
//				arr1[0]에서 arr2[0]으로 arr1.length개의 데이터를 복사
```

## 커맨드라인을 통해 입력받기

#####커맨드라인을 통해서 입력된 문자열은 main메서드 매개변수(args)에 전달.

> 예제 ArrayEx13 ~ 16
> 13 - 공백이 있는경우 큰따옴표(")로 감싸준다.
> MoreConverter - 대문자로만 입력가능 하도록 String클래스의 toUpperCase()사용
> 15 - Integer.parseInt(String str) String형을 int형으로 변환
