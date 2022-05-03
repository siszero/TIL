package greedy;

import java.util.*;

public class Boj_1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String[] arr = str.split("-");

		int answer = 0;

		for (int i = 0; i < arr.length; i++) {
			// - ���� ������ ������ ���ϴ� �Լ��� �ֱ�
			int plus = Plus(arr[i]);

			// ù ��° ���� ���
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
		String plus[] = i.split("\\+"); // + �����ڴ� ����� �� �տ� \\ ���ֱ�

		for (int a = 0; a < plus.length; a++) {
			// string �̾ int�� ��ȯ ---> 0010�̶�� ���� �ԷµǾ 10���� �ٲ�
			sum += Integer.parseInt(plus[a]);
		}

		return sum;
	}
}
