import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Decimal {
	static String N;
	static int B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = st.nextToken();
		B = Integer.parseInt(st.nextToken());

		int dec = 0;
		for (int i = 0; i < N.length(); i++) {
			char c = N.charAt(i); // 한 문자씩 끊기
			if ('A' <= c && c <= 'Z') // 문자가 A와 Z 사이일 때
				// 십진법으로 나타내기 위해서
				dec = dec * B + ((c - 'A') + 10); // 십진법으로 'A' 는 65
			else	// 0~9 사이는 그대로 출력
				// 십진법으로 '0'은 48 c가 현재 char임. 그렇기에 c가 1이면 십진법으로 49
				dec = dec * B + (c - '0');	
		}
		System.out.println(dec);
	}
}
