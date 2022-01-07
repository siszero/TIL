package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
	static int result = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println(factorial(N));
	}

	private static int factorial(int N) {
		if (N <= 1 ) 		// 1일 때 재귀 종료 후 반환
			return 1;
		return N * factorial(N - 1);
	}

}
