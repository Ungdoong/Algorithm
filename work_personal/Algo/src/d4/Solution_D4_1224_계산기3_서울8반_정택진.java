package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;


public class Solution_D4_1224_계산기3_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1224.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			Stack<Character> operStack = new Stack<>();
			Stack<Character> postStack = new Stack<>();
			Stack<Integer> calStack = new Stack<>();
			
			int N=Integer.parseInt(br.readLine());
			
			String line=br.readLine();
			for(int i=0; i<N; i++) {
				char input=line.charAt(i);
				
				if(input == '(')
					operStack.push(input);
				else if(input == ')') {
					while(operStack.peek() != '(')
						postStack.push(operStack.pop());
					operStack.pop();
				}
				else if(input >= '0' && input <= '9')
					postStack.push(input);
				else {
					while(!operStack.isEmpty() && (priority(input) <= priority(operStack.peek())))
						postStack.push(operStack.pop());
					operStack.push(input);
				}
			}
			
			while(!operStack.isEmpty())
				postStack.push(operStack.pop());
			
			int x,y;
			int length = postStack.size();
			Character[] arr=new Character[length];
			postStack.toArray(arr);
			
			for(int i=0; i<length; i++) {
				char item=arr[i];
				if(item >= '0' && item <= '9')
					calStack.push(item - '0');
				else if(item == '*') {
					x=calStack.pop();
					y=calStack.pop();
					calStack.push(x*y);
				}
				else if(item == '+') {
					x=calStack.pop();
					y=calStack.pop();
					calStack.push(x+y);
				}
			}
			
			System.out.println("#"+tc+" "+calStack.pop());
		}
	}
	
	public static int priority(char ch) {
		switch(ch) {
		case '+':	return 1;
		case '*':	return 2;
		default:	return -1;
		}
	}
}