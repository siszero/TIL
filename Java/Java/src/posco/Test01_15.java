package posco;

import java.util.*;

public class Test01_15 {

	public static void main(String[] args) {
		
		// HashSet : 사용하면 순서 고려 X 
		// LinkedHashSet : 순서 들어온 순서대로 저장 가능
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
		
		// os가 뒤에 들어와서 순서가 yy os가 됨..
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
