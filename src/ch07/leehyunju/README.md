#Ch.7 객체지향 프로그래밍 II
- - -
[TOC]

##1.상속(inheritance)
###1.1 상속이란?
* 기존의 클래스를 재사용하여 새로운 클래스를 작성
* 적은 양의 코드로 새로운 클래스 작성 가능
* 코드를 공통적으로 관리 가능
* 코드의 추가 및 변경이 용이
-> 코드의 재사용성 증가.
-> 코드 중복 제거를 통한 프로그램의 생산성과 유지보수에 기여

> 생성자와 초기화 블럭은 상속되지 않는다. 맴버만 상속된다.
> 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.

```java
class parent{ int age;}
class child01 extends parent{
  void hi(){
  system.out.println("hi");}}
class child02 extends parent {
  void hellow(){
  System.out.println("hellow");}
class grandchild extends child01 {
  void thanks(){
  System.out.println("thanks");}}
```


|클래스 이름|클래스 멤버
|---|
|parent|age|
|child01|age,hi()|
|child02|age,hellow()|
|grandchild|age,hi(),thanks()|

###1.2 클래스 간의 관계
* 포함(composite)
-> 하나의 클래스를 작성하는 데 다른 클래스를 맴버 변수르 선언하여 포함
-> 클래스 재사용율 높임
```
class Circle{int x,y,r; }   //x,y좌표(원점), r반지름
class Point{int x,y;}  //x,y좌표(원점)
```
|포함을 통한 클래스 활용
```
class Point{int x,y;}
class Circle{ Point p = new Point(); int r;}
```

###1.3 클래스간 관계설정하기(inheritance VS. composite)
* 상속관계 : '~은 ~이다.'(is-a)
-> A Circle is a Shape. //1. 원은 도형이다.
-> A Circle has a Shape. //2. 원은 도형을 갖고 있다.
* 포함관계 : '~은 ~을 가지고 있다.'(has-a)
-> A Circle is a Point. //3. 원은 점이다.
-> A Circle has a Point. //4. 원은 점을 갖고 있다.

###1.4 단일 상속
* C++ 다중 상속 가능
* JAVA 단일 상속만 가능
-> 클래스 간의 관계 보다 명확
-> 코드 신뢰할 수 있게 만들어 줌
```
class TV{ void power(){} }
class VCR{ void power(){} }
class TVCR extends TV, VCR{} // which power()?
```

###1.5 Object클래스 - 모든 클래스의 조상
* 컴파일러는 상속을 지정하지 않은 클래스에 대해 자동적으로 extends Object를 추가한다.
```
class Tv{} //컴파일 전
class Tv extends Object{} //컴파일 후
```

- - - - -

##2.오버라이딩
###2.1 오버라이딩이란?
* 상속받은 메서드의 내용을 변경하는 것
```java
class Point{
  int x,y;
  String getLocation(){
  return "x:"+x+"y:"+y;
  }
}
class Point3D extends Point{
  String getLocation(){ int z;
  return "x:+x+"y:"+y+"z:"+z;
  }
}
```

###2.2 오버라이딩의 조건
1. 접근 제어자는 조상 클래스의 메서드 보다 좁은 범위로 변경할 수 없다.
-> public, protected, (default), private
2. 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.
-> throws IOException, SQLException, Exception
3. 인스턴스 메서드를 static메서드로 또는 그 반대로 변경할 수 없다.

###2.3 오버로딩VS.오버라이딩
* 오버로딩 : 기존에 없는 새로운 메서드를 정의하는 것(new)
* 오버라이딩 : 상속받은 메서드의 내용을 변경하는 것(change, modify)
```java
class Parent{ void parentMethod(){return "method"};}
class Child extends Parent{
  void parentMethod(){return "method"+"overriding";} //오버라이딩
  void parentMethod(int i){} //오버로딩
  void childMethod(){}
  void childMethod(int i){} //오버로딩
  void childMethod(){} //에러. 중복정의
}
```

