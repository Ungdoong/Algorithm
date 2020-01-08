package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기_서울8반_정택진2 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String str=br.readLine();
			Stack<Character> stack=new Stack<Character>();
			
			int i=0;
			while(i<N) {
				char c=str.charAt(i++);
				if(c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else break;
				}
				else if(c == '}') {
					if(!stack.isEmpty() && stack.peek() == '{')
						stack.pop();
					else break;
				}
				else if(c == ']') {
					if(!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else break;
				}
				else if(c == '>') {
					if(!stack.isEmpty() && stack.peek() == '<')
						stack.pop();
					else break;
				}
				else stack.add(c);					
			}
			if(i == N && stack.isEmpty())
				System.out.println("#"+tc+" 1");
			else
				System.out.println("#"+tc+" 0");
		}
	}
}