package twopointer;

import java.io.*;
import java.util.*;

public class Boj_1253 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N + 1];
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A); // 정렬 안 되어있을 것을 생각해서 정렬해주기

		// 비교대상 만들기
		for (int a = 1; a <= N; a++) {
			int find = A[a];

			int i = 1;
			int j = N;
			while (i < j) {
				
				if (A[i] + A[j] == find) {
					if(i!=a&&j!=a) {
						count++;
						break;
					}
					else if (i==a)
						i++;
					else if (j == a)
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
