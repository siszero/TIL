import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Secretcode {
	static char alpha;
	static int  gap;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();		// 평문
		String key = br.readLine();			// 암호화 키
		
		
		System.out.println(encrypt(text,key));
		
	}
	
	 private static StringBuilder encrypt(String text, String key) {
		 StringBuilder cipherText = new StringBuilder();
		 
		 for(int i=0;i<text.length();i++) {
				// n i c e  d a y
				alpha = text.charAt(i);		// charAt()쓰면 문장에서 한 문자씩 빼낼 수 있음
				
				// 공백(space)이 아닌 알파벳이 있을 때
				if(alpha!= ' ') {
//					이해를 위한 출력..
//					System.out.println(key.charAt(i%key.length()));	//l  o	v
//					System.out.println('l');	// l  
//					System.out.println('l'-96);	// 12	
//					gap = (key.charAt(i%key.length())-96);	//12	15	22
					
					// a의 아스키코드 97
					// 만약 'l' 이라면 아스키코드로 108
					// a를 1로 두고 싶다 하면 l은 108-97+1 = 12
					gap = (key.charAt(i%key.length())-96);
					cipherText.append((char)(alpha-gap<97?(alpha-gap+26):alpha-gap));
					
				}
					
				else
					cipherText.append(' ');
			}
		return cipherText;
		
		
	}
}
