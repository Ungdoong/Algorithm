package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D3_1217_거듭제곱_서울8반_정택진2 {
	public static Stack<Long> stack=new Stack<Long>();
	public static long pow(int under, int upper) {
		for(int i=2; i<=upper; i++) {
			stack.add(stack.peek()*under);
		}
		return stack.peek();
	}
	public static long pow3(int n, int m) {
		if(m==1) return n;
		if((m&1)==0) {
			long y=pow3(n,m/2);
			return y*y;
		}else {
			long y=pow3(n,(m-1)/2);
			return n*y*y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1217.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			
			String line = br.readLine();
			int under = Integer.parseInt(line.split(" ")[0]);
			int upper = Integer.parseInt(line.split(" ")[1]);
			
			System.out.println("#"+tc+" "+pow3(under,upper));
		}
	}
}