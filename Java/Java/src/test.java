import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            String s = br.readLine();
            for(int j =0; j<s.length(); j++){
                char c = s.charAt(j);       // 받은 문자 하나씩 끊기
                if(c == '('){               // ( 괄호를 받았을 때는  stack에 넣기
                    stack.push(c);
                }
                else{                           // ) 괄호를 받았을 때
                    if(stack.size() == 0){      // stack 에 쌓여 있는게 없을 때
                        sb.append("NO");
                        // System.out.println("NO");
                        break;
                        // stack.push(c);
                        // break;
                    }
                    else{
                        stack.pop();
                        
                    }
                }
            }
        }
        if(stack.isEmpty()) {
			sb.append("YES");
		}
        else {
            sb.append("NO");
        }

        stack.clear();
        System.out.println(sb);
    }
}


