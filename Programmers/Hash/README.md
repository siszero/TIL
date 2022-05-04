# Hash

## HashMap
- Map Interface의 한 종류로 Key - Value 값으로 데이터를 묶어 저장할 수 있는 클래스입니다.  
(python에서 dictionary라고 생각하면 될 듯!)

- 해싱 기법을 사용하므로 많은 양의 데이터중에서 원하는 데이터를 빠르게 가져올 수 있습니다.


#### 해싱기법이란? 
- 해시함수(Hash Function)를 이용해서 데이터를 해시테이블(Hash Table)에 저장하고 검색하는 기법입니다.

- 해시함수는 데이터가 저장되어 있는 곳을 알려주며, 다량의 데이터 중에서 원하는 데이터를 빠르게 찾을 수 있는 특징이 있습니다.


참고 )  HashMap 이외에도 HashSet / HashTable등의 클래스에서 해싱 기법을 사용합니다.


### HashMap 사용법
```
HashMap<Integer, String> map = new HashMap<>();

// 데이터 넣기
map.put(1, "사과");

// value 값은 중복 가능, key 값은 중복 불가
// 만약 key 값 중복 시 가장 마지막에 쓴 값으로 저장 및 출력
map.put(1, "사과");
map.put(1, "포도");
// 이러면 출력이 {1=포도} 이렇게 됨


// 데이터 출력
map.get(1);     // 출력 값 :  포도

// 데이터 삭제
map.remove(1);      // key가 1 인 값 삭제

map. clear();       // 모든 데이터 삭제


// getOrDefault(Object key, V DefaultValue)
// - key : map 요소의 키이다.
// - defaultValue : 지정된 키로 매핑된 값이 없거나 null이면 반환하는 기본 값이다.

map.getOrDefault(key, 0);       // key 값이 없거나 null이면 0 반환, 있으면 key의 value 반환
```


### 데이터 추출
1. EntrySet 이용   
- Map interface의 Entry 메소드를 사용하여 Key 값 Value 값만을 추출할 수 있습니다.

- Entry 생성 시 java.util.Map.Entry를 import 해주어야 하며 HashMap에 지정한 Key와 Value 타입과 맞춰 주어야 합니다.

- entrySet은 HashMap의 모든 데이터를 확인할 수 있는 메소드입니다.
```
import java.util.Map.Entry;

// key값 출력
for(Entry<Integer, String> entry : map.entrySet()){
    System.out.println(entry.getKey());
}


// value 값 출력
for(Entry<Integer, String> entry : map.entrySet()){
    System.out.println(entry.getValue());
}

// 데이터 한 줄씩 출력
for(Entry<Integer, String> entry : map.entrySet()){
    System.out.println(entry);
}

```

2. keySet을 이용한 for문   

```
for (String key : map.keySet()) {
    System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));
}
```


3. Iterator를 이용한 while문

```
Iterator<String> keys = map.keySet().iterator();
while (keys.hasNext()) {
    String key = keys.next();
    System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));
}
```



[출처](https://sin0824.tistory.com/13)