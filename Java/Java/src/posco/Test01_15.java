package posco;

import java.util.*;

public class Test01_15 {

	public static void main(String[] args) {
		
		// HashSet : ����ϸ� ���� ��� X 
		// LinkedHashSet : ���� ���� ������� ���� ����
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
//		String[] teamIDs = {"aaa", "bbb", "ccc"};
//		String[] additional = {"os", "yy", "aaa", "os"};
		
		String[] teamIDs = {"A", "B"};
		String[] additional = {"A", "C", "C", "B", "F", "S"};
		

		for(int i =0; i<additional.length; i++) {
			int cnt = 0;
			
			for(int j = 0; j<teamIDs.length; j++) {
				if(additional[i].equals(teamIDs[j])) {
					cnt++;
				}
			}
			if(cnt == 0) {
				set.add(additional[i]);
			}
			
		}
		System.out.println(set);
		
		// os�� �ڿ� ���ͼ� ������ yy os�� ��..
//		HashMap<String, Integer> map = new HashMap<>();
//		for(int i =0 ;i<teamIDs.length; i++) {
//			map.put(teamIDs[i], 1);
//		}
//		for(int i =0 ;i<teamIDs.length; i++) {
//			map.put(additional[i], map.getOrDefault(additional[i], 0));
//		}
//		for (String key : map.keySet()) {
//			if(map.get(key) == 0) {
//				System.out.print(key + " ");
//			}
//
//		}
	}

}
