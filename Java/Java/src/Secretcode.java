import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Secretcode {
	static char alpha;
	static int  gap;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();		// ��
		String key = br.readLine();			// ��ȣȭ Ű
		
		
		System.out.println(encrypt(text,key));
		
	}
	
	 private static StringBuilder encrypt(String text, String key) {
		 StringBuilder cipherText = new StringBuilder();
		 
		 for(int i=0;i<text.length();i++) {
				// n i c e  d a y
				alpha = text.charAt(i);		// charAt()���� ���忡�� �� ���ھ� ���� �� ����
				
				// ����(space)�� �ƴ� ���ĺ��� ���� ��
				if(alpha!= ' ') {
//					���ظ� ���� ���..
//					System.out.println(key.charAt(i%key.length()));	//l  o	v
//					System.out.println('l');	// l  
//					System.out.println('l'-96);	// 12	
//					gap = (key.charAt(i%key.length())-96);	//12	15	22
					
					// a�� �ƽ�Ű�ڵ� 97
					// ���� 'l' �̶�� �ƽ�Ű�ڵ�� 108
					// a�� 1�� �ΰ� �ʹ� �ϸ� l�� 108-97+1 = 12
					gap = (key.charAt(i%key.length())-96);
					cipherText.append((char)(alpha-gap<97?(alpha-gap+26):alpha-gap));
					
				}
					
				else
					cipherText.append(' ');
			}
		return cipherText;
		
		
	}
}
