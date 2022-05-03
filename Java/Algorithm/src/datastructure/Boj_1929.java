package datastructure;

// �Ҽ����ϱ�
// �ٽ� �̷� : �����佺�׳׽��� ü ����

import java.util.*;

public class Boj_1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		for(int i = 2; i<=N; i++) {
			arr[i] = i;
		}
		
		// N�� �����ٱ��� Ȯ�� ( N���� ���� ���ڴ� �׻� N�� �����ٺ��� ���� ����� ���´�.)
		for(int i =2; i<= Math.sqrt(N); i++) {
			if(arr[i] == 0) {
				continue;
			}
			
			// ��������
			for(int j = i+i; j<=N; j= j+i) {
				arr[j] = 0;
			}
		}
		
		for(int i =M; i<=N; i++) {
			if(arr[i] != 0)
				System.out.println(arr[i]);
		}
		

	}

}