###2.4 super
* super : 조상 클래스로부터 상속받은 멤버 참조
-> 상속받은 멤버와 자신의 클래스에 정의된 멤버의 이름이 같을 때 super로 구별
-> 조상 클래스로 부터 상속받은 멤버도, 자손 클래스 자신의 멤버이므로 super대신 this사용 가능
* this : 멤버변수와 지역변수의 이름 같을 때 구별
* 모든 인스턴스의 메서드에는 자신이 속한 인스턴스의 주소가 지역변수로 저장.
-> 이 것이 참조변수인 this와 super의 값이 됨
```java
class SuperTest{
  public static void main(String args[]){
   Child c = new Child();
   c.method();
  }}
class Parent{ int x=10;}
class Child extends Parent{ int x=20;
void method(){
System.out.println("x="+x);
System.out.println("this.x="+this.x);
System.out.println("super.x="+super.x);
}}
```
|실행결과|
|---|
|x=20|
|this.x=20|
|super.x=10|
-> 조상 클래스에서 선언된 멤버변수와 같은 이름의 멤버변수를 중복 정의 가능
-> super을 통해 서로 구별 가능
-> 변수 뿐만 아니라 메서드도 super를 써서 호출 가능
-> 특히 조상 클래스의 메서드를 자손 클래스에서 오버라이딩 한 경우, super을 통해 조상 클래스의 매서드 사용 가능

###2.5 super() - 조상 클래스의 생성자
* Object 클래스를 제외한 모든 클래스의 생성자 첫 줄에는 생성자 this() 또는 super()를 호출해야 한다.
* 그렇지 않으면, 컴파일러가 자동적으로 'super();'를 생성자의 첫줄에 삽입한다.
```java
class PointTest{
  public static void main(String args[]){
  Point3D p3= new Point3D(1,2,3);
  }
}
class Point{
  int x,y;
  Point (int x, int y){ //기본생성자 Point()의 부재
    this.x=x;
    this.y=y;
  }
  String getLocation(){
    return "x:"+x+"y:"+y;
  }
}
class Point3D extends Point{
 int z;
 Point3D(int x, int y, int z){
 this.x=x;, this.y=y; this.z=z;
 }
 String getLocation(){
   return "x:"+x+"y:"+y+"z:"+z;
 }
}
```

```
컴파일 결과
-------
c:\jdk1.8\work>javac PointTest.java
PointTest.java:22: cannot resolve symbol
symbol : constructor Point()
location: class Point
Point3D(int x, inty, int z){
^
1 error
```
-> 1) point3D(int x, int y, int z)의 첫줄에 super(x,y);를 삽입
-> 2) class Point에 기본 생성자 Point()를 삽입


##3.Package와 Import
###3.1 패키지(pakage)
* 하나의 소스파일에는 첫 번째 문장으로 단 한번의 패키지 선언만을 허용한다.
* 모든 클래스는 반드시 하나의 패키지에 속해야 한다.
* 패키지는 점(.)을 구분자로 하여 계층구조로 구성할 수 있다.
* 패키지는 물리적으로 클래스 파일(.class)을 포함하는 하나의 디렉토리이다.
-> ex) java.lang.String : java라는 패키지 안의 lang이라는 패키지 안의 String라는 클래스

###3.2 패키지의 선언
```
package 패키지명;
```
-> 작성법 : 클래스나 인터페이승의 소스파일(.java)에 위의 한줄을 적어주면 작성 가능
-> 패키지 선언문은 반드시 소스파일에서 주석과 공백을 제외한 첫번째 문장이어야 함
-> 하나의 소스파일에 단 한번만 선언 가능
-> 패키지 미 생성 시, 자동으로 이름없는 패키지 적용(unnamed package)
```
ex)
package com.javachobo.book;

class PackageTest{
  public static void main(String[] args){
    Systme.out.println("hello World!")
  }
}
```

