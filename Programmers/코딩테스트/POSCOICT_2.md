# POSCO ICT
## 2번


## java
``` java
class Solution {
    public int solution(String[][] logs) {
        // 로그인 횟수 - 로그아웃 횟수
        int answer = 0;
        int len = logs.length;

        int in = 0;    // 로그인 횟수
        int out = 0;    // 로그아웃 횟수

        // if(!logs[len-1][0].equals("LOGOUT")){
        //     answer++;
        // }

        for(int i = 0; i<len; i++){
            if(logs[i][0].equals("LOGIN")){
                in++;
            }
            if(logs[i][0].equals("LOGOUT")){
                out++;
            }
        }
        answer = in-out;

        return answer;
    }
}

```
