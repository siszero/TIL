/*
 * ó���� ���� ���� �����ڸ� ���ؾ� �ϴ� ���� �ν����� ���ؼ� �ڿ������� �ϳ��� ���� ���� ���Ϸ��� �ϴٺ��� ����
 */
import java.util.Scanner;

public class Decomposition {
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// ���� �����ڸ� ���ϴ� ���̱� ������ ���������� �ö󰡱�
		for (int i = 0; i < N; i++) {
			int num = i; // i�� �״�� ���� while�� ������ ���� ����Ƿ� ���ο� ���� ����
			int sum = 0; // �� �ڸ����� ���� i�� �ٲ� �� ���� 0���� �ʱ�ȭ
			while (num != 0) {
				sum += num % 10; // �� �ڸ����� ��
				num /= 10;
			}

			if (sum + i == N) {
				result = i;
				break;
			}

		}
		System.out.println(result);

	}

}
