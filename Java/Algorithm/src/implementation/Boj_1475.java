import java.util.*;

public class Boj_1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();		// 자르기 위해 string으로 입력받기

		int size = str.length();
		int[] arr = new int[10];
		int temp = 0;
		int max = 0;

		// 각 숫자가 몇 번 나왔는지 세기 위해 배열이용
		for (int i = 0; i < size; i++) {
			temp = str.charAt(i) - '0';
			arr[temp]++;
		}

		// 6이랑 9는 같은 숫자로 생각
		int sum = arr[6] + arr[9];

		if (sum % 2 == 0) {
			arr[6] = sum / 2;
			arr[9] = sum / 2;
		} else {
			arr[6] = sum / 2 + 1;
			arr[9] = sum / 2 + 1;
		}

		// 가장 큰 수 출력
		for (int i : arr) {
			max = Math.max(max, i);
		}

		System.out.println(max);

	}

}
