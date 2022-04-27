package Sorting;

import java.util.*;

public class Boj_2750 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int A[] = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		
		// sort 함수 이용
//		Arrays.sort(A);
		
		for(int i =0; i< N-1;i++) {
			for(int j = 0; j<N-1-i;j++) {
				if(A[j]>A[j+1]) {
					// 자리바꿈
					int tmp = A[j];
					A[j] = A[j+1];
					A[j+1] = tmp;
				}
			}
		}

		for (int i = 0; i < N; i++)
			System.out.println(A[i]);

	}

}
