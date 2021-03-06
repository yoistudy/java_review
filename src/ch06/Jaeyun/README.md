Ch06. 객체지향 프로그래밍 I
===
## 객체지향언어

#### 객체지향이론

> 실제 세계는 사물(객체)로 이루어져 있으며, 발생하는 모든 것들은 사물간의 상호작용

> 객체 지향이론은 상속, 캡슐화, 추상화 개념을 중심으로 발전

#### 객체지향언어의 역사

- 1960년대 중반 객체지향이론을 프로그램에 적용한 Simula라는 최초의 객체지향언어 탄생

- 절차적 언어로는 한계를 느끼고 객체지향언어를 이용한 개발방법론이 대안으로 떠오름

- 1995년 자바가 발표되고 인터넷의 발전과 함께 객체지향언어는 프로그래밍언어의 주류로 자리잡음

#### 객체지향언어

주요특징

- 코드의 재사용성이 높음

- 코드의 관리가 용이

- 신뢰성이 높은 프로그래밍을 가능하게 함

  제어자와 메서드를 이용해 데이터를 보호하고 올바른 값을 유지시켜줌

  코드의 중복을 제거하여 중복된 코드의 불일치로 인한 오작동 방지

## 클래스와 객체

#### 클래스와 객체의 정의와 용도

> 클래스란 객체를 정의해 놓은것, 객체를 생성하는데 사용

> 객체란 실제로 존재하는 사물 또는 개념

- 클래스는 단지 객체를 생성하는데 사용될 뿐, 객체 그자체는 아님

- 객체를 사용하기 위해서 먼저 클래스로부터 객체를 생성하는 과정이 선행되어야 함

- JDK에서 유용한 클래스(Java API)를 기본적으로 제공

#### 객체와 인스턴스

> 클래스의 인스턴스화란 클래스로부터 객체를 만드는 과정

> 인스턴스란 어떤 클래스로부터 만들어진 객체

#### 객체의 구성요소 - 속성과 기능

- 객체는 속성과 기능으로 이루어져 있고 다수의 속성과 다수의 기능을 가질수 있음

- 속성과 기능을 그 객체의 멤버라고 함

- 속성(property)의 용어들 :

  - 멤버변수(member variable)

  - 특성(attribure)

  - 필드(field)

  - 상태(state)

- 기능(function)의 용어들 :

  - 메서드(method)

  - 행위(behavior)

  - 함수(function)

###### TV라는 클래스
|  속성 | 기능 |
|:-----|:-----|
| 크기, 길이, 높이, 색상, 볼륨, 채널... | 켜기, 끄기, 볼륨 높이기/낮추기, 채널 변경하기... |

- 속성을 멤버 변수로 표현

  볼륨 -> `int volume`

- 기능을 메서드로 표현

  볼륨 높이기  -> `volumeUp() { ... }`

- Tv 클래스 만들기

```java
class Tv {
  // Tv의 속성(멤버변수)
  String color;
  boolean power
  int volume;

  // Tv의 기능(메서드)
  void power() { power = !power; }
  void volumeUp() { ++volume; }
  void volumeDown() { --volume; }
}
```

#### 인스턴스의 생성과 사용

###### 변수 선언과 인스턴스 생성

```java
// 클래스명 참조변수명;
Tv tv; // Tv 클래스 타입의 참조변수 tv선언

// 변수명 = new 클래스명();
tv = new Tv(); // Tv인스턴스를 생성한 후 생성된 Tv인스턴스의 주소를 tv에 저장

```

1. `Tv tv;` : Tv클래스 타입의 참조변수 Tv를 선언. 참조변수 Tv가 메모리 공간에 생성

2. `tv = new Tv();`

  - 연산자 `new`에 의해 Tv클래스의 인스턴스가 메모리 공간에 생성

  - 각 멤버변수는 타입의 기본값으로 초기화

  - 대입연산자 `=`에 의해 생성된 인스턴스의 주소값을 참조변수 Tv에 저장

###### 멤버변수와 메서드 사용

```java
// 변수명.멤버변수;
tv.volume = 10; // 인스턴스의 멤버변수 접근

// 변수명.메서드;
tv.volumeDown(); // 인스턴스의 메서드 호출
```

