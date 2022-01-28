import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Find_Alphabet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ���ĺ� ���� �迭 ����
		int arr[] = new int[26];

		// �Է¹ޱ� ���� �ܾ�
		String s = br.readLine();

		for (int i = 0; i < 26; i++)
			arr[i] = -1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// �ߺ��� �ܾ��� ����, ó�� �����ϴ� ��ġ�� ����ؾ� �ϹǷ�
			// �迭�� �ε����� -1�� ����� ������ ��
			if (arr[c - 'a'] == -1)
				arr[c - 'a'] = i;
		}

		for (int a : arr)
			System.out.print(a + " ");

	}

}