```
ex2)
c:\jdk1.8\work>javac -d . PackageTest.java
```
>-> ex1의 코드를 ex2로 컴파일하면(-d 옵션 : 생성) 지정된 경로를 통해 패키지의 위치를 찾아서 클래스파일 생성
-> 패키지와 일치하는 디렉토리가 없는 경우 자동 생성
-> '-d' 옵션 뒤에는 해당 패키지의 루트(root)디렉토리의 경로를 적어줌
-> c:\jdk1.8>work>com>javachobo>book>PackageTest.class
[참고1] 만일 '-d' 옵션을 사용하지 않으면, 프로그래머가 직접 패키지의 계층구조에 맞게 디렉토리를 생성해야 한다.
[참고2] 클래스패스(classpath)는 컴파일러(javac.exe)나 JVM등이 클래스의 위치를 찾는데 사용되는 경로이다.
-> 클래스패스를 지정해 주지 않음ㄴ, 기본적으로 현재 디렉토리(.)가 클래스패스로 지정
-> 클래스패스를 따로 지정해 주는 경우에는 별도 추가 필요

```
ex3) 패스 포함
c:\WINDOWS>SET CLASSPATH=.;c:\jdk1.8\work;c:\jdk1.8\work\util.jar;
ex4) 실행 시
c:\WINDOWS>echo %classpath%.;c:\jdk1.8\work;
ex5) 실행 결과
c:\WINDOWS>java com.javachobo.book.PackageTest
Hello World!
ex6) -cp옵션을 사용해 일시적으로 클래스패스 지정
c:\WINDOWS>java -cp c:\jdk1.8\work com.javachobo.book.PackageTest
```   
[참고3] jre 디렉토리 아래의 classes디렉토리는 JDK설치 시에 자동으로 생성되지 않으므로 사용자가 직접 생성해야 한다.

###3.3 import문
* import문으로 사용하고자 하는 클래스의 패키지를 미리 명시 해주면, 패키지 명 생략 가능

###3.4 import문의 선언
```
[소스파일(*.java)의 구성 순서]
1) package문
2) import문
3) 클래스 선언
```
```java
ex1)
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
=> import java.util.*; 
=> import java.*; //클래스 이름 대신 *는 사용가능하지만, *는 하위 카테고리를 포함하지는 않음
ex2)
java.util.Date today = new java.util.Date();
ex3)
import java.util.Date;
Date today = new Date();
```

###3.5 static import문
* static import문 사용 시, static멤버 호출 시 클래스 이름 생략 가능
```java
ex1)
import static java.lang.Integer.*; //Integer클래스의 모든 static 매서드
import static java.lang.Math.random; //Math.random()만, 괄호 안붙임.
import static java.lang.System.out; //System.out을 out만으로 참조가능
ex2)
System.out.println(Math.random());
->
out.println(random());
```



##4.제어자
###4.1 제어자란?
>접근 제어자 : public, protected, default, private
>그 외 : static, final, abstract, native, transient, synchronized, volatile, strictfp

->접근 제어자는 4가지중 하나만 선택 사용 가능

###4.2 static - 클래스의, 공통적인
> static : 멤버변수, 메서드, 초기화 블럭에 사용가능
> [멤버변수]
> - 모든 인스턴스에 공통적으로 사용되는 클래스 변수
> - 클래스변수는 인스턴스를 생성하지 않고도 사용 가능
> - 클래스가 메모리에 로드될 때 생성
> 
> [매서드]
> - 인스턴스를 생성하지 않고도 호출이 가능한 static메서드가 됨
> - static메서드 내에서는 인스턴스 멤버들을 직젖사용 불가

[참고] static 초기화 블럭은 클래스가 메모리에 로드될 때 단 한버난 수행되며, 주로 클래스변수(static변수)를 초기화하는데 주로 사용
```java
class StaticTest{
  static int width = 200; //클래스변수(static 변수)
  static int height = 120; //클래스변수(static 변수)
  static {} //클래스 초기화 블럭, static변수의 복잡한 초기화 수행
  static int max(int a, int b){
   return a>b?a:b;
  }
}
```

###4.3 final - 마지막의, 변경될 수 없는
> final : 클래스, 메서드, 멤버변수, 지역변수에 사용가능
> [클래스]
> - 변경될 수 없는 클래스, 확장될 수 없는 클래스가 됨
> - final로 지정된 클래스는 다른 클래스의 조상이 될 수 없음
> 
> [메서드]
> - 변경될 수 없는 메서드, final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다.
>
>  [멤버변수/지역변수]
> - 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.

