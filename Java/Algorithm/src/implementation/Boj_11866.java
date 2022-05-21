import java.io.*;
import java.util.*;

public class Boj_11866 {
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> list = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <=N; i++) {
			list.add(i);
		}
		
		sb.append('<');
		
		int index = 0;	// 리스트에서 삭제할 요소를 참조할 인덱스 변수
		
		while(N > 1) {
			// 인덱스가 0부터 시작하기 때문에 k-1 해주기
			index = (index + (K - 1)) % N;
			
			// index위치에 있는 요소를 삭제함과 동시에 출력 
			sb.append(list.remove(index)).append(", "); 
			N--;
		}
		
		// 마지막으로 남은 요소 삭제함과 동시에 출력
		sb.append(list.remove()).append('>');
		System.out.println(sb);
		
		
	}
}

/*
 * 큐 사용
Queue<Integer> q;	// 1~N까지 큐에 입력되어있다고 가정
int K;	// K번째 수
 
while(!q.isEmpty()) {
 
	// K-1번 앞에 있는 원소를 뒤로 보낸다.
	for(int i = 0; i < K - 1; i++) {
		int val = q.poll();
		q.offer(val);
	}
 
	print(q.poll());	// K번째로 나오는 원소를 삭제함과 동시에 출력한다.
}

*/
