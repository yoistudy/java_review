#Ch12 쓰레드

##1. 프로세스와 쓰레드
프로세스란 간단히 말해서 '실행 중인 프로그램'이다.
프로그램을 실행하면 OS로부터 필요한 자원(메모리)을 할당받아 프로세스가 된다.

프로세스는 프로그램을 수행하는 데 필요한 데이터와 메모리 등의 자원 그리고 쓰레드로 구성되어 있으며
프로세스의 자원을 이용해서 실제로 작업을 수행하는 것이 바로 쓰레드이다.

모든 프로세스에는 최소한 하나 이상의 쓰레드가 존재하며,
둘 이상의 쓰레드를 가진 프로세스를 멀티쓰레드 프로세스라고 한다.

하나의 프로세스가 가질 수 있는 쓰레드의 개수는 제한되어 있지 않으나
쓰레드가 작업을 수행하는데 개별적인 메모리공간(호출스택)을 필요로 하기 때문에
프로세스의 메모리 한계(호출스택의 크기)에 따라 생성할 수 있는 쓰레드의 수가 결정된다.

	멀티쓰레딩의 장점
    - CPU의 사용률을 향상시킨다.
    - 자원을 보다 효율적으로 사용할 수 있다.
    - 사용자에 대한 응답성이 향상된다.
    - 작업이 분리되어 코드가 간결해진다.

[참고]쓰레드를 가벼운 프로세스, 즉 경량프로세스(light-weight proccess) 라고 부르기도 한다.

멀티쓰레드 프로세스는 여러 쓰레드가 같은 프로세스 내에서 자원을 공유하면서 작업을 하기 때문에
발생할 수 있는 동기화, 교착상태와 같은 문제들을 고려해서 신중히 프로그래밍해야한다.

##2. 쓰레드의 구현과 실행
쓰레드를 구현하는 방법은 Tread클래스를 상속받는 방법과 Runnable인터페이스를 구현하는 방법 두가지가 있다.
Thread클래스를 상속받으면 다른 클래스를 상속받을 수 없기 때문에, Runnable인터페이스를 구현하는 방법이 일반적이다.

Runnable인터페이스를 구현하는 방법은 재사용성이 높고
코드의 일관성을 유지할 수 있다는 장점이 있기 때문에 보다 객체지향적인 방법이라 할 수 있겠다.

	1.Thread클래스를 상속
	class MyThread extends Thread{
    	public void run(){/* 작업 내용 */}//Thread클래스의 run()을 오버라이딩
    }

	2.Runnable인터페이스를 구현
	class MyThread implements Runnable{
    	public void run(){/* 작업 내용 */}//Runnable인터페이스의 추상메서드 run() 구현
    }

Runnable인터페이스는 run()메서드만 정의되어 있는 간단한 인터페이스이다.
Runnable인터페이스를 구현하기 위해서는 추상메서드인 run()의 몸통을 만들어주는 것뿐이다.

	public interface Runnable{
    	public abstrart void run();
    }

쓰레드를 구현한다는 것은 두가지 방법 중 어떤 것을 선택하던 간에, 쓰레드를 통해 작업하고 하는
내용으로 run()의 몸통를 채우기만 하면 되는 것이다.

[예제12-1 p-635]
Thread클래스를 상속받은 경우와 Runnable인터페이스를 구현한 경우의 인스턴스 생성 방법이 다르다.
```java
ThreadEx1_1 t1 = new ThreadEx1_1();

Runnable r = new ThreadEx1_2();
Thread t2 = new Thread(r); //생성자 Tread(Runnable target)
//Thread t2 = new Thread(new ThreadEx1_2());
```
Runnable인터페이스를 구현한 경우, Runnable인터페이스를 구현한 클래스의 인스턴스를 생성한 다음,
이 인스턴스를 가지고 Thread클래스의 인스턴스를 생성할 때 생성자의 매개변수로 제공해야 한다.
이 때 사용되는 Thread클래스의 생성자는 Thread(Runnable target)로 호출시에
Runnable인터페이스를 구현한 클래스의 인스턴스를 넘겨줘야 한다.

