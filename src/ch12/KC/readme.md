# 쓰레드(Thread)
## 프로세스(process) / 쓰레드(Thread)
- 실행 중인 프로그램(Program)
- OS로부터 실행에 필요한 자원을 할당받아 프로세스가 된다.
- 프로세스는 수행에 필요한 자원(메모리, 데이터)과 쓰레드로 구성되어 있으며 실제로 작업을 수행하는 것은 쓰레드다.
- 한개의 프로세스가 가지는 쓰레드의 개수는 제한이 없으나, 호출스텍(메모리 공간)의 크기에 따라 쓰레드의 숫자(생성할 수 있는)가 결정된다.
  - 호출스텍의 공간을 나눠쓰는 개념으로 생각하면 된다.
- 다양한 요청을 처리해야 하는 서버 프로그램, 다양한 작업이 복잡적으로 이뤄지는 클라이언트 프로그램에서는 멀티쓰레드가 필수적이다.
  - 같은 프로세스에서 자원을 공유하기 때문에, 동기화(synchronization) / 교착상태(deadlock)같은 문제가 발생할 수 있다.

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

