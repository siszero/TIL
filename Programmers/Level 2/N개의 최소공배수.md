# [N개의 최소공배수](https://programmers.co.kr/learn/courses/30/lessons/12953)


## java
``` java
class Solution {
    
    // 5. 최대공약수 메소드, 유클리드 호제법
    public static int gcd(int a, int b){
        int x = Math.max(a,b);
        int y = Math.min(a,b);
        
        while(x % y != 0){
            int r = x % y;
            x = y;
            y = r;
        }
        
        return y;
    }
    
    public int solution(int[] arr) {
        // 1. 배열의 첫 번째 값을 저장.
        int answer = arr[0];
        
        // 2. 배열의 길이가 1이면 반복x, 그 이상은 다음 인덱스인 1부터 반복.
        for(int i = 1;i<arr.length;i++){
            // 3. 두 값의 최대공약수
            int gcd = gcd(answer,arr[i]);
            // 4. 두 값의 최소공배수
            answer = answer * arr[i] / gcd;
        }
        
        return answer;
    }
}
```