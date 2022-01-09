// 풀이 : string으로 입력받고 알파벳 첫 자리만 가져와서 각 배열에 맞는 위치에 1씩 증가시킨다.
// 주의 : 'a'나 97(a의 아스키코드)를 빼거나 더하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Basketball {
	static int N;
	static int[] alpha;
	static String name;
	static boolean chk; // boolean 처음에 지정 안해주면 false

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		alpha = new int[26];

		// 성이 같으면 ++
		for (int i = 0; i < N; i++) {
			name = br.readLine();

			// 만약 첫 자리가 b라면 98을 의미할 것임. alpha는 a는0, b는1, c는2 로 생각하기에
			// 98에서 a의 아스키코드 97을 빼줘야지 1이 되어 alpha[1]++ 가 됨.
			alpha[name.charAt(0) - 'a']++; // 'a'는 아스키코드로 97 'a'대신 97도 가능
		}

		for (int i = 0; i < 26; i++) {
			if (alpha[i] >= 5) {
				chk = true;

				// 위와 반대로 해당 인덱스의 알파벳을 출력할 때는 'a'를 더해야 함
				// bw.write((char)(98));를 실행하면 b 가 출력됨
				bw.write((char) (i + 'a'));
			}
		}

		if (!chk)
			bw.write("PREDAJA\n");

		bw.close();
	}

}
