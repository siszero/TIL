package dfs;

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

		for (int i = 0; i < N; i++) {
			if (map[i][num] == 1) {
				System.out.print((i + 1) + " ");
			}
		}

	}

}
