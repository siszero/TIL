# POSCO ICT
## 1번


## java
``` java
import java.util.*;
class Solution {
    public int[] solution(int[] p) {
        int num = p.length;
        int[] answer = new int[num];

        // 뒤에서 마지막까지 더해지니깐 마지막은 0으로 비워놓기
        for(int i =0; i< num-1; i++){
            answer[i] = 1;
        }

        int[] arr = new int[num];

        for(int i =0; i< num; i++){
            arr[i] = p[i];
        }
        Arrays.sort(arr);

        int[] p1 = new int[num];

        for(int i =0; i< num; i++){
            p1[i] = p[i];
        }
        // 정리된 배열 arr
        // 정리 안 된 배열 p

        for(int i =0; i< num-1; i++){
            for(int j = 0; j< num; j++){
                if(arr[i] == p[j]){
                    int tmp = p[i];
                    p[i] = p[j];
                    p[j] = tmp;
                    // System.out.println("p["+ j+ "] " +  p[j]);
                    answer[j] += 1;
                    break;
                }
            }
        }
        // 원래 그 자리였던 수는 0 
        for(int i = 0; i< num; i++){
            if(arr[i] == p1[i]){
                answer[i] = 0;
            }
        }
        return answer;
    }
}

```
