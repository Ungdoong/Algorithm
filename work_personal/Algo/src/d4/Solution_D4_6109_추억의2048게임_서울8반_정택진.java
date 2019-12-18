package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_6109_추억의2048게임_서울8반_정택진 {
	static final int dx[] = {0, -1, 0, 1};
	static final int dy[] = {-1, 0, 1, 0};
	static int N;
	
	public static void move(int[][] map, int dir) {
		boolean[][] changed = new boolean[N][N];
		int ff = (dir > 1)? N-1:0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cy = Math.abs(i - ff);
				int cx = Math.abs(j - ff);
				
				if(map[cy][cx] == 0)	continue;
				
				int value = map[cy][cx];
				map[cy][cx] = 0;
				int ny = cy + dy[dir];
				int nx = cx + dx[dir];
				
				while(nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx] == 0) {
					ny += dy[dir];
					nx += dx[dir];
				}
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) {
					ny -= dy[dir];
					nx -= dx[dir];
					map[ny][nx] = value;
					
					continue;
				}
				
				
				if(value == map[ny][nx] && !changed[ny][nx]) {
					map[ny][nx] += value;
					changed[ny][nx] = true;
				}else {
					ny -= dy[dir];
					nx -= dx[dir];
					map[ny][nx] = value;
				}
				
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_6109.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			int dir;
			if(s.equals("up"))			dir = 0;
			else if(s.equals("left"))	dir = 1;
			else if(s.equals("down"))	dir = 2;
			else						dir = 3;
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			move(map, dir);
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
