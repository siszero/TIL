package Sorting;

import java.util.*;

public class BiggestNum {

	public static String solution(int[] numbers) {
		String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i<numbers.length;i++)
            arr[i] = String.valueOf(numbers[i]);    // 숫자를 문자형으로 변환

        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        System.out.println((arr[1] + arr[0]).compareTo(arr[0] + arr[1]));
        
        // 0 중복 안되게
        if(arr[0].equals("0"))
            return "0";
        
        for(String i : arr)
            answer += i;
        
        return answer;
    }
	
	public static void main(String[] args) {

		int[] array = { 6, 10, 2 };

		System.out.println(solution(array));

	}
}
