package backtracking;

import java.util.Scanner;

public class Combination {
	private static boolean[] visit; // 방문여부
	private static int[] arr;
	private static int N, M;

	// N까지의 수 중에서 M개 고르기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N + 1];
		visit = new boolean[N + 1]; // 방문여부 확인
		nCr(0); // 처음 0
	}

	private static void nCr(int cnt) {
		if (cnt == M) { // 깊이가 M일 때
			for (int i = 0; i < M; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) { // 방문한 적이 있는지 확인 (1 1 일때, 2 2 일 때 처럼 중복제외하기 위함)
				visit[i] = true; // 방문했음을 저장
				arr[cnt] = i; // 깊이 저장
				nCr(cnt + 1); // 백트래킹
				// 중복순열에서 이 부분 추가해주면 중복허락하지 않는 순열
				for(int j=i+1;j<=N;j++)
					visit[j] = false; // 방문 저장 초기화
			}
		}

	}

}
