# Java
#### 
- 

### BufferedReader
Scanner  :  Space Enter를 모두 경계로 인식
BufferedReader  :  Enter만 경계로 인식, 받은 데이터가 String으로 고정
 * 	Scanner에 비해 다소 사용하기 불편하지만 많은 양의 데이터를 입력받을경우 BufferedReader로 입력받는 것이 효율적
 * 	예외처리를 꼭 해주어야한다.(보편적으로 throws IOException을 통하여 예외처리, try & catch를 활용하여 예외처리 또한 가능)

- Space를 경계로 인식하기 위한 두 가지 방법
 	1. StringTokenizer에 nextToken()함수를 통한 공백 단위의 구분.
  	2. String.split 함수를 활용
  	 ```sh
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
	N = Integer.parseInt(s.split(" ")[0]);
	M = Integer.parseInt(s.split(" ")[1]);
	```
  	
 ✨  BufferWriter 쓸 때 bw.close() 해줘야 함


### CharAt
string 타입으로 받은 문자열을  char 타입으로 한 글자만 받는 함수
1. 문자열 받기
   ```sh
   String str = "Java Programming";
   System.out.println(str.charAt(0));
    ```
   -> " J " 가 출력된다.

2. 숫자 받기
   숫자 0-9 까지는 유니코드에서 48-57 이다.

   ### Split
String 클래스에 속해 속해있는 문자열 자르기 위한 매서드
| 생성자 | 설명 |
| ------ | ------ |
| public String[] split(String regex); | 문자열을 regex(정규식)에 맞춰서 분리 |
| public String[] split(String regex, int limit); | limit 만큼 문자열을 자름 |

사용방법

```sh
   구분자로 문자열 분리
   String text = "Hi#nice#to#meet#you"
   String[] str = text.split("#")
   for(String s : str)
        System.out.println(s);
   -> Hi
      nice
      to
      meet
      you
```

★ 메타문자를 구분자로 사용하려고 할 때는 "\\" 를 앞에 붙여 줘야 함
★ 메타문자 종류  :  ?, *, +, ( ), [ ], { }
```sh
   String[] str = text.split("."); // 오류
   String[] str = text.split("\\."); // OK
```


### StringTokenizer
말 그대로 문자열을 토큰화 하는 것
구분자로 문자열을 쪼개주는 클래스
쪼개진 문자는 토큰이라고 부른다.

라이브러리
```sh
   import java.util.StringTokenizer;
   ```

| 생성자 | 설명 |
| ------ | ------ |
| StringTokenizer st = new StringTokenizer(문자열); | 문자열을 공백문자를 기준으로 분리 |
| StringTokenizer st = new StringTokenizer(문자열, "구분자"); | 구분자를 기준으로 문자열을 분리 |
| StringTokenizer st = new StringTokenizer(문자열, "구분자", true/false); | 구분자를 기준으로 문자열을 분리시키는데 true일 경우에는 구분자를 포함해서 분리, false일 경우에는 포함하지 않고 분리 |

StringTokenizer와 Split의 차이
| StringTokenizer | Split |
| ------ | ------ |
| java.util에 포함되어 있는 클래스 | String 클래스에 속해있는 메소드 |
| 문자 또는 문자열 구분 | 정규표현식으로 구분 |
| 빈 문자열을 토큰으로 인식 X | 빈 문자열을 토큰으로 인식 O |


### StringBuilder
Stirng은 변경 불가능한 문자열을 생성하지만 StringBuilder는 변경 가능한 문자열을 만들어 주기 때문에, String을 합치는 작업 시 하나의 대안이 될 수 있음.
String에는 없는 append와 insert와 같은 기능들 있음
String에서 + 사용시 기존 값 버리고 새로 할당하기 때문에 1000번 이상 수행하게 될 경우 급격히 느려진다.

| 메소드 | 설명 |
| ------ | ------ |
| sb.append(값) | StringBuffer, StringBuilder 뒤에 값을 붙인다 |
| sb.insert(인덱스, 값) | 특정 인덱스부터 값을 삽입한다 |
| sb.delete(인덱스, 인덱스) | 특정 인덱스부터 인덱스까지 값을 삭제한다 |
| sb.indexOf(값) | 값이 어느 인덱스에 들어있는지 확인한다 |
| sb.substring(인덱스, 인덱스) | 인덱스부터 인덱스까지 값을 잘라온다 |
| sb.length() | 길이 확인 |
| sb.replace(인덱스, 인덱스, 값) | 인덱스부터 인덱스까지 값으로 변경 |
| sb.reverse() | 글자 순서를 뒤집는다 |