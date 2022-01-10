// ������ 9�� �� 7���� ��¥
// �ϰ� ������ Ű�� ���� 100

import java.util.Arrays;
import java.util.Scanner;

public class Seventh_Dwarf {
	static int[] height = new int[9];
	static int sum = 0;
	static int spy1 = 0, spy2 = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ��ȩ ������ Ű �Է�
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
			sum += height[i]; // 9�� Ű�� ��
		}
		Arrays.sort(height); // ������������ ����

		// 2�� ã�Ƴ��� �� -> ���Ʈ ���� �˰���
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - height[i] - height[j] == 100) {
					spy1 = height[i];
					spy2 = height[j];
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (height[i] != spy1 && height[i] != spy2)
				System.out.println(height[i]);
		}
	}

}
