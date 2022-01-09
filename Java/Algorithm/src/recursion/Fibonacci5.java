package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci5 {
	static int N;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		System.out.println(Fib(N));
	}

	private static int Fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return Fib(n - 1) + Fib(n - 2);
	}

}
