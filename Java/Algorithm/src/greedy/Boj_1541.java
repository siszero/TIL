package greedy;

import java.util.*;

public class Boj_1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String[] arr = str.split("-");

		int answer = 0;

		for (int i = 0; i < arr.length; i++) {
			// - 으로 나눠진 수들을 더하는 함수에 넣기
			int plus = Plus(arr[i]);

			// 첫 번째 수일 경우
			if (i == 0) {
				answer += plus;
			} else {
				answer -= plus;
			}
		}
		System.out.println(answer);

	}

	static int Plus(String i) {
		int sum = 0;
		String plus[] = i.split("\\+"); // + 연산자는 사용할 때 앞에 \\ 써주기

		for (int a = 0; a < plus.length; a++) {
			// string 이어서 int로 변환 ---> 0010이라고 수가 입력되어도 10으로 바뀜
			sum += Integer.parseInt(plus[a]);
		}

		return sum;
	}
}
