ch.14 입출력(I/O)
===
## 문자기반 스트림

#### Reader와 Writer

- Reader/Writer는 문자기반 스트림의 조상클래스

- char 타입 배열 사용

- 인코딩 사용하여 읽기/쓰기

- Reader의 메서드

    - abstract void close() : 입력스트림을 닫고 사용하고 있던 자원 반환

    - void mark(int readlimit) : reset 메서드에 의해 돌아오기 위해 현재위치를 표시

    - boolean markSupported() : mark 메서드, reset 메서드의 지원 여부

    - int read() : 입력소스로 부터 하나의 문자를 읽어 온다

        char 범위(0 ~ 2^16-1)의 정수를 반환

        마지막 데이터에 도달하면 -1을 반환

    - int read(char[] c) : 매개견수로 주어진 배열의 크기만큼 입력소스에서 읽어서 배열에 저장한다
        읽어온 데이터의 개수나 -1을 반환

    - abstract int read(char[] c, int off, int len) : 입력소스로부터 최대 len개의 문자를 읽어 매개변수 배열의 지정된 위치(off)로 부터 읽은 만큼 저장한다

        읽어온 데이터의 개수나 -1을 반환

    - boolean ready() : 입력소스로부터 데이터를 읽을 준비가 되어있는지 알려준다

    - void reset() : 입력소스에서 마지막으로 mark 메서드가 호출되었던 위치로 되돌린다

    - long skip(long n) : 현재 위치에서 주어진 문자 수(n)만큼 건너 뜀

- Writer의 메서드

    - abstract void close() : 출력스트림을 닫고 사용하고 있던 자원 반환

    - abstract void flush() : 스트림 버퍼에 있는 모든 내용을 출력소스에 쓴다

        (버퍼가  있는 스트림에만 해당됨)

    - void write(int b) : 주어진 값을 출력소스에 쓴다

    - void write(char[] c) : 매개변수 배열에 저장된 모든 내용을 출력소스에 쓴다

    - abstract void write(char[] c, int off, int len) : 매개변수 배열의 지정된 위치(off)로 부터 len개의 문자를 읽어 출력소스에 쓴다

    - void write(String str) : 매개변수 문자열을 출력소스에 쓴다

    - void write(String str, int off, int len) : 매개변수 무자열의 지정된 위치(off)로 부터 len개의 문자를 읽어 출력소스에 쓴다

#### FileReader와 FileWriter

- 파일로 부터 텍스트 데이터를 읽고 파일에 쓰는데 사용

#### PipedReader와 PipedWriter

- 쓰레드간 데이터를 주고받을 때 사용됨

- 입력과 출력스트림을 하나의 스트림으로 연결해서 데이터를 주고받음

#### StringReader와 StringWriter

- CharArrayReader와 CharArrayWriter와 같이 입출력 대상이 메모리인 스트림

- StringWriter에 출력되는 데이터는 내부 StringBuffer에 저장된다

    - StringBuffer getBuffer() : StringWriter에 출력한 데이터가 저장된 StringBuffer를 반환

    - String toString() : StringWriter의 StringBuffer에 저장된 문자열을 반환


## 문자기본 보조스트림

#### BufferedReader와 BufferdWriter

- BufferedReader와 BufferdWriter는 버퍼를 이용해 입출력 효율을 높히기 위해 사용

- BufferedReader의 readLine()을 사용하면 데이터를 라인단위로 읽어 올 수 있다는 장점이 있다 (JDK 1.5 이후 Scanner를 이용해서도 간단하게 처리 가능)

- BufferdWriter는 newLine()이라는 줄바꿈 메서드를 제공한다

#### InputStreamReader와 OutputStreamWriter

- 바이트기반 스트림을 문자기반 스트림으로 연결시켜주는 역할

- 연결 이후 바이트기반 스트림의 데이터를 지정된 인코딩의 문자로 변환하는 작업을 수행

- InputStreamReader의 생성자와 메서드

    - InputStreamReader(InputStream in) : OS에서 사용하는 기본 인코딩의 문자로 변환하는 InputStreamReader를 생성

    - InputStreamReader(InputStream in, String encoding) : 지정된 인코딩을 사욯나는 InputStreamReader를 생성

    - String getEncoding() : InputStreamReader의 인코딩을 반환

