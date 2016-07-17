#Ch14 입출력 I/O

##1.자바에서의 입출력

###1.1 입출력이란?
I/O란 Input과 Output의 약자로 입력과 출력,
입출력은 컴퓨터 내부 또는 외부의 장치와 프로그램간의 데이터를 주고받는 것

###1.2 스트림(stream)

	스트림이란 데이터를 운반하는데 사용되는 연결통로이다.

입력과 출력을 동시에 수행하려면 입력을 위한 입력스트림(input stream)과
출력을 위한 출력스트림(output stream) 2개의 스트림이 필요
스트림은 먼저 보낸 데이터를 먼저 받게 되어 있으며 중간에 건너뜀 없이 연속적으로 데이터를 주고받는다.
(큐(queue)와 같은 FIFO구조)

###1.3 바이트기반 스트림 - InputStream, OutputStream
스트림은 바이트단위로 데이터를 전송
입출력 대상에 따라 여러종류의 입출력 스트림이 있음

| 입력스트림 | 출력스트림 | 입출력 대상의 종류 |
|--------|--------|--------|
|FileInputStream|FileOutputStream|파일|
|ByteArrayInputStream|ByteArrayOutputStream|메모리(byte배열)|
|PipedInputStream|PipedOutputStream|프로세르(프로세스간의 통신)|
|AudioInputStream|AudioOutputStream|오디오장치|

자바에서는 java.io패키지를 통해서 많은 종류의 입출력관련 클래스들을 제공,
입출력을 처리할 수 있는 표준화된 방법을 제공함으로써 입출력의 대상이 달라져도 동일한 방법으로
입출력이 가능하기 때문에 프로그래밍을 하기에 편리하다.

|InputStream|OutpuStream|
|--------|--------|
|abstract int read()|abstract void write(int b)|
|int read(byte[] b)|void write(byte[] b)|
|int read(byte[] b, int off, int len)|void write(byte[] b, int off, int len)|

InputStream의 read()와 OutputStream의 write(int b)는 입출력 대상에 따라
읽고 쓰는 방법이 다를 것이기 때문에 각 사왕에 알맞게 구혀나하는 의미에서 추상메서드로 정의되어 있다.

read()는 반드시 구현되어야 하는 핵심적인 메서드이고, read()없이는 int read(byte[] b, int off, int len)와 read(byte[] b)는 의미가 없다.

###1.4 보조스트림
보조스트림은 실제 데이터를 주고받는 스트림이 아니기 때문에 데이터를 입출력할 수 있는 기능은 없지만,
스트림의 기능을 향상시키거나 새로운 기능을 추가할 수 있다.
보조스트림만으로는 입출력을 처리할 수 없고, 스트림을 먼저 생성한 다음에 이를 이용해서 보조스트림을 생성

```java
//기반 스트림을 생성
FileInputStream fis = new FileInputStream("test.txt");
//기반 스트림을 이용해서 보조스트림을 생성
BufferedInputStream bis = new BufferedInputStream(fis);

bis.read();//보조스트림인 BufferedInputStream으로부터 데이터를 읽는다.
```
[참고]버퍼를 사용한 입출력과 사용하지 않은 입출력간의 성능차이가 상당하기 때문에 대부분의 경우 버퍼를 이용한 보조스트림을 사용한다.
[표14-3 p-817]

###1.5 문자기반 스트림 - Reader, Writer
문자데이터를 입출력할 때는 바이트기반 스트림 대신 문자기반 스트림을 사용

	InputStream -> Reader
    OutputStream -> writer

문자기반의 스트림의 이름은 바이트기반 스트림의 이름에서 InputStream은 Reader로
OutputStream은 Writer로 바꾸면 된다.
단,ByteArrayInputStream에 대응하는 문자기반 스트림은 CharArray이다.

