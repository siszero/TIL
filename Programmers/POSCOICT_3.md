# POSCO ICT
## 3번


## java
``` java
import java.util.*;

class Solution {
    public int[] solution(int[][] contests, int k, int p) {
        int[] answer = new int[k];  // k만큼 참가 가능
        int len = contests.length;
        int num = contests[0].length;
        int[] cnt = new int[len];       // 풀 수 있는 수를 넣을 배열 생성
        Integer[] sort_cnt = new Integer[len];      // 배열 비교하기 위한 내림차순시킬 배열 생성

        // 대회별 풀 수 있는 수
        for(int i =0; i<len; i++){
            for(int j = 0; j<num; j++){
                if(contests[i][j] <= 4){
                    cnt[i] +=1;
                }
            }
        }

        for(int i =0; i<len; i++){
            sort_cnt[i] = cnt[i];
        }

        // 숫자 내림차순을 위해 Comparator.reverseOrder()
        // 문자 내림차순은 Collections.reverseOrder()
        // -> 근데 뒤에서 다시 숫자로 바꿔줘야 해서 Integer배열로 만들어 주고 Comparator 사용
        Arrays.sort(sort_cnt, Comparator.reverseOrder());

        for(int i =0; i<k; i++){
            for(int j =0; j<cnt.length;j++){
                if(sort_cnt[i] == cnt[j]){
                    answer[i] = j;
                    cnt[j]=-1;
                    break;
                }
            }
        }
        Arrays.sort(answer);

        // System.out.print(Arrays.toString(sort_cnt));

        return answer;
    }
}
```
