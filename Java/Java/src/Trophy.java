import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Trophy {
	static int N;
	static int[] arr;
	static int cnt_left = 1, cnt_right = 1;
	static int max_left = 0, max_right = 0;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		max_left = arr[0];

		for (int i = 1; i < N; i++) {
			if (arr[i] > max_left) {
				cnt_left++;
				max_left = arr[i];
			}
		}

		max_right = arr[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] > max_right) {
				cnt_right++;
				max_right = arr[i];
			}
		}
		System.out.println(cnt_left);
		System.out.println(cnt_right);
	}

}
