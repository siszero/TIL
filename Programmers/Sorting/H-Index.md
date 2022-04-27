# [H-Index](https://programmers.co.kr/learn/courses/30/lessons/42747)

## 설명
문제이해만 하면 쉽게 풀 수 있는 문제   

[개념 참고](https://so-cute-danu-dev.tistory.com/52)


## java
``` java
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = citations.length-1; i>=0; i--){
            if(citations[i] > answer)
                answer++;
        }
        
        return answer;
    }
}
```