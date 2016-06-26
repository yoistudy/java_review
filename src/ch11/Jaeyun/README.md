Ch11. 컬렉션 프레임웍과 유용한 클래스
===
## 유용한 클래스들

java.util 패키지의 유용한 클래스들을 알아본다

#### Calendar와 Date

- 날짜와 시간에 관련된 데이터를 쉽게 처리할 수 있음

- JDK1.0부터 Date가 사용되었고 JDK1.1부터 보다 향상된 기능의 Calendar가 추가 됨

```java
/*
 * Calendar를 Date로 변환
 */
// Calendar는 추상클래스이므로 객체를 생성할 수 없음,
// 구현된 인스턴스를 얻음
Calendar cal = Calendar.getInstance();
..
Date date = new Date(cal.getTimeInMillis());

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
cal1.set(Calendar.MINUTE, 10);
cal1.set(Calendar.SECOND, 30);
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
// after 메소드는 인자보다 이후 날짜 인지 여부를 리턴
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
// setSeed 메서드는 seed를 새로 set한다
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

#### 정규식(Regular Expression) - Pattern. Match

정규표현식, 줄여서 정규식이라고도 한다

```java
// Pattern 클래스의 스태틱 compile 메서드로 Pattern 인스턴스를 얻는다
// 인자는 정규표현식 문자열
Pattern p = Pattern.compile("(yo[iy])+");

// 일치하는지 검사할 문자열을 전달하여 Matcher 인스턴스 생성
Matcher m = p.matcher("yoiyoy");

// matches 메서드는 일치하는지 여부 반환
Systeom.out.println(m.matches() ? "found!" : "not found");
```

###### find 메서드

```java
String source = "HP:011-1111-1111, HOME:02-999-9999";
// 괄호()로 감싸 그룹핑 할 수 있다
// 표현식에서 감싼 순서대로 1부터 그룹번호를 갖는다
String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
Pattern p = Pattern.compile(pattern);
Matcher m = p.matcher(source);
int i=0 ;

while (m.find()) {
    // goup 메서드로 그룹핑한 패턴을 반환 받을 수 있다.
    // group(0)은 매칭된 문자열을 그루핑하지 않고 전체 반환한다
	System.out.println( ++i + " : " + m. group() + " -> " +
			m.group(1) + ", " + m.group(2) + ", " +  m.group(3));
}
```

#### Scanner

화면, 파일, 문자열과 같은 입력소스로 부터 문자데이터를 읽어오는데 도움을 줌

###### JDK 1.5 부터 지원

```java
// JDK 1.5이전
BufferReader br = new BufferReader(new InputStreamReader(System.in));
String input = br.readLine();

