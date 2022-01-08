package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Combination {
	private static int[] arr;
	private static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// N까지의 수 중에서 M개 고르기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		String s = br.readLine();
		N = Integer.parseInt(s.split(" ")[0]);
		M = Integer.parseInt(s.split(" ")[1]);

		arr = new int[M];
		nCr(0,1);
		bw.close();
	}

	private static void nCr(int depth, int cur) throws IOException {
		if (depth == M) { // 깊이가 M일 때
			for (int i = 0; i < M; i++)
				bw.write(arr[i] + " ");
			bw.newLine();
			return;
		}
		for (int i = cur; i <= N; i++) {
			arr[depth] = i;
			nCr(depth + 1, i + 1);
		}
	}

}
