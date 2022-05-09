package string;

import java.util.*;
import java.io.*;

public class Boj_2675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			int M = Integer.parseInt(st[0]);
			String str = st[1];

			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}

	}

}