[참고] 대표적인 final클래스로는 String과 Math클래스가 있다.
```java
final class FinalTest{  //조상이 될 수 없는 클래스
  final int MAX_SIZE=10; //값을 변경할 수 없는 멤버변수(상수)
  final void getMaxSize(){ //오버라이딩 할 수 없는 메서드(변경불가)
    final int LV = MAX_SIZE; //값을 변경할 수 없는 지역변수(상수)
    return MAX_SIZE;
  }
}
```

###4.4 abstract - 추상의, 미완성의
> abstract : 클래스, 매서드에 사용 가능
> [클래스]
> - 클래스 내에 추상 메서드가 있음을 의미
> 
> [메서드]
> - 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알림

-> 추상 클래서는 완성되지 않은 메서드가 존재하므로, 인스터스 생성 불가
-> 완성된 메서드를 추상 클래서를 만드는 경우 : 인스턴스를 생성 불가하도록 하기 위해서
```java
abstract class AbstractTest{ //추상 클래스(추상 메서드를 포함한 클래스)
  abstract void move(){} //추상 메서드(구현부가 없는 메서드)
}
ex)
public abstract class WindowAdapter
  implements WindowListener, WindowStateListener, WindowFocusListener{
    public void windowOpened(WindowEvent e){}
    public void windowClosingwEvent e){}
    public void windowclosedowEvent e){}
    public void windowIconifieEvent e){}
  }
```

###4.5 접근 제어자(access modifier)
> 접근 제어자 : 클래스, 멤버변수, 메서드, 생성자 에서 사용 가능
> - private : 같은 클래스 내에서만 접근 가능
> - default :  같은 패키지 내에서만 접근 가능
> - protected : 같은 패키지 내에서, 그리고 다른 패키지의 자손 클래스에서 접근 가능
> - public : 접근 제한이 없음
>
> public > protected > default > private

> [접근 제어자를 이용한 캡슐화]
> - 데이터감추기(data hiding) : 데이터 보호 및 외부로부터의 접근 제한
> -> 객체 지향개념의 캡슐화(encasulation)에 해당

> [접근 제어자를 사용하는 이유]
> - 외부로 부터 데이터를 보호하기 위해
> - 외부에서 불필요한, 내부적으로만 사용되는 부분을 감추기 위해서

> [생성자의 접근 제어자]
> - 생성자를 통해 직접 인스턴스 생성 불가하게 함
> - public 메소드를 통해 인스턴스에 접근하게 하여, 사용 가능한 인스턴스 개수 제한 가능
> -> 단, 생성자가 private인 클래스는 다른 클래스의 조상이 될 수 없음


###4.6 제어자(modifier)의 조합
> 클래스 : public, (default), final, abstract
> 메서드 : 모든 접근 제어자, final, abstract, static
> 멤버변수 : 모든 접근 제어자, final, static
> 지역변수 : final

```
1. 메서드에 static과 abstract를 함께 사용할 수 없다.
  - static메서드는 몸통이 있는(구현부분) 메서드에만 사용할 수 있기 때문이다.
2. 클래스에 abstract와 final을 동시에 사용할 수 없다.
  - 클래스에 사용되는 final은 클래스를 확장할 수 없다는 의미이고,
    abstract는 상속을 통해서 완성되어야 한다는 의미이므로 서로 모순되기 때문이다.
3. abstract메서드의 접근 제어자가 private일 수 없다.
  - abstract메서드는 자손클래스에서 구현해주어야 하는데
    접근 제어자가 private면, 자손 클래스에서 접근할수 없기 때문이다.
4. 메서드에 private과 final을 같이 사용할 필요는 없다.
  - 접근 제어자가 privaate인 메서드는 오버라이딩 될 수 없기 때문이다.
    이 둘 중 하나만 사용해도 의미가 충분하다.
```



##다형성
##추상클래스
##인터페이스
##내부클래스