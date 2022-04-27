package twopointer;

import java.io.*;
import java.util.*;

public class Boj_1253 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A); // ���� �� �Ǿ����� ���� �����ؼ� �������ֱ�

		// �񱳴�� �����
		for (int k = 0; k < N; k++) {
			int find = A[k];
			int i = 0;
			int j = N - 1;

			while (i < j) {
				if (A[i] + A[j] == find) {
					if (i != k && j != k) {
						count++;
						break;
					} else if (i == k)
						i++;
					else if (j == k)
						j--;
				} else if (A[i] + A[j] < find)
					i++;
				else
					j--;
			}
		}

		System.out.println(count);

	}

}
