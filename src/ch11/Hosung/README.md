# ch11 컬렉션 프레임웍과 유용앟 클래스

자바에서는 많은 수의 다양한 패키지(Java API)를 제공하여
개발자들이 자바 어플리케이션을 쉽게 개발할 수 있도록 도와준다.

java.util 패키지를 중심으로 세 가지 그룹으로 나누어 설명

	1.컬렉션 프레임월(Collection Framework)
	 -다수의 데이터를 쉽게 처리할 수 있는 표준화된 방법을 제공하는 클래스
    2.유용한 클래스 - 알아두면 좋은 자주 쓰이는 클래스들
    3.형식화 클래스 - 데이터를 표준화된 형식으로 출력하는데 도움을 주는 클래스들

## 1.컬렉션 프레임웍(Collection Framework)
컬렉션 프레임웍이란 - 데이터 군을 저장하는  Vector와 같은 클래스들을 표주화한 설계
컬렉션은 다수의 데이터(데이터 그룹) 프레임웍은 표준화된 프로그래밍 방식을 의미

[참고]Java API문서에서는 컬렉션 프레임웍을 '데이터 군(그룹)을 다루고 표현하기 위한 단일화된 구조'라고 정의

컬렉션 프레임웍은 컬렉션(다수의 데이터)을 다루는 데 필요한 다양하고 풍부한 클래스들을 제공,
인터페이스와 다형성을 이용한 객체지향적 설계를 통해 표준화되어 있기 때문에 사용법을 익히기에도 편리하고 재사용성이 높은 코드를 작성할 수 있다는 장점

###1.1 컬렉션 프레임웍의 핵심 인터페이스 - List, Set, Map

| 인터페이스 | 특징 |
|--------|--------|
|  List  | 순서가 있는 데이터의 집합, 데이터의 중복을 허용 <br/> (ArrayList, LinkedList, Stack, Vector 등) |
|  Set   | 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다.<br/> (HashSet,TreeSet  등)      |
|  Map   | 키와 값의 쌍으로 이루어진 데이터의 집합.<br/> 순서는 유지되지않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용한다. <br/> (HashMap, TreeMap, Hashtable, Properties 등)      |

####1.1.1 Collection 인터페이스 p-442
Collection인터페이스는 컬렉션 클래스에 저장된 데이터를 읽고, 추가하고 삭제하는 등 
컬렉션을 다루는데 가장 기본적인 메서드들을 정의 하고 있다.

####1.1.2 List 인터페이스 p-443
List인터페이스는 중복을 허용하면서 저장순서가 유되는 컬렉션을 구현하는데 사용.
구현 클래스로는 ArrayList, LinkedList, Vector, Stack 등

####1.1.3. Set 인터페이스
Set인터페이스는 중복을 허용하지 않고 저장순서가 유지되지 않는 컬렉션 클래스를 구현하는데 사용.
구현 클래스로는 HashSet, TreeSet 등

####1.1.4 Map 인터페이스 p-444
Map인터페이스는 키(key)와 값(value)을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현하는데 사용.
키는 중복될 수 없지만, 값은 중복을 허용.
기존에 저장된 데이터와 중복된 키 값을 저장하면, 기존의 값은 없어지고 마지막에 저장된 값이 남게된다.
구현 클래스로는 Hashtable, HashMap, LinkedHashMap, SortedMap, TreeMap 등

####1.1.5 Map.Entry 인터페이스
Map.Entry 인터페이스는 Map인터페이스의 내부 인터페이스이다.
내부클래스와 같이 인터페이스도 내부인터페이스를 정의하는 것이 가능하다.

Map에 저장되는 key-value쌍을 다루기 위해 내부적으로  Entry인터페이스를 정의해 놓았다. p-445
객체지향적으로 설계하도록 유도하기 위한 것으로 Map인터페이스를 구현하는 클래스에서는 Map.Entry인터페이스도 함께 구현해야한다.

###1.2 동기화(Syncronization)
멀티쓰레드 프로그래밍에서는 하나의 객체를 여러 쓰레드가 동시에 접근할 수 있기때문에 데이터의 일관성을 유지하기 위해서는 동기화가 필요하다.

Vector와 Hashtable과 같은 구버전의 클래스들은 자체적으로 동기화 처리가 되어 있는데, 멀티쓰레드 프로그래밍이 아닌 경우에는
불필요한 기능이 되어 성능을 떨어뜨리는 요인이 된다.

ArrayList와 HashMap과 같은 컬렉션은 동기화를 자체적으로 처리하지 않고 필요한 경우에만
java.util.Collections클래스의 동기화 메서드를 이용해서 동기화처리가 가능하도록 변경하였다.

###1.3 Vector와 ArrayList
Vector와 ArrayList는 컬렉션 프레임웍에서 가장 많이 사용되는 컬렉션 클래스 일 것이다.
List인터페이스를 구현하기때문에 데이터의 저장순서가 유지되고 중복을 허용 한다는 공통적인 특징

ArrayList는 기존 Vector를 개선한 것으로 Vector와 구현원리와 기능적인 측면에서 동일하다고 할 수 있다.
Vector는 기존에 작성된 소스와의 호환성을 위해서 계속 남겨 두고 있기때문에 가능하면 ArrayList를 사용하는 것을 추천.

