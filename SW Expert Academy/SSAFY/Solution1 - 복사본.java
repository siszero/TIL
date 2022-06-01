/*
N개의 자연수가 있는 수열 A[1], A[2], …, A[N]이 주어진다.

1부터 N까지에서 고른 모든 가능한 서로 다른 i, j의 순서쌍 (i, j)에 대해서 A[i]를 A[j]로 나눈 나머지를 모두 더한 값을 구하라.

주어진 수열이 아래와 같다고 하자.

 3, 7, 5, 8

(i, j) = (1, 2)인 경우를 생각하면 3을 7로 나눈 나머지는 3이다.
또, (i, j) = (2, 3)인 경우를 생각하면 7을 5로 나눈 나머지는 2이다.


이와 같이 모든 경우를 따지면 그 총합은 37이 된다.

[입력 예]

2                    // 테스트 케이스의 수
3                     // N = 3, 테스트 케이스 #1
3 5 3
4                     // N = 4, 테스트 케이스 #2
3 7 5 8

[출력 예]
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