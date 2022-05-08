# [JadenCase 문자열 만들기](https://programmers.co.kr/learn/courses/30/lessons/12951)

## 설명
1. 대소문자 변환
``` java
// String 일 때
String str = "";
str.toLowerCase();

// char 일 때
char c = 'a'
Character.toUpperCase(c);
```

## java
``` java
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();        // 처음에 다 소문자로 바꿔주기
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            // 처음 나온 수 대문자로
            if(i==0){
                c = Character.toUpperCase(c);
            }
            // 앞 문자가 공백일 때 대문자로
            else if(s.charAt(i - 1) == ' '){
                c = Character.toUpperCase(c);
            }
            answer += c;
        }

        return answer;
    }
}
```
