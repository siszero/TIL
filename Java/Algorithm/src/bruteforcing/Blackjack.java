package bruteforcing;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		// N ������ŭ �Է¹ޱ�
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		int result = search(arr, N, M);
		System.out.println(result);

	}

	static int search(int[] arr, int N, int M) {
		int result = 0;
		// �� ���� ���� �ʿ�
		for (int i = 0; i < N - 2; i++)
			for (int j = i + 1; j < N - 1; j++)
				for (int k = j + 1; k < N; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					// �� ���� M�� ������ ū ���� ���� ������ M�̸� �� �̻� ���� �ʿ����
					if (temp == M)
						return temp;
					// M���ٴ� ������ ������ �պ��� Ŭ �� result�� ����
					if (result < temp && temp < M)
						result = temp;
				}
		return result;
	}

}
