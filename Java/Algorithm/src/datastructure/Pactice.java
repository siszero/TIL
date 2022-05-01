package datastructure;

public class Pactice {

	public static void main(String[] args) {
		String[] str = {"mournful gladness melancholy", "good thrilled mournful"};
		String[] arr = new String[str.length];
		String[] answer = new String[str.length];
		
		String[] happy = {"good", "thrilled"};
		String[] angry = {"annoyed", "dd"};
		String[] sad = {"mournful", "melancholy"};
		String[] joy = {"gladness", "ddd"};
		
		
		for(int i =0; i<str.length; i++) {
			int hcnt = 0;
			int acnt = 0;
			int scnt = 0;
			int jcnt = 0;
			
			arr = str[i].split(" ");
			for(int j=0;j<arr.length;j++) {
//				System.out.println(i + "는  " + arr[j]);
				for(int k =0; k<2; k++) {
					if(arr[j].contains(happy[k]))
						hcnt++;
					// angry 배열에 한개만있으면 오류 그럼 어떻게 하지?
					else if(arr[j].contains(angry[k]))
						acnt++;
					else if(arr[j].contains(sad[k]))
						scnt++;
					else if(arr[j].contains(joy[k]))
						jcnt++;
				}
				
			}
			// 가장 큰 값 구하기 (max 처럼)
			
			// 삼항연산자!?!
			if(hcnt > acnt && hcnt>scnt && hcnt >jcnt)
				answer[i] = "happy";
			else if(acnt > hcnt && acnt>scnt && acnt >jcnt)
				answer[i] = "angry";
			else if(scnt > hcnt && scnt>acnt && scnt >jcnt)
				answer[i] = "sad";
			else if(jcnt > hcnt && jcnt>acnt && jcnt >scnt)
				answer[i] = "joy";
		}
		
		// contain 함수?!
		// happy가 많은지 sad가 많은 지 보려면 if문을 여러개? 아님 방법이?!! ?이거 쓰기?

		for(int i =0; i<answer.length;i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