| 공통점 | 차이점 |
|--------|--------|
|-List인터페이스를 구현한다.</br>저장순서가 유지되고 중복을 허용한다. </br>-데이터의 저장 공간으로 배열을 사용한다.        |-Vector는 멀티 쓰레드에 대한 동기화가 되어 있으나,</br> ArrayList는 그렇지 않다.        |

Vector와 ArrayList는 Object배열을 이용해서 데이터를 순차적으로 저장
배열에 더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성해서 기존의 배열에 저장된 내용을 새로운 배열에 복사한다음 저장

	Vector,ArrayList 메서드 p-447
	예제11-1 ArrayList는 List인터페이스를 구현했기때문에 저장된 순서를 유지

ArrayList를 생성할 때, 저장할 요소의 개수를 고려해서 실제 저장할 개수보다 약간 여유있는 크기로 하는 것이 좋다.
생성할 때 지정한 크기보다 더 많은 객체를 저장하면 자동적으로 크기가 늘어나기는 하지만 처리시간이 많이 소요되기 때문이다.

	Vector의 용량과 크기에 관한 단계별 그림  p-453
	Vector와 ArrayList 같이 배열을 이용한 자료구조는 데이터를 읽어오고 저장하는데 효율이 좋지만,
    용량을 변경해야할 때는 새로운 배열을 생성 후 기존의 배열로부터 새로 생성된 배열로 데이터를 복사하기 때문에
    상당히 효율이 떨어진다는 단점이 있다. 그래서 처음 인스턴스를 생성할 데이터 개수를 잘 고려하여
    충분한 용량의 인스턴스를 생성하는 것이 좋다.

[Deep Copy vs Shallow Copy] p-460

###1.4 LinkedList
배열은 가장 기본적인 형태의 자료구조로 구조가 간단하며 사용하기 쉽고
데이터를 읽어 오는데 걸리는 시간이 가장 빠르다는 장점을 가지고 있지만 다음과 같은 단점도 가지고 있다.

	1.크기를 변경할 수 없다.
	 -크기를 변경 할 수 없기때문에 새로운 배열을 생성해서 데이터를 복사하는 작업이 필요하다.
     -실행속도를 향상시키기 위해서는 충분히 큰 크기의 배열을 생성해야하므로 메모리 낭비가 된다.
    2.비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸린다.
     -차례대로 데이터를 추가하고 마지막에서부터 데이터를 삭제하는것은 빠르지만,
     -배열의 중간에 데이터를 추가하려면, 빈자리를 만들기 위해 다른 데이터들을 복사해서 이동해야한다.

이러한 배열의 단점을 보완하기 위해서 LinkedList라는 자료구조가 고안되었다.
배열은 모든 데이터가 연속적으로 존재하지만
링크드리스트는 불연속적으로 존재하는 데이터를 서로 연결한 형태로 구성되어 있다.

링크드리스트에서의 데이터삭제는 삭제하고자 하는 요소의 이전요소가
삭제하고자 하는 요소의 다음 요소를 참조하도록 변경하기만 하면된다.
단 하나의 참조만 변경 하면 삭제가 이루어지기 때문에
배열처럼 데이터를 이동하기 위해 복사하는 과정이 없기 때문에 처리속도가 매우 빠르다.

새로운 데이터를 추가할 때는 새로운 요소를 생성한 다음
추가하고자 하는 위치의 이전 요소의 참조를 새로운 요소에 대한 참조로 변경해주고,
새로운 요소가 그 다음 요소를 참조하도록 변경하기만 하면 되므로 처리속도가 매우 빠르다.
(p-463 그림 11-8, 11-9)

링크드리스트는 단방향이기 때문에 다음 요소에 대한 접근은 쉽지만, 이전요소에 대한 접근은 어렵다.

	-더블 링크드리스트(double linked list)
    참조변수를 하나 더 추가하여 다음요소에 대한 참조 뿐만아니라 이전 요소에 대한 참조가 가능하도록 했으뿐,
    그외에는 링크드 리스트와 같다.
	링크드리스트보다 각 요소에 대한 접근과 이동이 쉽기 때문에 링크드리스트보다 더 많이 사용된다.

    -더블써귤러링크드리스트(double circular linked list)
    더블 링크드리스트의 접근성을 보다 향상시킨 것.
    더블링크드리스트의 첫번째 요소와 마지막 요소를 서로 연결 시킨 것


*ArrayList와 LinkedList의 성능차이 비교 (p-466 예제 11-6)
결론1 순차적으로 추가/삭제하는 경우는 ArrayList가 LinkedList보다 빠르다.
결론2 중간 데이터를 추가/삭제하는 경우에는 LinkedList가 ArrayList보다 빠르다.
-LinkedList는 저장해야하는 데이터의 개수가 많아질수록 데이터를 읽어 오는 시간(access tieme)이 길어진다는 단점

| 컬렉션 | 읽기(접근시간) | 추가/삭제 | 비고 |
|--------|--------|--------|--------|
| ArrayList | 빠르다 | 느리다 | 순차적인 추가삭제는 빠름. 비효율적인 메모리사용 |
| LinkedList | 느리다 | 빠르다 | 데이터가 많을수록 접근성이 떨어짐 |

