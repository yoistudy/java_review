Ch05. 배열
===
## 배열(Array)

##### 배열이란?
> 고정된 크기로 같은 타입의 순차적인 요소들을 저장한다

##### 배열의 선언

```java
// 타입[] 변수이름;
int[] score;
String[] name;

//타입 변수이름[];
int price[];
String menu[];
```

##### 배열의 생성

```java
int[] score; // 배열 변수의 선언
// 배열을 생성한다, 5개의 int값을 저장할 수 있는 고정된 크기를 가진다
score = new int[5];
```

- 배열 변수 선언
- new 연산자로 배열을 생성하면 배열 타입으로 배열 크기만큼 메모리 공간에 할당됨
- 생성된 배열(첫 요소의 주소)을 배열 변수가 참조

##### 배열의 초기화

- 배열은 생성과 동시에 해당 타입의 기본값으로 초기화 된다

- 선언과 리터럴 배열 생성을 동시에 할 경우

  - `new 타입[]` 생략 가능

  - `new 타입[]`에 크기를 지정할 수 없다

  - 리터럴의 크기와 같은 크기로 배열 생성

```java
int[] price = new int[] {1000, 1500};
int[] score = {100, 90, 70}; // new int[] 생략 가능
```

- 선언과 리터럴 배열 생성을 동시에 하지 않을 경우

  - `new 타입[]` 생략 불가

```java
int[] score;
score = new int[] {100, 90, 70}; // new int[] 생략할 수 없음
```

##### 배열의 활용

> 자바 배열은 0 기반 인덱스이다; 인덱스의 범위는 0 부터 시작하여 길이-1 까지다

- 배열 요소에 접근

  - `배열변수[인덱스]`로 접근

```java
int[] score = new int[] {100, 90, 70};

// length는 배열의 길이를 가지는 멤버 변수
for (int i = 0; i < score.length; i++) {
  score[i] = score[i] - 1;
  System.out.println(score[i]);
}
```

##### 다차원 배열

2차원 배열 선언

```java
// 타입[][] 변수이름;
int[][] studentScore;

//타입[] 변수이름[];
String studentClass[][];

//타입[] 변수이름[];
String[] studentGrade[];
```

2차원 배열 생성

```java
// new 타입[첫 번째 차원 크기][두 번째 차원 크기];
int[][] studentScore = new int[5][3]; // 5 X 3의 2차원 배열 생성

//3 X 2의 리터럴 2차원 배열
String[][] studentClass = new String[][] {
  {"ENGLISH", "MATH"},
  {"ENGLISH", "KOREAN"},
  {"KOREAN", "MATH"}
};
```

##### 가변배열

- 2차원 이상의 배열을 생성할 때 배열 차수 중 마지막 차수의 크기를 미정하면 유동적인 크기를 갖는 가변배열을 구성할 수 있다

2차원 가변 배열 생성
```java
// new 타입[첫 번째 차원 크기][두 번째 차원 크기 미정];
int[][] studentScore = new int[5][]; // 2차원 가변배열 생성
// 가변 배열 초기화
score[0] = new int[1];
score[1] = new int[4];
score[2] = new int[2];
score[3] = new int[4];
score[4] = new int[3];

//리터럴 2차원 가변 배열
String[][] studentClass = new String[][] {
  {"ENGLISH", "MATH"},
  {"ENGLISH", "KOREAN", ,"MATH", "PE"},
  {"ENGLISH", "KOREAN", "PE"},
  {"KOREAN"},
  {"MATH", "PE"}
};
```

##### 배열의 복사

- 배열은 고정된 크기를 가진다, 크기를 변경할 수 없음

  더 많은 공간이 필요하면 더 큰 배열을 새로 생성하고 이전 배열로부터 요소를 복사하는 방법이 있음

- for문을 사용하여 각 요소별로 접근하여 복사하는 방법

- System 클래스의 arraycopy 메소드를 사용하는 방법

  - 복사되는 배열의 요소가 기본타입인 경우 값을 복사, 참조타입인 경우 참조를 복사
  - `System.arraycopy(소스배열, 시작위치, 대상배열, 시작위치, 길이);`

##### 커맨드라인을 통해 입력받기

```shell
$java MainTest abc 123 # abc와 123를 매개변수로 전달
```

- 매개변수는 실행 프로그램의 main메서드의 String 타입의 배열인 args로 전달된다

- 공백으로 구분되기 때문에 공백을 포함한 하나의 매개변수는 큰따옴표(`""`)로 감싸준다
