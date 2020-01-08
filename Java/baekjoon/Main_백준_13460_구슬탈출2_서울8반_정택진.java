package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_13460_구슬탈출2_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static int N, M, result;
	
	public static void process(char[][] map, int[] red, int[] blue, int count) {
		if(count == 10 || result == 1) return;
		
		for(int d=0; d<4; d++) {
			int ny_r = red[0] + dy[d];
			int nx_r = red[1] + dx[d];
			int ny_b = blue[0] + dy[d];
			int nx_b = blue[1] + dx[d];
			
			if((map[ny_r][nx_r] == '#' && map[ny_b][nx_b] == '#') ||
					(map[ny_r][nx_r] == '#' && map[ny_b][nx_b] == 'R') ||
					(map[ny_r][nx_r] == 'B' && map[ny_b][nx_b] == '#'))	
				continue;
			
			while(map[ny_r][nx_r] == '.' || map[ny_b][nx_b] == '.') {
				while(map[ny_r][nx_r] == '.') {
					map[ny_r-dy[d]][nx_r-dx[d]] = '.';
					map[ny_r][nx_r] = 'R';
					ny_r += dy[d];
					nx_r += dx[d];
				}
				while(map[ny_b][nx_b] == '.') {
					map[ny_b-dy[d]][nx_b-dx[d]] = '.';
					map[ny_b][nx_b] = 'B';
					ny_b += dy[d];
					nx_b += dx[d];
				}
			}
			
			if(map[ny_b][nx_b] == 'O' || (map[ny_r][nx_r] == 'O' && map[ny_b][nx_b] == 'R'))	{
				map[ny_r-dy[d]][nx_r-dx[d]] = '.';
				map[ny_b-dy[d]][nx_b-dx[d]] = '.';
				map[red[0]][red[1]]   = 'R';
				map[blue[0]][blue[1]] = 'B';
				continue;
			}
			if(map[ny_r][nx_r] == 'O') {
				result = Math.min(result, count+1);
				map[ny_r-dy[d]][nx_r-dx[d]] = '.';
				map[ny_b-dy[d]][nx_b-dx[d]] = '.';
				map[red[0]][red[1]]   = 'R';
				map[blue[0]][blue[1]] = 'B';
				continue;
			}
			
			ny_r -= dy[d];
			nx_r -= dx[d];
			ny_b -= dy[d];
			nx_b -= dx[d];
			process(map, new int[] {ny_r, nx_r}, new int[] {ny_b, nx_b}, count+1);
			map[ny_r][nx_r] = '.';
			map[ny_b][nx_b] = '.';
			map[red[0]][red[1]]   = 'R';
			map[blue[0]][blue[1]] = 'B';
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_13460.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int[] red=new int[2];
		int[] blue=new int[2];
		char[][] map=new char[N][M];
		for(int i=0; i<N; i++) {
			String line=br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'R') { red[0] = i; red[1] = j; }
				else if(map[i][j] == 'B') { blue[0] = i; blue[1] = j; }
			}
		}
		result = Integer.MAX_VALUE/2;
		process(map, red, blue, 0);
		
		if(result == Integer.MAX_VALUE/2)	result = -1;
		System.out.println(result);
	}
}