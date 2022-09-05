# Deque
- Double-Ended Queue
- 큐의 양쪽에 데이터를 넣고 뺄 수 있는 형태의 자료구조
- 자료구조에 큐와 스택을 합쳐넣은 상태

## 사용방법
```java
Deque<String> deque1 = new ArrayDeque<>();
Deque<String> deque2 = new LinkedBlockingDeque<>();
Deque<String> deque3 = new ConcurrentLinkedDeque<>();
Deque<String> linkedList = new LinkedList<>();
```

## 값 추가
``` java
deque.addFirst(); // Deque의 앞쪽에 데이터를 삽입, 용량 초과시 Exception
deque.offerFirst(); //  Deque의 앞쪽에 데이터를 삽입 후 true, 용량 초과시 false

deque.addLast(); // Deque의 뒤쪽에 데이터를 삽입, 용량 초과시 Exception
deque.add(); // addLast()와 동일
deque.offerLast(); //Deque의 뒤쪽에 데이터를 삽입 후 true, 용량 초과시 false
deque.offer(); // offerLast()와 동일

deque.push(); // addFirst()와 동일
deque.pop(); // removeFirst()와 동일
```

## 값 제거
``` java
deque.removeFirst(); // Deque의 앞에서 제거, 비어있으면 예외
deque.remove(); // removeFirst()와 동일
deque.poll(); // Deque의 앞에서 제거, 비어있으면 null 리턴
deque.pollFirst(); // poll()과 동일

deque.removeLast(); // Deque의 뒤에서 제거, 비어있으면 예외
deque.pollLast(); // Deque의 뒤에서 제거, 비어있으면 null 리턴
```

[참고](https://hbase.tistory.com/128)