다루고자 하는 데이터의 개수가 변하지 않는 경우라면, ArrayList가 최상의 선탱이 되겠지만,
데이터 개수의 변경이 잦다면 LinkedList를 사용하는 것이 더 나은 선택이 될 것이다.

두 클래스의 장점을 이용해서 두 클래스를 혼합해서 사용하는 방법도 생각 해 볼 수 있다.

###1.5 Stack과 Queue
스택은 마지막에 저장한 데이터를 가장 먼저 꺼내게 되는 LIFO(Last In First Out)구조
큐는 처음에 저장한 데이터를 가장 먼저 꺼내게 되는 FIFO(First In First Out)구조

스택과 큐의 활용

	스택의 활용 예 - 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로
 	큐의 활용 예 - 최근사용문서, 인쇄작업 대기목록, 버퍼

###1.6 Enumeration, Iterator, ListIterator
Enumeration, Iterator, ListIterator는 모두 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스이다.
Enumeration는 Iterator의 구버전이며, ListIterator는 Iterator의 기능을 향상시킨 것

####1.6.1 Iterator
컬렉션 프레임웍에서는 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화하였다.
컬렉션에 저장된 각 요소에 접근하는 기능을 가진 Iterator인터페이스를 정의하고,
Collection인터페이스에는 Iterator를 반환하는 iterator()를 정의 하고 있다.

iterator()는 Collection인터페이스에 정의된 메서드이므로 Collection인터페이스의 자손인 List와 Set에도 포함되어있다.
List나 Set인터페이스를 구현하는 컬렉션은 iterator()가 각 컬렉션의 특징에 알맞게 작성되어 있다.

Iterator를 이용해서 컬렉션의 요소를 읽어오는 방법을 표준화했기 때문에 이처럼 코드의 재사용성을 높이는 것이 가능한 것이다.

공통 인터페이스를 정의해서 표준을 정의하고 구현하여 표준을 따르도록 함으로써
코드의 일관성을 유지하여 재사용성을 극대화하는 것이 객체지향 프로그래밍의 중요한 목정 중의 하나이다.

Map인터페이스를 구현한 컬렉션 클래스는 키와 값을 쌍으로 저장하고 있기때문에 iterator()를 직접 호출할 수 없고,
그 대신 keySet()이나 entrySet()과 같은 메서드를 통해서 키와 값을 각각 따로 Set의 형태로 얻어 온
후에 다시 iterator()를 호출 해야 Iterator를 억을 수 있다.(p-480)

####1.6.2 Enumeration과 ListIterator
Enumeration은 컬렉션 프레임웍이 만들어기 이전에 사용하던 것으로 Iterator의 구버전이라고 생각하면된다.
이전 전으로 작성된 소스와의 호환을 위해서 남겨두고 있을뿐이므로 가능하면 Enumeration대신 Iterator를 사용하도록.

ListIterator는 Iterator를 상속받아서 기능을 추가한 것으로, 컬렉션의 요소로 접근할 때
Iterator는 단방향으로만 이동할 수 있는데 반해 ListIterator는 양방향으로의 이동이 가능하다.
다만, ArrayList나 LinkedList와 같이 List인터페이스를 구현한 컬렉션에서만 사용할 수 있다.

Enumeration과 Iterator는 메서드이름만 다를 뿐 기능은 같고,
ListIterator는 Iterator에 이전방향으로의 접근기능을 추가한 것일 뿐이라는 것을 알 수 있다.(p-482)

###1.7 HashSet
HashSet은 Set인터페이스를 구현한 가장 대표적인 컬렉션이며, Set인터페이스의 특징대로 중복된 요소를 저장하지 않는다.
HashSet의 특징을 이용하면, 컬렉션 내의 중복된 요소들을 쉽게 제거할 수 있다.

HashSet은 저장순서를 유지하지 않으므로 저장순서를 유지하고자 한다면 LinkedHashSet을 사용해야 한다.

(오버라이딩을 통해 작성된 hashCode메서드 세가지 조건 p-494)

###1.8 TreeSet p-498
TreeSet은 이진검색트리라는 자료구조의 형태로 데이터를 저장하는 컬렉션 클래스이다.
이진검색트리는 정렬, 검색, 범위검색에 뛰어난 성능을 보이는 자료구조이며
TreeSet은 이진검색트리의 성능을 향상시킨 '레드-블랙 트리'로 구현되어있다.
Set인터페이스를 구현했으므로 중복된 데이터의 저장을 허용하지 않으며 정렬된 위치에 저장하므로 저장순서를 유지하지도 않는다.

이진검색트리는 부모노드의 왼쪽에는 부모노드의 값보다 작은 값의 자식노드를 오른쪽에서느 큰 값의 자식노드를 저장하는 이진트리이다.

트리는 데이터를 순차적으로 저장하는 것이 아니라 저장위치를 찾아서 저장해야하고,
삭제하는 경우 트리의 일부를 재구성해야하므로 링크드리스트보다 데이터 추가삭제시간은 더 걸린다.
대신 배열이나 링크드리스트에 비해 검색과 정렬기능이 훨씬 뛰어나다.

	이진검색트리(binary search tree)는
    -모든노드는 최대 두개의 자식노드를 가질 수 있다.
    -왼쪽 자식노드의 값은 부모노드의 값보다 작고 오른쪽자식노들의 값은 부모노드의 값보다 커야한다.
    -노드의 추가 삭제에 시간이 걸린다(순차적으로 저장하지 않으므로)
    -검색과 정렬에 유리하다.


