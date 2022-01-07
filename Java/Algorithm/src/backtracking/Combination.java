package backtracking;

import java.util.Scanner;

public class Combination {
	private static boolean[] visit; // �湮����
	private static int[] arr;
	private static int N, M;

	// N������ �� �߿��� M�� ����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N + 1];
		visit = new boolean[N + 1]; // �湮���� Ȯ��
		nCr(0); // ó�� 0
	}

	private static void nCr(int cnt) {
		if (cnt == M) { // ���̰� M�� ��
			for (int i = 0; i < M; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) { // �湮�� ���� �ִ��� Ȯ�� (1 1 �϶�, 2 2 �� �� ó�� �ߺ������ϱ� ����)
				visit[i] = true; // �湮������ ����
				arr[cnt] = i; // ���� ����
				nCr(cnt + 1); // ��Ʈ��ŷ
				// �ߺ��������� �� �κ� �߰����ָ� �ߺ�������� �ʴ� ����
				for(int j=i+1;j<=N;j++)
					visit[j] = false; // �湮 ���� �ʱ�ȭ
			}
		}

	}

}
