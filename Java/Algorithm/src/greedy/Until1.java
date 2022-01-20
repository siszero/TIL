package greedy;

import java.util.Scanner;

public class Until1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0;
		while (true) {
			if (n == 1)
				break;
			if (n % k == 0) {
				n /= k;
				cnt++;
			} else {
				n--;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

/*
예시 답안

while(true) {
	// N이 K로 나누어 떨어지는 수가 될 때까지 빼기
	int target = (n/k)*k;
	result += (n-target);
	n=target;
	// N이 K보다 작을 때(더 이상 나눌 수 없을 때) 반복문 탈출
	if(n<k)
		break;
	// K로 나누기
	result +=1;
	n/=k;
}
result+=(n-1);System.out.println(result);
*/