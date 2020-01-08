package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행_서울8반_정택진 {
	public static final int[] dx = { 0, 0, -1, 1};
	public static final int[] dy = { -1, 1, 0, 0};
	public static int R, C, max;
	public static char map[][];
	public static boolean visit[];
	
	public static void dfs(int y, int x, int count) {
		if(max == 26)	return;
		max = Math.max(max, count);
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(map[ny][nx] != '\u0000' && !visit[map[ny][nx] - 'A']) {
				visit[map[ny][nx] - 'A'] = true;
				dfs(ny, nx, count+1);
				visit[map[ny][nx] - 'A'] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_7699.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			map=new char[R+2][C+2];
			for(int i=1; i<=R; i++) {
				String line=br.readLine();
				for(int j=1; j<=C; j++)	map[i][j] = line.charAt(j-1);
			}
			
			visit=new boolean[26];
			visit[map[1][1] - 'A'] = true;
			max=0;
			dfs(1, 1, 1);
			
			System.out.println("#"+tc+" "+max);
		}
	}

}
