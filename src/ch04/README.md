Ch04. 조건문과 반복문
===
## 조건문

##### if문
- 기본적인 if문

```java
if (조건식) {
  doSometing();
}
// 블럭 없이 사용하면 조건식에 대하여 단 하나의 행을 실행
if (조건식)
  doSometing();
```

- if-else문

```java
if (조건식) {
  doSometing1();
} else {
  doSometing2();
}
```

- if-else if문

```java
if (조건식) {
  doSometing1();
} else if (조건식) {
  doSometing2();
} else if (조건식) {
  doSometing3();
}
```
- 중첩 if문

```java
if (조건식) {
  if (조건식) {
    doSometing();
  }
}
```

##### switch문

- 조건의 수가 많을때 if문보다 switch문 사용이 더 간결

- swith문의 조건식 결과 값은 int형 범위의 정수값

  JDK 1.7부터 String형도 됨

- case문에는 리터럴 상수만 허용

- break문으로 switch문을 탈출하며 case문에 break를 사용 하지 않으면 다음 case문을 실행

```java
switch (조건식) {
  case 값1:
    // 값1일때 수행되는 명령
    doSometing1();
    break;
  case 값2:
    // 값1일때 수행되는 명령
    doSometing2();
    break; // switch문 빠져나간다
  default:
    doSometing3();
}
```
## 반복문

- 반복적으로 수행되도록 할 때 사용

- 주어진 조건에 만족하는 동안 반복을 실행 하기위해 조건식을 포함

> switch문을 제외한 if, for, while문의 조건식은 boolean형의 연산결과여야 한다

##### for문

- 초기화 -> 조건식 -> 수행될 문장 -> 증감식 -> 조건식으로 반복

- 초기화시 선언한 변수는 for문 블럭내에서만 유효

- 기본 for문

```java
for (초기화; 조건식; 증강식) {
  //조건식이 true일때 수행되는 명령
}
```

- 중첩 for문

```java
for (초기화; 조건식; 증강식) {
  //조건식이 true일때 수행되는 명령
  for (초기화; 조건식; 증강식) {
    //조건식이 true일때 수행되는 명령
  }
}
```

##### for each문
- Array, Collections나 Iterable<E> 상속 받은 객체에서 사용가능

```java
String[] temp = { "aa", "bb", "cc" };
for (String el : temp) {
    System.out.println(el);
}
```


##### while문

- 조건식

- while 블럭 안에서 반복 탈출을 위한 증감식이 필요하다

- 기본 while문

```java
while (조건식) {
  //조건식이 true일때 수행되는 명령, 증감식 포함해야함
}
```

##### do while문

- do 블럭을 수행한 후 조건식을 평가하여 while문 진입

- do 블럭을 최소 한번은 수행될 것을 보장

- 기본 do while문

```java
do {

} while (조건식) {
  //조건식이 true일때 수행되는 명령, 증감식 포함해야함
}
```

##### break문

- 해당 반복문을 벋어난다

##### continue문

- 반복문의 끝으로 이동해 다음 반복문으로 넘어간다

##### 이름 붙은 반복문

- 반복문 앞에 명시

```java
Loop1 : for(;;){

}
```
- break, continue문에서 불러서 사용
