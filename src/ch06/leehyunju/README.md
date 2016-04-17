#Ch06. 객체지향 프로그래밍 I
##4.오버로딩(overloading)
###4.5 가변인자(varargs)와 오버로딩
* 가변인자 : jdk1.5부터 동적으로 매개변수 개수 지정 가능하며,
           이를 가변인자라고 한다.
* 선언방법 : 타입...변수명
```
ex1)
public printStream printf(String format, Object...args){...}
```
* 가변 인자는 가장 마지막에 선언
```
ex2)
String concatenate(String s1, String s2){...}
String concatenate(String s1, String s2, String s3){...}
ex3)
String concatenate(String...args){...}
```