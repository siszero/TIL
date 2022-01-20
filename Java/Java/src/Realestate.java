// 오래걸림. 처음에 한 코드는 
// 15 2
// 2 8 하면 안됨. 4 8 하면 되는데		-> 	부모노드 까지만 인식

import java.io.*;
import java.util.StringTokenizer;

public class Realestate {
	static int N, Q;
	static int duck;
	static boolean[] tmp;
	static int ducks=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); // 땅의 수
		Q = Integer.parseInt(st.nextToken()); // 오리 수

		tmp = new boolean[N + 1];

		for(int i =0; i<Q; i++) {
			int res = 0;
			int duck = Integer.parseInt(br.readLine());	// 오리 한마리씩 땅 정하기
			ducks=duck;
			// 오리가 정한 땅에서부터 루트찾아서 올라가기(부모루트로 하나씩 올라가기)
			while(duck!=1) {
				// 땅 소유주가 이미 있을 때
				if(tmp[duck])
					res = duck;	// 소유주가 있는 땅 때문에 땅을 가지지 못함. 그 소유주가 있는 땅을 출력해야함.
				duck/=2;	// 부모 루트로 올라가기 위함
			}
			tmp[ducks]=true;
			// 소유주가 있는 땅을 갔을 때 : 해당 땅의 번호 출력
			// 소유주 없었을 때 초기값인 0 그대로 출력
			sb.append(res).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}