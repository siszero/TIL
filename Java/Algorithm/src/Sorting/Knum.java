package Sorting;

import java.util.*;




public class Knum {
	
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];	// commands.length = 3
        
        for(int i = 0; i<commands.length; i++){
            int[] ans = new int[(commands[i][1]-commands[i][0]+1)];		// commands[0][1]-commands[0][0]+1 = 4

            int j = -1;
        	for(int k = (commands[i][0]-1); k<(commands[i][1]); k++){
        		j++;
            	ans[j] = array[k];
            }
            
            Arrays.sort(ans);

            
            answer[i] = ans[(commands[i][2]-1)];
            System.out.println(answer[i]);
        }

        
        return answer;
    }
	

	public static void main(String[] args) {
		
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		System.out.println(solution(array, commands));

	}



}

