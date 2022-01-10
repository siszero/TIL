// 난쟁이 9명 중 7명이 진짜
// 일곱 난쟁이 키의 합은 100

import java.util.Arrays;
import java.util.Scanner;

public class Seventh_Dwarf {
	static int[] height = new int[9];
	static int sum = 0;
	static int spy1 = 0, spy2 = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 아홉 난쟁이 키 입력
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
			sum += height[i]; // 9명 키의 합
		}
		Arrays.sort(height); // 오름차순으로 정렬

		// 2명만 찾아내면 됨 -> 브루트 포스 알고리즘
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
