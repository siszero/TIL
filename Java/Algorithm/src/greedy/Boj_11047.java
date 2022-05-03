package greedy;

import java.io.*;
import java.util.*;

public class Boj_11047 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int num = 0;
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			int A = Integer.parseInt(br.readLine());
			
			arr[i] = A;
		}
		
		
		
		for(int i = N-1; i >=0; i--) {
			if(K !=0) {
				if(arr[i] <= K) {
					num += K / arr[i];
					K %= arr[i];
				}
			}
		}
		
		System.out.println(num);

		
	}

}
