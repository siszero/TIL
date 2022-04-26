package datastructure;

import java.io.*;
import java.util.*;

public class Boj_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 2���� �迭�� ũ��
		int M = Integer.parseInt(st.nextToken()); // ���� �� ������ ����

		int A[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}

		// ���� ���� ���ϱ� ���ؼ� ���ο� �迭 ����
		int D[][] = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				// ���� ��
				D[i][j] = D[i - 1][j] + D[i][j - 1] + A[i][j] - D[i - 1][j - 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
			System.out.println(result);
		}

	}

}
