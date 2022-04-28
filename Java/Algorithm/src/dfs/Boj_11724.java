package dfs;

import java.io.*;
import java.util.*;

public class Boj_11724 {
	static ArrayList<Integer>[] A;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		A = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		// 인접리스트 초기화
		for (int i = 1; i < n + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// 양방향 에지
			A[u].add(v);
			A[v].add(u);

		}
		int cnt = 0;

		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}

	public static void dfs(int v) {
		if (visited[v])
			return;

		visited[v] = true;
		for (int i : A[v]) {
			if (visited[i] == false)
				dfs(i);
		}
	}

}
