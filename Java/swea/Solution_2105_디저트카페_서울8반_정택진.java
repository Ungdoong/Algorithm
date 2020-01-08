package swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페_서울8반_정택진 {
	public static final int dx[] = {-1, 1, 1, -1};
	public static final int dy[] = {1, 1, -1, -1};
	public static int N, result;
	
	static class Stat{
		int[] start;
		int[] cur;
		int[] dir_accum;
		boolean[] visit;
		int count;
		
		public Stat(int y, int x) {
			this.start = new int[] {y, x};
			this.cur = new int[] {y, x};
			this.dir_accum = new int[4];
			this.visit = new boolean[101];
			this.count = 0;
		}
	}
	
	public static void dfs(int[][] map, Stat stat, int dir) {
		int cy = stat.cur[0];
		int cx = stat.cur[1];
		if(dir == -1) {
			int ny = cy + dy[0];
			int nx = cx + dx[0];
			
			if(map[cy][cx] == map[ny][nx])	return;
			
			stat.dir_accum[0]++;
			stat.cur[0] = ny;
			stat.cur[1] = nx;
			stat.visit[map[cy][cx]] = true;
			stat.visit[map[ny][nx]] = true;
			stat.count += 2;
			dfs(map, stat, 0);
		}else {
			for(int i=0; i<2; i++) {
				if(dir+i >=4)	continue;
				
				int d = dir+i;
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				
				if(map[ny][nx] == 0)	continue;
				//다음 지점이 출발점일 경우
				if(ny == stat.start[0] && nx == stat.start[1]) {
					result = Math.max(result, stat.count);
					return;
				}
				
				//출발점이 아닌경우
				if(stat.visit[map[ny][nx]])	continue;
				if(d-2 >= 0 && stat.dir_accum[d-2] < stat.dir_accum[d]+1)	continue;
				
				stat.dir_accum[d]++;
				stat.cur[0] = ny;
				stat.cur[1] = nx;
				stat.visit[map[ny][nx]] = true;
				stat.count++;
				dfs(map, stat, d);
				stat.count--;
				stat.visit[map[ny][nx]] = false;
				stat.cur[0] = cy;
				stat.cur[1] = cx;
				stat.dir_accum[d]--;
			}
		}
	}
	
	public static void run(int[][] map) {
		for(int i=1; i<=N-2; i++) {
			for(int j=2; j<=N-1; j++) {
				dfs(map, new Stat(i, j), -1);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_2105.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N+2][N+2];
			
			for(int i=1; i<=N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			result = -1;
			run(map);
			System.out.println("#"+tc+" "+result);
		}
	}
}
