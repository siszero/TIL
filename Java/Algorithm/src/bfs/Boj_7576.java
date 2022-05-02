package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {
	static int N, M, total;
	static int[][] map;
	static boolean[][] visited;

	static Queue<int[]> q = new LinkedList<>();

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		total = N * M; // 최초 토마토 상태 체크하기 위함

		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					q.offer(new int[] { i, j });
					total--;
				} else if (map[i][j] == -1)
					total--;
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					System.out.println("-1");
					return;
				}
				else {
					if (total == 0)// 토마토 다 익었을 때
						System.out.println("0");
					else {
						bfs();
						System.out.println(map[M - 1][N - 1]);
					}
				}
					
			}
		}

		

	}

	private static void bfs() {
		int[] now = q.poll(); // 배열 하나씩 꺼내기
//		visited[i][j] = true;

		while (!q.isEmpty()) {
			for (int k = 0; k < 4; k++) { // 상하좌우
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];

				if (boundary(x, y)) {
					if (map[x][y] != 0) {
//						visited[x][y] =true;
						map[x][y] = map[now[0]][now[1]] + 1; // 깊이 +1
//						q.add(new int[] {x,y});
					}
				}
			}

		}
	}

	private static boolean boundary(int x, int y) {
		return x >= 0 && y >= 0 && x > N && y > M;
	}
}