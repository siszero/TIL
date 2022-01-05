package backtracking;

import java.util.Scanner;

public class NQueen {

	private static int N; // 체스판 크기
	private static int[] arr;
	private static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N]; // 배열 크기 = 체스판 크기

		nqueen(0);
		System.out.println(cnt);

	}

	public static void nqueen(int depth) {
		if (depth == N) { // 행을 다 채웠을 때
			// (depth와 N이 같아지는 시점에 N 개의 퀸을 둔 것으로 판단 즉, 끝까지 다 돌았을 때 cnt 값을 증가시킴)
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;

			if (Possibility(depth)) // 놓을 수 있을 때 nqueen 호출(재귀)
				nqueen(depth + 1);	// 다음 퀸 배치
		}
	}

	// 퀸 배치 가능 여부 검사
	public static boolean Possibility(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) // 같은 행일 때
				return false;

			// 같은 대각선일 때
			else if (Math.abs(arr[col] - arr[i]) == Math.abs(col - i))
				return false;
		}
		return true;

	}

}
