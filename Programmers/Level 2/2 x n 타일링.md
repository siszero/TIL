# [2 x n 타일링](https://programmers.co.kr/learn/courses/30/lessons/12900)


## 개념
- DP

## java
``` java
class Solution {
    public int solution(int n) {
        int[] dp = new int[60001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<60001; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
        }
        return dp[n];
    }
}
```