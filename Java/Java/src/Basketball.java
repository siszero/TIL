// Ǯ�� : string���� �Է¹ް� ���ĺ� ù �ڸ��� �����ͼ� �� �迭�� �´� ��ġ�� 1�� ������Ų��.
// ���� : 'a'�� 97(a�� �ƽ�Ű�ڵ�)�� ���ų� ���ϱ�

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Basketball {
	static int N;
	static int[] alpha;
	static String name;
	static boolean chk; // boolean ó���� ���� �����ָ� false

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		alpha = new int[26];

		// ���� ������ ++
		for (int i = 0; i < N; i++) {
			name = br.readLine();

			// ���� ù �ڸ��� b��� 98�� �ǹ��� ����. alpha�� a��0, b��1, c��2 �� �����ϱ⿡
			// 98���� a�� �ƽ�Ű�ڵ� 97�� ������� 1�� �Ǿ� alpha[1]++ �� ��.
			alpha[name.charAt(0) - 'a']++; // 'a'�� �ƽ�Ű�ڵ�� 97 'a'��� 97�� ����
		}

		for (int i = 0; i < 26; i++) {
			if (alpha[i] >= 5) {
				chk = true;

				// ���� �ݴ�� �ش� �ε����� ���ĺ��� ����� ���� 'a'�� ���ؾ� ��
				// bw.write((char)(98));�� �����ϸ� b �� ��µ�
				bw.write((char) (i + 'a'));
			}
		}

		if (!chk)
			bw.write("PREDAJA\n");

		bw.close();
	}

}
