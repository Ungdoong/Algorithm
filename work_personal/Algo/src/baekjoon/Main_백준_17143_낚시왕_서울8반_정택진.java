package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17143_낚시왕_서울8반_정택진 {
	public static final int dx[] = {0, 1, 0, -1};
	public static final int dy[] = {-1, 0, 1, 0};
	
	static class Shark{
		int velocity;
		int size;
		int dir;
		
		public Shark(int velocity, int size, int dir) {
			this.velocity = velocity;
			this.size = size;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Shark - " + this.dir+" / "+this.velocity+" / "+this.size;
		}
	}
	
	public static int R, C, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Shark[][] map = new Shark[R][C];
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			if(d == 2)	d = 3;
			else if(d == 3)	d = 2;
			map[y][x] = new Shark(v, s, d-1);
		}

		int player_x = -1;
		int result = 0;
		while(player_x < C-1) {
			player_x++;
			int cy = 0;
			Shark curr = map[cy][player_x];
			
			while(curr == null) {
				cy++;
				curr = map[cy][player_x];
				if(cy == R - 1)	break;
			}
			
			if(curr != null) {
				result += curr.size;
				map[cy][player_x] = null;
			}
			
			move(map);
		}
		
		System.out.println(result);
	}
	
	public static void move(Shark[][] map) {
		Shark[][] newMap = new Shark[R][C]; 
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == null)	continue;
				
				Shark curr = map[i][j];
				int ny = i;
				int nx = j;
				int d = curr.dir;
				int v = curr.velocity;
				
				while(v > 0) {
					v--;
					ny += dy[d];
					nx += dx[d];
					
					if(nx<0 || ny<0 || nx>=C || ny>= R) {
						d = (d + 2) % 4;
						ny += dy[d] * 2;
						nx += dx[d] * 2;
					}
				}
				curr.dir = d;
				Shark next = newMap[ny][nx];
				if(next != null)
					newMap[ny][nx] = (next.size >= curr.size)? next:curr;
				else
					newMap[ny][nx] = curr;
			}
		}
		
		for(int i=0; i<R; i++)
			for(int j=0; j<C; j++)
				map[i][j] = newMap[i][j];
	}
}