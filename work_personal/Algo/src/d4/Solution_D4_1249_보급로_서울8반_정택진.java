package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_D4_1249_보급로_서울8반_정택진 {
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static final int[] dx = {0,1,0,-1};
	public static final int[] dy = {-1,0,1,0};
	public static int map[][], accum[][], min, N;
	
	public static void dfs(int x, int y, int count) {
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || nx>=N || ny<0 || ny>=N)	continue;
			if(accum[ny][nx] > count+map[ny][nx]) {
				accum[ny][nx] = count+map[ny][nx];
				dfs(nx, ny, count+map[ny][nx]);
			}
		}
	}
	
	public static void dfs() {
		Stack<Node> entry = new Stack<Node>();
		entry.push(new Node(0, 0));
		accum[0][0]=0;
		while(!entry.isEmpty()) {
			int cy=entry.peek().y;
			int cx=entry.peek().x;
			entry.pop();
			for(int i=0; i<4; i++) {
				int nx=cx+dx[i];
				int ny=cy+dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=N)	continue;
				if(accum[ny][nx] > accum[cy][cx]+map[ny][nx]) {
					accum[ny][nx] = accum[cy][cx]+map[ny][nx];
					entry.push(new Node(nx, ny));
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<Node> entry = new LinkedList<Node>();
		entry.offer(new Node(0,0));
		accum[0][0]=0;
		while(!entry.isEmpty()) {
			int cy=entry.peek().y;
			int cx=entry.peek().x;
			entry.poll();
			for(int i=0; i<4; i++) {
				int nx=cx+dx[i];
				int ny=cy+dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=N)	continue;
				if(accum[ny][nx] > accum[cy][cx]+map[ny][nx]) {
					accum[ny][nx] = accum[cy][cx]+map[ny][nx];
					entry.offer(new Node(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1249.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			accum=new int[N][N];
			
			//맵 초기화
			for(int i=0; i<N; i++) {
				String line=br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j]=line.charAt(j) - '0';
					accum[i][j]=Integer.MAX_VALUE;
				}
			}
			bfs();
			
			System.out.println("#"+tc+" "+accum[N-1][N-1]);
		}
	}
}
