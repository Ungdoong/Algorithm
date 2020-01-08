package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드_서울8반_정택진 {
	public static int H, W, N, cur_y, cur_x, cur_dir;	//0:상 1:하 2:좌 3:우
	public static final int[] dx = {0,0,-1,1};
	public static final int[] dy = {-1,1,0,0};
	public static final char[] dd = {'^','v','<','>'};
	public static char map[][], command[];
	
	public static void swap(int y1, int x1, int y2, int x2) {
		char tmp = map[y1][x1];
		map[y1][x1] = map[y2][x2];
		map[y2][x2] = tmp;
	}
	
	public static void rotation(int dir) {
		int ny = cur_y + dy[dir];
		int nx = cur_x + dx[dir];
		
		if(map[ny][nx] == '.') {
			swap(ny,nx,cur_y,cur_x);
			cur_y=ny;
			cur_x=nx;
		}
		map[cur_y][cur_x] = dd[dir];
		cur_dir = dir;
	}
	
	public static void shoot() {
		int ny = cur_y + dy[cur_dir];
		int nx = cur_x + dx[cur_dir];
		while(map[ny][nx] == '.' || map[ny][nx] == '-') {
			ny = ny + dy[cur_dir];
			nx = nx + dx[cur_dir];
		}
		if(map[ny][nx] == '*')	map[ny][nx] = '.';
	}
	
	public static void run() {
		for(int c=0; c<N; c++) {
			switch(command[c]) {
				case 'U':
					rotation(0);
					break;
				case 'D':
					rotation(1);
					break;
				case 'L':
					rotation(2);
					break;
				case 'R':
					rotation(3);
					break;
				case 'S':
					shoot();
					break;
			}
		}
	}
	
	public static void init(BufferedReader br) throws Exception{
		StringTokenizer st=new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		map = new char[H+2][W+2];
		for(int i=1; i<=H; i++) {
			String line = br.readLine();
			for(int j=1; j<=W; j++) {
				map[i][j] = line.charAt(j-1);
				if(map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v') {
					cur_y = i; cur_x = j;
					switch(map[i][j]) {
						case '^': cur_dir=0; break;
						case 'v': cur_dir=1; break;
						case '<': cur_dir=2; break;
						case '>': cur_dir=3; break;
					}
				}
			}
		}
		N=Integer.parseInt(br.readLine());
		command = new char[N];
		String line = br.readLine();
		for(int i=0; i<N; i++)
			command[i] = line.charAt(i);
	}
	
	public static void print(int tc) {
		System.out.print("#"+tc+" ");
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1873.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			init(br);
			run();
			print(tc);
		}
	}
}