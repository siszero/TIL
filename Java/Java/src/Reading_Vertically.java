import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Reading_Vertically {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = new String[5];
		String result = "";
		int max = 0;

		// �ټ��� �Է¹���
		for (int i = 0; i < input.length; i++) {
			input[i] = br.readLine();

			// ���� �� ���� ���� (Math.max() �Լ� ����)
			max = Math.max(max, input[i].length());

		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (input[j].length() > i)
					result += input[j].charAt(i);
			}
		}
		bw.write(result + "\n");

		bw.close();
	}

}