인슨턴스변수로 Runnable타입의 변수 r을 선언해 놓고 생성자를 통해서 Runnable인터페이스를 구현한
인스턴스를 참조하도록 되어 있는 것을 확인할 수 있다.
run()을 호출하면 참조변서 r을 통해서 Runnable인터페이스를 구현한 인스턴스의 run() 호출
상속을 통해 run()을 오버라이딩하지 않고 외부로부터 제공받을 수 있게 된다.
```java
public class Thread{
	private Runnable r;//Runnable을 구현한 클래스의 인트턴스를 참조하기 위한 변수를 선언

    public Thread(Runnable r){
    	this.r = r;
    }

	public void run(){
    	if(r!=null)
        	r.run();
    }
}
```

Thread클래스를 상속받으면, Thread클래스의 메서드를 직접 호출 할 수 있지만,
Runnable을 구현하면 Thread클래스의 static메서드인 currentThread()를 호출하여
쓰레드에 대한 참조를 얻어 와야만 호출이 가능하다.

	Thread currentThread() - 현재 실행중인 쓰레드의 참조를 반환한다.
	String getName() - 쓰레드의 이름을 반환한다.

쓰레드의 이름은 다음과 같은 생성자나 메서드를 통해서 지정 또는 변경 할 수 있다.
쓰레드의 이름을 지정하지 않으면 'Thread-번호'의 형식으로 이름이 정해진다.
```java
Thread (Runnable target, Str ing name)
Thread(String name)
void setName (String name)
```

쓰레드를 생성한 다음에는 start()를 호출해야만 작업을 시작하게 된다.
한 가지 더 알아 두어야 할 것은한 번 사용한 쓰레드는 다시 재사용할 수 없다.
하나의 쓰레드에 대해 start()가 한번만 호출될 수 있다는 뜻이다.
```java
ThreadExl 1 tl = new ThreadExl 1();
tl.start();
t1.start();//IllegalThreadException발생
```
```java
ThreadExl 1 tl = new ThreadExl 1();
tl.start();
t1 = new ThreadEx1_1();
t1.start();
```

##3. start()와 run()
run()을 호출하는 것은 생성된 쓰레드를 실행시키는 것이 아니라
단순히 클래스에 속한 메서드 하나를 호출하는 것이다.

start()는 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택을 생성한 다음에 run()을 호출해서,
생성된 호출스택에 run()이 첫 번째로 저장되게 한다.

모든 쓰레드는 독립적인 작업을 수행하기 위해 자신만의 호출스택을 필요로 하기 때문에,
새로운 쓰레드를 생성하고 실행시킬 때마다 새로운 호출스택이 생성되고 쓰레드가 종료되면
작업에 사용된 호출스택은 소멸된다

	[그림 12-2 p-638]
	1.mains메서드에서 쓰레드의 start메서드를 호출한다.
	2.start메서드는 쓰레드가 작업을 수행하는데 사용될 새로운 호출스택을 생성한다.
	3.생성된 호출스택에 run메서드를 호출해서 쓰레드가 작업을 수행하도록 한다.
	4.이제는 호출스택잉 2개이기 때문에 스케줄러가 정한 순서에 의해서 번갈아 가면서 실행된다.

쓰레드가 둘 이상일때는 호출스택의 최상위에 있는 메서드일지라도 대기상태에 있을 수 있다.
스케줄러는 시작되었지만 아직 종료되지 않은 쓰레드들의 우선순위를 고려하여 실행순서와 실행시간을 결정하고,
각 쓰레드들은 작성된 스케줄에 따라 자신의 순서가 되면 지정된 시간동안 작업을 수행한다.

주어진 시간동안 작업을 마치지 못한 쓰레드는 다시 자신의 차례가 돌아올 때까지 대기상태에 있게되며,
작업을 마친 쓰레드, 즉 run()의 수행이 종료된 쓰레드는 호출스택이 모두 비워지면서
이 쓰레드가 사용하던 호출 스택은 사라진다.