###1.9 Comprator와 Comparable
Comprator와 Comparable은 모두 인터페이스로 객체들을 정렬 또는 이진검색트리를 구성하는데 필요한
메서드를 정의하고 있다.

Comparable을 구현하고 있는 클래스들은 같은 타입의 인스턴스끼리 서로 비교할 수 있는 클래스들,
주로 Integer와 같은 Wrapper(Boolean 제외)클래스와 String, Data, File과 같은 것들이며
기본적으로 오름차순으로 정렬되도록 구현되어 있다.

Comparable을 구현하지 않은 클래스들의 인스턴스를 TreeSet에 담는다면 정렬기준이 없기때문에
당연히 알아서 정렬되지 않을 뿐더러 컴파일 에러는 발생하지 않지만 실행 시 에러가 발생한다.

	Comaparable - 기본 정렬기준을 구현하는데 사용.
    Comparator - 기본 정렬기준 외에 다른 기준으로 정렬하고할 때 사용

Comparable을 구현한 클래스들이 기본적으로 오름차순으로 정렬되어 있지만,
내림차순으로 정렬한다던가 아니면 다른 기준에 의해서 정렬되도록 하고 싶을 때 Comparator를 구현해서
정렬기준을 제공할 수 있다.

###1.10 Hashtable과 HashMap
Hashtable과 HashMap의 관계는 Vector와 ArrayList의 관계와 같아서 Hashtable보다는
새로운 버전인 HashMap을 사용할 것을 권한다.

HashMap은 Map을 구현했으므로 앞에서 살펴본 Map의 특징, 키와 값을 묶어서 하나의 데이터로 저장한다는 즉징을 갖는다.
그리고 해싱(hashing)을 사용하기 때문에 많은 양의 데이터를 검색하는데 있어서 뛰어난 성능을 보인다.

	키(key) -  컬렉션 내의 키 중에서 유일해야 한다.
    값(value) - 키와 달리 데이터의 중복을 허용한다.

키는 저장된 값을 찾는데 사용되는 것이기 때문에 컬렉션 내에서 유일해야 한다.
즉, HashMap에 저장된 데이터를 하나의 키로 검색했을 때 결과가 단 하나이어야 함을 뜻한다.

해싱(hashing)이란 -p514
해시함수를 이용해서 데이터를 해시테이블에 저장하고 검색하는 기법을 말한다.
해시함수는 데이터가 저장되어 있는 곳을 알려주기 때문에 다량의 데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다.
해싱을 구현한 컬렉션 클래스로는 HashSet, HashMap, Hashtable 등이 있다.
Hashtable대신 HashMap을 사용하도록 하자.

###1.11 TreeMap
이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장한다.
검색과 정렬에 적합한 컬렉션 클래스.

검색에 관한한 대부분의 경우에는 HashMap이 TreeMap보다 더 뛰어나므로 HashMap을 사용하는 것이 좋다.
다만 범위검색이나 정렬이 필효나 경우에는 TreeMap을 사용하자.

###1.12 Properties
Propertiesㄴ는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것으로,
Hashtable은 키과 값을 (Object,Object)의 형태로 저장하는데 비해
Properties는 (String,String)의 형태로 저장하는 보다 단순화된 컬렉션클래스이다.

주로 어플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다. 간단한 입출력은 Properties를 활용하면 몇 줄의 코드로 쉽게 해결될 수 있다.

Properties는 Hashtable을 상속받아 구현한 것이라 Map의 특성상 저장순서를 유지하지 않기 때문에
출력된 순서가 저장순서와 무관하다는 것
Properties는 컬렉션프레임웍 이전의 구버전이므로 Iterator가 아닌 Enumeration을 사용한다.

외부파일의 형식은 라인단위로 키와 값이 '='로 연결된 형태이어야 하며,
주석라인은 첫 번째 문자가 '#'이어야 한다.

###1.13 컬렉션 클래스 정리 & 요약 (p-526 그림11-26 표11-21)

## 2.유용한 클래스들

###2.1  Calendar와 Date
자바에서는 날짜와 시가에 관련된 데이터를 쉽게 처리할 수 있도록 Caledar나 Date를 제공.
이전 버전으로 작성된 코드와의 화환을 위해서 남겨두고 있지만,
가능하면 Date보다는 Calendar를 사용하도록 하자.

간단한 날짜처리에는 Date를 사용하는 것이 더 나을 수 있으며, 반드시 Date를 사용해야하는
경우도 있어서 Calendar와 Date간의 변환방법을 꼭 알아두어야 한다.

	1.Calendar를 Date로 변환
	  Calendar cal= Calendar.getInstance();
      ...
      Date d = new Date(cal.getTimeInMillis());

     2.Date를 Calendar로 변환
      Date d = new Date()'
      ...
      Calendar cal = Calendar.getInstance();
      cal.setTime(d);

