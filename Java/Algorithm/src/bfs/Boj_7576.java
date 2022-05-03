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
		total = N * M; // ���� �丶�� ���� üũ�ϱ� ����

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
		if (total == 0) { // ���� �丶�䰡 ��� ���� ������ ��
			max = 1;
		} else {
			bfs();
		}

		System.out.println(visited() ? max - 1 : -1);

	}

	private static void bfs() {
		
//		visited[i][j] = true; 	// �̷��� �湮üũ�� ����. �ֳ��ϸ� �̰Ŵ� �̷�ó�� ��ġ�� �����Ǿ� �ִ°� �ƴϾ� �׷��� ��� ��? �湮ó�� �Լ� �ϳ� ���������.

		while (!q.isEmpty()) {
			int[] now = q.poll(); // �迭 �ϳ��� ������
			for (int k = 0; k < 4; k++) { // �����¿�
				int y = now[0] + dx[k];
				int x = now[1] + dy[k];

				if (boundary(y, x)) {
					if (map[y][x] == 0) {
//						visited[x][y] =true;
						q.offer(new int[] { y, x });
						map[y][x] = map[now[0]][now[1]] + 1; // ���� +1

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