// JDK 1.5이후
Scanner s = new Scanner(System.in);
String input = s.readLine();
```
###### 구분자
- Scanner useDelimiter(String pattern)
- Scanner useDelimiter(Pattern pattern) - 정규표현식을 구분자로 사용가능

###### 다음의 메서드로 원하는 타입으로 입력값을 받을 수 있음
- `boolean nextBoolean()`
- `byte nextByte()`
- `short nextShort()`
- `int nextlnt()`
- `long nextLong()`
- `double nextDouble()`
- `float nextFloat()`
- `String nextLine()`


#### String Tokenizer

긴 문자열을 지정된 구분자로 토큰이라는 여러 개의 문자열로 나누는데 사용

###### 문자열을 나누는 방법
- String 클래스의 인스턴스 메서드 split(String regex)
- Scanner 클래스의 인스턴스 메서드 useDelimiter(String pattern)나 useDelimiter(Pattern pattern)
- StringTokenizer의 생성자

###### StringTokenizer 생성자와 메서드
- `StringTokenizer(String str, String delim)`
- `StringTokenizer(String str, String delim, boolean returnDelims)`
- `int countTokens()`
- `boolean hasMoreTokens()`
- `String nextToken()`

```java
// 구분자로 넘긴 문자열 ",|"는 문자열자체가 구분자가 아니라 문자열내의 각 문자가 구분자로 사용된다
// 즉 ","이나 "|"으로 구분된다
StringTokenizer st = new StringTokenizer ("영어,국어,수학|국사|물리|체육" , ",|");
while (st.hasMoreTokens()) {
    System.out.println("과목 : "+ st.nextToken());
}
```

## 형식화 클래스

데이터를 포매팅(formatting)하는데 사용할 패턴을 정의함

데이터를 패턴에 맞춰 포매팅 하거나 그 반대로도 사용


#### DecimalFormat

10진수 숫자로 포매팅 클래스

###### 포매팅
- `0` - 10진수(값이 없을 때 0)
- `#` - 10진수
- `.` - 소수점
- `-` - 음수 부호
- `,` - 단위 구분자
- `E` - 지수 기호
- `;` - 패턴 구분자
- `%` - 퍼센트
- `\u2030` - 퍼밀(퍼센트의 1/10)
- `\u00A4` - 통화
- ` `(backtick)` - 이스케이프 문자

```java
double number = 1234567.89;
String pattern = "#,###.##";
DecimalFormat df = new DecimalFormat(pattern);
String formattedString = df.format(number);
try {
	System.out.printf("포맷패턴 : %s\n", pattern);
    System.out.printf("포맷된 문자열 : %s\n", formattedString);
    System.out.printf("포맷된 문자열로 부터 추출한 값 : %s\n", df.parse(formattedString).doubleValue());
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
```

#### SimpleDateFormat

날짜 포매팅 클래스

###### 포매팅
- `G` - 연대(BC, AD)
- `y` - 년도
- `M` - 월 (1~12 또는 1월~12월)
- `W` - 년의 몇 번째 주 (1~53)
- `W` - 월의 몇 번째 주 (1~5)
- `D` - 년의 몇 번째 일 (1~366)
- `d` - 월의 몇 번째 일 (1~31)
- `F` - 월의 멸 번째 요일 (1~5)
- `E` - 요일
- `a` - 오전/오후 (AM, PM)
- `H` - 시간 (0~23)
- `k` - 시간 (1~24)
- `K` - 시간 (0~11)
- `h` - 시간 (1~12)
- `m` - 룬 (0~59)
- `s` - 초 (0~59)
- `S` - 천분의 일초 (0~999)
- `z` - Time zone(General time zone)
- `Z` - Time zone(RFC 822 time zone)
- ` `(backtick)` - 이스케이프 문자(특수문자 를 표현하는데 사용)

```java
Calendar today = Calendar.getInstance();
String pattern = "yyyy-MM-dd";
SimpleDateFormat sdf = new SimpleDateFormat(pattern);
// 오늘 날짜를 yyy-MM-dd형 태로 변환하여 반환한다.
// format 매서드는 Date 인스턴스를 인자로 받는다
String formattedString = sdf.format(new Date(today.getTimeInMillis()));
try {
	System.out.printf("포맷패턴 : %s\n", pattern);
	System.out.printf("포맷된 문자열 : %s\n", formattedString);
	System.out.printf("포맷된 문자열로 부터 추출한 값 : : %s\n", sdf.parse(formattedString));
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

```

#### ChoiceFormat

특정 범위의 속하는 값 포매팅 클래스

if문이나 switch문을 대신하여 사용할 수 있음

###### 포매팅

```java
double[] limits = {60, 70, 80, 90};
String[] formats = {"D", "C", "B", "A"};
int[] scores = {100, 95, 88, 30, 20, 50, 70, 64};
// ChoiceFormat 생성자
// 첫번째 인자는 double 타입의 배열로 범위를 표현하기 때문에 오름차순이어야 함
// 두번째 인자는 String 타입의 배열로 첫번째 인자의 범위에 해당하는 포맷
// 첫번째 인자와 두번째 인자의 배열길이는 서로 같아야 한다
ChoiceFormat cf = new ChoiceFormat(limits, formats);

for (int i = 0; i < scores.length; i++) {
    String formattedString = cf.format(scores[i]);
    System.out.printf("%d : %s\n", scores[i], formattedString);
}
```

#### MessageFormat

양식에 사용할 수 있는 포매팅 클래스

###### 포매팅

```java
String pattern = " 이름 : {0}\n 전화번호 : {1}\n 나이  : {2}\n 등록일 : {3}";
Object[] arguments = {
		"yoiyoy",
		"010-1234-5678",
		"29",
		"2016-06-19"
};
MessageFormat mf = new MessageFormat(pattern);
// MessageFormat 클래스의 스태틱 메서드 format을 사용한다
// 첫번째 인자는 String 타입으로 패턴으로 {0으로 시작하는 숫자}가 포함되어야 한다
// 두번째 인자는 Object 타입 배열로 인덱스는 패턴의 숫자에 대응하며 포매팅 될 값이 지정되어야 한다
String formattedString = MessageFormat.format(pattern, arguments);

try {
	System.out.println(formattedString);
	Object[] valus = mf.parse(formattedString);
	System.out.println("포맷된 문자열로 부터 추출한 값 : ");
	for (Object value : valus) {
		System.out.printf("%s\n", value);
	}

} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
```

## 제네릭스(Generics)



#### 제네릭스란
- 다양한 객체를 다루는 메서드나 컬랙션 클래스의 컴파일 시 타입 체크 해주는 기능

- 타입의 안전성 제공

- 타입 체크와 형변환을 생략할 수 있으므로 코드가 간결해짐

- 기호를 사용
`T` - 참조형 타입, 타입(Type)을 의미
`E` - 요소(Element)를 의미
`K` - 키(Key)를 의미
`V` - 값(Value)를 의미

#### `ArrayList<E>`

컬렉션 프레임웍스의 ArrayList 클래스를 통해 제네릭스 사용하는 방법을 알아본다

###### ArrayList
```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
    ...
    private transient E[] elementData;
    public boolean add(E o) { /* 내용생략 */ }
    ...
}
```


###### 제네릭스 사용
```java
// 제네릭을 사용하지 않을 경우
// 저장 객체와 반환 객체가 Object 타입임
ArrayList tvList = new ArrayList();
tvList.add(new Tv());
Tv tv = (Tv)tvList.get(0); // 반환 객체의 형변환 필요

// 컬랙션클래스<저장할 객체의 타입> 변수명 = new 컬랙션클래스<저장할 객체의 타입>();
// ArrayList의 E가 Tv타입이 됨
// 저장 객체와 반환 객체가 Tv타입으로 보장 됨
ArrayList<Tv> tvList = new ArrayList<Tv>();
tvList.add(new Tv());
Tv tv = tvList.get(0);
```

###### 제네릭의 다형성
```java
/*
 * 참조변수 타입과 생성객체타입에서 다형성
 */
List<Tv> tvList = new ArrayList<Tv>();

/*
 * 저장객체와 반환객체의 다형성
 */
ArrayList<Product> tvList = new ArrayList<Tv>(); // 컴파일 에러

// 제네릭스으로 상속관계 표현
public static <T extends Product> void printAll(ArrayList<T> productList1, ArrayList<T> productList2) {
	for (T product: productList1) {
		System.out.println(product.getName());
	}
}

```

###### Iterator<E>

```java
// 제네릭 없이 사용할 경우
Iterator it = list.iterator();
while (it.next()) {
    Product product = (Product)it.next(); // 명시적 형변환 필요
    System.out.println("상품:" + product.getName());
}

// 제네릭 사용할 경우
Iterator it<Product> = list.iterator();
while (it.next()) {
    Product product = it.next(); // Product 타입으로 반환값 보장
    System.out.println("상품:" + product.getName());
}

```

###### Comparable<T>

Comparable 인터페이스는 정렬기준을 구현할 때 사용한다
```java
 // 구현 클래스를 작성하여 사용하는 방법
class Product implements Comparable<Product> {
    ...

    @Override
    public int compareTo(Product o) {
		return o.getPrice() - this.getPrice();
    }
}
Collections.sort(productList)  // 가격순으로 상품리스트를 정렬

// 익명 구현 객체를 작성하여 사용하는 방법
Collections.sort(productList, new Comparator<Product>() {
	@Override
	public int compare(Product o1, Product o2) {
		return o2.getPrice() - o1.getPrice();
	}
});

```
###### HashMap<K,V>

HashMap 객체의 키(K)와 값(V) 타입의 제네릭 사용

```java
// 제네릭 없이 사용할 경우
HashMap productPriceMap = new HashMap<>();
productPriceMap.put("TV", 2000);
productPriceMap.put("AUDIO", 1000);
Integer tvPrice = (Integer)productPriceMap.get("TV"); // 명시적 형변환 필요

// 제네릭 사용할 경우
HashMap<String, Integer> productPriceMap = new HashMap<>();
productPriceMap.put("TV", 2000);
productPriceMap.put("AUDIO", 1000);
Integer tvPrice = productPriceMap.get("TV"); // Integer 타입으로 반환값 보장

```


















---
