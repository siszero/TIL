# [N-Queen](https://programmers.co.kr/learn/courses/30/lessons/12952?language=java)


## java
``` java
// 세로와 대각선만 확인, 가로는 확인 안 해도 됨(한 줄에 하나씩 들어가기 때문)
class Solution {
    int answer;
    int dx[]= {0,0,1,-1,-1,-1,1,1};
    int dy[]= {-1,1,0,0,-1,1,-1,1};
    
    public int solution(int n) {
        answer=0;
        int [][]map = new int[n][n];
        solve(map,n,0);
        return answer;
    }
    
    private void solve(int[][] map, int n, int cnt) {
        if(cnt==n) {
            answer++;
            return;
        }

        for(int i=0; i<n; i++) {
            if(!isBound(map,cnt,i,n)) continue;
            map[cnt][i]=1;
            solve(map,n,cnt+1);
            map[cnt][i]=0;
        }

    }
    private boolean isBound(int[][] map, int x, int y, int n ) {
        for(int i=0; i<8; i++) {
            int nx=x;
            int ny=y;

            while(true) {
                nx+=dx[i];
                ny+=dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n) break;
                if(map[nx][ny]==1) return false;
            }
        }
        return true;
    }
}
```