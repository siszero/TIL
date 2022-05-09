package posco;

import java.util.Scanner;

public class Test03_15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		String str = Integer.toString(N);
		
		for(int i =0; i<str.length(); i+=2) {
			str.substring(i,i+1);
			
		}

	}

}
