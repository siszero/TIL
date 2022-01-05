package backtracking;

import java.util.Scanner;

public class NQueen {

	private static int N; // 체스판 크기
	private static int[] arr;	// 체스판
	private static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N]; // 배열 크기 = 체스판 크기

		nqueen(0);
		System.out.println(cnt);

	}

	public static void nqueen(int depth) {	// depth = 열
		if (depth == N) { // 행을 다 채웠을 때
			// 모두 다 돌았을 때 즉, depth와 N이 같아질 때 N개의 퀸을 둔것으로 판단. cnt의 값 증가
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;

			// 해당 열에서 i 번째 행에 놓을 수 있는지 확인
			if (Possibility(depth))
				nqueen(depth + 1);		// 다음 퀸 배치
		}
	}

	// 퀸 배치 가능 여부 검사
	public static boolean Possibility(int col) {
		for (int i = 0; i < col; i++) {
			// 같은 행일 때
			if (arr[col] == arr[i])
				return false;

			// 같은 대각선일 때
			else if (Math.abs(arr[col] - arr[i]) == Math.abs(col - i))
				return false;
		}
		return true;

	}

}
