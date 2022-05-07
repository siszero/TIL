package backtracking;

import java.util.*;

public class Boj_15649 {

	static int N, M, cnt;

	static int[] input;
	static int[] number;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		input = new int[N];
		number = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
		permutation(0);

	}

	public static void permutation(int cnt) {

		// 기저조건
		if (cnt == M) {
			for (int i = 0; i < number.length; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
			return;
		}

		// 유도조건
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			number[cnt] = input[i];
			visited[i] = true;
			permutation(cnt + 1);
			visited[i] = false;
		}

	}

}
