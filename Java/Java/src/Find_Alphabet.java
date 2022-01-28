import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Find_Alphabet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 알파벳 넣을 배열 생성
		int arr[] = new int[26];

		// 입력받기 위한 단어
		String s = br.readLine();

		for (int i = 0; i < 26; i++)
			arr[i] = -1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// 중복된 단어일 때는, 처음 등장하는 위치를 출력해야 하므로
			// 배열의 인덱스가 -1일 때라는 조건을 줌
			if (arr[c - 'a'] == -1)
				arr[c - 'a'] = i;
		}

		for (int a : arr)
			System.out.print(a + " ");

	}

}