[표 14-5 p818]바이트기반 스트림과 문자기반 스트림의 읽고 쓰는 메서드
[표 14-6 p818]바이트기반 보조스트림과 문자기반 보조스트림

##2.바이트기반 스트림

###2.1 InputStream과 OutpuStream
InputStream과 OutputStream은 모든 바이트기반의 스트림의 조상

[표 14-7 p-819]InputStream의 메서드
[표 14-8 p-819]OutputStream의 메서드

사용하고닫지 않은 스트림을 JVM이 자동적으로 닫아주기는 하지만,
스트림을 사용해서 모든 작업을 마치고 난 후 에는 close()를 호출해서 받드시 닫아줘야한다.
[참고]ByteArrayInputStream과 같이 메모리를 사용하는 스트림과 System.in, System.out과 같은
표준입출력스트림은 닫아 주지 않아도 된다.

###2.2 ByteArrayInputStream과 ByteArrayOutputStream
ByteArrayInputStream/ByteArrayOutputStream은 메모리, 즉 바이트배열에 데이터를 입출력 하는데 사용되는 스트림이다.
주로 다른곳에 입출력하기 전에 데이터를 임시로 바이트배열에 담아서 변환 등의 작업을 하는데 사용된다.

###2.3 FileInputStream과 FileOutputStream
FileInputStream/FileOutputStream은 파일에 입출력을 하기 위한 스트림.

| 생성자 | 설명 |
|--------|--------|
| FileInputStream)(String name) |지정된 파일이름을 가진 실제파일과 연결된 FileInputStream을 생성한다.|
|FileInputStream(File file)|파일의 이름이 String이 아니 File인스턴스로 지정해주야 하는 점을 제외하고 FileInputStream(String name)와 같다.|
|FileOutputStream(String name,boolean append)|지정된 파일이름(name)을 가진 실제 파일과 연결된 FileOutputStream을 생성한다. 두번째 인자인 append를 true로 하면, 출력 시 기존의 파일내용의 마지막에 덧붙인다. false면, 기존의 파일내용을 덮어쓰게 된다.|
|FileOutputStream(File file)|파일의 이름을 String이 아닌 File인스턴스로 지정해주야 하는 점을 제외하고 FileOutputStream(String name)과 같다|

[그림14-1 p-825]FileInputStream과 FileOutputStream을 이용한 파일복사

##3.바이트기반의 보조스트림
###3.1 FilterInputStream과 FilterOutputStream
FilterInputStream/FilterOutputStream은 InputStream/OutputStream의 자손이며 모든 보조스트림의 조상
보조스트림은 자체적으로 입출력을 수행할 수 없기 때문에 기반스트림을 필요로한다.

FilterInputStream/FilterOutputStream의 모든 메서드는 단순히 기반스트림의 메서드를 그대로 호출 할 뿐이다.
FilterInputStream/FilterOutputStream자체로는 아무런 일도 하지 않음을 의미한다.
FilterInputStream/FilterOutputStream는 상속을 통해 원하는 직업을 수행하도록 읽고 쓰는 메서드를 오버라이딩해야 한다.

FilterInputStream(InputStream in)는 접근제어자가 protected이기 때문에 FilterInputStream의 인스턴스를 생성해서 사용할 수 없고 상속을 통해서 오버라이딩되어야 한다.

FilterInputStream/FilterOutputStream을 상속받아서 기반스트림에 보조기능을 추가한 보조스트림

	FilterInputStream의 자손 - BufferedInputStream, DataInputStream, PushbackInputStream 등
    FilterOutputStream의 자손 - BufferedOutputStream, DataOutputStream, PrintStream 등

###3.2 BufferedInputStream과 BufferedOutputStream
BufferedInputStream/BufferedOutputStream은 스트림의 입출력 효율을 높이기 위해
버퍼를 사용하는 보조스트림.
한 바이트씩 입출력하는 것 보다는 버퍼(바이트배열)를 이용해서 한 번에 여러 바이트를 입출력 하는 것이 빠르기 때문에 대부분의 입출력 작업에 사용된다.

