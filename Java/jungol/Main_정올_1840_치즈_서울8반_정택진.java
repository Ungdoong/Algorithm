package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_1840_치즈_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static int H, W;
	public static Queue<int[]> q;
	public static boolean[][] visit;
	
	public static int erase(int[][] map) {
		int del = 0;
		for(int i=1; i<=H-1; i++) {
			for(int j=1; j<=W-1; j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
					visit[i][j] = true;
					q.offer(new int[] {i, j});
					del++;
				}
			}
		}

		return del;
	}
	
	public static void bfs(int[][] map) {
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int y = curr[0];
			int x = curr[1];
			
			map[y][x] = -1;
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(ny < 0 || ny >= H || nx < 0 || nx >= W)	continue;
				if(!visit[ny][nx] && map[ny][nx] == 0) {
					visit[ny][nx] = true;
					q.offer(new int[] {ny, nx});
				}
				
				if(map[ny][nx] == 1)	map[ny][nx] = 2;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1840.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		//변수 초기화, 테두리 -1
		int[][] map = new int[H][W];
		int sum = 0;
		for(int i=0; i<H; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)	sum++;
			}
		}
		
		int time = 0;
		int prev_result = 0;
		q = new LinkedList<int[]>();
		visit = new boolean[H][W];
		q.offer(new int[] {0, 0});
		visit[0][0] = true;
		while(sum > 0) {
			time++;
			bfs(map);
			int del = erase(map);
			
			if(sum - del == 0) {
				prev_result = sum;
				sum -= del;
			}else
				sum -= del;
		}
		
		System.out.println(time);
		System.out.println(prev_result);
	}
}