[참고]start()가 호출된 쓰레드는 바로 실행되는 것이 아니라는 점에 주의해야한다.
일단 대기상태로 있다가 스케줄러가 정한 순서에 의해서 실행된다.

	실행 중인 사용자쓰레드가 하나도 없을 때 프로그램은 종료된다.

##4. 싱글쓰레드와 멀티쓰레드
[그림 12-4 p-642]
두 개의 쓰레드로 작업한 시간이 싱글쓰레드로 작업한 시간보다 더 걸리게 되는데
그 이유는 쓰레드간의 작업전환에 시간이 걸리기 때문이다.
그래서 단순히 CPU만을 사용하는 계산작업이라면
오히려 멀티쓰레드보다 싱글쓰레드로 프로그래밍 하는 것이 더 효율적이다.

[그림 12-5 p-644]
CPU이외의 자원을 사용하는 작업의 경우에는 싱글쓰레드 프로세스보다 멀티쓰레드 프로세스가 더 효율적이다.
예를 들어 사용자로부터 데이터를 입력받는 작업, 네트워크로 파일을 주고받는 작업, 프린터로 파일을 출력하는
작업과 같이 외부기기와의 입출력을 필요로 하는 경우가 이에 해당한다.
두 개의 쓰레드로 처리한다면 사용자의 입력을 기다리는 동안 다른 쓰레드가 작업을 처리할 수 있기때문에
보다 효율적인 CPU의 사용이 가능하다.

##5. 쓰레드의 우선순위
쓰레드는 우선순위(priority)라는 속성(멤버변수)을 가지고 있는데,
이 우선순위의 값에 따라 쓰레드가 얻는 실행시간이 달라진다. 쓰레드가 수행하는 작업의 중요도에 따라
쓰레드의 우선순위를 서로 다르게 지정하여 특정 쓰레드가 더 많은 작업시간을 갖도록 할 수 있다.

쓰레드가 가질 수 있는 우선순위의 범위는 1~10이며 숫자가 높을수록 우선순위가 높다.
우선순위의 높고 낮음은 절대적인 것이 아니라 상대적인 것임에 주의하자.
프로세스에게 주어진 실행시간을 두 쓰레드에게 어떠한 비율로 나누어 할당할 것인지는 쓰레드간의
우선순위 차이에 의해서 결정된다.

쓰레드의 우선순위는 쓰레드를 생성한 쓰레드로부터 상속 받는다는 것이다.

쓰레드를 실행하기 전에만 우선순위를 변경할 수 있다는 것을 기억하자.

##6. 쓰레드 그룹(thread group)
쓰레드 그룹은 서로 관련된 쓰레드를 그룹으로 다루기 위한 것으로,
쓰레드 그룹을 생성해서 쓰레드를 그룹으로 묶어서 관리할 수 있다.
쓰레드 그룹에 다른 쓰레드 그룹을 포함 시킬 수 있다.

쓰레드 그룹은 보안상의 이유로 도입된 개념으로, 자신이 속한 쓰레드 그룹이나
하위 쓰레드 그룹은 변경할 수 있지만 다른 쓰레드 그룹의 쓰레드를 변경할 수는 없다.

ThreadGroup을 사용해서 생성할 수 있다.
주요 생성자와 메서드 [표 12-1 p-650]

쓰레드를 쓰레드 그룹에 포함시키려면 Thread의 생성자를 이용해야한다.
```java
Thread(ThreadGroup group, String name)
Thread(ThreadGroup group, Runnable target)
Thread(ThreadGroup group, Runnable target, String name)
Thread(ThreadGroup group, Runnable target, String name, long stackSize)
```
모든 쓰레드는 반드시 쓰레드 그룹에 포함되어 있어야 하기 때문에,
위와 같이 그룹을 지정하는 생성자를 사용하지 않은 쓰레드는 기본적으로 자신을 생성한 쓰레드와 같은 쓰레드 그룹에 속하게 된다.

우리가 생성하는 모든 쓰레드 그룹은 main쓰레드 그룹의 하위 쓰레드 그룹이 되며,
쓰레드 그룹을 지정하지 않고 생성한 쓰레드는 자동적으로 main쓰레드 그룹에 속하게 된다.

