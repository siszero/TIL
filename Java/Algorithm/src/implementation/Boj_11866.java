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
		
		int index = 0;	// ����Ʈ���� ������ ��Ҹ� ������ �ε��� ����
		
		while(N > 1) {
			// �ε����� 0���� �����ϱ� ������ k-1 ���ֱ�
			index = (index + (K - 1)) % N;
			
			// index��ġ�� �ִ� ��Ҹ� �����԰� ���ÿ� ��� 
			sb.append(list.remove(index)).append(", "); 
			N--;
		}
		
		// ���������� ���� ��� �����԰� ���ÿ� ���
		sb.append(list.remove()).append('>');
		System.out.println(sb);
		
		
	}
}

/*
 * ť ���
Queue<Integer> q;	// 1~N���� ť�� �ԷµǾ��ִٰ� ����
int K;	// K��° ��
 
while(!q.isEmpty()) {
 
	// K-1�� �տ� �ִ� ���Ҹ� �ڷ� ������.
	for(int i = 0; i < K - 1; i++) {
		int val = q.poll();
		q.offer(val);
	}
 
	print(q.poll());	// K��°�� ������ ���Ҹ� �����԰� ���ÿ� ����Ѵ�.
}

*/
