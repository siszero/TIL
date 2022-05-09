package posco;

import java.util.*;

public class Test02_15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] answer = new int[2];
		
		if(N %7 == 1) {
			answer[0] = (N/7)*2;
			answer[1] = answer[0]+1;
		}
		else if(N%7==6) {
			answer[0] = (N/7)*2 + 1;
			answer[1] = answer[0]+1;
		}
		else if(N%7==0) {
			answer[0] = (N/7)*2;
			answer[1] = answer[0];
		}
		else {
			answer[0] = (N/7)*2;
			answer[1] = answer[0] +2;
		}

		System.out.println(Arrays.toString(answer));
	}

}
