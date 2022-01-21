## python
```python
# 리스트 자료 이용(append()함수, pop()함수 그냥 이용 가능)
# append() : 가장 오른쪽에 삽입
# pop() : 가장 오른쪽에서 꺼내기

stack = []

# 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
stack.append(5)
stack.append(2)
stack.append(3)
stack.append(7)
stack.pop()
stack.append(1)
stack.append(4)
stack.pop()

print(stack) # 최하단 원소부터 출력
print(stack[::-1]) # 최상단 원소부터 출력
```
실행 결과
[5, 2, 3, 1]
[1, 3, 2, 5]


## Java

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop();
        s.push(1);
        s.push(4);
        s.pop();
        // 스택의 최상단 원소부터 출력
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

}
```

실행 결과
1 3 2 5