1. `tv.volume = 10;` : 대입연사자 `=`에 의해 Tv클래스 인스턴스의 멤버변수 volume에 값 10을 저장

2. `tv.volumeDown();` :

  - Tv클래스 인스턴스의 메소드 volumeDown이 호출됨

  - 메서드 내부 `--volume;`가 실행되어 멤버변수 volume을 값을 1감소

#### 클래스의 또 다른 정의

###### 데이터와 함수의 결합

> 변수 - 하나의 데이터를 저장할 수 있는 공간

> 배열 - 같은 종류의 데이터를 하나의 집합으로 저장할 수 있는 공간

> 구조체 - 서로 관련된 여러 데이터를 종류에 관계없이 하나의 집합으로 저장할 수 있는 공간

> 클래스 - 데이터와 함수의 결합(구조체 + 함수)

###### 사용자정의 타입

> 사용자정의 타입이란 프로그래밍 언어에서 제공하는 기본타입 외에
서로 관련된 변수들을 묶어서 하나의 타입으로 새로 추가하는 것

예를 들어 시간이라는 개념을 표현하기 위해 시, 분, 초 변수들을 하나의 단위로 묶은 시간타입으로 사용하는 것

## 변수와 메서드

#### 선언 위치에 따른 변수의 종류

> 변수는 클래스변수, 인스턴스변수, 지역변수 세 종류가 있다

|  변수의 종류 | 선언위치 | 생성시기 |
|:---:|:---:|:----|
| 클래스변수| 클래스 영역 | 클래스가 메모리에 올라갈 때 |
| 인스턴스변수| 클래스 영역 | 인스턴스가 생성되었을 때 |
| 지역변수| 클래스 이외의 영역의 블럭(메서드, 생성자, 초기화) 내부 | 변수 선언문이 수행되었을 때 |

###### 인스턴스변수

- 인스턴스를 생성이 선행되어야 인스턴스변수의 값을 읽어 오거나 저장 가능

- 인스턴스변수는 인스턴스마다 독립적인 공간을 갖음

  인스턴스마다 고유한 상태를 유지해야하는 속성의 경우 인스턴스변수로 선언하여 사용

###### 클래스변수

- 인스턴스 변수 앞에 `static`을 붙여서 선언

- 인스턴스를 생성하지 않고도 언제라도 바로 사용 가능

  `클래스이름.클래스변수`로 사용

- 인스턴스마다 독립적인 공간을 갖는 인스턴스변수와 달리 모든 인스턴스가 공통된 저장공간(변수)을 공유

  한 클래스의 모든 인스턴스들이 공통적인 값을 유지해야하는 속성의 경우 클래스변수로 선언하여 사용

###### 지역변수

- 블럭 내에서 선언과 사용이 가능하며 블럭을 벗어나면 사용 불가

#### 메서드

> 작업을 수행하기 위한 명령문의 집합

> 주로 입력값을 받아서 처리하고 결과를 돌려줌, 입력값이 없을 수 도있고 결과 값을 반환하지 않을 수 도 있음

- 반복적으로 수행되어야 하는 여러 문장을 하나의 메서드로 정의해 놓으면 좋음

- 하나의 메서드는 한 가지 기능만 수행하도록 작성하는 것이 좋음

- 관련된 여러문장을 하나의 메서드로 만들어 놓는 것이 좋음

###### 메서드 작성
```java
// 리턴타입 메서드이름 (타입 변수명, 타입 변수명, ..)
int add(int a, int b) {
  // 구현부
  int result = a + b;
  return result; // 결과를 반환 한다
}

```
#### return문

###### 메서드가 정상적으로 종료되는 경우

- 메서드의 블럭 내의 마지막 문장까지 수행했을 때

- 메서드 블럭 내에 있는 문장을 수행중 return문을 만났을 때

  - 반환값이 없는 경우 `return;`만 써주면 됨

  - 반환값이 있는 경우 `return 반환값;`만 써주면 됨

    반환값은 메서드의 선언부에 정의된 반환타입과 일치하거나 반환타입으로 자동형변환 가능한 것이어야함

    어떠한 경우에도 return문에 의해 결과가 반환 되어야 하기 때문에 조건문 안에 return문이 있다면 조건식 결과의 모든 경우에 return문이 수행될 수 있도록 해야 한다

