// ���ڿ��� �޾Ƽ� ���� �ϳ��ϳ� ���ϱ�

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_toCase {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			if (Character.isLowerCase(str.charAt(i)))
				System.out.print(Character.toUpperCase(str.charAt(i)));
			else
				System.out.print(Character.toLowerCase(str.charAt(i)));
		}
	}
}
