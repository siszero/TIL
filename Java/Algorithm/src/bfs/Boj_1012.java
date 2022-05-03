package bfs;

import java.util.*;
import java.io.*;

public class Boj_1012 {

	static int N, M, k, T, max;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[N][M]; // [3][5]
			visited = new boolean[N][M];
			max = 0;

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());

				map[x][y] = 1; // 배추 있는 곳 1로
			}

			for (int a = 0; a < N; a++) {
				for (int b = 0; b < M; b++) {
					if (map[a][b] == 1 && !visited[a][b]) {
						bfs(a, b);
						max++;
					}
				}
			}
			sb.append(max);
			sb.append("\n");
//			System.out.println(max);
		}
		System.out.println(sb);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });

		while (!q.isEmpty()) {
			visited[i][j] = true;
			int[] now = q.poll();
			for (int k = 0; k < 4; k++) {
				// now[0] = 0, now[1] = 4
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];

				if (boundary(x, y)) {
					// 배추가 있으면서 방문하지 않았을 경우
					if (map[x][y] == 1 && !visited[x][y]) {
						visited[x][y] = true; // 방문완료
						q.offer(new int[] { x, y });
					}
				}

			}
		}
	}

	private static boolean boundary(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
