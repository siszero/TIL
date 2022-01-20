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
���� ���

while(true) {
	// N�� K�� ������ �������� ���� �� ������ ����
	int target = (n/k)*k;
	result += (n-target);
	n=target;
	// N�� K���� ���� ��(�� �̻� ���� �� ���� ��) �ݺ��� Ż��
	if(n<k)
		break;
	// K�� ������
	result +=1;
	n/=k;
}
result+=(n-1);System.out.println(result);
*/