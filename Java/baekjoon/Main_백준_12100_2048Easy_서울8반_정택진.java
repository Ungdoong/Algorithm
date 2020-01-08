package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_12100_2048Easy_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static int N, result;
	public static void move(int[][] map, int dir) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int y = i;
				int x = j;
				if(dir == 1) {
					y = N-i-1;
				}else if(dir == 3){
					x = N-j-1;
				}
				
				if(map[y][x] == 0)	continue;
				
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				int num = map[y][x];
				while(nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx] == 0) {
					ny += dy[dir];
					nx += dx[dir];
				}
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && num == map[ny][nx]) {
					num += num;
					result = Math.max(result, num);
				}
				else {
					ny -= dy[dir];
					nx -= dx[dir];
				}
				map[y][x] = 0;
				map[ny][nx] = num;
			}
		}
	}
	
	public static void step(int[][] map, int[] dirs, int count) {
		if(count == 5) {
			int[][] cp = new int[N][N];
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					cp[i][j] = map[i][j];
			for(int i=0; i<5; i++)
				move(cp, dirs[i]);
			return;
		}
		
		for(int d=0; d<4; d++) {
			dirs[count] = d;
			step(map, dirs, count+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		int[] dirs= new int[5];
		step(map, dirs, 0);
		
		System.out.println(result);
	}
}