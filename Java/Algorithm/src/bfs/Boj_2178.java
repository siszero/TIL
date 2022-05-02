/*
1. add()

해당 큐 맨 뒤에 값 삽입
값 추가 성공 시 true 반환
큐가 꽉 찬 경우 IllegalStateException 에러 발생
2. offer()

해당 큐 맨 뒤에 값 삽입
값 추가 성공 시 true 반환
값 추가 실패 시 false 반환
*/

package bfs;

import java.io.*;
import java.util.*;

public class Boj_2178 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}
		
		bfs(0, 0);
		System.out.println(map[N - 1][M - 1]);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j }); // 처음 값 넣기, 처음은 지나가야 하니깐 무조건 1일테니

		while (!q.isEmpty()) {
			int[] now = q.poll();
			visited[i][j] = true;
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];

				// map을 벗어나지 않는다면
				if (boundary(x, y)) {
					// 이동가능한 칸 && 방문하지 않은 칸
					if (map[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						map[x][y] = map[now[0]][now[1]] + 1;	// 깊이 업데이트
						q.add(new int[] { x, y });
					}
				}
			}
		}
	}

	// map을 벗어나는지 검사
	// 좌표 유효성 검사
	private static boolean boundary(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < M;
	}

}
