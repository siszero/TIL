package bruteforcing;

import java.util.Scanner;

public class Pernutation {
	static int N,M;
	static boolean[] isSelected;
	static int[] output;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		isSelected = new boolean[N+1];
		output = new int[N+1];
		
		// nPr: 서로 다른 n개 중 r개를 선택하는 경우(순서 o)
		nPr(0);
	}

	private static void nPr(int cnt) {
		if(cnt== M) {
			for(int i=0;i<M;i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(isSelected[i])
				continue;
			
			output[cnt] = i;
			isSelected[i] = true;
			nPr(cnt+1);
			isSelected[i] = false;
		}
		
	}
}
