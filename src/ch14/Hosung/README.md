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

##4. 문자기반 스트림

###4.1 Reader와 Writer
문자기반의 스트림의 조상이 Reader/Writer.
byte배열 대신 char배열을 사용한다는 것외에는 InputStream/OutputStream의 메서드와 다르지 않다.

| 메서드 | 설명 |
|--------|--------|
|abstrct void close()|입력스트림을 닫음으로써 사용하고 있던 자원을 반환 |
|void mark(int readlimit)|현재위치를 표시해놓는다. 후에 reset()에 의해서 표시해 놓은 위치로 다시 돌아갈 수 있다. |
|boolean markSupported()|mark()와 reset()을 지원하는지를 알려 준다. |
|int read()|입력소스로부터 하나의 문자를 읽어 온다. char의 범위인 0~65535범위의 정수를 반환하며, 입력스트림의 마지막 데이터데 도달하면, -1을 반환한다. |
|int read(char[] c)|입력소스로부터 매개변수로 주어진 배열 c의 크기만큼 일어서 배열c에 저장한다. 읽어 온 데이터의 개수 또는 -1을 반환한다.|
|abstrct int read(cahr[] c, int off, int len)|입력소스로부터 최대 len개의 문자를 읽어서, 배열 c의 지정된 위치(off)부터 읽은 만큼 저장한다. 읽어 온 데이터의 개수 또는 -1을 반환한다. |
|booleadn ready()|입력소스로부터 데이터를 읽을 준비가 되어있는지 알려 준다. |
|void reset()|입력소스에서의 위치를 마지막으로 mark()가 호출되었던 위치로 되돌린다. |
|long skip(long n)|현재 위치에서 주어진 문자 수(n)만큼을 건너뛴다 |
[표 14-21 p-842]Reader의 메서드

| 메서드 | 설명 |
|--------|--------|
|abstract void close()|출력스트림을 닫음으로써 사용하고 있던 자원을 반환 |
|abstract void flush(int readlimit)|스트림의 버퍼에 있는 모든 내용을 출력소스에 쓴다.(버퍼가 있는 스트림에만 해당됨) |
|void write(int b)|주어진 값을 출력소스에 쓴다. |
|void write(char[] c)|주어진 배열 c에 저장된 모든 내용을 출력소스에 쓴다.|
|abstrct void write(cahr[] c, int off, int len)|주어진 배열 c에 저장된 내용중에서 off번째부터 len길이만큼만 출력소스에 쓴다. |
|void write(String str)|주어진 문자열(str)을 출력소스에 쓴다.|
|void write(String str, int off, int len)|주어진 문자열(str)의 일부를 출력소스에 쓴다.(off번째 문자부터 len개 만큼의 문자열)|
[표 14-22 p-842]Writer의 메서드

문자기반 스트림, 즉 Reader/Writer 그리고 그 자손들은 여러 종류의 인코딩과 자바에서
사용하는 유니코드간의 변환을 자동적으로 처리해준다. Reader는 특정 인코딩을 읽어서 유니코드로 변환하고
Writer는 유니코드를 특정인코딩으로 변환하여 저장한다.

###4.2 FileReader와 FileWriter
FileReader/FileWriter는 파일로부터 텍스트데이터를 읽고, 파일에 쓰는데 사용된다.
사용방법은 FileInputStream/FileOutputStream과 다르지 않다.
[예제14-15 p-843]

###4.3 PipedReader와 PipedWriter
PipedReader/PipedWriter는 쓰레드 간에 데이터를 주고받을 때 사용된다.
다른 스트림과는 달리 입력과 출력스트림을 하나의 스트림으로 연결해서 데이터를 주고받는다는 특징

스트림을 생성한 다름에 어느 한쪽 connect()를 호출해서 입력스트림과 출력스트림을 연결.
입출력을을 마친 후에는 어느 한쪽 스트림만 닫아도 나머지 스트림은 자동으로 닫힌다.
이점을 제외하고는 일반 입출력방법과 다르지 않다.

[예제 14-17 p-845]
쓰레드를 시작하기 전에 PipedReader와 PipedWriter를 연결해야한다는 것에 유의

