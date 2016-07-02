#부록 - JDK 1.5에 추가된 기능

##1. 향상된 for문
배열과 컬렉션에 저장된 요소에 접근하기 할 때 기존보다 편리한 방법으로 처리할 수 있도록 for문의 새로운 문법 추가

	1.배열
		for(배열의 타입 변수명 : 배열){
        	//반복할 문장
        }
	2.컬렉션
		for(컬렉션에 저장된 요소의 타입 변수명: 컬렉션){
        	//반복할 문장
        }

```java
for(int i=0; i<arr.length; i++){
	System.out.println(arr[i]);
}

for(int i=0 : arr){
	//arr[i]가 아닌 i라는 것에 유의
	System.out.println(i);
}
```
```java
for(;it.hasNext();){
	System.out.println(it.next());
}

for(Integer i : list){
	System.out.println(i);
}
```
향상된 for문은 배열보다 컬렉션에 저장된 요소에 접근할 때 더욱 코드가 간결
향상된 for문내에서 삭제와 같이 컬렉션을 변경하는 동작을 해서는 안된다.

##2. 오토박싱(autoboxing)
컬렉션에는 객체로 저장해야하기 때문에 기본형 값을 저장하기 위해서는 Wrapper(Integer나 long과 같은)클래스를 사용해야했다.
컴파일러에 의해서 자동적으로 Wrapper클래스로 변환되어 저장되는 데 이것을 오토박싱이라고 한다.
저장된 값을 꺼낼 때도 변환과정을 거치지 않고도 기본형 형태의 값을 바로 얻을 수 있는데 이것을 언박싱이라고 한다.

```java
ArrayList list = new ArrayList();
list.add(new Integer(10));
list.add(new Integer(20));
list.add(new Integer(30));

Integer i = (Integer)list.get(0);
int value = i.intValue();
```
```java
ArrayList<Integer> list = new ArrayList<Integer>;
list.add(10);
list.add(20);
list.add(30);

int value = list.get(0);
```

##3. 타입에 안전한 열거형(Typeafe enums) p-948
자바의 열거형은 C언어의 열거형보다 더 향상된 개념의 열거형으로
열거형이 갖는 값뿐만 아니라 타입까지 관리하기 때문에 보다 논리적인 오류를 줄일 수 있다.

열거형은 메서드나 생성자에도 적용될 수 있으나 잘 사용되지 않는다.
보다 자세한 내용은 Java API문서 참고

##4. 가변인수(Varargs)
JDK1.5 부터는 동적으로 매개변수의 개수를 지정해 줄 수 있게 되었다.

가변인수는 '타입... 변수명'와 같은 형식으로 정의한다.

	public String concatenate(String... str){/*내용생략*/}

가변인수의 대표적인 예는 PrintStream의 printf()와 MessageFormat의 format()

[예제A-2 p-950]
```java
static String concatenate(String delim,String... args){
	String result="";

    for(String str : args){
    	result += str + delim;
    }

	return result;
}

staic String concatenate(String... args){
	return concatenate("",args);
}
```
가변인수를 선언한 메서드를 오버로딩할 때는 구별되지 모하는 경우가 발생하기 쉽기 때문에 주의해야한다.
가능하면 가변인수를 사용한 메서드를 오버로딩하지 않는 것이 좋다.

##5. static import문
static import문을 사용하면 static멤버를 호출할 때 클래스명을 생략할 수 있다.

코딩을 편리하게 해주지만 남용하면 오히려 독이 될 수 있기 때문에 주의
[참고]http://uncle-bae.blogspot.kr/2016/06/java-static-import-import.html

```java
import static java.lang.System.out;
import static java.lang.Math.*;

//System.out.println(Math.random());
out.println(random());
```

##6. StringBuilder
StringBuilder는 StringBuffer와 완전히 동일한 클래스이다.
동기화처리를 하지 않기 때문에 멀티쓰레드 프로그래밍에서 사용하면 안된다.
멀티쓰레드 프로그래밍이 아닌 경우에는 StringBuffer보다 빠른 성능을 보장

동기화 여부를 제외하고는 두 클래스가 기능상으로 완전히 동일
StringBuffer타입의 참조변수를 선언한 부분과 StringBuilder의 생성자만 바꾸면 된다.

```java
StringBuffer sb;
sb = new StringBuffer();
sb.append("abc");

StringBuilder sb;
sb = new StringBuilder();
sb.append("abc");
```
StringBuffer도 충분히 성능이 좋기 때문에 성능향상이 반드시 필요한 경우를 제외하고는
기존에 작성한 코드에서 굳이 바꿀 필요는 없을 것이다.