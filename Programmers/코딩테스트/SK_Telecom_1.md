# SK Telecom
## 1번


## java
``` java
import java.util.*;

class Solution {
    public int[] solution(int[] p) {
        int num = p.length;
        int[] answer = new int [num];
        int[] arr = new int[num];

        for(int i=0; i< num; i++){
            answer[i] = 0;
            arr[i] = p[i];
        }

        Arrays.sort(arr);

        for(int i =0; i<num; i++){
            for(int j =0; j<num; j++){
                if(arr[i] == p[j] && arr[i] != p[i]){
                    int tmp = p[i];
                    p[i] = p[j];
                    p[j] = tmp;
                    answer[i] += 1;
                    answer[j] += 1;
                    break;
                }
            }
        }

        return answer;
    }
}
```