- OutputStreamWriter의 생성자와 메서드

    - OutputStreamWriter(OutputStream out) : OS에서 사용하는 기본 인코딩의 문자로 변환하는 InputStreamWriter를 생성

    - OutputStreamWriter(OutputStream out, String encoding) : 지정된 인코딩을 사용하는 OutputStreamWriter을 생성

    - String getEncoding() : OutputStreamWriter의 인코딩을 반환

- OS에서 사용하는 인코딩 종류를 알아보기

```java

Properties prop = System.getProperties();
System.out.println(prop.get ("sun.jnu.encoding"));

InputStreamReader isr = new InputStreamReader()
System.out.println(isr.getEncoding());

```

## 표준입출력과 FileReader

#### 표준입출력 - System.in, System.out, System.err

- 표준입출력은 콘솔을 통한 데이터 입력과 콘솔로의 데이터 출력을 의미

- 자바에서는 표준입출력을 위해 3가지 입출력 스트림을 제공

    - System.in : 콘솔로부터 데이터를 입력 받음

        콘솔 입력은 한번에 버퍼 크기만큼 입력이 가능하고 Enter나 중지명령을 하기 전까지 blocking 상태에 머문다

    - System.out : 콜솔로 데이터를 출력

    - System.err : 콘솔로 에러를 출력하는데 사용

#### 표준입출력의 대상변경 - setOut(), setErr(), setIn()

- static void setOut(PrintStream out) : System.out의 출력을 지정된 PrintStream으로 변경

- static void setErr(PrintStream err) : System.err의 출력을 지정한 PrintStream으로 변경

- static void setIn(InputStream in) : System.in의 입력을 지정한 InputStream으로 변경

#### RandomAccessFile

- RandomAccessFile는 입력과 출력을 모두 할 수 있도록 설계

- InputStream이나 OutputStream을 상속받지 않고 DataInput과 DataOutput 인터페이스를 구현하여 읽기, 쓰기 모두 가능

- DataInput과 DataOutput 인터페이스에는 기본 자료형의 읽기, 쓰기 메서드가 정의 되어있다

- RandomAccessFile은 파일의 어느 위치에서나 입출력이 가능케 하기위해 작업이 수행되는 곳을 가리키는 (동시에 임의로 지정할 수 있는) 파일포인터를 내부적으로 가지고 있다

파일의 임의의 위치에서 작업을 하고 싶다면 파일포인터를 원하는 위치로 지정하고 작업을 해야한다

- RandomAccessFile의 메서드와 생성자

    - RandomAccessFile(File file, String mode), RandomAccessFile(String fileName, String mode) : 주어진 file에 RandomAccessFile 인스턴스 생성

        mode에는 `r`(읽기), `rw`(읽기와쓰기) 두가지 값이 지정가능

            `rw` 시 파일이 존재하지 않으면 새 파일 생성

    - long getFilePointer() : 파일 포인터 위치를 반환

    - long length() : 파일의 크기를 반환(byte 단위)

    - void eek(long pos) : 지정된 위치로 파일 포인터를 이동(위치는 파일 시작점 기준, byte 단위)

    - void setLength(long newLength) : 파일의 크기를 지정된 길이로 변경(byte 단위)

    - skipByte(int n) : 지정된 크기만큼 byte를 건너 뜀

#### File

- 파일과 디렉토리를 다룰 수 있다

- File의 생성자와 경로 관련 메서드

    - File(String fileName) : 매개변수 문자열을 이름으로 같는 파일(디렉토리 포함)의 File인스턴스를 생성한다

    - File(String pathName, String fileName) : 파일의 경로와 이름을 따로 분리해서 지정하여 File인스턴스를 생성

    - String getName() : 파일이름을 반환

    - String getPath() : 파일 경로를 반환

    - String getAbsolutePath() : 파일의 절대 경로를 반환

    - File getAbsoluteFile() : 파일의 절대경로를 File로 반환

    - String getParent() : 파일의 부모 디렉토리를 반환

    - File getParent() : 파일의 부모 디렉토리를 File로 반환

    - String getCanonicalPath() : 파일의 정규경로를 반환

    - File getCanonicalPath() : 파일의 정규경로를 File로 반환

        정규경로란 현재 디렉토리를 의미하는 `.`와 같은 기호나 링크를 포함하고 있지 않는 파일의 유일한 경로

- 경로 관련 File의 멤버 변수

    - static String pathSeparator : OS의 경로 구분자 문자열

    - static char pathSeparatorChar : OS의 경로 구분자 문자

    - static String separator : OS의 이름구분자 문자열

    - static char separatorChar : OS의 이름구분자 문자

