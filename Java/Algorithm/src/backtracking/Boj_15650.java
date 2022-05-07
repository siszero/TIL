package backtracking;

import java.util.Scanner;

public class Boj_15650 {

	static int N, M;

	static int[] input;
	static int[] number;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		input = new int[N];
		number = new int[M];

		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}

		int start = 0;
		Combination(0, start);

	}

	static void Combination(int cnt, int start) {
		// 기저 조건
		if (cnt == M) {
			for (int i = 0; i < number.length; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
			return;
		}

		// 유도 조건
		for (int i = start; i < N; i++) {
			number[cnt] = input[i];
			Combination(cnt + 1, i + 1);

		}

	}

}
