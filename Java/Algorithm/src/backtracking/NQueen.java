package backtracking;

import java.util.Scanner;

public class NQueen {

	private static int N; // ü���� ũ��
	private static int[] arr;
	private static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N]; // �迭 ũ�� = ü���� ũ��

		nqueen(0);
		System.out.println(cnt);

	}

	public static void nqueen(int depth) {
		if (depth == N) { // ���� �� ä���� ��
			// (depth�� N�� �������� ������ N ���� ���� �� ������ �Ǵ� ��, ������ �� ������ �� cnt ���� ������Ŵ)
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;

			if (Possibility(depth)) // ���� �� ���� �� nqueen ȣ��(���)
				nqueen(depth + 1);	// ���� �� ��ġ
		}
	}

	// �� ��ġ ���� ���� �˻�
	public static boolean Possibility(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) // ���� ���� ��
				return false;

			// ���� �밢���� ��
			else if (Math.abs(arr[col] - arr[i]) == Math.abs(col - i))
				return false;
		}
		return true;

	}

}