##7. 데몬 쓰레드(daemon thread)
데몬 쓰레드는 다른 일반 쓰레드(데몬 쓰레드가 아닌 쓰레드)의 작업을 돕는 보저적인 역할을 수행하는 쓰레드이다.
일반 쓰레드가 모두 종료되면 데몬 쓰레드는 강제적으로 자동 종료되는데, 데몬 쓰레드는 일반 쓰레드의
보조역할을 수행하므로 일반 쓰레드가 모두 종료되고 나며 데몬 쓰레드의 존재의 의미가 없기 때문이다.
이 점을 제외하고는 데몬 쓰레드와 일반 쓰레드는 다르지 않다.
(ex 가비지 컬렉터, 워드프로세서의 자동저장, 화면자동갱신 등....)

데몬 쓰레드는 무한루프와 조건문을 이용해서 실행 후 대기하고 있다가 특정 조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.

데몬 쓰레드는 일반 쓰레드의 작성방법과 실행방법이 같으며 다만 쓰레드를 생성한 다음 실행하기 전에
setDaemon(true)를 호출하기만 하면 된다. 데몬 쓰레드가 생성한 쓰레드는 자동적으로 데몬 쓰레드가 된다.

```java
boolean isDaemon() - 쓰레드가 데몬 쓰레드인지 확인한다. 데몬 쓰레드이면 true를 반환한다.
void setDaemon(boolean on) - 쓰레드를 데몬 쓰레드로 또는 사용자 쓰레드로 변경한다.
							 (매개변수 on의 값을 true로 지정하면 데몬 쓰레드가 된다.)
```
setDaemon메서드는 반드시 start()를 호출하기 전에 실행되어야한다.
그렇지 않으면 IllegalThreadStateException이 발생한다.

##8. 쓰레드의 실행제어
쓰레드의 상태와 관련된 메서드

| 생성자/메서드 | 설명 |
|--------|--------|
|void interrupt()|sleep()이나 join()에 의해 일시정지상태인 쓰레드를 실행대기상태고 만든다.|
|void join()<br/>void join(long millis)<br/>void join(long milis,int nanos)|      지정된 시간동안 쓰레드가 실행되도록 한다.  |
|void resume()|suspend()에 의해 일시정지상태에 있는 쓰레드를 실행대기상태로 만든다.|
|static void sleep(long millis)<br/>static void sleep(long millis,int nanos)|   지정된 시간동안 쓰레드를 일시정지시킨다.|
|void stop()|쓰레드를 즉시 종료시킨다.|
|void suspend()|쓰레드를 일시정지시킨다.|
|static void yield()|실행 중에 다른 쓰레드에게 양보하고 실행대기상태가 된다.|
[표 12-2 p-657]

쓰레드의 상태

| 상태 | 설명 |
|--------|--------|
|NEW|쓰레드가 생성되고 아직 start()가 호출되지 않은 상태|
|RUNNABLE|실행 중 또는 실행 가능한 상태|
|BLOCKED|동기화블럭에 의해서 일시정지된 상태|
|WAITING <BR/> TIMED_WAITING|쓰레드의 작업이 종료되지는 않았지만 실행가능하지 않은 일시정지상태|
|TERMINATED|쓰레드의 작업이 종료된 상태|
[표 12-3 p-657]
[그림 12-7 p-658]

join()을 사용하지 않으면 main쓰레드는 바로 종료되지만,
join을 사용해서 쓰레드의 모든 작업이 끝날 때 까지 기다리지만, join(long millis)이나,
join(long milis, int nanos)를 사용하면 지정된 시간만큼만 main쓰레드가 기다리도록 할 수 있다.
한 쓰레드의 작업의 중간에 다른 쓰레드의 작업이 필요할 때 join()을 사용한다.

sleep()은 쓰레드를 지정된 시간동안 일시정지상태가 되도록 한다.
주의할 점은 시간이 지난 후에 바로 실행상태가 아닌 실행개기상태가 되는 것이다.
suspend()가 호출되면 쓰레드는 일시정지 상태가 되고 resume()이 호출되면 다시 실행대기상태가 된다.
stop()을 호출하면 쓰레드는 즉시 종료된다.

