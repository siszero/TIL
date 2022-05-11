# [x만큼 간격이 있는 n개의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12954#qna)

## 설명
1. long 으로 안 맞춰 줄 경우, 테스트 13,14에서 실패
2. x는 0일 때 케이스 추가 안 해주면 테스트8에서 런타임에러


## java
``` java
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int a = 0;

        if(x<0){
            for(long i = (long)x; i>=(long)x*(long)n; i+=(long)x){
                answer[a] = i;
                a++;
            }
        }
        else if(x ==0){
            answer[a] = 0;
            return answer;
        }
        else{
            for(long i = (long)x; i<=(long)x*(long)n; i+=(long)x){
                answer[a] = i;
                a++;
            }
            
        }
        
        
        return answer;
    }
}
```
