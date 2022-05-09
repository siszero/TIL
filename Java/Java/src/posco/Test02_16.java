package posco;

// 1시간 걸림 (문제 이해 잘못해서 다시 품)
public class Test02_16 {

	public static void main(String[] args) {
		int[][] board = {{2,7,9},{3,5,1},{8,6,4}};
//		int[][] board = {{2,6,4},{3,8,5},{9,1,7}};
//		int[][] board = {{3,1},{4,2}};

		int n = board.length;
		int cnt = 0;
		
		boolean[][] visited = new boolean[n][n];
		
		int x = 0;
		int y = 0;
		
		// k인 수를 찾아서 위치확인
		for(int k = 1; k<=n*n; k++) {
			for(int i =0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(k == board[i][j]) {
						if(Math.abs(j-y) > (n/2)) {
							cnt += (n-j-y +1);
						}
						else {
							cnt+= (Math.abs(j-y)+1);
						}
						if(Math.abs(i-x) > (n/2)) {
							cnt += (n-i-x);
						}
						else {
							cnt+= (Math.abs(i-x));
						}
						x = i;
						y= j;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
