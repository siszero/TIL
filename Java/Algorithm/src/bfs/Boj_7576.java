package bfs;

import java.io.*;
import java.util.*;

public class Boj_7576 {
	static int N, M, total, max;
	static int[][] map;
	static boolean[][] visited;

	static Queue<int[]> q = new LinkedList<>();

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		total = N * M; // 최초 토마토 상태 체크하기 위함

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					q.offer(new int[] { i, j });
					total--;
				} else if (map[i][j] == -1)
					total--;
			}
		}
		max = 0;
		if (total == 0) { // 최초 토마토가 모두 익은 상태일 때
			max = 1;
		} else {
			bfs();
		}

		System.out.println(visited() ? max - 1 : -1);

	}

	private static void bfs() {
		
//		visited[i][j] = true; 	// 이렇게 방문체크를 못해. 왜냐하면 이거는 미로처럼 위치가 고정되어 있는게 아니야 그러면 어떻게 해? 방문처리 함수 하나 만들어주자.

		while (!q.isEmpty()) {
			int[] now = q.poll(); // 배열 하나씩 꺼내기
			for (int k = 0; k < 4; k++) { // 상하좌우
				int y = now[0] + dx[k];
				int x = now[1] + dy[k];

				if (boundary(y, x)) {
					if (map[y][x] == 0) {
//						visited[x][y] =true;
						q.offer(new int[] { y, x });
						map[y][x] = map[now[0]][now[1]] + 1; // 깊이 +1

						if (max < map[y][x]) {
							max = map[y][x];
						}
					}
				}
			}
		}
		
	}

	private static boolean visited() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean boundary(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}