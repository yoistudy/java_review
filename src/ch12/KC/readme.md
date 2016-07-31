# 쓰레드(Thread)
## 프로세스(process) / 쓰레드(Thread)
- 실행 중인 프로그램(Program)
- OS로부터 실행에 필요한 자원을 할당받아 프로세스가 된다.
- 프로세스는 수행에 필요한 자원(메모리, 데이터)과 쓰레드로 구성되어 있으며 실제로 작업을 수행하는 것은 쓰레드다.
- 한개의 프로세스가 가지는 쓰레드의 개수는 제한이 없으나, 호출스텍(메모리 공간)의 크기에 따라 쓰레드의 숫자(생성할 수 있는)가 결정된다.
  - 호출스텍의 공간을 나눠쓰는 개념으로 생각하면 된다.
- 다양한 요청을 처리해야 하는 서버 프로그램, 다양한 작업이 복잡적으로 이뤄지는 클라이언트 프로그램에서는 멀티쓰레드가 필수적이다.
  - 같은 프로세스에서 자원을 공유하기 때문에, 동기화(synchronization) / 교착상태(deadlock)같은 문제가 발생할 수 있다.
- 쓰레드(Thread)의 종류는 **사용자 쓰레드**와 **데몬쓰레드** 두 가지 종류가 있다.

## 구현/실행
- Thread 클래스 확장(상속)

    ```java
    class ThreadSample extends Thread{
        public void run(){
            // 코드 구현
        }
    }
    ```
- Runnable 인터페이스 구현

    ```java
    class ThreadSample implements Runnable{
        public void run(){
            // 코드 구현
        }
    }
    ```

    > 결국, 인터페이스(Runnable)을 활용하는 방법이나 Thread 클래스를 확장하는 방법이나 run() 매소드의 내용을 채우면 되는 것
- 쓰레드의 이름을 지정하지 않으면 [Thread-번호] 형식으로 이름이 정해진다.
- **한번 사용한 쓰레드는 재사용이 불가능하다. 그렇기 때문에 하나의 스레드에 대해서는 한 번만 호출이 가능하다**
  - 두 번 이상 호출하면 IllegalThreadStateException 발생

## run() / start()
- run()은 개별 호출스택에서 실행할 코드를 구현한 부분
- start()는 개별 호출스택을 생성하며 run()매소드를 호출한다.
  - 생성된 호출스택에서 가장 먼저 run() 매소드를 호출하여 호출스택에 가장 하단에 위치하게 된다.
- 쓰레드의 실행은 기본적으로 우선순위를 고려하여 실행이 되며, 하나의 쓰레드가 실행 중이면, 어떤 특정 쓰레드는 잠시 실행을 멈추는 대기상태로 기다리게 된다.
  - 대기상태로 있다가, 스케줄러가 정한 순서에 의하여 실행된다.
- 프로그램은 쓰레드가 하나도 존재하지 않을 떄, 종료가 된다.

## Single-Thread / Multi-Thread
- 프로세스는 기본적으로 OS의 프로세스 스캐쥴러에 영향을 받기 때문에, 쓰레드의 실행은 코드를 작성한 사람의 의도대로 실행되지 않는 경우가 많다.
- 쓰레드의 스캐쥴링은 JVM의 쓰레드 스캐쥴러에 의하여 관리된다.
  - JVM 즉 자바 가상머신을 활용한 프로그램도 프로세스 스캐쥴러에 영향을 받기 때문에 실행 자체가 일정하지 않을 가능성이 높다.
- CPU 연산이 많은 작업에는 Single-Thread가 유리하다.
  - 책에도 나와있지만, 멀티쓰레드는 기본적으로 Context Switching이 발생하여 시간 소모가 발생하기 때문에 시간이 일반적으로 더 소모될 수 있으나 멀티코어 프로세서를 사용하는 경우에는 쓰레드 처리가 병렬로 처리될 수 있기 때문에 사실상 거의 차이가 안날 수 있다.
  - 프로세스 스위칭은 일반적으로 쓰레드 스위칭보다 더 큰 비용이 발생한다.
