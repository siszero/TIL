# [3 x n 타일링](https://programmers.co.kr/learn/courses/30/lessons/12900)

## 개념
- DP

## java
``` java
class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n+1];

        // N이 홀수일때는 완전하게 모든 공간을 가득 채우는건 불가능 -> 짝수일 때만 생각
        dp[0] = 1;
        dp[2] = 3;

        for(int i=4; i<=n; i+=2){
            dp[i] = dp[i-2] * 3;
            for(int j=i-4; j>=0; j-=2){
                dp[i] += dp[j] * 2;
            }
            dp[i] = dp[i] % 1000000007;
        }
        answer = (int) dp[n];

        return answer;
    }
}
```