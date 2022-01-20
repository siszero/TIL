package greedy;

// 오름차순 정렬 -> 공포도 낮은 모험가부터 하나씩 확인
// '현재 그룹에 포함된 모험가의 수' 가 '현재 확인하고 있는 공포도'보다 크거나 같다면 이를 그룹으로 설정하면 됨
// -> 공포도가 오름차순 정렬이 되어 있다는 점에서 항상 최소한의 모험가의 수만 포함하여 그룹을 결성하게 됨

import java.util.*;

public class Fear {
	public static int n;
	public static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++)
			list.add(sc.nextInt());
		Collections.sort(list);	// 오름차순 정렬
		
		int result = 0;	// 총 그룹의 수
		int count = 0;	// 현재 그룹에 포함된 모험가의 수
		for(int i =0;i<n;i++) {		// 공포도를 낮은 것부터 하나씩 확인
			count +=1;		// 현재 그룹에 해당 모험가를 포함시키기
			if(count>=list.get(i)) {	// 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
				result+=1;		// 총 그룹의 수 증가시키기
				count=0;		// 현재 그룹에 포함된 모험가의 수 초기화
			}
		}
		System.out.println(result);
		
	}

}
