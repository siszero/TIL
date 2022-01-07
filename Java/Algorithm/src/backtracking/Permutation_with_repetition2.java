package backtracking;

import java.util.Scanner;

public class Permutation_with_repetition2 {

	private static int[] arr; // ���� ��Ƶ� �迭
	private static int N, M;

	// N������ �� �߿��� M�� ����
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
		System.out.println();
		// �� ä������ �� ��ȸ�ϸ� ���ڸ� ������
		for (int i = 1; i <= N; i++) {
			System.out.println("cnt = " + cnt);
			arr[cnt] = i;
			System.out.println("arr[" +cnt + "] = " + arr[cnt]);
			nPir(cnt + 1);
		}

	}

}