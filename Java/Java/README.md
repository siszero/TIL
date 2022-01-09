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