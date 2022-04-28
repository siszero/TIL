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
		N = sc.nextInt(); // ���� ��
		int C = sc.nextInt(); // ���� ��

		int[][] adjMatrix = new int[N][N]; // ���� �� ũ��� ����

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// �����̹Ƿ� ���� �ϳ��� ����� ó��
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}

//		for (int[] is : adjMatrix)
//			System.out.println(Arrays.toString(is));

		dfs(adjMatrix, new boolean[N], 0);

	}

	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);

		// current ������ �������� ó��(��, �湮���� ���� ����������)
		for (int j = 0; j < N; j++) {
			// �湮���� �ʾҰ� current���� j�� �� �� �ִٸ�
			if (!visited[j] && adjMatrix[current][j] != 0) {
				dfs(adjMatrix, visited, j);
			}
		}

	}

}
