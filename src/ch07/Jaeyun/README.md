Ch06. 객체지향 프로그래밍 II
===
## 상속(inheritance)

#### 상속이란

> 기존 클래스를 재사용하여 새로운 클래스를 작성하는 것

###### 상속의 쓰임

- 관계에서 계층 구조를 표현

  IS-A 관계 class 나 extends class 가 일때 나 class is a 가 class

- 코드의 재사용


---
작성중..

---
## 다형성(polymorphism)

#### 다형성이란

> 다형성이라는 용어는 하나의 유기체나 종이 여러 형태나 발달 단계를 가질 수 있다는 생물학의  한 원리를 말한다

>	OOP에서 하나의 타입으로 여러 타입의 인스턴스를 가질(참조할) 수 있다

> 한 클래스의 서브클래스들은 각각의 고유한 behavior를 정의(구현)할 수 있고 몇몇의 같은 기능들은 부모클래스로부터 공유 받을 수 있다. 이를 통해 공통의 인터페이스로 통해 서브클래스들의 고유의 behavior를 사용할 수 있다

#### 구현

###### 부모클래스 타입의 참조변수로 서브클래스 인스턴스를 참조

Tv클래스와 CaptionTv클래스의 관계

![Tv클래스와 CaptionTv클래스의 관계](https://raw.githubusercontent.com/yoistudy/java_review/master/src/ch07/Jaeyun/01_tv_and_captiontv_class.png)

```java
Tv tv = new CaptionTv(); // 부모클래스 타입의 참조변수가 서브클래스 인스턴스를 참조
CaptionTv cTv = new CaptionTv(); // 인스턴스 타입과 같은 참조변수
```
- Tv타입의 참조변수인 tv는 CaptionTv인스턴스 중에서 Tv클래스의 멤버들만 사용 할 수 있다

  사용가능한 멤버 5개; power, channel, power(), channelUp(), channelDown()

- 인스턴스의 타입과 같은 참조변수 cTv는 인스턴스의 모든 멤버들을 사용할 수 있다

	사용가능한 멤버 7개; power, channel, text, power(), channelUp(), channelDown(), caption()

###### 서브클래스 타입의 참조변수로 부모클래스 인스턴스를 참조

```java
CaptionTv cTv = new Tv(); // 컴파일 에러 발생
```
참조변수 cTv의 타입인 CaptionTv(서브클래스)로 Tv(부모클래스)를 참조하게되면 Tv에 존재하지 않는 멤버를 cTv로 사용하고자 할 가능성이 있으므로 허용되지않는다

참조변수의 타입이 참조변수가 참조하고 있는 인스턴스에서 사용할 수 있는 멤버를 결정한다


#### 참조변수의 형변환

> 형변환은 참조변수의 타입을 변환하는 것이지 인스턴스를 변환하는 것이 아니다

> 형변환을 통해서 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 범위를 조절하는 것

- 서브클래스의 타입 -> 부모클래스의 타입 (up-casting) - 캐스트연산자 생략 가능

- 부모클래스의 타입 -> 서브클래스의 타입 (down-casting) - 명시적 형변환 필요, 캐스트연산자 생략 불가



![Car클래스와 FireEngine, Ambulance클래스의 관계](https://raw.githubusercontent.com/yoistudy/java_review/master/src/ch07/Jaeyun/02_car_and_fireengine_and_ambulance_class.png)

```java
Car car = new null;
FireEngine fe = new FireEngine();
FireEngine fe2 = null;
Ambulance am = null;

car = fe; // car = (Car)fe;과 같다
fe2 = (FireEngine)car; // 부모클래스 타입인 참조변수 car를 서브클래스로 형변환할 때 명시적으로 형변환 필요
am = (Ambulance)fe; // 컴파일 에러, 같은 부모를 갖는 서브클래스간 형변환은 허용되지 않음 형변환은 부모-자식 관계일 때 가능

```

#### instanceof 연산자

`참조변수 instanceof 인스턴스타입`

- 참조변수의 인스턴스의 타입을 알아보기 위해 사용

- 연산결과로 boolean값을 반환

```java
if (fe instanceof FireEngine) { // fe는 FireEngine 타입 인스턴스를 참조하기 때문에 true 반환
  System.out.println("fe는 FireEngine타입의 인스턴스");
}

if (fe instanceof Car) { // FireEngine 타입이 Car를 상속받았기 때문에 true를 반환
  System.out.println("fe는 Car타입의 인스턴스");
}

if (fe instanceof Object) { // FireEngine 타입이 Car를 상속받았고 Car는 Object를 상속받았기 때문에 true를 반환
  System.out.println("fe는 Object타입의 인스턴스");
}
```

#### 참조변수와 인스턴스의 연결

###### 부모클래스에 선언된 멤버변와 같은 이름의 인스턴스 멤버를 서브클래스에 중복으로 정의했을 때

- 참조변수의 타입에 따라 참조변수의 멤버변수를 사용함

- 참조변수의 타입에 관계없이 (오버라이딩된)멤버 메소드를 사용함


#### 매게변수의 다형성

#### 여러 종류의 객체를 하나의 배열로 다루기


## 추상클래스(abstract class)

#### abstraction이란

> 특정 관점에서 객체들의 공통된 속성과 기능들을 불필요한(구현에 관한) 상세를 제외하고 추출하여 일반화 하는 것

#### 추상클래스란


---
작성중..

---
