package datastructure;

import java.util.Scanner;

public class Boj_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long max = 0;
		long sum = 0;
		
		int A[] = new int[N];
		
		for(int i = 0; i< N; i++) {
			A[i] = sc.nextInt();
			sum += A[i];
		}
		
		for(int i =0; i<N; i++) {
			if(max<A[i])
				max = A[i];
		}
		
		System.out.println(sum*100.0/max/N);
	}
}