suspend(), resume(), stop()은 쓰레드를 교착상태에 빠뜨릴 가능성이 있기 때문에
deprecated되었으므로 사용하지 않는 것이 좋다.

interrupt()는 InterruptException을 발생시켜서 sleep(),join(),wait()에 의해 일시정지상태인
쓰레드를 실행대기상태로 만든다. 그러나 interrupt()가 호출되었을 때 sleep(),join(),wait()에
의한 일시정지상태가 아니라면 아무 일도 일어나지 않는다.

가비지 컬렉터와 같은 데몬 쓰레드의 우선순위를 낮추기보다는 sleeep()을 이용해서 주기적으로 실해오디도록
하다가 필요할 때마다 interrupt()를 호출해서 즉시 가비지 컬렉션이 이루어지도록 하는 것이 좋다.

##9. 쓰레드의 동기화
멀티쓰레드 프로그래밍에서 동기화는 중요한 요소이다.
얼마만큼 동기화를 잘 처리하는가에 따라서 프로그램의 성능에 많은 영향을 미치게 된다.

###9.1 synchronized를 이용한 동기화
자바에서 키워드 synchronized를 통해 해당 작업과 관련된 공유데이터에 lock을 걸어서
먼저 작업 중이던 쓰레드가 작업을 완전히 마칠 때까지는 다른 쓰레드에게 제어권이 넘어가더라도
데이터가 변경되지 않도록 보호함으로써 쓰레드의 동기화를 가능하게 한다.


synchronized는 다음과 같은 두 가지 방법으로 사용
가능하면 메서드에 synchonized를 사용하는 메서드 단위의 동기화를 권장

	1.특정한 객체에 lock을 걸고자 할 때
		synchronized(객체의 참조변수){
        	//...
        }
	2.메서드에 lock을 걸고자 할 때
		public synchronized void clacSum(){
        	//...
        }

synchronized블록의 경우 블록을 수행하는 동안은 지정된 객체에 lock이 걸려서 다른 쓰레드가 이 객체에 접근할 수 없게 된다.
synchronized메서드의 경우에도 메서드가 종료될 때까지 다른 쓰레드가 이 메서드를 호출하여 수행할 수 없게 된다.

synchronized를 이용해서 동기화를 처리할때 교착상태에 빠질 수 있기때문에 주의해야한다.

    교착상태(dead lock)란 두 쓰레드가 lock을 건 상태에서 서로 lock이 풀리기를 기다리는
    상황으로 작업이 진행되지 않고 영원히 기다리게 되는 상황을 말한다.

Thread에 정의된 stop(), suspend(), resume()과 같이 쓰레드의 상태를 변경하는 메서드들은
교착상태를 일으킬 가능성이 높다는 이유로 deprecated되었다.
그래서 while문, if문을 사용해서 쓰레드를 제어해야한다.
또는 suspend대신 wait()를, resume()대신 notify()를 사용한다.

작업도중에 쓰레드를 종료시킬 때는 작업하고 있던 객체의 lock을 푸는 것만이 아니라 작업 중에 변경했던
공유데이터를 작업이전의 상태로 돌려놓는 것까지 고려해야한다.

###9.2 wait()과 notify()
한 쓰레드가 객체에 lock을 걸고 오래 기다리는 대신 wait()을 호출해서 다른 쓰레드에게 제어권을 넘겨주고
대기상태로 기다리다가 다른 쓰레드에 의해서 notify()가 호출되면 다시 실행상태가 되도록 하는 것이다.


[참고]wait() 대신에 wait(long timeout)이나 wait(long timeout, int nanos)를 사용하면
notify()가 호출되지 않아도 지정된 시간이 지나면 쓰레드가 자동적으로 실행상태가 된다.

	wait(), notify(), notifyAll()
	- Object에 정의되어 있다.
    - 동기화 블록내에서만 사용할 수 있다.
    - 보다 효율적인 동기화를 가능하게 한다.






