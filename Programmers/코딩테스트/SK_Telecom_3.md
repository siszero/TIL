# SK Telecom
## 3번


## java
``` java
class Solution {
    public int[] solution(int n, String[] plans, String[] clients) {
        int plen = plans.length;
        int clen = clients.length;

        int[] answer = new int[clen];

        // clients의 요금제 >= plans의 요금제 && 고객의 부가사항이 plans에 다 있어야 함

        int[] plan = new int[plen];
        int[] client = new int[clen];

        String[] data = new String[plen];
        String m = "";
        for(int i =0; i<plen; i++){
            String str = plans[i];
            String[] a = str.split(" ");

            plan[i] = Integer.parseInt(a[0]);

            for(int j =1; j<a.length; j++){
                m += (a[j]);
            }
            int nn = Integer.parseInt(m);
            data[i] = Integer.toString(nn);
            // System.out.println(data[i]);
        }


        for(int i =0; i<clen; i++){
            String str = clients[i];
            String[] a = str.split(" ");
            client[i] = Integer.parseInt(a[0]);
            int c = 0;
            for(int j =0; j<plen; j++){
                if(client[i]<=plan[j]){
                    int cnt = 0;
                    for(int k =1; k<a.length; k++){
                        if(!data[j].contains(a[k])){
                            cnt++;
                            // System.out.println("x" + a[k]);
                        }
                        // else{
                        //     System.out.println("0" + a[k]);
                        // }
                    }
                    if(cnt == 0){
                        answer[i] = j+1;
                        break;
                    }
                }
                else{
                    c++;
                }

            }
            if(c == plen){
                answer[i] = 0;
            }

        }
        return answer;
    }
}
```