| 메서드/생성자 | 설명 |
|--------|--------|
|BufferedInputStream(InputStream in, int size)|주어진 InputStream인스턴스를 입력소르로하며 지정된 크기(byte단위)의 버퍼를 갖는 BufferedInputStream인스턴스를 생성한다.|
|BufferedInputStream(InputStream in)|주어진 InputStream인스턴스를 입력소스로 하며 버퍼의 크기를 지정해주지 않으므로 기본적으로 8192byte 크기의 버퍼를 갖게 된다.|

[BufferedInputStream의 생성자]
프로그램에서 입력소스로부터 데이터를 읽기 위해 read메서드를 호출하면,
BufferedInputStream은 입력소르로 부터 버퍼의 크기만큼의 데이터를 읽어다 자신의 내부 버퍼에 저장.
프로그램에서는 BufferedInputStream의 버퍼에 저장된 데이터를 읽으면 되는 것.
외보의 입력소스로부터 읽는 것보다 내부의 버퍼로 부터 읽는 것이 훨씬 빠르기 때문에 작업 효율이 높아진다.

| 메서드/생성자 | 설명 |
|--------|--------|
|BufferedOutputStream(OutputStream out, int size)|주어진 OutputStream인스턴스를  출력소스로하며 지정된 크기(byte단위)의 버퍼를 갖는 BufferedOutputStream인스턴스를 생성한다.|
|BufferedOutputStream(OutputStream out)|주어진 OutputStream인스턴스를 출력소스로 하며 버퍼의 크기를 지정해주지 않으므로 기본적으로 8192byte 크기의 버퍼를 갖게 된다.|
|flush()|버퍼의 모든 내용을 출력소스에 출력한 다음, 버퍼를 비운다.|
|close()|flush()를 호출해서 버퍼의 모든 내용을 출력소스에 출력하고, BufferedOutputStream인스턴스가 사용하던 자원을 반환한다.|

[BufferedOutputStream의 생성자]
프로그램에서 write메서드를 이용한 출력이 BufferedOutputStream의 버퍼에 저장.
버퍼가 가득파면, 그 때 버퍼의 모든 내용을 출력소스에 출력.
그리고 버퍼를 비우고 다시 프로그램으로부터의 출력을 저장할 준비.
버퍼가 가득 찼을 때만 출력소스에 출력을 하기 때문에, 마지막 출력부분이 출력소스에 쓰여지지 못하고
BufferedOutputStream의 버퍼에 남아있는 채로 프로그램이 종료될 수 있다는 점을 주의
그래서 프로그램의 모든 출력작업을 마친 후 BufferedOutputStream에 close()나 flush()를 호출해서 마지막에 버퍼에 있는 모든 내용을 출력소스에 출력되도록 해야 한다.

BufferedOutputStream에 정의된 close()는 flush()를 호출한 다음에 기반스트림의 close()를
호출하는 것을 알 수 있다. BufferedOutputStream는 FilterOutputStream의 close()를 오버라이딩 없이 그대로 상속받는다.
```java
publice class FilterOutputStream extends OutputStream{
	protected OutputStream out;
    public FilterOutputStream(OutputStream out){
    	this.out = out;
    }
    ...
    public void close() throws IOException{
    	try{
        	flush();
        }catch(IOException ignored){}
        out.close();
    }
}
```

보조스트림을 사용한 경우에는 기반스트림의 close()나 flush()를 호출할 필요없이
단순히 보조스트림의 close()를 호출하기만 하면 된다.

###3.3 DataInputStream과 DataOutputStream
DataInputStream/DataOutputStream역시 FilterInputStream/FilterOutputStream의 자손이며
DataInputStream은 DataInput인터페이스를, DataOutputStream은 DataOutput인터페이스를 각각구현했기 때문에,
데이터를 읽고 쓰는데 있어서 byte단위가 아닌, 8가지 기본 자료형의 단위로 일록 쓸 수 있다는 장점이 있다.

