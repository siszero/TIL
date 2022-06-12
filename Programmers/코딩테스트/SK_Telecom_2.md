# SK Telecom
## 2번


## java
``` java
class Solution {
    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2];

        // 다음 달 금액은 payments[0]은 빼고 estimates를 더한 값임

        // [(이번달 vip x, 다음달 vip o), (이번달 vip o, 다음달 vip x)]
        // 2년 미만(22 이하는 다 안 됨) x x
        // 납부금액 90 안 넘으면 다 안됨 x x
        // 23일 때 다음달 납부금액(900000) 넘으면  다음달 vip x o
        // 24이상 60미만이고 납부금액이 90이 안 넘는데 다음달 납부금액이 90이 넘으면 다음달 vip 됨 x o
        // 24이상 60미만이고 납부금액이 90이 넘는데 다음달 납부금액이 90이 안넘으면 다음달 vip 안됨 o x
        // 24이상 60미만이고 납부금액이 90이 넘는데 다음달 납부금액도 90이 넘으면 다음달 vip 됨 o o
        // 59일 때 납부금액 90 넘고 다음달 납부금액이 60이상이 아니면 o x
        // 59일 때 납부금액 90 안 넘고 다음달 납부금액이 60이상이면 x o
        // 60이상일 때 납부금액 90 넘고 다음달 납부금액이 60이상이면 다음달도 vip o o

        int len = periods.length;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i =0; i<len; i++){
            int now = 0;
            int next = 0;
            for(int j = 0; j<12; j++){
                now += payments[i][j];
            }
            for(int j = 1; j<12; j++){
                next += payments[i][j];
            }
            next += estimates[i];

            if((periods[i] == 23 && next>=900000) || (periods[i] >=24 && periods[i] <59 && now<900000 && next >= 900000) || (periods[i] == 59 && now<900000 && next >= 600000)){
                cnt1++;
            }
            else if((periods[i] >=24 && periods[i] <59 && now>=900000 && next < 900000) || (periods[i] == 59 && now>=900000 && next < 600000)){
                cnt2++;
            }
            else{
                continue;
            }

        }

        answer[0] = cnt1;
        answer[1] = cnt2;

        return answer;
    }
}
```
