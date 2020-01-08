package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1227_미로2_서울8반_정택진 {
	public static final int N=100;
	public static final int[] dx = {0,0,-1,1};
	public static final int[] dy = {-1,1,0,0};
	static class xy{
		int x; int y;
		xy(int x, int y){ this.x=x; this.y=y; }
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1227.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			
			Queue<xy> q=new LinkedList<>();
			int[][] miro=new int[N][N];
			boolean[][] visit=new boolean[N][N];
			boolean result=false;
			
			//초기화
			for(int y=0; y<N; y++) {
				String str=br.readLine();
				for(int x=0; x<N; x++) {
					miro[y][x]= str.charAt(x) - '0';
					if(miro[y][x] == 2) {
						q.offer(new xy(x, y));
						visit[y][x] = true;
					}
				}
			}

			while(!q.isEmpty()) {
				xy c=q.poll();
				if(miro[c.y][c.x] == 3 ) {
					result = true;
					break;
				}
				for(int i=0; i<4; i++) {
					int nx=c.x+dx[i];
					int ny=c.y+dy[i];
					if(nx>=0 && ny>=0 && nx<N && ny<N && miro[ny][nx] != 1 
							&& !visit[ny][nx]) {
						q.offer(new xy(nx, ny));
						visit[ny][nx] = true;
					}
				}
			}
			
			if(result)
				System.out.println("#"+tc+" 1");
			else
				System.out.println("#"+tc+" 0");
		}
	}
}