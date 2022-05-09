package string;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[26];

		for (int i = 0; i < arr.length; i++) {
			// ÃÊ±âÈ­
			arr[i] = -1;
		}

		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - 'a';
			if (arr[num] == -1) {
				arr[num] = i;
			}
		}
		for(int i = 0; i<arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);

//		for(int i = 0; i<arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println(Arrays.toString(arr));

	}

}
