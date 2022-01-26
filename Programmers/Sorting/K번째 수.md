# [K번째 수](https://programmers.co.kr/learn/courses/30/lessons/42748)

## 설명
1. ArrayList 사용 -> Collections.sort()로 정렬
2. 배열 인덱스는 0으로 시작하므로 -1 해주기


## java
``` java
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        // commands배열의 행만큼 answer 배열 만들기
        answer = new int[commands.length];
        
        // commands 행 돌기
        for(int i = 0;i<commands.length; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            // 배열 인덱스가 0부터 시작하기 때문에 commands[i][0]-1 부터 시작함 (k번째 원소 구하려면 인덱스는 k-1이어야 함)
            for(int j=commands[i][0]-1; j<commands[i][1]; j++) 
                list.add(array[j]); 
            // 오름차순 정렬
            Collections.sort(list);
            // get() 으로 리스트에서 가져오기
            // 배열 인덱스가 0으로 시작하기에 -1을 해주는 것임
            answer[i] =list.get(commands[i][2]-1);
        }      
        return answer;
    }
}
```




## 다른 방법   
1. 배열의 복사해주는 함수인 **copyOfRange** 사용
2. copyOfRange( 배열, 시작 인덱스, 끝 인덱스 ) : 원본 배열을 먼저 넣고, 복사를 시작할 인덱스와 마지막 인덱스를 받는다. 이때, 시작 인덱스는 포함하지만 끝 인덱스는 제외한다.


## java
```java
import java.util.*;
 
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int temp[] = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
}
```