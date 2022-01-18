import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Decimal {
	static String N;
	static int B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = st.nextToken();
		B = Integer.parseInt(st.nextToken());

		int dec = 0;
		for (int i = 0; i < N.length(); i++) {
			char c = N.charAt(i); // �� ���ھ� ����
			if ('A' <= c && c <= 'Z') // ���ڰ� A�� Z ������ ��
				// ���������� ��Ÿ���� ���ؼ�
				dec = dec * B + ((c - 'A') + 10); // ���������� 'A' �� 65
			else	// 0~9 ���̴� �״�� ���
				// ���������� '0'�� 48 c�� ���� char��. �׷��⿡ c�� 1�̸� ���������� 49
				dec = dec * B + (c - '0');	
		}
		System.out.println(dec);
	}
}
