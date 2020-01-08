package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_7733_치즈도둑_DFS_서울8반_정택진 {
	public static final int dx[] = { 0, 0, -1, 1};
	public static final int dy[] = { -1, 1, 0, 0};
	
	public static void eating(int[][] cheese, int day, int N){
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(cheese[i][j] == day)	cheese[i][j] = 0;
			}
		}
	}
	
	public static void dfs(int[][] cheese, boolean[][] check, int i, int j) {
		Stack<int[]> stack=new Stack<>();
		stack.push(new int[] {i , j});
		while(!stack.isEmpty()) {
			int[] curr=stack.pop();
			int y=curr[0];
			int x=curr[1];
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(cheese[ny][nx] != 0 && !check[ny][nx])	{
					check[ny][nx] = true;
					stack.push(new int[] {ny, nx});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_7733.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			//변수 초기화
			int N=Integer.parseInt(br.readLine());
			
			int[][] cheese=new int[N+2][N+2];
			int max=0;
			for(int i=1; i<=N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					if(max < cheese[i][j])	max = cheese[i][j];
				}
			}
			
			int result=1;
			for(int day=1; day<=max; day++) {
				eating(cheese, day, N);
				
				int sum=0;
				boolean[][] check = new boolean[N+2][N+2];
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						if(cheese[i][j] != 0 && !check[i][j]) {
							sum++;
							dfs(cheese, check, i, j);
						}
					}
				}
				
				if(result < sum)	result = sum;
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