###4.4 StringReader와 StringWriter
StringReader/StringWriter는 CharArrayReader/CharArrayWriter와 같이 입출력 대상이 메모리인 스트림이다.
StringWriter에 출력되는 데이터는 내부의 StringBuffer에 저장되며 StringWriter의 다음과 같은
메서드를 이용해서 저장된 데이터를 얻을 수 있다.

	StringBuffer getBuffer() : StringWriter에 출력한 데이터가 저장된 StringBuffer를 반환
    String toString() : StringWriter에 출력된 (StringBuffer에 저장된) 문자열을 반환한다.

근본적으로 String도 char배열이지만, char배열 보다는 String으로 처리하는 것이 여러모로 편리한 겨우가 더 많을 것이다.

[예제 14-18 p-847]

##5.문자기반의 보조스트림

###5.1 BufferedReader와 BufferedWriter
BufferedReader/BufferedWriter는 버퍼를 이용해서 입출력의 효율을 높일 수 있도록 해주는 역할
버퍼를 이용하면 입출력의 효율이 비교할 수 없을정도로 좋아지기 때문에 사용하는 것이 좋다.

BufferedReader의 readLine()을 사용하면 데이터를 라인단위로 읽어 올 수 있다는 장점
BufferedWriter는 newLine()라는 줄바꿈 해주는 메서드를 가지고 있음.

BufferedReader의 readLine()을 이용해서 파일을 라인단위로 읽은다음 indexOf()를 이용해서
파일의 특정 문자 또는 문자열을 포함한 라인을 쉽게 찾아 낼수 있음 [예제 14-19 p-848]

###5.2 InputStreamReader와 OutputStreamWriter
InputStreamReader/OutputStreamWriter는 바이트기반 스트림을 문자기반 스트림으로 연결시켜주는 역할.
그리고 바이트 기반 스트림의 데이터를 지정된 인코딩의 문자데이터로 변환하는 작업을 수행.
[참고]InputStreamReader/OutputStreamWriter는 Reader/Writer의 자손

| 생성자/메서드 | 설명 |
|--------|--------|
|InputStreamReader(InputStream in)  | OS에서 사용하는 기본 인코딩의 문자로 변환하는 InputStreamReader를 생성 |
|InputStreamReader(InputStream in,String encoding)  | 지정된 인코딩을 사용하는 InputStreamReader를 생성한다. |
|String getEncoding()  | InputStreamReader의 인코딩을 알려준다.|

[표 14-23] InputStreamReader의 생성자와 메서드

| 생성자/메서드 | 설명 |
|--------|--------|
|OutputStreamReader(OutputStream in)  | OS에서 사용하는 기본 인코딩의 문자로 변환하는 OututStreamReader를 생성 |
|OututStreamReader(OutputStream in,String encoding)  | 지정된 인코딩을 사용하는 OutputStreamReader를 생성한다. |
|String getEncoding()  | OutputStreamReader의 인코딩을 알려준다.|

[표 14-24] OutputStreamReader의 생성자와 메서드

##6.표준입출력과 File

###6.1 표준입출력 - System.in, System.out, System.err
자바에서는 표준 입출력(standard I/O)을 위해 3가지 입출력 스트림
System.in , System.out , System.err 를 제공
자바어플리케이션의 실행과 동시에 사용할 수 있게 자동적으로 생성되기 때문에
개발자가 별도로 스트림을 생성하는 코드를 작성하지 않고도 사용이 가능하다.

	System.in  - 콘솔로부터 데이터를 입력받는데 사용
    System.out - 콘솔로부터 데이터를 출력하는데 사용
    System.err - 콘솔로부터 데이터를 출력하는데 사용

in, out, err는 System 클래스에 선언된 클래스변수(static 변수)이다.
선언부분만 보면 out, err, in 의 타입은 InputStream과 PrintStream이지만
실제로 버퍼를 이용하는 BufferedInputStream 과 BufferedOutputStream의 인스턴스 사용.

```java
	public final class System{
    	public final static InputStream in = nullInputStream();
        public final static PrintStream out = nullPrintStream();
        public final static PrintStream err = nullPrintStream();
        ...
    }
```

