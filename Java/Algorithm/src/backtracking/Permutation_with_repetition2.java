/*
 * Permutation_with_repetition�� �ð��ʰ��� ���� -> Scanner��� BufferReader, BufferWriter ���
 * Scanner : ���� �Է��� ������� Space Enter�� ��� ���� �ν�.
 * BufferedReader : Enter�� ���� �ν�, ���� �����Ͱ� String���� ����.
 * 	- Scanner�� ���� �ټ� ����ϱ� ���������� ���� ���� �����͸� �Է¹������ BufferedReader�� �Է¹޴� ���� ȿ����
 * 	- ����ó���� �� ���־���Ѵ�.(���������� throws IOException�� ���Ͽ� ����ó��, try & catch�� Ȱ���Ͽ� ����ó�� ���� ����)
 *  - Space�� ���� �ν��ϱ� ���� �� ���� ���
 * 		1.  StringTokenizer�� nextToken()�Լ��� ���� ���� ������ ����.
 *  	2. String.split �Լ��� Ȱ��
 */

package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Permutation_with_repetition2 {

	private static int[] arr; // ���� ��Ƶ� �迭
	private static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	// N������ �� �߿��� M�� ����
	public static void main(String[] args) throws IOException {	// ����ó��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// ����
		// Enter���� ���� �ν��ϱ⿡ ���鸶�� ������ ��� �迭�� ����
		// String array[] = s.split(" ");
		String s = br.readLine();
		N = Integer.parseInt(s.split(" ")[0]);
		M = Integer.parseInt(s.split(" ")[1]);


		arr = new int[M]; // ���� ��Ƶ� �迭�� ũ�⸦ M����
		nPir(0); // ó�� 0
		bw.close();
	}

	private static void nPir(int cnt) throws IOException{
		if (cnt == M) { // ���̰� M�� �� ��, ���ϴ� ���̸�ŭ �� ä������
			for (int i = 0; i < M; i++)
				bw.write(arr[i] + " ");
			bw.newLine();
			return;
		}
		// �� ä������ �� ��ȸ�ϸ� ���ڸ� ������
		for (int i = 1; i <= N; i++) {
			arr[cnt] = i;
			nPir(cnt + 1);
		}

	}

}