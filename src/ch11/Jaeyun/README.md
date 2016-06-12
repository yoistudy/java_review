Ch11. 컬렉션 프레임웍과 유용한 클래스
===
## 유용한 클래스들

java.util 패키지의 유용한 클래스들을 알아본다

#### Calendar와 Date

- 날짜와 시간에 관견ㄹ된 데이터를 쉽게 처리할 수 있음

- JDK1.0부터 Date가 사용되었고 JDK1.1부터 보다 향상된 기능의 Calendar가 추가 됨

```java
/*
 * Calendar를 Date로 변환
 */
// Calendar는 추상클래스이므로 객체를 생성할 수 없음,
// 구현된 인스턴스를 얻음
Calendar cal = Calendar.getInstance();
..
Date date = new Date(cal.getTimeInMills());

/*
 * Date를 Calendar로 변환
 */
Date date = new Date();
..
Calendar cal = Calendar.getInstance();
cal.setTime(date);
```
Calendar를 구현한 클래스로는 `BuddhistCalendar`, `JapaneseImperialCalendar`, `GregorianCalendar`가 있다

###### Calendar의 스태틱 메서드 getInstance

시스템의 국가와 지역설정을 확인하여 getInstance 메서드로 해당 타입 인스턴스 반환
- 태국 - BuddhistCalendar 타입
- 일본 - JapaneseImperialCalendar 타입
- 그 외 - GregorianCalendar 타입

###### Calendar의 인스턴스 메서드 get, set

```java
Calendar cal1 = Calendar.getInstance();
Calendar cal2 = Calendar.getInstance();

// get 메서드의 인자인 스태틱 상수 값은 내부 fields 베열의 인덱스다
// get(Calendar.MONTH))의 범위는 0(1월)~11(12월)이다
System.out.println("월 " +  cal1.get(Calendar.MONTH))

/*
 * 2016년 6월 19일 14시 10분 30초로 설정하기
 */
// field 하나 씩
cal1.set(Calendar.YEAR, 2016);
cal1.set(Calendar.MONTH, 5);
cal1.set(Calendar.DATE, 19);
cal1.set(Calendar.HOUR_OF_DAY, 14);
cal1.set (Calendar.MINUTE , 10 );
cal1.set (Calendar.SECOND, 30 );
// 인자로 한번에 set하기
cal2.set(2016 , 5, 19 , 14, 10, 30);
```
###### Calendar의 인스턴스 메서드 add, roll

```java
/*
 * 증가 시키기, 필드의 값을 음의 정수를 지정하면 감소시킬 수 있다
 */
// add 메서드로 어떤 필드를 증감할 때 다른 필드의 값에도 영향을 미친다
// 2016년 7월 3일..이 된다
cal1.add(Calendar.DATE, 14);
// roll 메서드로 어떤 필드를 증감할 때 다른 필드에 영향을 미치지 않는다
// (현재 필드를 변경함으로 다른 필드의 값이 유효하지 않은 경우에는 다른필드의 값을 유효한 값으로 변경)
// 2016년 6월 5일..이 된다
cal2.roll(Calendar.DATE, 14);
```
###### Calendar의 인스턴스 메서드 after, before

```java
// after 메소드는 인자보다 이 후 날짜 인지 여부를 리턴
// true
cal1.after(cal2);
// before 메소드는 인자보다 이 전 날짜 인지 여부를 리턴
// false
cal1.before(cal2);
```

#### Random

- 난수를 얻기 위해 Math.random 메소드를 사용할 수도 있지만 Random 클래스를 사용할 수도 있음

- Math.random 메소드와 Random 클래스의 가장 큰 차이점은 Random 클래스는 종자값(seed)를 설정할 수 있다는 것
    생성자에서 인자로 seed를 받으며 기본 생성자는 나노초를 이용해서 seed를 만들어 사용

```java
/*
 * 같은 seed로 Random 클래스 인스턴스를 생성했을 때 같은 값을 반환한다
 */
Random random1 = new Random(1234);
Random random2 = new Random(1234);

// nextInt 메서드는 int 타입 난수를 반환한다
// true
System.out.println("random1 == random2 " +
	(random1.nextInt() == random2.nextInt())
);
// setSeed 메서드는 seed를 인자로 변경한다
random1.setSeed(4321);
// false
System.out.println("random1 == random2 " +
	(random1.nextInt() == random2.nextInt())
);

```

###### 난수를 반환하는 인스턴스 메서드
- `nextBoolean()` - boolean 타입 난수
- `nextBytes(byte[] bytes)` - 난수를 byte 배열
- `nextDouble()` - double 타입의 난수 (0.0 <= x < 1.0)
- `nextFloat()` - float 타입의 난수 (0.0 <= x < 1.0)
- `nextGaussian()` - 평균은 0.0 이고 표준편차는 1.0인 가우시안분포에 따른 double형 난수
- `nextlnt()` - int 타입 난수
- `nextlnt(int n)` - 0 ~ n 범위의 난수 반환
- `nextLong()` - long 타입 난수

#### 정규표현식(Regular Expression) - Pattern. Match



---
