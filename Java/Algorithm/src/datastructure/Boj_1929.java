package datastructure;

// 소수구하기
// 핵심 이론 : 에라토스테네스의 체 원리

import java.util.*;

public class Boj_1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		for(int i = 2; i<=N; i++) {
			arr[i] = i;
		}
		
		// N의 제곱근까지 확인 ( N보다 작은 숫자는 항상 N의 제곱근보다 작은 약수를 갖는다.)
		for(int i =2; i<= Math.sqrt(N); i++) {
			if(arr[i] == 0) {
				continue;
			}
			
			// 배수지우기
			for(int j = i+i; j<=N; j= j+i) {
				arr[j] = 0;
			}
		}
		
		for(int i =M; i<=N; i++) {
			if(arr[i] != 0)
				System.out.println(arr[i]);
		}
		

	}

}
