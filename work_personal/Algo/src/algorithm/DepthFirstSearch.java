package algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class DepthFirstSearch {
	public static int[][] graph;
	public static boolean[] visit;
	public static Stack<Integer> stack;
	public static int N, M;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_dfs.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		graph=new int[N][N];
		stack=new Stack<>();
		visit=new boolean[N];
		for(int i=0; i<M; i++) {
			String s=br.readLine();
			int src=Integer.parseInt(s.split(" ")[0]);
			int dst=Integer.parseInt(s.split(" ")[1]);
			graph[src][dst] = graph[dst][src] = 1;
		}
		
		System.out.print("#1 ");
		dfs(0);
		visit=new boolean[N];
		System.out.print("#1 ");
		dfsr(0);
	}
	
	public static void dfsr(int c) {
		visit[c]=true;
		System.out.print(c+" ");
		
		for(int i=0; i<N; i++) {
			if(!visit[i] && graph[c][i] == 1) {
				visit[i]=true;
				dfsr(i);
			}
		}
	}
	
	public static void dfs(int c) {
		stack.add(c);
		
		while(!stack.empty()) {
			int curr=stack.pop();
			if(visit[curr] == false) {
				visit[curr] = true;
				System.out.print(curr + " ");
				
				for(int i=0; i<N; i++) {
					if(graph[curr][i] == 1 && !visit[i]) {
						stack.push(i);
					}
				}
			}
		}
		System.out.println();
	}
}