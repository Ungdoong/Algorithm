package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1024_내리막길_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static boolean visit[][];
	public static int X, Y;
	
	public static int dfs(int[][] map, int[][] memo, int x, int y) {
		if(y == Y && x == X)	return 1;
		if(memo[y][x] != 0)	return memo[y][x];
		if(!visit[y][x]) {
			visit[y][x] = true;
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(map[ny][nx] == -1 || map[ny][nx] >= map[y][x])	continue;
				if(map[y][x] > map[ny][nx])	memo[y][x] += dfs(map, memo, nx, ny);
			}
		}
		
		return memo[y][x];
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1024.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		//초기화
		int[][] map = new int[Y+2][X+2];
		for(int i=0; i<Y+2; i++) {
			if(i>=1 && i<Y+1)
				st = new StringTokenizer(br.readLine());
			for(int j=0; j<X+2; j++) {
				if(i == 0 || i == Y+1 || j == 0 || j == X+1)
					map[i][j] = -1;
				else
					map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[Y+2][X+2];
		int[][] memo = new int[Y+2][X+2];
		
		System.out.println(dfs(map,memo,1,1));
	}
}
