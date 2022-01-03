package bruteforcing;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		// N 개수만큼 입력받기
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		int result = search(arr, N, M);
		System.out.println(result);

	}

	static int search(int[] arr, int N, int M) {
		int result = 0;
		// 세 장의 합이 필요
		for (int i = 0; i < N - 2; i++)
			for (int j = i + 1; j < N - 1; j++)
				for (int k = j + 1; k < N; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					// 세 합이 M일 때보다 큰 경우는 없기 때문에 M이면 더 이상 비교할 필요없음
					if (temp == M)
						return temp;
					// M보다는 작은데 이전의 합보다 클 때 result에 대입
					if (result < temp && temp < M)
						result = temp;
				}
		return result;
	}

}