###6.2 표준입출력의 대상변경 - setOut(), setErr(), setIn()
초기에는 System.in , System.out, System.err의 입출력대상이 콘솔화면이지만,
setInt(), setOut(), setErr()를 사용하면 입출력을 콘솔이외에 다른 입출력 대상으로 변경하는 것이 가능

	static void setOut(PrintStream out)
    	-System.out의 출력을 지정된 PrintStream으로 변경한다.
    static void setErr(PrintStream err)
    	-System.err의 출력을 지정된 PrintStream으로 변경한다.
	static void setIn(InputStream in)
    	-System.in의 입력을 지정된 InputStream으로 변경한다.

[예제 14-23]

JDK1.5 부터 Scanner클래스가 제공되면서 System.in으로부터 데이터를 입력받아 작업하는것이 편리해짐

###6.3 RandomAccessFile


###6.4 File


##7.직렬화(Serialization)

###7.1 직렬화란?
직렬화(serialization)란 객체를 데이터 스트림으로 만드는 것을 뜻한다.
객체에 저장된 데이터를 스트림에 쓰기위해 연속적인 데이터로 변환하는 것.

반대로 스트림으로부터 데이터를 읽어서 객체를 만드는 것을 역직렬화(deserialization)라고한다.

객체는 클래스에 정의된 인스턴스변수의 집합. 객체에는 클래스변수나 메서드가 포함되지 않는다.
객체는 오직 인스턴스변수들로만 구성되어 있다.

객체를 저장한다는 것은 바로 객체의 모든 인스턴스변수의 값을 저장한다는 것과 같은 의미.
어떤 객체를 저장하고 자한다면, 현재 객체의 모든 인스턴스변수의 값을 저장하기만 하면 된다.
객체를 다시 생성하려면, 객체를 생성한 후에 저장했던 값을 읽어서 생성한 객체의 인스턴스변수에 저장하면 되는 것.

객체를 어떻게 직렬화해야 하는지 전현 고민하지 않아도 된다. 다만 객체를 직렬화/역직렬화할 수 있는
ObjectInputStream과 ObjectOutputStream을 사용하는 방법만 알면 된다.
[참고] 두 객체가 동일한지 판단하는 기준은 두 객체의 인스턴스변수의 값들이 같고 다름이라는 것

###7.2 ObjectInputStream, ObjectOutputStream
직렬화(스트림에 객체를 출력)에는 ObjectInputStream을 사용하고,
역직렬화(스트림으로부터 객체를 입력)에는 ObjectOutputStream을 사용

ObjectInputStream과 ObjectOutputStream은 각각 InputStream과 OutputStream을 직접 상속받지만
기반스트림을 필요로 하는 보조스트림이다. 객체를 생성할 때 입출력(직렬화/역직렬화)할 스트림을 지정해주어야 한다.

	ObjectInputStream(InputStream in)
    ObjectOutputStream(OutputStream out)


	FileOutputStream fos = new FileOutputStream("objectfile.ser");
    ObjectOutputStream out = new ObjectOutputStream(fos);
    
    out.writeObject(new UserInfo());

objectfile.ser이라는 파일에 UserInfo객체를 직렬화 하여 저장한다.
출력할스트림(FileOutputStream)을 생성해서 이를 기반스트림으로 하는 ObjectOutputStream을 생성
ObjectOutputStream의 writeObject(Object obj)를 사용해서 객체를 출력하면,
객체가 파일에 직렬화되어 저장된다.

	FileInputStream fis = new FileInputStream("objectfile.ser");
    ObjectInputStream in = new ObjectInputStream(fis);
    
    UserInfo info = (UserInfo)in.readObject();

입력스트림을 사용하고 readObject()를 사용하여 저장된 데이터를 읽기만 하면 객체로 역직렬화된다.
다만 readObject()의 반환타입이 Object이기 때문에 원래의 타입으로 형변환 해주어야 한다.

[표 14-29 p-880]ObjectInputStream과 ObjectOutputStream의 메서드

