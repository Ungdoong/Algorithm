package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_dfs_서울8반_정택진 {
	public static final int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static final int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int W, H;
	
	public static void dfs(int[][] map, int index, int cx, int cy) {
		for(int d=0; d<8; d++) {
			int ny = cy + dy[d];
			int nx = cx + dx[d];
			if(nx < 0 || nx >= W || ny < 0 || ny >= H)	continue;
			if(map[ny][nx] == 1) {
				map[ny][nx] = index;
				dfs(map, index, nx, ny);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_4963.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			if(W == 0 || H == 0)	break;
			
			//맵 초기화
			int[][] map = new int[H][W];
			for(int y=0; y<H; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0; x<W; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			//방문
			int index = 0;
			for(int y=0; y<H; y++) {
				for(int x=0; x<W; x++) {
					if(map[y][x] == 1) {
						index--;
						dfs(map, index, x, y);
					}
				}
			}
			
			System.out.println(-1*index);
		}
	}
}