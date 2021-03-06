package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_1082_화염에서탈출_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static int H, W;
	
	public static void fire(char[][] map) {
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=W; j++) {
				if(map[i][j] == '*') {
					for(int d=0; d<4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if(map[ny][nx] == '.')	map[ny][nx] = '!';
					}
				}
			}
		}
		for(int i=1; i<=H; i++)
			for(int j=1; j<=W; j++)
				if(map[i][j] == '!')	map[i][j] = '*';
	}
	
	public static int bfs(char[][] map, int[] cur) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visit = new boolean[H+2][W+2];
		q.offer(new int[] {cur[0], cur[1]});
		visit[cur[0]][cur[1]] = true;
		
		int time = 1;
		int cur_size = q.size();
		int result = 0;
		fire(map);
		while(!q.isEmpty() && result == 0) {
			int[] curr = q.poll();
			int y = curr[0];
			int x = curr[1];
			cur_size--;

			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(!visit[ny][nx] && map[ny][nx] == '.') {
					visit[ny][nx] = true;
					q.offer(new int[] {ny, nx});
				}
				if(map[ny][nx] == 'D')
					result = time;
			}
			
			if(cur_size == 0) {
				time++;
				cur_size = q.size();
				fire(map);
			}
			
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1082.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		//변수 초기화
		char[][] map = new char[H+2][W+2];
		int[] cur = new int[2];
		for(int i=0; i<H+2; i++) {
			String line = "";
			if(i >= 1 && i <= H)
				line = br.readLine();
			for(int j=0; j<W+2; j++) {
				if(i == 0 || i == H+1 || j == 0 || j == W+1)
					map[i][j] = '#';
				else {
					map[i][j] = line.charAt(j-1);
					if(map[i][j] == 'S') {
						map[i][j] = '.';
						cur[0] = i;
						cur[1] = j;
					}
				}
			}
		}
		
		int result = bfs(map, cur);
		
		if(result == 0)
			System.out.println("impossible");
		else
			System.out.println(result);
	}
}
