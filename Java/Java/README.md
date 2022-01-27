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


### HashSet
Set 인터페이스의 구현 클래스, Set의 성질 그대로 상속받음
Set의 성질  :  객체 중복 저장 X, 하나의 NULL값만 저장가능, 저장 순서 유지 X
- 순서대로 입력되지 않고 일정하게 유지되지 않는다.
- 특징 : 중복을 허용하지 않음
- HashSet의 경우 정렬을 해주지 않고 TreeSet의 경우 자동정렬을 해준다.

변수 선언
```sh
HashSet<Integer> set = new HashSet<Integer>();
HashSet<String> set2 = new HashSet<String>();
```

값 추가
```sh
set.add(1);
set.add(2);
set2.add("a");
set2.add("b");
```

값 삭제
```sh
set.remove(1);    // 값 1 삭제
set.clear();      // 전체삭제
set2.remove("a");    // 문자 a 삭제
set2.clear();        // 전체 삭제
```

값 출력
```sh
set.add(1);
set.add(2);
System.out.println("set의 값 : " + set);

결과
set의 값 : [1, 2]

Iterator iter = set.iterator();	// Iterator 사용
while(iter.hasNext()) {//값이 있으면 true 없으면 false
    System.out.print(iter.next());
}

결과
1 2
```



### 개선된 for문
```sh
   for(자료형 변수명 : 배열명){
	문장
   } 
```
이 때, 자료형은 한 단계 아래로 적으면 된다. 

ex)
```sh
   String[] arr = {"1","2","3","4","5"};
         
   for(String s : arr)	  
      System.out.print(s);
```
결과
>1
>2
>3
>4
>5      


ex)
```sh
   String[][] arr = {{"1","2","3"},{"2.1","2.2"}};
         
   for(String[] arrs : arr)	  
      for(String s : arrs)
         System.out.print(s);
```
결과
>1
>2
>3
>2.1
>2.2


### next()와 nextLine() 차이
next()는 문자 혹은 문자열을 공백 기준으로 한 단어 또는 한 문자씩 입력을 받는다.
- Hello World를 입력받았다면 출력했을 때 Hello만 출력한다.(띄어쓰기 한 이후에 입력한 World를 인식하지 않음)

nextLine()은 문자 혹은 엔터를 치기 전까지의 문장 전체를 입력받는다. 
- Hello World를 입력받았다면 출력했을 때 Hello World 모두 출력

### ArrayList
다수의 데이터를 넣기 위한 자료구조
List 인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 선형리스트

```sh
ArrayList list = new ArrayList();//타입 미설정 Object로 선언된다.
ArrayList<Student> members = new ArrayList<Student>();//타입설정 Student객체만 사용가능
ArrayList<Integer> num = new ArrayList<Integer>();//타입설정 int타입만 사용가능
ArrayList<Integer> num2 = new ArrayList<>();//new에서 타입 파라미터 생략가능
ArrayList<Integer> num3 = new ArrayList<Integer>(10);//초기 용량(capacity)지정
ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));//생성시 값추가
```

ArrayList 값 추가
```sh
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(1); // 값 추가
list.add(null); // null값도 add가능
list.add(1,10); // index 1에 10 삽입
```
```sh
ArrayList<Student> members = new ArrayList<Student>();
Student student = new Student(name,age);
members.add(student);
members.add(new Member("홍길동",23));
```

ArrayList 값 삭제
```sh
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
list.remove(1);  //index 1 제거
list.clear();  //모든 값 제거
```

ArrayList 값 출력
```sh
System.out.println(list.get(3));//3번째 index 출력

for(Integer i : list) { //for문을 통한 전체출력
    System.out.println(i);
}

Iterator iter = list.iterator(); //Iterator 선언 
while(iter.hasNext()){//다음값이 있는지 체크
    System.out.println(iter.next()); //값 출력
}
```

