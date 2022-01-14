/*
 * 출력 오류로 틀렸던 부분
 * 1. 처음에 while문 밖에 clock 정의해서 틀림
 * 2. 시가 24 될 때, 분이랑 초가 60 될 때의 if문을 if, else if, else if 로 써줘서 01:00:00 같은 경우를 제대로 못찾아냄
 */

import java.io.*;
import java.util.StringTokenizer;

public class Digital_clock {
	static int h, m, s, lh, lm, ls;
	static int clock;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

//		System.out.println();
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 처음시각
			String[] first_clock = st.nextToken().split(":");
			h = Integer.parseInt(first_clock[0]);
			m = Integer.parseInt(first_clock[1]);
			s = Integer.parseInt(first_clock[2]);

			// 나중시각
			String[] last_clock = st.nextToken().split(":");
			lh = Integer.parseInt(last_clock[0]);
			lm = Integer.parseInt(last_clock[1]);
			ls = Integer.parseInt(last_clock[2]);

			int cnt = 0; // 다음 줄의 입력으로 넘어갈 때 cnt 초기화
			while (true) {
				clock = h * 10000 + m * 100 + s;
//				System.out.println(clock);
				// 3의 배수이면
				if ((clock % 3) == 0)
					cnt++;
//				System.out.println(cnt);

				// 처음시각과 나중시각이 같아질 때 끝내기
				if (h == lh && m == lm && s == ls)
					break;

				s++;

				// 초가 60이면 0으로 바꾸고 분을 +1 해주기
				if (s == 60) {
					s = 0;
					m++;
				}
				if (m == 60) {
					m = 0;
					h++;
				}
				if (h == 24)
					h = 0;
			}
//			System.out.print(cnt+"\n");		// -> 왜 이렇게 하면 안될까?
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