| 메서드/생성자 | 설명 |
|--------|--------|
|DataInputStream(InputStream in)|주어진 InputStream인스턴스를 기반스트림으로 하는 DataInputStream인스턴스를 생성한다.|
|boolean readBoolean()<br/>byte readByte()<br/>char readChar()<br/>short readShort()<br/>int readInt()<br/>long readlong()<br/>float readFloat<br/>double readDouble()|각 자료형에 알맞은 값들을 읽어온다. 더이상 읽을 값이 없으면 EOFException을 발생시킨다.|
|String readUTF()|UTF형식으로 쓰여진 문자를 읽는다. 더 이상 읽을 값이 없으면 EOFExcetption을 발생시킨다.|
|int skipBytes(int n)|현재 읽고 있는 위치에서 지정된 숫자(n) 만큼 건너뛴다.|

[표14-12 p-830]DataInputStream의 생성자와 메서드

| 메서드/생성자 | 설명 |
|--------|--------|
|DataOutputStream(OutputStream out)|주어진 OutputStream인스턴스를 기반스트림으로 하는 DataOutputStream인스턴스를 생성한다.|
|void writeBoolean(bollean b)<br/>void writeByte(int b)<br/>void writeChar(int c)<br/>void writeShort(int s)<br/>void writeInt(int I)<br/>void writeLong(int l)<br/>void writeFloat(float f)<br/>void writeDouble(double d)|각 자료형에 알맞은 값들을 출력한다.|
|void writeUTF(String s)|UTF형식으로 문자를 출력한다.|

[표14-13 p-830]DataOutputStream의 생성자와 메서드

###3.4 SequenceInputStream
SequenceInputStream은 여러 개의 입력스트림을 연속적으로 연결해서 하나의 스트림으로부터 데이터를 읽는 것과 같이 처리할 수 있도록 도와준다.
SequenceInputStream의 생성자를 제외하고 나머지 작업은 다른 입력스트림과 다르지 않다.
[참고]SequenceInputStream은 다른 보조스트림과 달리 FilterInputStream의 자손이 아닌 InputStream을 바로 상속받아서 구현하였다.

| 메서드/생성자 | 설명 |
|--------|--------|
|SequenceInputStream(Enumeration e)|Enumeration에 저장된 순서대로 입력스트림을 하나의 스트림으로 연결한다.|
|SequenceInputStream(InputStream s1, InputStream s2)|두 개의 입력스트림을 하나로 연결한다.|

[예제 14-13 p-836]

###3.5 PrintStream
PrintStream은 데이터를 기반스트림에 다양한 형태로 출력할 수 있는 print, println, printf와 같은 메서드를 오버로딩하여 제공한다.
PrintStream보다 향상된 기능의 문자기반 스트림인 PrintWriter가 추가되었으나
매우 빈번히 사용되던 System.out이 PrintStream이다보니 둘 다 사용할 수밖에 없게되었다.
PrintWriter에 비해 다양한 언어의 문자를 처리하는데 적합하기 때문에 가능하면 PrintWriter를 사용하는 것이 좋다.

[표14-15 p-838] PrintStream의 생성자와 메서드

print()나 println()을 이요해서 출력하는 중에 PrintStream기반 스트림에서 IOException이 발생하면 checkError()를 통해서 인지할 수 있다.
println()이나 print()는 예외를 던지지 않고 내부에서 처리하도록 정의하였는데, println()과 같은 메서드가 매우 자주 사용되는 것이기 때문이다.

printf()는 JDK1.5부터 추가된 것, 객체지향적이지는 않지만, C언어와 같이 편리한 형식화된 출력 지원
pritnf()에 사용될 수 있는 옵션 자세한 내용은 JAVA API 참조
[표 14-16~20 p-839]



