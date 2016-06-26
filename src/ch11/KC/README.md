Ch11 컬렉션 프레임웍 / Utility Class
====================

### 컬렉션 프레임웍
```
*다수의 데이터*를 쉽게 처리할 수 있는 *표준화*된 방법을 제공하는 클래스
```

### 핵심 인터페이스
```
0. Collection(Interface)
1. List (ArrayList, LinkedList, Stack, Vector)
2. Set  (HashSet, TreeSet)
3. Map  (HashMap, HashTable, TreeMap 등)
   Collectio 인터페이스를 따르진 않음.
```
### 동기화(Synchronization)
- Multi-Thread Programming에서 여러 쓰레드(여러개의 작업군)가 하나의 객체에 동시에 접근할 떄 발생하는 문제
- 구버젼에서 구현한 클래스들(Vector, Hashtable)의 경우 자체적으로 동기화 처리가 되어 있으나, 신규로 추가된 클래스에는 없는 경우도 있음.
- 동기화가 필요한 경우, 키워드를 사용하거나 동기화 처리가 구현된 클래스를 이용해야 한다.

### Deep Copy / Shallow Copy
- 자체에서 모든 호출은 Call by value(값)
- 참조 객체 역시 값이 전달되는데 바로 *주소값*이 전달되는 형태
- Primitive Type(Deep Copy) / Reference Type(Shallow Copy)

### List
#### Vector vs ArrayList
```
- 저장순서 유지 / 중복 허용
- Vector의 경우 Multi-Thread 동기화 처리(Thread Safe)
- 기본적으로 생성된 공간 이상의 내용이 들어올 경우, 새로운 객체를 생성하여 공간을 확장함.
- 삭제 연산 시 주의점 : 앞에서부터 순차적으로 삭제 연산이 있을 경우, 이후 요소들이 빈 공간을 채우기 위해 이동을 해야 함.
- 객체 생성 시, 충분한 공간 할당을 해놓고 사용하는 것이 좋음 : 기본적으로 자동으로 2배 가량의 공간을 확장하기 때문에 충분한 공간을 할당해놓고 사용하는 것이 좋다.
  ex) 게시판 페이지 처리
```
#### LinkedList
##### Array
```
- 크기 변경 불가
- 순차 처리 시 삭제/추가 시간이 많이 걸림
```
##### 이러한 Array의 단점을 보완하기 위해 LinkedList사용
```
Single Linked List(단방향)
Double Linked List(양방향)
Double Circular Linked List(순회)
```

##### ArrayList vs LinkedList
```
- 순차처리 시 ArrayList
- 중간 데이터 처리 시 LinkedList
- 데이터 주소 계산 = 배열의 주소 + n * 데이터 타입의 크기
```

#### Stack vs Queue
##### Queue
```
- FIFO(First in First Out) : 먼저 들어온 애가 가장 먼저 나간다.
- Enqueue(들어올 때) / Dequeue(나갈 때)
- 들어온 순서대로 처리 하기 때문에, 주로 작업 스캐쥴러에 사용하거나 순차 처리로 처리해야 할 로직에 사용
- LinkedList를 주로 사용(ArrayList는 앞에 요소가 삭제 되면 뒤에 요소들이 모두 이동해야 하기 때문에)
```

##### Stack
```
- LIFO(Fist in, Last Out) : 먼저 들어온 애가 마지막에 나간다.
- Push(들어올 떄) / Pop(나갈 떄)
- [호출 스택] 등이 가장 접하기 좋은 예제
- 스텍이 가득 차 있는 상태에서 Push를 하면 StackOverFlow
  스택이 비어 있는 상태에서 데이터를 꺼내면 StackUnderFlow
```

#### Enumertaion / Iterator / ListIterator
- 저장된 요소를 접근하는데 사용되는 *인터페이스*
- Enumeration -> Iterator -> ListIterator 순으로 기능이 향상 됨.
- 공통 인터페이스를 유지하여 중복을 제거하고 재사용성을 높임

##### Iterator
- Enumberation(X) -> Iterator를 사용하자
  기존 코드의 호환성때문에 유지 되고 있는 인터페이스
- Enumeration의 신버젼
- 컬렉션 프레임웍에서 저장된 요소를 읽어오는 표준화된 방법


```java
Iterator iter = list.iterator();
while(iter.hasNext()){
    // 작업 수행
}
```


##### ListIterator
- Iterator : 단방향 접근
- ListIterator : 양방향으로 접근이 가능

```java
Iterator iter = list.listIterator();
while(iter.hasPrevious()){
    System.out.println(iter.previous());
}
```


