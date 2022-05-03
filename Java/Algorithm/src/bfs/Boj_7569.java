/*
 * 1차원 가로
 * 2차원 세로 가로
 * 3차원 높이 세로 가로
 */

package bfs;

import java.util.*;
import java.io.*;

public class Boj_7569 {

	static int N, M, H, total, max;
	static int[][][] map;
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { 1, 0, -1, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		total = H * N * M;

		for (int i = 0; i < H; i++) {

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());

					if (map[i][j][k] == 1) {
						total--;
						q.offer(new int[] { i, j, k });
					} else if (map[i][j][k] == -1)
						total--;
				}
			}
		}
		max = 0;
		if (total == 0)
			max = 1;
		else
			bfs();

		System.out.println(visited() ? max - 1 : -1);
	}

	private static boolean visited() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0)
						return false;
				}
			}
		}
		return true;
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] now = q.poll();
			// 상하좌우 위아래
			for (int k = 0; k < 6; k++) {
				int z = now[0] + dz[k];
				int y = now[1] + dy[k];
				int x = now[2] + dx[k];
				if (boundary(z, y, x)) {
					if (map[z][y][x] == 0) {
						q.offer(new int[] { z, y, x });
						map[z][y][x] = map[now[0]][now[1]][now[2]] + 1;

						if (max < map[z][y][x])
							max = map[z][y][x];
					}
				}
			}
		}
	}

	private static boolean boundary(int z, int y, int x) {
		return x >= 0 && y >= 0 && z >= 0 && z < H && y < N && x < M;
	}
}