Calendar는 추상클래스이기 때문에 직접 객체를 생성할 수 없고,
메서드를 통해서 완전히 구현된 클래스를 얻어야 한다.

	Calendar cal = new Calendar(); //에러! 추상클래스는 인스턴스 생성할 수 없음

	//getInstance()메서드는 Calendar클래스를 구현한 클래스의 인스턴스를 반환
    Calendar cal = Calendar.getInstance();

Calendar를 상속박아 완전히 구현한 클래스로는 GregorianCalendar와 BuddhistCalendar가 있는데
getInstance()는 시스템의 국가와 지역설정을 확인해서 태국인 경우에는 BuddhistCalendar의
인스턴스를 반환하고, 그외에는 GregorianCalendar의 인스턴스를 반환한다.

인스턴스를 직접 생성해서 사용하지 않고, 이처럼 메서드를 통해서 인스턴스를 반환받게하는 이유는 최소한의
변경으로 프로그램이 작동할 수 있도록 하기 위한 것이다 .

```java
class MyApplication{
	public static void main(String args[]){
    	Caledar cal = new GregorianCalendar();
    }
}
```
위와 같은 특정 인스턴스를 생성하도록 프로그램이 작성되어 있다면, 다른 종류의 역법(Calendar)을
사용하는 국가에서 실행한다던가 새로운 역법이 추가된다던가 하는경우, 즉 다른 종류의 인스턴스를 필요로
하는 경우에 MyApplication을 변경해야 하는데 비해 아래와 같은 메서드를 통해서 인스턴스를 얻어오도록
하면 MyApplication을 변경하지 않아도 된다.
```java
class MyApplication{
	public static void main(String args[]){
    	Caledar cal = Calendar.getInstance();
    }
}
```
자주 사용하는 Calendar의 기능 -예제 11-39 p-529

getInstance()를 통해서 얻은 인스턴스는 기본적으로 현재 시스템의 날짜와 시간에 대한 정보를 담고있다.
원하는 날짜나 시간으로 설정하려면 set메서드를 사용하면된다.

[예제11-40] p-530
두 날짜간의 차이를 구하기 위해서는 두 날짜를 최소단위인 초단위로 변경한 다음 그 차이를 구하면된다.
getTimeInMillis()는 1/1000초 단위로 값을 반환하기 때문에
초단위로 얻기위해서는 1000으로 나눠 주어야 하고,
일단위로 얻기 위해서는 24(시간) * 60(분) *60(초) *1000으로 나누어야 한다.
시간상의 전후를 알고 싶을때는 두 날짜간의 차이가 양수인지 음수인지 판단하면 될 것이다.

[예제 11-42] p-533
add를 사용하면 지정한 필드의 값을 원하는 만큼 증가 또는 감소시킬 수 있기 때문에 add메서드를 이용하면
특정 날짜 또는 시간을 기점으로 해서 일정시간 전후의 날짜와 시간을 알아낼 수 있다.
roll도 지정한 필드의 값을 증가 또는 감소시킬 수 있는데, add메서드와의 차이점은 다른 필드에 영향을
미치지 않는다는 것이다.
(add메서드로 날짜필드(Calendar.DATE)의 값을 31만큼 든가시켰으면 다음달로 넘어가므로 월 필드의 값도 1증가하지만,
roll메서드는 같은 경우에 월 필드(Calendar.MONTH)의 값은 변하지 않고 일 필드의 값만 바뀐다.)
단, 일 필드가 말일 일 때, roll메서드를 이용해서 월 필드를 변경하는 경우 일 필드에 영향을 미칠 수 있다.[예제11-43]

	boolean isLeapYear(int year)
    		:매개 변수 year이면 윤년이면 true를 그렇지 않으면 false를 반환
	int dayDiff(int y1, int m1, int d1, int y2, int m2, int d2)
    		:두 날짜간의 차이를 일단위로 반환한다.
    int getDayOfWeek(int year, int month, int day)
			:지정한 날짜의 요일을 반환한다.(1~7, 1이 일요일)
    String convertDayToDate(int day)
            :일 단위의 값을 년월일의 형태의 문자열로 변환하여 반환한다.
    int convertDateToDay(int year, int month, int day)
    		:년월일을 입력 받아서 일단위로 변환한다.
[참고]일 단위로 변환할 때 서기 1년 1월 1일부터의 일의 수를 계산하였지만, Calendar의 경우 1970년 1월 1일을 기준으로
계산한다. 그래서 1970년 1월 1일 이전의 날짜에 대한 getTimeInMillis()를 호출하면 음수를 결과로 얻는다.

###2.2 Random
난수를 얻는 방법을 생각하면 Math.random()이 떠오를 것이다.
그리고 Random클래스를 사용하는 방법도 있는데, 몇가지 추가적인 기능을 제외하고는 Math.random()과 다르지 않다.
대부분의 경우 Math.random만 사용해도 난수를 얻는데 별 어려움이 없기 때문에
가능하면 Random 보다는 Math.random()을 사용 할 것을 권한다.

Math.random()과 Random의 가장 큰 차이점이라면, 종자값(seed)을 설정할 수 있다는 것이다.
종자값이 같은 Random인스턴스들은 항상 같은 난수를 같은 순서대로 반환한다.
종자값은 난수를 만드는 공식에서 사용되는 값으로 같은 공식에 같은 값을 넣으면 같은 결과를 얻는 것처럼
같은 종자값을 넣으면 같은 난수를 얻게된다.