#### HashSet
- Set인터페이스를 구현한 대표적인 클래스
- 중복(X) / 저장순서를 유지하지 않기 때문에 유지하고자 한다면 *LinkedHashSet*를 사용

```java
// Custom Class의 경우 Set 인터페이스 구현 클래스를 정확하게 사용하기 위해서
// equals, hashCode 메서드를 오버라이딩 해서 사용해야 함.
Person person = new Person("David",10);

// String 클래스의 경우, 오버라이딩이 적절하게 이뤄져 있는 클래스이기 때문에
// 별도로 equals, hashCode 메서드를 오버라이딩 하지 않아도 됨.
String name   = new String("10");
```

2016-06-26 내용 추가
----------------------------


#### TreeSet
- "이진검색트리" 자료 구조 형태
- 정렬, 검색, 범위검색에 뛰어난 성능을 보임
- TreeSet은 이진검색트리(Binary Search Tree)의 성능을 향상시킨 '레드-블랙 트리'로 구현
- TreeSet은 저장할 때, 이미 정렬하기 때문에 읽어올때 따로 정렬해야 할 필요가 없음
- 범위검색 시(Range Search) 할 때, 대문자와 소문자 기준에 따라 검색 결과가 달라질 수 있으므로 통일성 있는 데이터 저장이 필요
> 문자열의 경우 아스키코드 값을 기준으로 하기 때문, 공백-숫자-대문자-소문자(오름차순 기준)

#### 이진트리(Binary Tree)
> 여러 개의 노드가 서로 연결된 구조로 각 노드는 최대 2개의 노드를 연결할 수 있으며 루트 노드에서 시작하여 계속하여 확장할 수 있다.
하나의 부모 노드를 2개의 자식 노드와 연결할 수 있는데, 자식 노드가 또 다른 노드들의 부모가 될 수 있으며 계속하여 자식-부모 구조로 확장
하여 구조가 이뤄진다.

#### 이진검색트리(Binary Search Tree)
- 왼쪽(최소) - 부모노드(중간값) - 오른쪽(최대값)
- 1,5,7의 경우, 왼쪽(1) - 부모노드(5) - 오른쪽(7)로 구성할 수 있음.
- 저장된 값들에 비례해서 검색 시간이 증가, 하지만 값의 개수가 10배 증가해도 특정 값을 찾는데 필요한 비교횟수는 3~4번만 증가할 정도로 검색 효율이 뛰어남
- LinkedList에 비해, 삭제 연산 시 트리 구성을 변경해야 하므로, 추가삭제 시간은 더 걸린다.
- **검색, 정렬 > 추가, 삭제**


#### Comparator / Comparable
- 인터페이스, 객체들을 정렬하거나 이진검색트리를 구성하는데 필요한 매서드 정의
- Comparable을 구현하는 클래스는 서로 비교할 수 있음
- Integer, String, Date, File 등 기본적으로 오름차순
- Comparable을 구현한 클래스는 정렬이 가능하다는 것을 의미함.
- 비교 연산 시, 비교 값이 작으면 음수 / 같으면 0 / 크면 1을 리턴한다
- Comparator는 기본 정렬기준 외에 다른 기준으로 정렬할 떄 사용
```java
public final class Integer extends Number implements Comparable
... 생략
```

#### HashMap
- Key/Value로 자료를 저장
- 내부 구현은 Entry 클래스의 배열로 저장되며, Entry클래스 역시 Key/Value의 구조로 이뤄져 있음.
- 해싱(Hashing)
  - 해시 함수(Hash Function)을 이용해서 데이터를 해시테이블(HashTable)에 저장하고 검색하는 기법을 말함
해시함수가 데이터가 저장된 곳을 알려주기 떄문에 대량의 데이터 중 원하는 데이터르 빠르게 찾을 수 있음.
  - 자바에서는 HashTable이 있긴 하지만, JDK1.2부터 도입된 컬렉션프레임워크 이전 소스에 대하여 호환성 때문에 남겨두고 있기 떄문에
  HashTable 대신 HashMap을 사용하는 것을 추천함.
  - hashCode()를 사용하여 실제 키값에 매칭되는 객체 및 인스턴스를 반환하기 떄문에, 키는 Unique한 성격을 가져야 한다.



#### TreeMap
- 이진검색트리의 형태로 Key/Value 쌍으로 이뤄진 데이터 구조
- HashMap이 검색 성능이 일반적으로 더 좋지만, 범위검색 혹은 정렬의 경우 TreeMap이 더 우위에 있다.