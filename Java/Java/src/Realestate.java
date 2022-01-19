import java.io.*;
import java.util.StringTokenizer;

public class Realestate {
	static int N, Q;
	static int[] ducks;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	//	���� ��
		Q = Integer.parseInt(st.nextToken());	//	���� ��
		
		ducks = new int[Q];	// �迭 ����
		for(int i =0; i<Q;i++) 
			ducks[i]=Integer.parseInt(br.readLine());
		
		root();
		br.close();
	}

	static void root() {
		StringBuilder sb = new StringBuilder();
		visit = new boolean[N+1];
		for(int i:ducks) {
			int answer = 0;
			int tmp=i;
			//  ���� ���ϴ� ������ ���� ��Ʈ�� �̵�
			while(i!=1) {
				if(visit[i])
					answer=i;
				i>>=1;
			}
			visit[tmp]=true;
			sb.append(answer).append('\n');
		}
		System.out.println(sb.toString());
	}
}
