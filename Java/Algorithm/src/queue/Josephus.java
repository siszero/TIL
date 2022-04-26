package queue;

import java.util.*;

public class Josephus {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		
		for(int i=0;i<n;i++)
			q.offer(i+1);		// 1���� �־��ֱ� ������
		
		System.out.print("<");
		
		while(q.size()>1) {		// !q.isEmpty()
			
			// k�� ����� �ƴ� �� ������ �� ���� �ٽ� �� �ڷ�
			for(int i =0;i<k-1;i++) {
				int val = q.poll();		// �� ���� ���ο� ������ �־��ֱ�
				q.offer(val);			// �� �� �ٽ� �ֱ�
			}
			System.out.print(q.poll() + ", ");
		}
		// ���� while ������ q.size()>0 ���� ������µ� �׷��� �Ǹ� ������ �� ������ , �� �پ ���´�.
		// �׷��� ���� ������ ���� ���ܵΰ� �ؿ��� >�� �Բ� ����ϵ��� �Ͽ���.
		System.out.print(q.poll() + ">");
	}

}