- 다른 네트워크 작업 / 장비 사용등의 외부 입출력이 사용되는 경우는 직접적으로 CPU와 관련된 연산이 진행되는 것이 아니기 때문에 Multi-Thread가 유리하다.

## Thread 처리 우선 순위
- 쓰레드는 우선순위 프로퍼티(맴버변수)를 가지고 있는데, 이 값에 의하여 쓰레드가 점유할 수 있는 시간이 달라진다.
  - 즉, 우선순위 값이 높을수록 실행을 더 많이 할 수 있음을 의미한다.
```java
// 쓰레드 인스턴스 유선순위 할당 getter/setter
void setPriority(int newPriority);
int getPriority();

public static final int MAX_PRIORITY = 10; // 최대
public static final int MIN_PRIORITY = 1; // 최소 우선 순위
public static final int NORM_PRIORITY = 5; // 보통 우선 순위


```
- 1~10까지 값을 할당할 수 있으나, 값 자체는 절대적인것이 아니라 상대적이라는 것에 주의해야 한다.
- 우선순위는 쓰레드를 생성한 상위 쓰레드의 값을 상속받기 때문에, 주의해야 한다.
  - main thread는 기본값이 5, 하지만 이 값 역시 상대적이라는 것에 주의!
  - 상대적이긴 하지만, 우선순위 값이 2 이상으로 차이가 나면 실행시간에 차이가 커진다.

## Thread Group(쓰레드 그룹)
- 쓰레드를 그룹/폴더 단위로 관리 가능
- 보안상의 이유로 도입된 기능으로, 상위 쓰레드 그룹에서 하위 쓰레드 그룹을 변경 가능하지만 별개의 그룹을 가진 쓰레드 그룹의 쓰레드는 직접 컨트롤이 불가능하다.
- 모든 쓰레드들은 그룹을 가져야 한다.
  - 별도로 그룹을 지정하지 않으면 main thread group에 속하며, 그룹은 기본적으로 main thread group의 하위 그룹으로 속하게 된다.
- JVM Thread Group
  - MAIN Thread Group
    - User Defined Thread Group
    - 쓰레드 그룹을 지정하지 않은 쓰레드들이 속하게 되는 그룹
  - SYSTEM Thread Group
    - Finalizer Thread의 경우, 가비지컬렉팅 역할을 하는 쓰레드

## Daemon Thread(데몬 쓰레드)
- Worker Thread를 돕는 보조적인 성격의 Thread
- 작업 쓰레드가 종료되면 자동적으로 종료된다.
  - 작업 쓰레드의 보조를 하는 역할이기 때문에, 실질적인 작업이 없는 경우 존재 의미가 없기 때문이다.
```java
boolean isDaemon(); // 데몬쓰레드 유무 확인
void setDaemon(boolean on/off); // 데몬쓰레드 설정
```


## Thread 실행 제어
### Multi Thread Programing이 어려운 이유
- 동기화(Synchronization) / 스캐쥴링 / DeadLock 발생 및 제어의 어려움
- OS의 프로세스 관리/스캐쥴링에 영향을 받기 때문에 실행 제어가 어려움
- 쓰레드 실행은 실행대기열에 있는 순서에 영향을 받는다. 기본적인 실행대기열 구조는 QUEUE와 비슷하다.
- Thread State
  1. NEW : 쓰레드 생성 후 start()가 안된 상태
  2. RUNNABLE : 실행 중 또는 실행 가능한 상태
  3. BLOCKED : 동기화 블럭에 의하여 일시정지된 상태
  4. WATING/TIME_WAITED : 쓰레드 작업이 종료되지는 않았지만, 실행가능하지 않은 상태/일시정지 상태
  5. TERMINATED : 종료 상태
- 참고 URL
  - [NAVER D2 / 쓰레드 상태](http://d2.naver.com/helloworld/10963)
  - [ORACLE / THREAD.STATE](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html)
  - [Java Thread Methods and Thread States](http://www.w3resource.com/java-tutorial/java-threadclass-methods-and-threadstates.php)