- File인스턴스를 생성했다고 파일나 디렉토리가 생성되는 되는 것이아니라 출력스트림을 생성하거나 createNewFile 메서드를 호출해야한다

- 그 밖의 메서드

    - boolean canRead() : 읽을 수 있는 파일인지 여부

    - boolean canWrite() : 쓸 수 있는 파일인지 여부

    - boolean exists() : 파일의 존재여부

    - boolean isAbsolute() : 파일 또는 디렉터리의 경로가 절대경로명으로 지정되었는지 여부

    - boolean isDirectory() : 디렉토리 여부

    - boolean isFile() : 파일 여부

    - boolean isHidden() : 속성이 숨김인지 여부, 존재하지 않을때 false 반환

    - int comapareTo(File pathname) : 매개변수의 경로 문자열의 파일이나 디렉토리와 비교한다

        같으면 0을 반환

        다르면 1또는 -1을 반환

    - boolean createNewFile() : 빈 파일을 생성 (경로에 파일이 이미 존재하면 생성되지 않는다)

    - static File createTempFile(String prefix, String suffix) : 임시디렉토리에 임시파일을 생성

    - static File createTempFile(String prefix, String suffix, File directory) : 지정된 디렉토리에 임시파일을 생성

    - boolean delete() : 파일을 삭제

    - void deleteOnExit() : 응용 프로그램 종료시 파일 삭제

    - boolean equals(Object obj) : 주어진 객체가 같은 파일인지 여부

    - long length() : 파일 크기 반환

    - String[] list() : 디렉토리 포함하고 있는 파일, 디렉토리 내용을 String 배열로 반환

    - File[] listFiles() : 디렉토리 포함하고 있는 파일, 디렉토리 내용을 File 배열로 반환

    - static File[] listRootss[] : 파일시스템의 root의 목록을 반환


## 직렬화(Serialization)

#### Serialization란?

- Serialization이란 객체를 데이터 스트림으로 민드는것

- 스트림으로부터 데이터를 읽어 객체를 만드는 것을 Deserialization

#### ObjectlnputStream, ObjectOutputStream

- Serialization(스트림에 객체를 출력하는) 때 ObjectOutputStream 사용

- Deserialization(스트림으로부터 객체를 입력하는) 때 ObjectlnputStream를 사용

```java
FileOutputStream fos = new FileOutputStream("instance.ser");
ObjectOutputStream oos = new ObjectOutputStream(fos);

oos.writeObject(new UserInfo()); // UserInfo 인스턴스 Serialization

FileInputStream fis = new FileInputStream ("instance.ser");
ObjectInputStream ois= new ObjectInputStream (fis) ;

UserInfo info = (UserInfo) ois.readObject(); // UserInfo 인스턴스 Deserialization
```

#### 직렬화가 가능한 클래스 만들기 - Serializable, transient

- Serializable는 어떤 추상메서드도 없는 인터페이스, 구현 클래스에서 Serialization 고려 여부 판단을 위해 사용

- Serializable 인터페이스 구현으로 직렬화 가능한 클래스 작성 가능

- Serialization을 하고자하는 객체의 클래스에 Serialization가 안되는 객체의 참조를 포함하고 있으면 transient를 붙여 직렬화 대상에서 제외할 수 있다

- Serializable을 구현한 클래스와 하위 자손 클래스의 인스턴스 변수만이 Serialization된다

    - 조상 클래스 필드의 Serialization를 위한 writeObject, readObject 메서드

    ```java
    private void writeObject(ObjectOutputStream out) throws IOException {
        // 조상 클래스 필드의 인스턴스 변수 쓰기
		out.writeUTF(name);
		out.writeUTF(password);
        // (Serializable을 구현한) 현재 클래스 필드의 인스턴스 변수 쓰기
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // 조상 클래스 필드의 인스턴스 변수 읽기
		this.name = in.readUTF();
		this.password = in.readUTF();
        // (Serializable을 구현한) 현재 클래스 필드의 인스턴스 변수 읽기
		in.defaultReadObject();
	}
    ```

#### 직렬가능한 클래스의 버전관리

- 파일을 저장하는 시점의 클래스 정의와 파일이 읽혀지는 시점의 클래스 정의가 같은지 확인이 필요

- 클래스에 static final long serialVersionUID으로 버전을 관리한다


---
