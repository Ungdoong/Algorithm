package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9376_탈옥_서울8반_정택진 {
	public static final int dx[] = { 0, 0, -1, 1 };
	public static final int dy[] = { -1, 1, 0, 0 };
	public static int H, W, min, one[], two[];
	public static boolean opened[][];
	
	public static void dfs(char[][] map, boolean[][] visit, int[] man, int count) {
		if(count >= min)	return;
		for(int d=0; d<4; d++) {
			int ny = man[0] + dy[d];
			int nx = man[1] + dx[d];

			if(map[ny][nx] == '\u0000') {
				if(one[2] == 0) {
					one[2] = 1;
					boolean v[][] = new boolean[H+2][W+2];
					v[two[0]][two[1]] = true;
					dfs(map, v, two, count);
					return;
				}else {
					min = Math.min(min, count);
					one[2] = 0;
					return;
				}
			}
			
			if(!visit[ny][nx] && map[ny][nx] != '*') {
				if(map[ny][nx] == '#' && !opened[ny][nx]) {
					opened[ny][nx] = true;
					visit[ny][nx] = true;
					dfs(map, visit, new int[] {ny,nx}, count+1);
					visit[ny][nx] = false;
					opened[ny][nx] = false;
				}else if(map[ny][nx] == '#' && opened[ny][nx] && one[2] == 1) {
					min = Math.min(min, count);
					one[2] = 0;
					return;
				}else {
					visit[ny][nx]= true;
					dfs(map, visit, new int[] {ny,nx}, count);
					visit[ny][nx] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9376.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			H=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			char[][] map=new char[H+2][W+2];
			one = new int[3];
			two = new int[2];
			for(int i=1; i<=H; i++) {
				String line=br.readLine();
				for(int j=1; j<=W; j++) {
					map[i][j] = line.charAt(j-1);
					if(map[i][j] == '$') { 
						if(one[0] == 0) { one[0] = i; one[1] = j; }
						else			{ two[0] = i; two[1] = j; }
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			boolean[][] visit= new boolean[H+2][W+2];
			visit[one[0]][one[1]] = true;
			opened = new boolean[H+2][W+2];
			dfs(map, visit, one, 0);
			System.out.println(min);
		}
	}
}