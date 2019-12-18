package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1868_파핑파핑지뢰찾기_서울8반_정택진 {
	public static final int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static final int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int N;
	
	public static void bfs(char[][] map, int[][] numbers, int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {y, x});
		map[y][x] = '0';
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cy = curr[0];
			int cx = curr[1];
			
			for(int d=0; d<8; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				
				if(nx<0 || ny<0 || nx>=N || ny>= N || map[ny][nx] != '.')	continue;
				
				map[ny][nx] = (char)(numbers[ny][nx] + '0');
				
				if(numbers[ny][nx] == 0)	q.offer(new int[] {ny, nx});
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1868.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			char[][] map = new char[N][N];
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			int[][] numbers = new int[N][N];
			int click = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == '*') {
						numbers[i][j] = -1;
						continue;
					}
					int mine = 0;
					for(int d=0; d<8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						
						if(nx<0 || ny<0 || nx>=N || ny>=N)	continue;
						if(map[ny][nx] == '*')	mine++;
					}
					
					numbers[i][j] = mine;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == '.' && numbers[i][j] == 0) {
						bfs(map, numbers, i, j);
						click++;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] != '.')	continue;
					
					map[i][j] = (char)(numbers[i][j] + '0');
					click++;
				}
			}
			
			System.out.println("#"+tc+" "+click);
		}
	}
}
