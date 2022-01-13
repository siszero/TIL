/*
 * 자바에서 정수의 최댓값, 최솟값 출력
 * Integer 클래스의 MAX_VALUE, MIN_VALUE 사용하기
 * Integer.MAX_VALUE	// 2147483647
 * Integer.MIN_VALUE	// -2147483648
 */

import java.util.Scanner;

public class Operator2 {
	private static int N;
	private static int[] num;
	private static int[] operator;
	// 최대 최소 초기화
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		num = new int[N];
		operator = new int[4];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}

		operate(1, num[0]);

		System.out.println(max);
		System.out.println(min);
	}

	// value는 다음 숫자, sum은 수행했을 때의 합
	public static void operate(int value, int sum) {
		
		// 모든 숫자를 다 사용했을 때
		if (value == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		// 연산자 한 번씩 다 확인
		for (int i = 0; i < 4; i++) {
			// 각 연산자의 개수가 0이 되면 쓸 연산자가 없어서 if문 돌지 않음
			if (operator[i] != 0) {
				operator[i]--;		// 연산자가 쓰이면 개수를 하나 줄여줌
				if (i == 0) // 덧셈
					operate(value + 1, sum + num[value]);
				else if (i == 1) // 뺄셈
					operate(value + 1, sum - num[value]);
				else if (i == 2) // 곱셈
					operate(value + 1, sum * num[value]);
				else if (i == 3) // 나눗셈
					operate(value + 1, sum / num[value]);
				operator[i]++;
			}
		}
	}
}