#### 메서드의 호출

- 매개변수 없을 경우

  `참조변수.메서드이름();`

- 매개변수 있을 경우

  `참조변수.메서드이름(값1, 값2, ...);`

  호출 시 매개변수 타입은 자동형변환이 가능한 타입의 값을 지정해야한다

#### JVM 메모리구조

응용프로그램이 실행되면 JVM은 시스템으로 부터 필요한 메모리를 할당 받고 이 메모리를 용도에 따라 여러 영역으로 나누어 관리

###### JVM 주요 메모리 영역

- 메서드(method) 영역

  프로그램 실행 중 어떤 클래스가 사용되면 JVM은 해당 클래스의 클래스파일을 읽어서 분석하고 클래스에 대한 정보를 이곳에 저장

  그 클래스의 클래스변수도 이 영역에 함께 생성

- 힙(heap) 영역

  인스턴스가 생성되는 공간,

  프로그램 실행 중 생성되는 인스턴스는 모두 이곳에 생성, 즉 인스턴스변수들이 생성되는 공간

- 호출스택(call stack)

  메서드의 작업에 필요한 메모리공간을 제공

  메서드가 호출되면 호출된 메서드를 위한 메모리가 호출스택에 할당됨()

  메서드가 작업을 수행하는 동안 지역변수들과 연산의 중간결과 등을 저장하는데 사용됨

  메서드가 작업을 마치면 할당되었던 메모리공간은 반환되어 비워진다

