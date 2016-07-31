# I/O
## 입출력이란?
Computer 내부/외부와 데이터를 주고 받는 것을 통칭함.

### 스트림
- 연속적인 데이터 흐름
- 스트림은 기본적으로 단방향 통신만 가능
  - 입력/출력 스트림을 별도로 사용해야 함.
  - InputStream / OuputStream
  - 큐(Queue)(선입선출) 구조와 비슷

### 바이트 기반 스트림
java.io 패키지를 통하여 표준화된 수 많은 종류의 입출력 관련 클래스를 제공하고 있으며 관련 클래스를 잘 활용하는 것이 핵심이다.

- InputStream(read) / OuputStream(write)
  - File : 파일
  - ByteArray : 메모리
  - Piped : 프로세스
  - Audio : 오디오장치

### 보조스트림
기반 스트림의 기능을 보완하는 목적으로 사용된다. 실제로 데이터를 주고 받는 스트림이 아니고, 기능 향상 및 추가의 목적으로 사용한다.
```java
FileInputStream fis = new FileInputStream('text.txt');
BufferedInputStream bis = new BufferedInputStream(fis);
bis.read();
```

버퍼 보조 스트림을 사용했을 경우와 그렇지 않은 경우는 입출력 속도 및 성능에서 크게 차이가 나기 때문에 가급적이면 보조스트림을 사용하는 것이 좋다.
또한, 버퍼 스트림 역시 InputStream/OuputStream의 확장된 클래스들이기 때문에 기본적인 입출력 방법은 동일s하다.

- Filter : 필터 사용
- Buffered : 버퍼를 이용
- Data : Primitive 타입을 사용하여 데이터 처리
- Sequence : 스트림 연결
- LineNumber : 읽은 데이터의 라인 버호 카운트
- Object : 데이터를 객체 단위로 읽고 쓰는데 사용
- Pushback : 버퍼를 사용하여 읽은 데이터 원복

### 문자 기반 스트림
자바에서는 기본적으로 문자(char)형이 2byte이기 때문에 앞에서의 바이트 스트림을 그대로 사용하는데에 제약이 생긴다. 이점을 보완하기 위한 것이 문자기반 스트림이다.

- Reader/Writer
  - File
  - CharArray
  - Piped
  - String

바이트 기반의 보조스트림이 있듯이, 문자열 기반 보조스트림 역시 존재한다. 목적 및 사용방법은 거의 다르지 않다.

### 표준 입출력
콘솔을 통한 입력/출력을 의미한다. 자바에서는 System.in, System.out, System.err을 제공하는데 자바 실행 시 자동으로 사용할 수 있도록 생성되기 때문에 소스에서 별도로 생성을 하지 않아도 된다.

- System.in : InputStream
- System.out : PrintStream
- System.err : PrintStream

setOut(), setErr(), setIn() 매서드를 통하여 콘솔에 입력하는 것을 다른 입출력(파일 등)으로 변경하여 사용하는 것이 가능하다.
> System 클래스에 static 매소드로 정의되어 있다.


### 직렬화(Serialize)
객체를 데이터 스트림으로 만드는 것을 의미. 객체에 저장된 데이터를 스트림에 쓰기 위해 연속적인 데이터로 변환하는 것을 말한다.
> 즉, 객체를 저장하고 다시 가져오는 과정을 직렬화 / 역직렬화라고 한다.

- ObjectInputStream(스트림으로 객체 입력) / ObjectOutputStream(스트림으로 객체 출력)
  > 위 2개 스트림 모두, 기반 스트림을 필요로 하는 보조 스트림이다.

직렬화 가능한 클래스를 만드는 방법은 'java.io.Serializable' 인터페이스를 구현하도록 하면 된다.
> 실제 인터페이스에는 아무 내용도 없지만, 직렬화 유무를 판단하는 역할을 한다.
```java
public class UserInfo implements Serializable{
    String name;
    String password;
    int age;
}
```
직렬화 작업 시, 대상 클래스가 상속을 받고 있는 경우라면 슈퍼 클래스의 변수들이 Serializable 인터페이스를 구현하고 있지 않다면 직렬화 대상에서 제외된다. 이를 개선하기 위해 writeObject/ readObject를 추가하여 직렬화 되도록 구현해야 한다.
> 실제로 매서드들은 private 접근자로 직렬화/역직렬화 시 자동으로 콜백된다.


직렬화된 객체를 역직렬화 할때, 동일한 클래스(변경이 없었던)를 사용해야 하는데 만약 변경이 있었다면 InValidClassException이 발생하면서 실패한다.

직렬화/역직렬화 시 클래스의 버젼이 달라서 생기는 익셉션인데 serialVersionUID 클래스 버젼을 자동으로 생성해서 직렬화 내용에 표함해야 된다.
> 즉 클래스의 버젼 관리를 하는 개념과 비슷하다. 같은 버젼의 클래스만을 직렬화/역직렬화를 시키겠다는 의미와 같다.

