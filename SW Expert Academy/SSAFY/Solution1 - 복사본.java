/*
N���� �ڿ����� �ִ� ���� A[1], A[2], ��, A[N]�� �־�����.

1���� N�������� �� ��� ������ ���� �ٸ� i, j�� ������ (i, j)�� ���ؼ� A[i]�� A[j]�� ���� �������� ��� ���� ���� ���϶�.

�־��� ������ �Ʒ��� ���ٰ� ����.

 3, 7, 5, 8

(i, j) = (1, 2)�� ��츦 �����ϸ� 3�� 7�� ���� �������� 3�̴�.
��, (i, j) = (2, 3)�� ��츦 �����ϸ� 7�� 5�� ���� �������� 2�̴�.


�̿� ���� ��� ��츦 ������ �� ������ 37�� �ȴ�.

[�Է� ��]

2                    // �׽�Ʈ ���̽��� ��
3                     // N = 3, �׽�Ʈ ���̽� #1
3 5 3
4                     // N = 4, �׽�Ʈ ���̽� #2
3 7 5 8

[��� ��]
#1 10
#2 37

 */

//import java.io.*;
//import java.util.*;
//
//class Solution1 {
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//
//		int t = Integer.parseInt(br.readLine());
//
//		for (int a = 1; a <= t; a++) {
//			sb.append("#").append(a).append(" ");
//
//			int n = Integer.parseInt(br.readLine());
//			int[] arr = new int[n];
//
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int i = 0; i < n; i++) {
//				arr[i] = Integer.parseInt(st.nextToken());
//			}
//
//			int sum = 0;
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					if (i != j) {
//						sum += arr[i] % arr[j];
//					}
//
//				}
//			}
//			sb.append(sum).append("\n");
//
//		}
//		System.out.println(sb.toString());
//	}
//}