###2.3 정규식(Regular Expression) - Pattern.Math
정규식이란 텍스트 데이터 주에서 원하는 조건과 일치하는 문자열을 찾아내기 위해 사용하는 것으로 미리 정의된 기호와 문자를
이용해서 작성한 문자열을 말한다. 원래 Unix에서 사용하던 것이고 Perl의 강력한 기능이었는데 요즘은 자바를 비롯해
다양한 언어에서 지원하고 있다.

정규식을 이용하면 많은 양의 텍스트 파일 중에서 원하는 데이터를 손쉽게 뽑아낼 수도 있고 입력된 데이터가 형식에 맞는지 체크할 수도있다.

Java API문서에서 java.util.regex.Pattern을 찾아보면 정규식에 사용되는 기호와 작성방법이 설명되어 있다.

[예제 11-54]Pattern은 정규식을 정의하는데 사용되고, Matcher는 정규식을 데이터와 비교하는 역할을 한다.

	1.정규식을 매개변수로 Pattern클래스의 static메서드인 Pattern compile(String regex)을
	  호출하여 Pattern인스턴스를 얻는다.
      Pattern p = Pattern.compile("c[a-z]*");
	2.정규식으로 비교할 대상을 매개변수로 Pattern클래스의 Matcher matcher를 호출해서 Matcher인스턴스를 얻는다.
	  Matcher m = p.matcher(data[i]);
    3.Matcher인스턴스에 boolean matches()를 호출해서 정규식에 부합하는지 확인한다.
      if(m.matches())

자주사용되는 패턴 [예제 11-55 p-551]

[예제 11-56]
정규식의 일부를 괄호로 나누어 묶어서 그룹화 할 수 있다. 그룹화된 부분은 하나의 단위로 묶이는 셈이 되어서
한 번 또는 그 이상의 반복을 의미하는 '+' 나 '*'가 뒤에 오면 그룹화된 부분이 적용대상이 된다.
그룹화된 부분은 group(int i)를 이용해서 나누어 얻을 수 있다.

매칭되는 문자열에서 첫 번째 그룹은 group(1)로 두 번째 그룹은 group(2)와 같이 호출함으로써 얻을 수 있다.
group() 또는 group(0)은 그룹으로 매칭된 문자열 전체를 나누어지지 않은 채로 반환한다.

find()는 주어진 소스 내에서 패턴과 일치하는 부분을 찾아내면 true를 반환하고 찾지 못하면 false를 반환한다.
find()를 호출하면 이전에 발견한 패턴과 일치하는 부분의 다음부터 다시 패턴 매칭을 시작한다.
Iterator를 이용해서 컬렉션의 데이터를 얻는 코드와 유사한 방식이므로 서로 비교해보면 이해하기 쉬을 것이다.

```java
Matcher m = p.matcher(source);
while(m.find()){
	System.out.println(m.group());
}
```
```java
Iterator it = set.iterator();
while(it.hasNext()){
	System.out.println(it.next());
}
```

###2.4 Scanner
Scanner는 화면, 파일, 문자열과 같은 입력소스로부터 문자데이터를 읽어오는데 도울을 줄 목적으로
JDK1.5부터 추가되었다. Scanner에는 다음과 같은 생성자를 지원하기때문에 다양한 입력소스로부터 데이터를 읽을 수 있다.

	Scanner(String source)
	Scanner(File source)
	Scanner (File source , String charsetName)
	Scanner(InputStream source)
	Scanner(InputStream source, String charsetName )
	Scanner(Readable source)
	Scanner(ReadableByteChannel source)
	Scanner (ReadableByteChannel source, String charsetName)

또한 Scanner는 정규식표현을 이용한 라인단위의 검색을 지원하며 구분자에도 정규식 표현을 사용할 수 있어서
복잡한 형태의 구분자도 처리가 가능하다.

	Scanner useDelimiter(Pattern pattern)
	Scanner useDelimiter(String pattern)

###2.5 StringTokenizer
StringTokenizer는 긴 문자열을 지정된 구분자를 기준으로
토큰이라는 여러 개의 작은 문자열로 잘라내는데 사용된다.
StringTokenizer를 이용하는 방법 이외에도
String의 split(String regex)을 사용해서 String[] result = "100,200,300,400".split(",")와
Scanner의 Scanner(Regular expression)을 사용해서 Scanner sc2 = new Scnner("100,200,300,400").useDelimiter(",")와
같이 할 수도 있지만 이 두가지 방법은 정규식 표현을 사용해야하므로 정규식 표현에 익숙하지 않은경우 StringTokenizer를 사용하는 것이 간단하면서
명확한 결과를 얻르 수 있을 것이다.

StringTokenizer는 구분자로 단 하나의 문자 밖에 사용하지 못하기 때문에
보다 복잡한 형태의 구분자로 문자열을 나누어야 할 때는 Scanner나 split메서들을 사용해야 할 것이다.

생성자 StringTokenizer(String str, String delim, boolean returnDelims)를 사용해서
구분자도 토큰으로 간주되도록 하였다. [예제 11-64]
단 한 문자의 구분자만 사용할 수 있기 때문에 구분자 전체가 하나의 구분자가 아니라 각각의 문자가 모두 구분자라는 것에 주의해야한다.
반드시 두 문자 이상의 구분자를 사용해야 한다면, Scanner나 String클래스의 split메서드를 사용해야한다.

