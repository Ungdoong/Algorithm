package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D4_1232_사칙연산_서울8반_정택진 {
	public static Object[] tree=new Object[1001];
	
	static class Node{
		public char oper;
		public int left;
		public int right;
		
		public Node(char oper, int left, int right) {
			this.oper=oper;
			this.left=left;
			this.right=right;
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1232.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line;
		
		for(int tc=1; tc<=10; tc++) {
			int N=Integer.parseInt(br.readLine());
			
			//입력값 변수화
			for(int i=0; i<N; i++) {
				line=br.readLine().split(" ");
				if(line.length > 2)
					tree[Integer.parseInt(line[0])] 
							= new Node(line[1].charAt(0)
							, Integer.parseInt(line[2])
							, Integer.parseInt(line[3]));
				else
					tree[Integer.parseInt(line[0])] = Integer.parseInt(line[1]);
			}
			
			int result = calc(1);
			
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	
	public static int calc(int node) {
		if(tree[node] instanceof Node) {
			Node n=(Node)tree[node];
			switch(n.oper) {
				case '+':
					return calc(n.left) + calc(n.right);
				case '-':
					return calc(n.left) - calc(n.right);
				case '*':
					return calc(n.left) * calc(n.right);
				case '/':
					return calc(n.left) / calc(n.right);
				default:
					return -1;	
			}
		}else {
			return (int)tree[node];
		}
	}
}