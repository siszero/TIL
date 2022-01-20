// �����ɸ�. ó���� �� �ڵ�� 
// 15 2
// 2 8 �ϸ� �ȵ�. 4 8 �ϸ� �Ǵµ�		-> 	�θ��� ������ �ν�

import java.io.*;
import java.util.StringTokenizer;

public class Realestate {
	static int N, Q;
	static int duck;
	static boolean[] tmp;
	static int ducks=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); // ���� ��
		Q = Integer.parseInt(st.nextToken()); // ���� ��

		tmp = new boolean[N + 1];

		for(int i =0; i<Q; i++) {
			int res = 0;
			int duck = Integer.parseInt(br.readLine());	// ���� �Ѹ����� �� ���ϱ�
			ducks=duck;
			// ������ ���� ���������� ��Ʈã�Ƽ� �ö󰡱�(�θ��Ʈ�� �ϳ��� �ö󰡱�)
			while(duck!=1) {
				// �� �����ְ� �̹� ���� ��
				if(tmp[duck])
					res = duck;	// �����ְ� �ִ� �� ������ ���� ������ ����. �� �����ְ� �ִ� ���� ����ؾ���.
				duck/=2;	// �θ� ��Ʈ�� �ö󰡱� ����
			}
			tmp[ducks]=true;
			// �����ְ� �ִ� ���� ���� �� : �ش� ���� ��ȣ ���
			// ������ ������ �� �ʱⰪ�� 0 �״�� ���
			sb.append(res).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}