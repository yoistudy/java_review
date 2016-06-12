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
<pre>
<code>
Iterator iter = list.iterator();
while(iter.hasNext()){
    // 작업 수행
}
</code>
</pre>


##### ListIterator
- Iterator : 단방향 접근
- ListIterator : 양방향으로 접근이 가능
<pre>
<code>
Iterator iter = list.listIterator();
while(iter.hasPrevious()){
    System.out.println(iter.previous());
}
</code>
</pre>

#### HashSet
- Set인터페이스를 구현한 대표적인 클래스
- 중복(X) / 저장순서를 유지하지 않기 때문에 유지하고자 한다면 *LinkedHashSet*를 사용
<pre>
<code>
// Custom Class의 경우 Set 인터페이스 구현 클래스를 정확하게 사용하기 위해서
// equals, hashCode 메서드를 오버라이딩 해서 사용해야 함.
Person person = new Person("David",10);

// String 클래스의 경우, 오버라이딩이 적절하게 이뤄져 있는 클래스이기 때문에
// 별도로 equals, hashCode 메서드를 오버라이딩 하지 않아도 됨.
String name   = new String("10");
</code>
</pre>