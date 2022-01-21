## python
- 삽입 : append()
- 삭제 : pop(), popleft()
```python
# 큐(Queue) 구현을 위해 deque 라이브러리 사용 (시간 훨씬 빠름)
from collections import deque 

queue = deque()

# 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)
queue.popleft()     // 가장 왼쪽에 있는 데이터 꺼내기
queue.append(1)
queue.append(4)
queue.popleft()

print(queue) # 먼저 들어온 순서대로 출력
queue.reverse() # 다음 출력을 위해 역순으로 바꾸기
print(queue) # 나중에 들어온 원소부터 출력
```
실행 결과
deque([3, 7, 1, 4])
deque([4, 1, 7, 3])

## Java
- 삽입 : offer()
- 삭제 : poll()
``` Java
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();
        q.offer(1);
        q.offer(4);
        q.poll();
        // 먼저 들어온 원소부터 추출
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }

}
```
실행 결과
3 7 1 4