[참고](https://coding-factory.tistory.com/551)


### 자바 정렬 방법
Arrays.sort를 사용하는 방법과 Collections.sort를 사용하는 방법
- Arrays.sort 는 배열 정렬할 때 사용
- Collections.sort 는 list를 정렬할 때 사용


내림차순으로 정렬
```sh
Collections.sort(list, Collections.reverseOrder());
```
|   정렬 기준 재정의 하지 않았을 때는 오름차순으로 출력됨.




### 람다식
- 함수를 하나의 식으로 표현한 것
- 메소드의 이름이 필요없기 때문에 익명 함수의 한 종류라고 볼 수 있다.
- 특징
    - 람다식 내에서 사용되는 지역변수는 final이 붙지 않아도 상수로 간주됨
    - 람다식으로 선언된 변수명은 다른 변수명과 중복 불가능
- 장점
    - 간결한 코드
    - 높은 가독성
    - 함수를 만드는 과정없이 한 번에 처리할 수 있어 생산성이 높아짐
    - 병렬프로그래밍이 용이
- 단점
    - 람다를 사용하면서 만든 무명함수는 재사용 불가
    - 디버깅 어려움
    - 람다를 남발하면 코드 지저분해질 수 있음
    - 재귀로 만들경우 부적합
기존방식
```
반환티입 메소드명 (매개변수, ...) {
    실행문 
} 
// 예시
public String hello() {
    return "Hello World!"; 
}

public int sum(int a, int b){
    return a + b;
}
```

람다식 이용
```
// 람다식 한줄 문법
// 리턴값이 있다면 자동으로 수행 결과가 리턴됨
(매개변수) -> 명령문;  

// 람다식 여러줄 문법
(매개변수) -> { 명령문;  명령문;  명령문; return; }


// 예시 
() -> "Hello World!";
(a,b) -> a + b;
```



### CompareTo()
- A.compareTo(B) 
        - A와 B가 같으면 0 리턴
        - A  >  B  양수 리턴
        - A  <  B  음수 리턴
        - 첫째자리부터 차례대로 비교함



### 배열 복사 방법

**copyOf**
- Arrays.copyOf( 복사할 배열, 복사할 배열의 크기 );
```sh
   int [] arr1 = {1, 2, 3, 4, 5};
   int [] arr2 = Arrays.copyOf(arr1, arr1.length);
   for(int i =0; i < arr2.length; i++) 
      System.out.print(arr2[i] + " ");
```
실행 결과   
1  2  3  4  5   


**copyOfRange** 
- copyOfRange( 배열, 시작 인덱스, 끝 인덱스 )
-  원본 배열을 먼저 넣고, 복사를 시작할 인덱스와 마지막 인덱스를 받는다. 이때, 시작 인덱스는 포함하지만 끝 인덱스는 제외한다.

```
   int [] arr1 = {1, 2, 3};
   int [] arr3 = Arrays.copyOfRange(arr1, 0, 4); // 특정범위를 지정해서 해당부분만 복사가능
   for(int i =0; i < arr3.length; i++)
      System.out.print(arr3[i] + " ");
```
실행 결과   
1  2  3  0   

-> 나머지 초과된 범위의 값은 0 으로 채워진다.   



### 길이 확인
1. length
 - arrays(int[], double[], String[])
 - length는 배열(Array)의 길이를 알고자 할때 사용된다.

 
2. length()
 - String related Object(String, StringBuilder etc)
 - length()는 문자열(String)의 길이를 알고자 할때 사용된다.

 
3. size()
 - Collection Object(ArrayList, Set etc)
 - size()는 컬렉션프레임워크 타입의 길이를 알고자 할때 사용된다.
 
 
### Charater
1. isUpperCase()        // 대문자 확인 메소드
2. isLowerCase()        // 소문자 확인 메소드
3. isDigit()            // 숫자 확인 메소드
4. toUpperCase()    // 대문자 변환 메소드
5. toLowerCase()    // 소문자 변환 메소드
6. isAlphabetic()   // 영문자 확인 메소드(한글 자음,모음 포함)
7. isLetter()   // 영문자 확인 메소드(한글 자음,모음 포함)