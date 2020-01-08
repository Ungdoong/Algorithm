package swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D9_5644_무선충전_서울8반_정택진 {
	public static final int dx[] = {0, 0, 1, 0, -1};
	public static final int dy[] = {0, -1, 0, 1, 0};
	public static int N, M;
	
	public static void move(int[][][] map, int[] cur, int d) {
		int ny = cur[0] + dy[d];
		int nx = cur[1] + dx[d];
		cur[0] = ny;
		cur[1] = nx;
		for(int i=2; i<N+2; i++) {
			cur[i] = map[ny][nx][i-2];
		}
	}
	
	public static void draw_map(int[][][] map, int n, int y, int x, int count) {
		if(count == 0)	return;
		
		for(int d=1; d<=4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny<1 || ny>10 || nx<1 || nx>10 ) 
				continue;

			map[ny][nx][n] = 1;
			draw_map(map, n, ny, nx, count-1);
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_5644.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			int[] A = new int[M+1];
			int[] B = new int[M+1];
			int[][][] map = new int[11][11][N];
			int[] powers = new int[N];
			
			st=new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++)	A[i] = Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++)	B[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				powers[i] = Integer.parseInt(st.nextToken());
				
				map[y][x][i] = 1;
				draw_map(map, i, y, x, dis);
			}
			
			int[] cur_A = new int[N+2];
			int[] cur_B = new int[N+2];
			cur_A[0] = cur_A[1] = 1;
			cur_B[0] = cur_B[1] = 10;
			int sum = 0;
			int time = 0;
			
			while(time <= M) {
				move(map, cur_A, A[time]);
				move(map, cur_B, B[time]);
				
				int max = 0;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						int pa = (cur_A[i+2] == 0)? 0:powers[i];
						int pb = (cur_B[j+2] == 0)? 0:powers[j];
						if(pa != 0 && pb != 0 && i == j) {
							pa /= 2;
							pb = pa;
						}
						max = Math.max(max, pa+pb);
					}
				}
				sum += max;
				time++;
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}
