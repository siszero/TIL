package string;

import java.util.Scanner;

public class Boj_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int sum = 0;
		String num = sc.next();

		for (int i = 0; i < num.length(); i++) {
			sum += (num.charAt(i) - '0');
		}

		System.out.println(sum);

	}

}
