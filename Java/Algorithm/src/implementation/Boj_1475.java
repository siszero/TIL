import java.util.*;

public class Boj_1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();		// �ڸ��� ���� string���� �Է¹ޱ�

		int size = str.length();
		int[] arr = new int[10];
		int temp = 0;
		int max = 0;

		// �� ���ڰ� �� �� ���Դ��� ���� ���� �迭�̿�
		for (int i = 0; i < size; i++) {
			temp = str.charAt(i) - '0';
			arr[temp]++;
		}

		// 6�̶� 9�� ���� ���ڷ� ����
		int sum = arr[6] + arr[9];

		if (sum % 2 == 0) {
			arr[6] = sum / 2;
			arr[9] = sum / 2;
		} else {
			arr[6] = sum / 2 + 1;
			arr[9] = sum / 2 + 1;
		}

		// ���� ū �� ���
		for (int i : arr) {
			max = Math.max(max, i);
		}

		System.out.println(max);

	}

}
