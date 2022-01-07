/*
 * Permutation_with_repetition은 시간초과로 실패 -> Scanner대신 BufferReader, BufferWriter 사용
 * Scanner : 통해 입력을 받을경우 Space Enter를 모두 경계로 인식.
 * BufferedReader : Enter만 경계로 인식, 받은 데이터가 String으로 고정.
 * 	- Scanner에 비해 다소 사용하기 불편하지만 많은 양의 데이터를 입력받을경우 BufferedReader로 입력받는 것이 효율적
 * 	- 예외처리를 꼭 해주어야한다.(보편적으로 throws IOException을 통하여 예외처리, try & catch를 활용하여 예외처리 또한 가능)
 *  - Space를 경계로 인식하기 위한 두 가지 방법
 * 		1.  StringTokenizer에 nextToken()함수를 통한 공백 단위의 구분.
 *  	2. String.split 함수를 활용
 */

package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Permutation_with_repetition2 {

	private static int[] arr; // 숫자 담아둘 배열
	private static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	// N까지의 수 중에서 M개 고르기
	public static void main(String[] args) throws IOException {	// 예외처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 선언
		// Enter만을 경계로 인식하기에 공백마다 데이터 끊어서 배열에 넣음
		// String array[] = s.split(" ");
		String s = br.readLine();
		N = Integer.parseInt(s.split(" ")[0]);
		M = Integer.parseInt(s.split(" ")[1]);


		arr = new int[M]; // 숫자 담아둘 배열의 크기를 M으로
		nPir(0); // 처음 0
		bw.close();
	}

	private static void nPir(int cnt) throws IOException{
		if (cnt == M) { // 깊이가 M일 때 즉, 원하는 길이만큼 다 채워지면
			for (int i = 0; i < M; i++)
				bw.write(arr[i] + " ");
			bw.newLine();
			return;
		}
		// 다 채워지기 전 순회하며 숫자를 선택함
		for (int i = 1; i <= N; i++) {
			arr[cnt] = i;
			nPir(cnt + 1);
		}

	}

}