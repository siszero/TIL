/*
 * ��� ������ Ʋ�ȴ� �κ�
 * 1. ó���� while�� �ۿ� clock �����ؼ� Ʋ��
 * 2. �ð� 24 �� ��, ���̶� �ʰ� 60 �� ���� if���� if, else if, else if �� ���༭ 01:00:00 ���� ��츦 ����� ��ã�Ƴ�
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

			// ó���ð�
			String[] first_clock = st.nextToken().split(":");
			h = Integer.parseInt(first_clock[0]);
			m = Integer.parseInt(first_clock[1]);
			s = Integer.parseInt(first_clock[2]);

			// ���߽ð�
			String[] last_clock = st.nextToken().split(":");
			lh = Integer.parseInt(last_clock[0]);
			lm = Integer.parseInt(last_clock[1]);
			ls = Integer.parseInt(last_clock[2]);

			int cnt = 0; // ���� ���� �Է����� �Ѿ �� cnt �ʱ�ȭ
			while (true) {
				clock = h * 10000 + m * 100 + s;
//				System.out.println(clock);
				// 3�� ����̸�
				if ((clock % 3) == 0)
					cnt++;
//				System.out.println(cnt);

				// ó���ð��� ���߽ð��� ������ �� ������
				if (h == lh && m == lm && s == ls)
					break;

				s++;

				// �ʰ� 60�̸� 0���� �ٲٰ� ���� +1 ���ֱ�
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
//			System.out.print(cnt+"\n");		// -> �� �̷��� �ϸ� �ȵɱ�?
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
