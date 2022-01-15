/*
 * 처음에 가장 작은 생성자를 구해야 하는 것을 인식하지 못해서 자연수부터 하나씩 작은 수를 비교하려고 하다보니 막힘
 */
import java.util.Scanner;

public class Decomposition {
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// 작은 생성자를 구하는 것이기 때문에 작은수부터 올라가기
		for (int i = 0; i < N; i++) {
			int num = i; // i를 그대로 쓰면 while문 내에서 오류 생기므로 새로운 변수 생성
			int sum = 0; // 각 자릿수의 합은 i가 바뀔 때 마다 0으로 초기화
			while (num != 0) {
				sum += num % 10; // 각 자릿수의 합
				num /= 10;
			}

			if (sum + i == N) {
				result = i;
				break;
			}

		}
		System.out.println(result);

	}

}
