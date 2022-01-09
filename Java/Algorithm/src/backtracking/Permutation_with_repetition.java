package backtracking;

import java.util.Scanner;

public class Permutation_with_repetition {

	private static int[] arr; // ���� ��Ƶ� �迭
	private static int N, M;

	// N������ �� �߿��� M�� ������
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M]; // ���� ��Ƶ� �迭�� ũ�⸦ M����
		nPir(0); // ó�� 0
	}

	private static void nPir(int cnt) {
		if (cnt == M) { // ���̰� M�� �� ��, ���ϴ� ���̸�ŭ �� ä������
			for (int i = 0; i < M; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		// �� ä������ �� ��ȸ�ϸ� ���ڸ� ������
		for (int i = 1; i <= N; i++) {
			arr[cnt] = i;
			nPir(cnt + 1);
		}

	}

}