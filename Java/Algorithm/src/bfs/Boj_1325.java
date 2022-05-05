package bfs;

import java.io.*;
import java.util.*;

public class Boj_1325 {
	static int N, M, A, B;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

//		map = new int[M][2];

		map = new int[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
//			map[i][0] = Integer.parseInt(st.nextToken());
//			map[i][1] = Integer.parseInt(st.nextToken());
			map[B - 1][A - 1] = 1;
		}

		int max = -1;
		int num = -1;

		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
			if (cnt > max) {
				max = cnt;
				num = i;

			}
		}
		
/*
10 9
2 1
3 1
4 3
5 3
6 3
7 6
8 6
9 6
10 6
 */
		for (int i = 0; i < N; i++) {
			if (map[i][num] == 1) {
				for(int j =0; j<N; j++) {
					if(map[num][j]==1 && num>j) {
						num = i;
					}
					else {
						System.out.print((i + 1) + " ");
					}
				}
				
			}
//			else if(map[i][num] == 1 && map[num][i]!=1){
//				System.out.print((i + 1) + " ");
//			}
		}

	}

}
