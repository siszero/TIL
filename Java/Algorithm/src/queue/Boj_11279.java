package queue;

// StringBuilder 안 쓰면 시간 초과
import java.util.*;

public class Boj_11279 {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			pq.add(num);
			if (num == 0) {
				sb.append(pq.poll()+"\n");
			}

		}
		System.out.println(sb);
	}

}
