# 정렬(Sorting)
데이터를 특정한 기준에 따라 순서대로 나열하는 것

## 선택 정렬
- 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸는 것   
|   시간복잡도 : O(N^2)   
|   -> N  +  (N-1)  +  (N-2)  +  ...  +  2   

<img src="https://user-images.githubusercontent.com/64197543/150691242-5ffcb572-ed70-4055-b939-eedfc111d820.png"  width="500" height="400"/>


[Python  /  Java  /  C++](https://github.com/siszero/TIL/blob/main/Java/Algorithm/src/Sorting/%EC%84%A0%ED%83%9D%EC%A0%95%EB%A0%AC.md)


## 삽입 정렬
- 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입하는 것
|   시간복잡도 : O(N^2)    
|   최선의 경우 시간복잡도 : O(N) 

<img src="https://user-images.githubusercontent.com/64197543/150691205-d4ef5a18-47b8-4387-95dd-f42aa45fa64e.png"  width="800" height="700"/>


[Python  /  Java  /  C++](https://github.com/siszero/TIL/blob/main/Java/Algorithm/src/Sorting/%EC%82%BD%EC%9E%85%EC%A0%95%EB%A0%AC.md)



## 퀵 정렬
- 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
- 일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘 중 하나
- 정렬 라이브러리의 근간이 됨
- 가장 기본적인 퀵 정렬은 첫 번째 데이터를 기준 데이터(Pivot)로 설정함   
|   시간복잡도 : O(NlogN)   
|   최악의 경우 시간복잡도 : O(N^2)   

![퀵정렬](https://user-images.githubusercontent.com/64197543/150691249-2c2193ac-95e7-45be-a135-897a9bc04641.png)


[Python  /  Java  /  C++](https://github.com/siszero/TIL/blob/main/Java/Algorithm/src/Sorting/%ED%80%B5%EC%A0%95%EB%A0%AC.md)



## 계수 정렬
- 특정한 조건이 부합할 때만 사용할 수 있지만 매우 빠르게 동작하는 정렬 알고리즘
    - 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때 사용 가능
- 데이터의 개수가 N, 데이터(양수) 중 최댓값이 K일 때 최악의 경우에도 수행 시간 O(N+K)를 보장
- 동일한 값을 가지는 데이터가 여러 개 등장할 때 효과적으로 사용 가능
    - 성적의 경우 같은 점수를 맞은 학생이 여러 명일 때 효과적임

1. 가장 작은 데이터부터 가장 큰 데이터까지의 범위가 모두 담길 수 있도록 리스트를 생성한다.
2. 데이터를 하나씩 확인하며 데이터의 값과 동일한 인덱스의 데이터를 1씩 증가시킨다.
3. 결과적으로 최종 리스트에는 각 데이터가 몇 번씩 등장했는지 그 횟수가 기록된다.
![WJDFUF](https://user-images.githubusercontent.com/64197543/150691258-d2b5d205-f47b-4624-b44a-383c9be71a9f.PNG)


4. 결과를 확인할 대 첫 번째 데이터부터 하나씩 그 값만큼 반복하여 인덱스를 출력한다.
![222](https://user-images.githubusercontent.com/64197543/150691259-34d99384-1385-4ce6-abbc-b35b3775f796.PNG)


|   시간복잡도 : O(N + K)   
|   공간복잡도 : O(N + K) 


| 정렬 알고리즘 | 평균 시간 복잡도 | 공간복잡도 | 특징 |
| ------ | ------ | ------ | ------ |
| 선택 정렬 | O(N^2) | O(N) | 매우 간단한 아이디어 |
| 삽입 정렬 | O(N^2) | O(N) | 데이터가 거의 정렬되어 있을 때 가장 빠름 |
| 퀵 정렬 | O(NlogN) | O(N) | 대부분의 경우에 적합, 충분히 빠름 |
| 계수 정렬 | O(N + K) | O(N + K) | 데이터 크기가 한정되어 있는 경우에만 사용가능하지만 매우 빠르게 동작함 |


[Python  /  Java  /  C++](https://github.com/siszero/TIL/blob/main/Java/Algorithm/src/Sorting/%EA%B3%84%EC%88%98%EC%A0%95%EB%A0%AC.md)





[참고 - 이코테 2021](https://youtu.be/KGyK-pNvWos)