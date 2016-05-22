Ch08. 예외처리
===
## 예외처리(exception handle)

#### 프로그램 오류

###### 에러 - 프로그램 실행 중 복구할 수 없는 심각한 문제가 발생한 경우
######  예외 - 프로그램 실행 중 정상적인 명령의 흐름을 방해하는 경우


#### 예외처리란

> 프로그램 실행 시 발생할 수 있는 예외를 catch할 코드를 작성하는 것

> 프로그램의 정상적인 명령 흐름을 유지하기 위한 것

#### 캐치 혹은 명시하기의 요건(The Catch or Specify Requirement)

유효한 자바 프로그래밍 코드는 "캐치 혹은 명시하기의 요건"을 반드시 지켜야한다. 즉 예외를 발생시킬 수 도 있는 코드는 반드시 아래중 하나가 포함 되어있어야 한다. 이는 checked exception으로 강제된다

- 예외를 캐치하는 try문

  try문에는 반드시 예외를 처리할 수 있는 (해당 예외 타입)핸들러를 사용해야 한다

- 예외를 던질(throw) 수 있다고 명시한 메소드

  메소드에는 반드시 throws clause를 사용하여 예외 리스트들을 명시한다

"캐치 혹은 명시하기의 요건"을 지키지 않은 코드는 컴파일되지 않음

## 예외의 세가지 종류
모든 예외가 "캐치 혹은 명시하기의 요건"에 적용되지는 않는다. 예외의 세가지 종류 중 한 가지 종류만 적용됨

#### checked exception

- Error와 RuntimeException 그리고 그 서브클래스들을 제외한 모든 예외

- 잘 작성된 애플리케이션이라면 예상하여 복구해야할 수 있는 예외 상황

- "캐치 혹은 명시하기의 요건"이 적용된다

#### error

- Error와 그 서브클래스들

- 애플리케이션 외부의 예외적 상황

- 대게 예상하고 그로부터 복구할 수 없는 예외

- "캐치 혹은 명시하기의 요건"이 적용 안됨

#### runtime exception

- RuntimeException과 그 서브클래스들

- 애플리케이션 내부의 예외적 상황

- 대부분 잘못된 로직이나 잘못된 API 사용과 같은 프로그래밍 버그들

- "캐치 혹은 명시하기의 요건"이 적용 안됨

Error와 RuntimeException을 unchecked exception이라고도 한다

## 예외 캐치와 핸들링

#### 예외 핸들링 요소

- try, catch, finally

- try-with-resources (Java SE 7에서 추가)

#### try 블럭

- 예외 핸들러를 생성의 첫 단계는 에외를 throw할 수도 있는 코드들을 try 블럭으로 감싸는 것

- try 블럭으로 감싸는 범위를 경우에 따라 조정

```java
try {

   // 에외를 throw할 수도 있는 코드

}
```

#### catch 블럭

- 예외를 캐치하기 위해 catch 블럭이 반드시 try 블럭 바로 다음에 뒤따라야 함

- 하나 이상의 catch 블럭을 사용 할 수 있음

- 아규먼트로 캐치할 예외 타입을 지정하며, `Throwable` 클래스로부터 상속받은 타입이여야 함

- 코드의 중복을 줄이기 위해 `|`로 구분하여 멀티캐치(예외타입 아규먼트를 하나 이상 사용)할 수 있음 (Java SE 7에서 추가)

  이때 생성되는 예외인스턴스변수는 묵시적으로 final이 됨

```java
try {

  // 에외를 throw할 수도 있는 코드

} catch (예외타입1 예외인스턴스변수) {

  // 예외 처리 코드

} catch (예외타입2 | 예외타입3 예외인스턴스변수) { // 하나의 catch 블럭에 하나 이상의 예외타입 사용

  // 예외인스턴스변수는 final
  // 예외 처리 코드

}
```

#### finally 블럭

- finally 블럭은 try 블럭을 빠져나오면 반드시 실행 됨

- 예외가 발생했을 때도 실행 됨

- 클린업 코드(자원해제에 관한 코드)를 실행하지 않고 건너뛰는 상황을 피할 수 있게 해줌

  finally 블럭에 클린업 코드를 넣는 것은 자원 누수를 막을 수 있다

참고 - JVM이 try나 catch 블럭에을 실행하고 있을 때 종료되면 finally 블럭은 실행되지 않음

```java
finally {

    // 반드시 실행 되어야할 코드
    // try 블럭에서 사용한 자원이 해제되지 않았으면 해제하는 코드

}
```

#### try-with-resources 문

- 하나 이상의 (사용 후 반드시 해제가 필요한)자원을 선언한 try 문

-  __java.lang.AutoCloseable__ 과 그것을 확장한 인터페이스를 구현한 타입의 객체라면 try-with-resources 블럭에서 자원으로 사용가능함

- try 블럭을 나오면 자원을 해제함

- try 블럭에서 예외가 throw되면 try-with-resources 문에서 자원을 생성한 역순으로 자원이 해제됨

```java
try (BufferedReader br =
      new BufferedReader(new FileReader(fileName)); // 하나 이상의 자원을 사용 할 경우 세미콜론을 이용해 구분
    java.util.zip.ZipFile zf =
  		new java.util.zip.ZipFile(zipFileName)
	) {

  // 에외를 throw할 수도 있는 코드
}
```
## throw된 예외 명시하기

예외가 발생했을 때 발생한 코드에서 예외를 캐치하여 핸들링하는게 적합한 경우가 있고

호출(콜 스택)을 거슬러 내려가 그 코드를 사용하는 곳으로 예외를 전달하여 핸들링하는게 더 좋을 때도 있다