관련리소스 - [Java Virtual Machine, Call stack, Java Byte Code](http://www.slideshare.net/javajigi/java-virtual-machine-call-stack-java-byte-code)

#### 기본형 매개변수와 참조형 매개변수

메스드를 호출 할때 매개변수로 지정한 값을 메서드의 매게변수에 복사해서 넘겨준다

매개변수의 타입이 기본형일 때는 값이 저장되어있기 때문에 값이 복사되고

참조형일 때는 주소가 저장되어있기 떄문에 주소가 복사되어 전달된다 (즉 참조된다)

- 기본형 매개변수 - 변수의 값을 읽기만 할 수 있음 (read only)

- 참조형 매개변수 - 변수의 값을 읽고 변경 할 수 있음 (read & write)

#### 재귀호출

> 재귀호출이란 매서드 내부에서 자기 자신을 다시 호출하는 것

- 매소드를 간단하게 하기 위해 반복문 대신 재귀호출을 이용할 수 있음

- 메서드를 호출하는데 비용이 추가적으로 들기 때문에 효율이 떨어 짐

- 반복문과 마찬가지로 무한호출에 빠지지 않기위해 탈출조건이 있어야 함

  무한호출에 빠지면 StackOverflowError가 발생함

```java
// 재귀호출로 구현한 팩토리얼 메서드
long factorial (int n) {
  return (n == 1) ? 1 : n * factorial(n - 1);
}
```
#### 클래스매서드(static매서드)와 인스턴스매서드

###### 인스턴스메서드

- 인스턴스변수와 관련된 작업을 하는 메서드, 인스턴스변수가 필요한 메서드

###### 클래스메서드(static매서드)

- 메서드에 `static`을 붙여서 선언

- 인스턴스를 생성하지 않고도 언제라도 바로 사용 가능

  `클래스이름.클래스메서드`로 사용

- 인스턴스와 관계없는 메서드를 클래스메서드로 정의

#### **static의 사용**

- 클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통적으로 사용하는 것에 static을 붙인다

- 클래스변수(static변수)는 인스턴스를 생성하지 않아도 사용할 수 있다.

- 클래스메서드(static메서드)는 인스턴스변수를 사용할 수 없다

- 메서드 내에서 인스턴스변수를 사용하지 않는다면 static을 붙이는 것을 고려한다

#### 클래스맴버와 인스턴스멤버간의 참조와 호출

- 같은 클래스에 속한 멤버 간에는 별도의 인스턴스를 생성하지 않고도 서로 참조 또는 호출이 가능

- 클래스멤버가 인스턴스멤버를 참조 또는 호출하고자 하는 경우에 인스턴스를 생성해야한다

  인스턴스멤버가 존재하는 시점에 클래스멤버는 항상 존재하지만 클래스멤버가 존재하는 시점에 인스턴스 멤버가 존재할 수 도 있고 안할 수 도 있기 때문이다

## 매서드 오버로딩

#### 매서드 오버로딩이란?

> 한 클래스에서 같은 메서드 이름(식별자)으로 여러개의 매서드를 선언하는 것

> 오버로딩 시에 메서드들은 각각 매개변수의 타입, 개수가 서로 달라야 한다

#### 오버로딩 조건

- 메서드 이름(식별자)이 같아야 한다

- 매개변수의 타입 또는 개수가 달라야 한다

- 매개변수는 같고 리턴타입이 다른경우 오버로딩이 성립되지 않는다

  리턴타입은 오버로딩을 구현하는데 아무런 영향을 주지 못한다

#### 오버로딩 예

PrintStream클래스는10개의 오버로딩이 된 println메서드를 정의

println메서드는 어떤 종류의 매개변수를 지정해도 출력할 수 있다

```java딩
void println()
void println(boolean x)
void println(char x)
void println(char[] x )
void println(double x)
void println(float x)
void println(int x)
void println(long x)
void println(Object x)
void println(String x)
```

#### 오버로딩의 장점

- 같은 기능의 메서드를 매개변수 타입별로 각각 명명하지 않고 오버라이딩을 사용한다면 메서드 명이 간결해지고 사용이 편리함

#### 가변인자와 오버로딩

## 생성자

#### 생성자란?

> 인스턴스가 생성될 때 호출 되는 인스터스 초기화 메서드

> 인스턴스 변수의 초기화 같은 인스턴스 생성시에 실행 되어야할 작업에 사용

- 연산자가 new 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 것은 아님

#### 기본생성자

클래스에 생성자가 하나도 정의되지 않았을 때 컴파일러가 자동적으로 생성자를 추가한다

```java

class Person () {
  Person () {
  }
}
```

#### 매개변수가 있는 생성자

- 매개변수를 선언하여 생성자 호출 시 매개변수를 이용하여 인스턴스 초기화 작업을 할 수 있다

```java
class Car {
  String color ;
  String gearType;
  int door ;

  Car () {} // 생성자
  Car(String c , String g, int d) { // 샘성 자
      color c;
      gearType g ;
      door d
    }

  // Car c = new Car( "white" , "auto" , 4);로 사용
}
```
#### 생성자에서 다른 생성자 호출하기 - this(), this

###### this()와 this

> this - 인스턴스 자신을 가리키는 참조 변수, 인스턴스메서드 지역변수로 존재

> this() - 생성자메서드

###### 같은 클래스의 생성자 간에 서로 호출이 가능하며 조건은

- 생성자의 이름으로 클래스이름 대신 this를 사용

- 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫줄에서만 호출

#### 생성자를 이용한 인스턴스 복사

## 변수의 초기화

#### 변수의 초기화

> 멤버변수와 배열의 초기화는 서낵적이지만 지역변수는 사용전 반드시 초기화 필요

#### 명시적 초기화

> 변수 선언과 동시에 초기화하는 것

```java
class Car  {
  int door = 4;
  Engine e = new Engine();
}
```

#### 초기화 블럭

```java
class Car  {
  static {
  // 클래스 초기화 블럭
  }

  {
  // 인스턴스 초기화 블럭
  }
}
```
- 클래스 초기화 블럭

> 클래스가 메모리에 처음 로딩될 때 한번만 수행

- 인스턴스 초기화 블럭

> 인스턴스가 생성될 때 마다 수행

#### 멤버변수의 초기화 시기와 순서

- 클래스변수 초기화 순서

  > 타입 기본값 -> 명시적 초기화 -> 클래스 초기화 블럭

- 인스턴스변수 초기화 순서

  > 타입 기본값 -> 명시적 초기화 -> 인스턴스 초기화 블럭 -> 생성자
