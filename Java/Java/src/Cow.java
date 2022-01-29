/*
 * 소의 위치가 바뀔 때 마다 answer++
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cow {
	static int n;
	static int[] cow;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		cow = new int[11];
		Arrays.fill(cow, -1);

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");

			int num = Integer.parseInt(temp[0]);
			int pos = Integer.parseInt(temp[1]);

			if (cow[num] == -1)
				cow[num] = pos;
			else if (cow[num] != pos) {
				cow[num] = pos;
				answer += 1;
			}

		}

		System.out.println(answer);
	}

}
