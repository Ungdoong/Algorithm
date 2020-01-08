package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17837_새로운게임2_서울8반_정택진 {
	static final int dx[] = {0, 1, -1, 0, 0};
	static final int dy[] = {0, 0, 0, -1, 1};
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] map = new char[N+2][N+2];
		Arrays.fill(map, '2');
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				 map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		int[][][] horses = new int[N+2][N+2][4];
		for(int i=0; i<K; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			horses[y][x][0] = Integer.parseInt(st.nextToken());
		}
		
		boolean finish = false;
		while(!finish) {
			
		}
	}
	
	static boolean white(int[][][] horses, int cy, int cx, int ny, int nx) {
		int insert_i = 0;
		while(horses[ny][nx][insert_i] != 0)	insert_i++;
		
		int delete_i = 0;
		while(insert_i < 4 && horses[cy][cx][delete_i] != 0) {
			horses[ny][nx][insert_i++] = horses[cy][cx][delete_i];
			horses[cy][cx][delete_i++] = 0;
		}
		
		if(insert_i == 4)	return true;
		return false;
	}
	
	static boolean red(int[][][] horses, int cy, int cx, int ny, int nx) {
		int insert_i = 0;
		while(horses[ny][nx][insert_i] != 0)	insert_i++;
		
		int delete_i = 0;
		while(horses[cy][cx][delete_i] != 0)	delete_i++;
		delete_i--;
		
		while(insert_i<4 && delete_i>=0) {
			horses[ny][nx][insert_i++] = horses[cy][cx][delete_i];
			horses[cy][cx][delete_i--] = 0;
		}
		
		if(insert_i == 4)	return true;
		return false;
	}
	
	static boolean blue(int[][][] horses, char[][] map, int cy, int cx) {
		int d = horses[cy][cx][0];
		if(d==1 || d==3)	d++;
		else if(d==2 || d==4)	d--;
		horses[cy][cx][0] = d;
		
		int ny = cy + dy[d];
		int nx = cx + dx[d];
		
		char color = map[ny][nx];
		if(color == '0')	return white(horses, cy, cx, ny, nx);
		else if(color == '1')	return red(horses, cy, cx, ny, nx);
		else	return false;
	}
}