split은 빈 문자열도 토큰으로 인식하는 반면 StringTokenizer는 빈 문자열을 토큰으로 인식하지 않기 때문에
인식하는 토큰의 개수가 서로 다른 것을 알 수 있다.[예제 11-67]
split()은 데이터를 토큰으로 잘라낸 결과를 배열에 담아서 반환하기 때문에
데이터를 토큰으로 바로바로 잘라서 반환하는 StringTokenizer보다 성능이 떨저질 수밖에 없다.
그러나 데이터의 양이 많은 경우가 아니라면 별 문제가 되지 않으므로 신경 쓸 부분은 아니다.

##3.형식화 클래스
형식화 클래스는 java.text패키지에 포함되어 있으며 숫자, 날짜, 텍스트 데이터를 일정한 형식에 맞게
표현할 수 있는 방법을 객체지향적으로 설계하여 표준화하였다.

형식화 클래스는 형식화에 사용될 패턴을 정의하는데, 데이터를 정의된 패턴에 맞춰 형식화 할 수 있을 뿐만 아니라
역으로 형식화된 데이터에서 원래의 데이터를 얻어낼 수도 있다.

###3.1 DecimalFormat
형식화 클래스 중에서 숫자를 형식화 하는데 사용되는 것이 DecimalFormat이다.
DecimalFormat을 이용하면 숫자 데이터를 정수, 부동소수점, 금액 등의 다양한 형식으로 표현할 수 있으며,
반대로 일정한 형식의 텍스트 데이터를 숫자로 쉽게 변환하는 것도 가능하다.

자주 사용될만한 패턴들 [표 11-26 p-574]
원하는 출력형식의 패턴을 작성하여 DecimalFormat인스턴슬 생성한 다음,
출력하고자 하는 문자열로 format메서드를 호출하면 원하는 패턴에 맞게 변환된 문자열을 얻게된다.
```java
String number = "1234567.89";
DecimalFormat df = new DecimalFormat("#.#E0");
String result = df.format(number);
```

parse메서드를 이용하면 기호와 문자가 포함된 문자열을 숫자로 쉽게 변환할 수 있다.
[참고]Integer.parseInt메서는 콤마(,)가 포함된 문자열을 숫자로 변환하지 못한다.

###3.2 SimpleDateFormat
Date와 Calendar만으로 날짜 데이터를 원하는 형태로 다양하게 출력하는 것은 불편하고 복잡하다.
그러나 SimpleDataFormat을 사용하면 이러한 문제들이 간단하게 해결된다.
[표 11-27 p-578] SimpleDateFormat의 패턴에 사용되는 기호

먼저 원하는 출력형식의 패턴을 작성하여 SimpleDateFormat인스턴스를 생성한 다음,
출력하고자 하는 Date인스턴스를 가지고 format(Date d)를 호출하면 지정한 출력형식에 맞게 변환된 문자열을 얻게된다.
```java
Date today = new Date();
SimpleDateaFormat df = new SimpleDateFormat("yyyy-MM-dd");

//오늘 날짜를 yyyy-MM-dd형태로 변환하여 반환한다.
String result = df.format(today);
```

Date인스턴스만 format메서드에 사용될 수 있기 때문에 Calendar인스턴스를 Date인스턴스로 변환하여 사용
[참고]Date인스턴스를 Calendar인스턴스로 변환할 때는 Calendar클래스의 setTime()을 사용하면 된다.

[예제 11-72]
parse(String source)를 사용하여 날짜 데이터의 출력형식을 변환하는 방법을 보여주는 예제
SimpleDateFormat의 parse(String source)는 문자열을 날짜로 변환해주기 때문에 매우 유용하게 사용
[참고]parse(String source)는 SimpleDataFormat의 조상인 DateFormat에 정의되어 있다.
[참고]지정된 형식과 입력된 형식이 일치하지 않는 경우에는 예외가 발생하므로 적정한 예외처리가 필요하다.

###3.3 ChoiceFormat
ChoiceFormat은 특정 범위에 속하는 값을 문자열로 변환해준다.
연속적 또는 불연속적인 범위의 값들을 처리하는 데 있어서 if문이나 switdh문은 적절하지 못한 경우가 많다.
ChoiceFormat을 잘 사용하면 복잡하게 처리될 수밖에 없었던 코드를 간단하고 직관적으로 만들 수 있다.

###3.4 MessageFormat
MessageFormat은 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와준다.
데이터가 들어갈 자리를 마련해 놓은 양식을 미리 작성하고 프로그램을 이용해서 다수의 데이터를 같은 양식으로 출력할 때 사용하면 좋다.
MessageFormat의 parse를 이용하면 지정된 양식에서 필요한 데이터만을 손쉽게 추출해 낼 수도 있다.

MessageFormat에 사용할 양식인 문자열 msg를 작성할 때 '{숫자}'로 표시된 부분이 데이터가 출력될 자리이다.
이 자리는 순차적일 필요는 없고 여러 번 반복해서 사용할 수도 있다.
객체배열기기 때문에 String이외에도 다른 객체들이 지정될 수 있다.

