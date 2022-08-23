# Stack
```java
LIFO(Last In First Out) 구조
데이터 추가 : push()
데이터 빼기 : pop()
데이터 확인(최상단 값만 확인-삭제X) : peak()
데이터 초기화 : clear()
데이터 비어있는지 확인 : empty()
특정 데이터 포함 확인 : contains()


Stack<String> stack = new Stack<>();

    stack.push();
    Stack.pop();  // 데이터 꺼내기
    stack.peak();  // 최상단 값 출력(제거 x)
    stack.pop();

```