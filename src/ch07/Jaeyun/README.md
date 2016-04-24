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

###### 부모클래스 타입의 참조 변수로 서브클래스 인스턴스를 참조

Tv클래스와 CaptionTv클래스의 관계

![Tv클래스와 CaptionTv클래스의 관계](https://raw.githubusercontent.com/yoistudy/java_review/master/src/ch07/Jaeyun/01_tv_and_captiontv_class.png)

```java
Tv tv = new CaptionTv(); // 부모클래스 타입의 참조 변수가 서브클래스 인스턴스를 참조
CaptionTv cTv = new CaptionTv(); // 인스턴스 타입과 같은 참조 변수
```
- Tv타입의 참조변수인 tv는 CaptionTv인스턴스 중에서 Tv클래스의 멤버들만 사용 할 수 있다

  사용가능한 멤버 5개; power, channel, power(), channelUp(), channelDown()

- 인스턴스의 타입과 같은 참조변수 cTv는 인스턴스의 모든 멤버들을 사용할 수 있다

	사용가능한 멤버 7개; power, channel, text, power(), channelUp(), channelDown(), caption()

###### 서브클래스 타입의 참조 변수로 부모클래스 인스턴스를 참조

```java
CaptionTv cTv = new Tv(); // 컴파일 에러 발생
```
참조변수의 타입인 서브클래스에 존재하는 멤버를 부모클래스의 인스턴스로 사용하려고 할 수 있다.


---
작성중..

---
