package dfs;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */
import java.util.*;

public class DFS_LinkedMatrix {

	static private int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		int C = sc.nextInt(); // 간선 수

		int[][] adjMatrix = new int[N][N]; // 정점 수 크기로 생성

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 무향이므로 간선 하나로 양방향 처리
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}

//		for (int[] is : adjMatrix)
//			System.out.println(Arrays.toString(is));

		dfs(adjMatrix, new boolean[N], 0);

	}

	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);

		// current 정점에 인접정점 처리(단, 방문하지 않은 인접정점만)
		for (int j = 0; j < N; j++) {
			// 방문하지 않았고 current에서 j로 갈 수 있다면
			if (!visited[j] && adjMatrix[current][j] != 0) {
				dfs(adjMatrix, visited, j);
			}
		}

	}

}