defaultReadObject()와 defaultWriteObject()는 자동직렬화를 수행.
객체를 직렬화/역직렬화하는 작업은 객체의 모든 인스턴스변수가 참조하고 있는 모든 객체에 대한 것이기 때문에
상당히 복잡하며 시간도 오래 걸린다.
readObject()와 writeObject()를 사용한 자동 직렬화가 편리하기는 하지만
직렬화작업시간을 단축시키려면 직렬화하고자 하는 객체의 클래스에 추가적으로 다음과 같은 2개의 메서드를 직접 구현해주어야 한다.

	private void writeObject(ObjectOutputStream out) throws IOException{
    	//write메서드를 사용해서 직렬화를 수행
    }
	
	private void readObject(ObjectInputStream out)
    	throws IOException, ClassNotFoundException{
    	//read메서드를 사용해서 역직렬화를 수행
    }

###7.3 직렬화가 가능한 클래스 만들기 -Serializable, transient
직렬화 하고자 하는 클래스가 java.io.Serializable인터페이스를 구현하도록 하면 된다.

	public class UserInfo implements java.io.Serializable{
    	String name;
        String password;
    }

Serializable인터페이스는 아무런 내용도 없는 빈 인터페이스이지만, 직렬화를 구려하여 작성한 클래스인지를
판단하는 기준이 된다.

	publid interface Serializable{ }

자식 클래스가 Serializable을 구현하지 않았지만, 조상 클래스가 Serializable을 구현 하였으면
자식 클래스에서 역시 직렬화가 가능하다. 자식클래스를 직렬화하면 조상클래스에 정의된 인스턴스변수도 함께 직렬화
그러나 조상클래스에서 Serializable을 구현하지 않고 자식클래스를 직렬화 할때는 조상클래스에 정의된 인스턴스변수는
직렬화 대상에서 제외된다.

모든 클래스의 최고조상인 Object는 Serializable을 구현하지 않았기 때문에 직렬화할 수 없다.
인스턴스변수의 타입이 직렬화가 안되는 Object이긴 하지만 실제 저장된 객체의 인스턴스 종류에 따라 직렬화가 가능.
인스턴스변수의 타입이 아닌 실제로 연결된 객체의 종류에 의해서 결정된다는 것을 기억

직렬화하고자 하는 객체의 클래스에 직렬화가 안 되는 객체에 대한 참조를 포함하고 있다면,
제어자 transient를 붙여서 직렬화 대상에서 제외되도록 할 수 있다.

	public class UserInfo implements Serializable{
    	String name;
        transient String password;// 직렬화 대상에서 제외
        
        transient Object obj = new Object(); //작렬화 대상에서 제외
    }

직렬화되지 않은 조상으로부터 상속받은 인스턴스변수는 직렬화될 객체의 클래스에 writeObject()와 readObject()를
추가해서 조상으로부터 상속받은 인스턴스변수가 직접 직렬화 되도록 해야 한다.
이 메서드들은 직렬화/역직렬화 작업시에 자동적으로 호출된다.
[예제 14-41 p-886]

###7.4 직렬화가능한 클래스의 버전관리
직렬화된 객체를 역직렬화할 때는 직렬화 했을 때와 같은 클래스를 사용해야한다.
클래스의 이름이 같더라도 클래스의 내용이 변경되는 경우 역직렬화는 실패하며 예외가 발생한다.

	java.io.InvalidClassException: Userlnfo; local class incompatible: stream
    classdesc serialVersionUID 6953673583338942489, local class
	serialV ersionUID = - 6256164443556992367

직렬화 할 때와 역 직렬화 할 때의 클래스의 버전이 같아야 하는데 다르다는 것

객체가 직렬화될 때 클래스에 정의된 멤버들의 정보를 이용해서 serialVersionUID라는 클래스의 버전을 자동생성해서
직렬화 내용에 포함된다.
역직렬화 할 때 클래스의 버전을 비교함으로써 직렬화할 때의 클래스의 버전과 일치하는지 확인할 수 있는 것.
static변수 또는 transient가 붙은 인스턴스변수가 추가되는 경우에는 직렬화에 영향을 미치지 않기때문에
클래스의 버전을 다르게 인식하도록 할 필요ㅎ는 없다.

직렬화가 가능한 클래스가 있을 때, 클래스의 버전을 수동으로 관리하면 serialVersionUID를 추가로 정의
클래스 내에 serialVersionUID를 정의해주면,
클래스의 내용이 바뀌어도 클래스이 버전이 자동생성된 값으로 변경되지 않는다.

	class MyData implements java.io.Serializable{
    	static final long serialVersionUID = 3518731767529258119L;
        int value1;
    }