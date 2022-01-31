import java.io.*;
import java.util.*;

public class Increasing_Subsequence {

	static int[] a;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		a = new int[n];
		dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++)
			LIS(i);

		int max = -1;

		// �ִ�
		for (int i = 0; i < n; i++)
			max = Math.max(max, dp[i]);
		System.out.println(max);
	}

	private static int LIS(int i) {
		// Ž������ ���� ���̶��
		if (dp[i] == 0) {
			dp[i] = 1;	// �ʱ�ȭ
			
			// ���ȣ�� : i-1���� 0���� ���� ������ ã��
			for (int j = i - 1; j >= 0; j--) {
				if (a[i] > a[j])
					dp[i] = Math.max(dp[i], LIS(j) + 1);
			}
		}
		return dp[i];
	}
}