##4.제너릭스(Generics)
제너릭스는 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입 체크를 해주는 기능이다.
객체의 타입을 컴파일 시에 체크하기 때문에 객체의 타입 안정성을 높이고 형변환의 번거로움이 줄어든다.

	제너릭스의 장점
    1.타입 안정성을 제공한다.
    2.타입체크와 형변환을 생략할 수 있으므로 코드가 간결해 진다.

[참고]타입 안정성을 높인다는 것은 의도하지 않은 타입의 객체를 저장하는 것을 막고,
저장된 객체를 꺼내올 때 원래의 타입과 다른 타입으로 형변환되어 발생 할 수 있는 오류를 줄여준 다는 뜻이다.

기존에는 다양한 종류의 타입을 다루는 메서드의 매개변수나 리턴타입으로 Object타입의 참조변수를 많이 사용했고,
그로 인해 형변환이 불가피했지만, 이젠 Object타입 대신 원하는 타입을 지정하기만 하면 되는 것이다.
[참고]타입을 지정하지 않으면 Object타입으로 간주된다.

###4.1 ArrayList< E >
'E'는 요소를 뜻하는 'Element'의 약자로 , 'E'대신 어떤 다른 문자를 사용해도 상관없지만
소스코드 내에서 같은 문자를 일관되게 사용해야 한다.
만일 타입을 지정하지 않으면 'E'는 Object타입으로 간주된다.

아래와 같이 컬렉션 클래스 이름 바로 뒤에 저장할 객체의 타입을 적어주면, 컬렉션에 저장할 수 있는 객체는 지정한 타입의 객체뿐이다.
```java
컬렉션클래스<지정할 객체의 타입> 변수명 = new 컬렉션클래스<저장할 객체의 타입>();

ArrayList<Tv> tvList = new ArrayList<Tv>();
```

저장된 객체를 꺼낼 때는 형변환할 필요가 없다. 이미 어떤 타입의 객체들이 저장되어 있는지 알고 있기 때문이다.
제너릭스를 적용한 코드와 그렇지 않은 코드를 비교해 보자
```java
ArrayList tvList = new ArrayList();
tvList.add(new Tv());
Tv t = (Tv)tvList.get(0);
```
```java
ArrayList<Tv> tvList = new ArrayList<Tv>();
tvList.add(new Tv());
Tv t = tvList.get(0);
```

만일 다형성을 사용해야하는 경우에는 조상타입을 지정함으로서 여러 종류의 객체를 저장 할 수 있다.
다만 꺼내올 때 원래의 타입으로 형변환해야 한다.(p-590)

제너릭스에서도 다형성을 적용해서 아래와 같이 할 수 있다.
```java
List<Tv> tvList = new ArrayList<Tv>();//허용O
```
그러나 Product클래스가 Tv클래스의 조상이라 할지라도 아래와 같이 할 수는 없다.
```java
ArrayList<Product> tvList = new ArrayList<Tv>();//허용X
```
매개변수 타입이 ArrayList< Product >로 선언된 경우,
이 메서드의 매개변수로는 ArrayList< Product >타입의 객체만 사용 할 수 있다.
그렇지 않으면 컴파일 에러가 발생한다.

컬렉션에 저장될 객체에도 다형성이 필요할 때는 와일드카드'?'를 사용하면된다.
보통 제너릭에서는 단 하나의 타입을 지정하지만,
와일드 카드는 하나 이상의 타입을 지정하는 것을 가능하게 해준다.

```java
//Product 또는 그 자손들이 담긴 ArrayList를 매개변수로 받는 메서드
public static void printAll(ArrayList< ? extends Product> list){
	for(Unit u :list){
    	System.out.println(u);
    }
}
```
[주의]만일 Product가 클래스가 아닌 인터페이스라 할지라도 키워드로 'implements'를 사용하지 않고
클래스와 동일하게 'extends'를 사용한다는 것에 주의하자.

###4.2 Iterator< E >
컬렉션 클래스 뿐 만아니라 Iterator에도 제네릭스가 적용 되어 있다.

[예제 11-81 p-594]
ArrayList에 Student객체를 저장할 것이라고 지정을 했어도 Iterator타입의 참조변수를 선언할 때
저장된 객체의 타입을 지정해주지 않으면, Iterator()의 next()를 호출할 때 형변환을 해야 한다.

###4.3 Comparable< T >과 Collections.sort()
클래스의 기본 정렬기준을 구현하는 Comprable인터페이스에서도 제네릭스가 적용된다.


###4.4 HashMap< K , V >
HashMap처럼 데이터를 키와 값의 형태로 저장하는 컬렉션 클래스는 지정해 줘야할 타입이 두 개이다.
그래서 '< K , V >'와 같이 두 개의 타입을 콤마 ','로 구분해서 적어줘야 한다.
여기서 'K'와 'V'는 각각 'Key'와 'Value'의 첫 글자에서 따온 것일 뿐
'T'나 'E'와 마찬가지로 임의의 참조형 타입을 의미한다.

타입을 지정하지 않으면 Object타입으로 간주된다.

HashMap에서 값을 꺼내오는 get(Object key)를 사용할 때,
그리고 저장된 키와 값들을 꺼내오는 keySet()과 values()를 사용할 때 형변환을 하지 않아도 된다.