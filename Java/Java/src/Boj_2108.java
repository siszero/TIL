import java.util.*;

public class Boj_2108 {

	static int N, sum;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		sum = 0;

		for (int i = 0; i < N; i++) {
			int M = sc.nextInt();
			arr[i] = M;
			sum += arr[i];
		}
		Arrays.sort(arr);

		System.out.println(average());
		System.out.println(median());
		System.out.println(mode());
		System.out.println(range());

	}
	
	static int average() {
		int result = (int)Math.round((double)sum / N); // 반올림 후 저장
		return result;
	}

	static int median() {
		return arr[arr.length / 2];
	}

	static int mode() {
		int cnt = 0;
		int max = -1;
		int mod = arr[0];
		boolean check = false;

		for (int i = 0; i < N - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				cnt++;
			}
			else {
				cnt = 0;
			}
			if (max < cnt) {
				max = cnt;
				mod = arr[i];
				check = true;
			}
			else if (max == cnt && check == true) {
				mod = arr[i];
				check = false;	// check는 빈도수가 모두 같을 때 두번째로 작은 수를 구하기 위해 필요하다.
			}
		}
		return mod;
	}

	static int range() {
		if (N == 1) {
			return 0;
		}
		return arr[N - 1] - arr[0];
	}

}