예를 들어 예외를 throw할 수 있는 어떤 기능을 하는 코드를 작성하고 그 코드에서 예외 핸들링하는 경우 그 기능을 사용하는 곳에서 예외를 제어할 수 없다. 그 기능을 사용하는 곳의 모든 요구를 예상할 수 없기 때문에 예외을 전달하여 예외 핸들링의 제어도 넘겨주는 것

```java
public void writeList() throws IndexOutOfBoundsException {
  PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
    for (int i = 0; i < SIZE; i++) {
      out.println("Value at: " + i + " = " + list.get(i));
  }
  out.close();
}
```

위의 코드에서 직접 예외를 핸들링하지 않으려면 코드가 throw할 수 있는 예외를 `throws`로 메소드에 명시하면 된다

## 예외 발생시키기

- 어느 코드(본인이 직접 작성한 코드, JRE 처럼 누군가 작성한 패키지에 포함된 코드)에서나 예외를 throw할 수 있다

- 모든 예외는 `throw`문으로 throw한다

작성하는 코드에서 일어날 수 있는 문제를 표현하기위해 사용자가 직접 예외를 작성할 수 있다

#### throw 문

- throw문에는 하나의 인자가 필요하며 __java.lang.Throwable__ 의 서브클래스 인스턴스여야 한다

```java
public Object pop() {
  Object obj;

  if (size == 0) {
      throw new EmptyStackException();
  }

  obj = objectAt(size - 1);
  setObjectAt(size - 1, null);
  size--;
  return obj;
}
```

## 사용자 정의 예외

#### 코드에서 발생한 문제로 throw할 예외를 고를때 직접 예외를 작성해야하는 경우
- Java가 제공하는 예외 타입이 표현하지 않는 예외가 필요할 때
- 벤더가 제공하는 예외와 구별되는게 사용자에게 도움이 될 때
- 연관된 하나 이상의 예외를 throw하는 코드일 때
- 코드에서 사용하려는 예외를 사용자가 사용할 수 없을때 (예를 들어 패키지가 독립적으로 제공되어야 하는데 코드가 타 패키지의 예외를 사용하려고 할 때)

#### 예외 작성

```java
class UserDefinedException extend Exception {

  UserDefinedException(String message) {
    super(message);
  }
}
```
예외 타입 UserDefinedException 작성

## 연쇄 예외 (chanined exceptions)

- 하나의 예외가 또 다른 예외를 throw시킬 수 있다

- 해당 예외가 어떤 예외를 유발하는지 알 수 있도록 chained excpetions을 사용


#### chained excpetions을 지원하는 __java.lang.Throwable__ 의 생성자와 메서드
- Throwable(String, Throwable) : 첫번째 인자에는 메세지, 두번째 인자에는 현재 생성되는 예외의 원인(cause) 예외 인스턴스
- Throwable(Throwable)
- Throwable getCause()
- Throwable initCause(Throwable) : 인자에는 원인 예외 인스턴스

#### 연쇄 예외 사용

```java
try {
  // IOException을 throw할 수 있는 코드
} catch (IOException e) {
    throw new SampleException("Other IOException", e);
}
```
IOException이 throw되면 핸들러에서 SampleException이 throw된다
SampleException throw의 원인은 IOException이 되며 throw시 생성자에 메시지와 함께 원인 예외 인스턴스를 전달한다


## 캐치와 명시하기와 unchecked exception

#### 캐치와 명시하기 우회
자바에서 unchecked exception은 "캐치 혹은 명시하기의 요건"이 적용되지 않기때문에

- unchecked exception만 throw하는 코드를 작성
- 모든 예외를 RuntimeException의 서브클래스로 생성

프로그래머에게 편리하게 보일지라도 "캐치 혹은 명시하기의 요건"의 목적을 회피하는 것이며 프로그래머가 __작성한 클래스를 사용하는 다른 사용자에게 문제를 발생시킬 수 있다__

#### 메소드 작성자가 메소드 스코프안에서 발생할 수 있는 모든 checked exception을 명시해야하는 이유
- 메소드에서 throw될 수 있는 예외의 명시하는 부분은 메소드의 공개된 프로그래밍 인터페이스이다 (사용하는 곳에서 확인할 수 있다)

- 메소드를 호출하는 사용자들은 반드시 그 메소드가 throw할 수도 있는 예외를 알아야 한다

  그래야 어떻게 핸들링할 수 있을지 결정할 수 있기 때문이다

#### 메소드에 예외를 명시하는 것이 좋지만 RuntimeException은 명시 하지 않는 이유
- RuntimeException은 프로그래밍 자체가 야기한 문제들을 표현

  코드에서 그런 문제(산술, 포인터, 인덱싱 예외 등)를 복구하고 처리하는걸 예상할 수 없음

- RuntimeException은 프로그램 어디서나 발생할 수 있고 특정 어느 곳에서는 많이 발생할 수 도 있음

  RuntimeException을 메소드에 모두 명시하는 것은 프로그램의 명료함을 떨어뜨릴수 있음


#### RuntimeException을 throw하는 사례
메소드에 아규먼트가 잘못 전달되어 null이라면 메소드는 unchecked exception인 NullPointerException을 throw할 수 도 있다

#### checked exception과 unchecked exception을 만드는 사례
메소드가 발생할 수 있는 예외를 명시하기가 귀찮다고해서 그냥 RuntimeException을 throw하거나  RuntimeException의 서브클래스의 예외를 만들면 안됨

- 코드에서 예외 처리를 할 수 있도록 예상할 수 있다면 checked exception을 만든다

- 코드에서 예외 복구에 대해 아무것도 할 수 없다면 unchecked exception을 만든다



---
###### 관련 리소스
- [The Java™ Tutorials](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
- [정상혁님 블로그](http://egloos.zum.com/benelog/v/1901121)
