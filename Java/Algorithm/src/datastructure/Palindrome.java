package datastructure;

public class Palindrome {

	public static void main(String[] args) {
		int start = 1;
		int end = 100;
		
		String st = "" + start;
		String fn = "" + end;
		
		for(int i =start; i<end;i++) {
			String str = "" + i;
			
			for(int j = 0; j<str.length(); j++)
				
				System.out.print(str.substring(j, j+1) + " ");
			System.out.println();
		}
		

	}

}
