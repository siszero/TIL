package posco;

import java.util.*;

public class Test02_14 {

	public static void main(String[] args) {
//		int[] input = {1,2,3};
//		int[] input = {5, 5, 6, 7};
		int[] input = {9, 10, 9, 10};

		HashMap<Integer,Integer> map = new HashMap<>();
		Arrays.sort(input);
		int cnt = 0;
		int answer=0;
		map.put(input[0], 1);
		
		for(int i =1; i<input.length;i++) {
			
			map.put(input[i],map.getOrDefault(map, 1)+1);
			
			System.out.println("map " + map.size());
			if(map.size() == input.length) {
				System.out.println("µé¾î¿È?");
				for(int key : map.keySet()) {
					if( map.get(key)> 2) {
						answer = -1;
						break;
					}
				}
			}
			
			if(input[i] == input[i-1]) {
				input[i] +=1;
				answer++;
			}
			
			
			
		}
		
		System.out.println(answer);
		
	}

}
