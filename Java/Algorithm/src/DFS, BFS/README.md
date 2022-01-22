# 그래프
정점(node)과 그 정점을 연결하는 간선(edge)으로 이루어진 자료구조
그래프 탐색 : 하나의 정점에서 시작해 차례대로 모든 정점들을 한 번씩 방문한다.

# 탐색
많은 양의 데이터 중에서 원하는 데이터를 찾는 과정

# 스택 
먼저 들어온 데이터가 나중에 나가는 형식(선입후출)의 자료구조

ex) 박스쌓기

[파이썬, 자바 코드](https://github.com/siszero/TIL/blob/main/Java/Algorithm/src/DFS%2C%20BFS/Stack.md)

# 큐
먼저 들어온 데이터가 먼저 나가는 형식(선입선출)의 자료구조

[파이썬, 자바 코드](https://github.com/siszero/TIL/blob/main/Java/Algorithm/src/DFS%2C%20BFS/Queue.md)


# DFS(Depth-First Search)
### 깊이 우선 탐색
**스택** 자료구조(혹은 재귀 함수)를 이용한다.
1. 탐색 시작 노드를 스택에 삽입하고 방문처리 한다.
2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면 그 노드를 스택에 넣고 꺼낸다. (인접한 노드를 선택할 때는 가장 작은 숫자 먼저 선택)
3. 더 이상 2번의 과정을 수행할 수 없을 때까지 반복한다.

- DFS : [파이썬, 자바 코드](https://github.com/siszero/TIL/blob/main/Java/Algorithm/src/DFS%2C%20BFS/DFS.md)


# BFS(Breadth-First Search)
### 너비 우선 탐색
그래프에서 가까운 노드부터 우선적으로 탐색하는 알고리즘
**큐** 자료구조 이용
1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
2. 큐에서 노드를 꺼낸 뒤 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 넣고 방문처리 한다.
3. 더 이상 2번의 과정을 수행할 수 없을 때까지 반복한다.
(방문 기준 : 번호가 낮은 인접 노드 부터)

- BFS : [파이썬, 자바 코드](https://github.com/siszero/TIL/blob/main/Java/Algorithm/src/DFS%2C%20BFS/BFS.md)