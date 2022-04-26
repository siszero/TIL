package datastructure;

import java.io.*;
import java.util.*;

public class Boj_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int suNo = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		
		long[] S = new long[suNo + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= suNo; i++)
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		
		for(int i = 0;i<quizNo; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(S[b]-S[a-1]);
		}
		
		
	}

}
