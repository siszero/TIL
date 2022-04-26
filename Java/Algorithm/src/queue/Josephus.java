package queue;

import java.util.*;

public class Josephus {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		
		for(int i=0;i<n;i++)
			q.offer(i+1);		// 1부터 넣어주기 때문에
		
		System.out.print("<");
		
		while(q.size()>1) {		// !q.isEmpty()
			
			// k의 배수가 아닌 값 빼내고 그 값을 다시 맨 뒤로
			for(int i =0;i<k-1;i++) {
				int val = q.poll();		// 값 빼고 새로운 변수에 넣어주기
				q.offer(val);			// 그 값 다시 넣기
			}
			System.out.print(q.poll() + ", ");
		}
		// 위의 while 문에서 q.size()>0 으로 해줬었는데 그렇게 되면 마지막 값 다음에 , 가 붙어서 나온다.
		// 그래서 가장 마지막 수는 남겨두고 밑에서 >와 함께 출력하도록 하였다.
		System.out.print(q.poll() + ">");
	}

}
