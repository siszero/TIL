/*
 * �ڹٿ��� ������ �ִ�, �ּڰ� ���
 * Integer Ŭ������ MAX_VALUE, MIN_VALUE ����ϱ�
 * Integer.MAX_VALUE	// 2147483647
 * Integer.MIN_VALUE	// -2147483648
 */

import java.util.Scanner;

public class Operator2 {
	private static int N;
	private static int[] num;
	private static int[] operator;
	// �ִ� �ּ� �ʱ�ȭ
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		num = new int[N];
		operator = new int[4];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}

		operate(1, num[0]);

		System.out.println(max);
		System.out.println(min);
	}

	// value�� ���� ����, sum�� �������� ���� ��
	public static void operate(int value, int sum) {
		
		// ��� ���ڸ� �� ������� ��
		if (value == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		// ������ �� ���� �� Ȯ��
		for (int i = 0; i < 4; i++) {
			// �� �������� ������ 0�� �Ǹ� �� �����ڰ� ��� if�� ���� ����
			if (operator[i] != 0) {
				operator[i]--;		// �����ڰ� ���̸� ������ �ϳ� �ٿ���
				if (i == 0) // ����
					operate(value + 1, sum + num[value]);
				else if (i == 1) // ����
					operate(value + 1, sum - num[value]);
				else if (i == 2) // ����
					operate(value + 1, sum * num[value]);
				else if (i == 3) // ������
					operate(value + 1, sum / num[value]);
				operator[i]++;
			}
		}
	}
}
