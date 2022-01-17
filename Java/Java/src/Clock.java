// 완전 탐색
// contains() 함수 사용

import java.util.Scanner;

public class Clock {
	static int N, K;
	static int cnt = 0;
//	static String time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		// hour
		for (int h = 0; h <= N; h++) {
			// minute
			for (int m = 0; m < 60; m++) {
				// second
				for (int s = 0; s < 60; s++) {
					if (h % 10 == K || h / 10 == K || m % 10 == K || m / 10 == K || s % 10 == K || s / 10 == K)
						cnt++;
					
//					<contains() 함수 사용>
//					time = ((h < 10) ? "0" + h : "" + h) + ((m < 10) ? "0" + m : "" + m)
//							+ ((s < 10) ? "0" + s : "" + s);
//					if (time.contains("" + K))
//						cnt++;

				}
			}

		}
		System.out.println(cnt);

	}

}
