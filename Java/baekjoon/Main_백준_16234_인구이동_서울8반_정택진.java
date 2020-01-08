package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16234_인구이동_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static int N, L, R, result;
	
	public static int bfs(int[][] map, int[][] union, int index, int cy, int cx) {
		Queue<int[]> q = new LinkedList<int[]>();
		Queue<int[]> q2 = new LinkedList<int[]>();
		q.add(new int[] {cy, cx});
		union[cy][cx] = index;
	
		int sumAll = map[cy][cx];
		int count = 1;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int y = curr[0];
			int x = curr[1];
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || union[ny][nx] != 0)	continue;
				
				int interval = Math.abs(map[y][x] - map[ny][nx]);
				if(interval >= L && interval <= R) {
					union[ny][nx] = index;
					sumAll += map[ny][nx];
					count++;
					q.offer(new int[] {ny, nx});
				}
			}
			q2.offer(curr);
		}
		
		int after = sumAll / count;
		int i = index;
		while(!q2.isEmpty()) {
			int[] curr = q2.poll();
			int y = curr[0];
			int x = curr[1];
			
			if(map[y][x] != after) {
				map[y][x] = after;
				i = index+1;
			}
		}
		
		
		return i;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++)	
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] union;
		int union_index = 0;
		result = -1;
		while(union_index != 1) {
			result++;
			union_index = 1;
			union = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(union[i][j] == 0) {
						union_index = bfs(map, union, union_index, i, j);
					}
				}
			}
		}
		
		System.out.println(result);
	}
}