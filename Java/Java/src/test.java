import java.util.*;
import java.io.*;

class CodeRunner
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            String s = br.readLine();
            for(int j =0; j<s.length(); j++){
                char c = s.charAt(j);
                if(c == '('){
                    stack.push(c);
                }
                else{
                    if(stack.size() == 0){
                        stack.push(c);
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()) {
			System.out.println("YES");
		}
        else {
            System.out.println("NO");
        }

        stack.clear();
    }
}