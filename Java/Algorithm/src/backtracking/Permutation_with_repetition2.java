package backtracking;

import java.util.Scanner;

public class Permutation_with_repetition2 {

	private static int[] arr; // 숫자 담아둘 배열
	private static int N, M;

	// N까지의 수 중에서 M개 고르기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M]; // 숫자 담아둘 배열의 크기를 M으로
		nPir(0); // 처음 0
	}

	private static void nPir(int cnt) {
		if (cnt == M) { // 깊이가 M일 때 즉, 원하는 길이만큼 다 채워지면
			for (int i = 0; i < M; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		System.out.println();
		// 다 채워지기 전 순회하며 숫자를 선택함
		for (int i = 1; i <= N; i++) {
			System.out.println("cnt = " + cnt);
			arr[cnt] = i;
			System.out.println("arr[" +cnt + "] = " + arr[cnt]);
			nPir(cnt + 1);
		}

	}

}