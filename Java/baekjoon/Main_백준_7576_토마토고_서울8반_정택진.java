package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7576_토마토고_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[H][W];
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i=0; i<H; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<W; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					q.offer(new int[] {i, j, 0});
				}
			}
		}
		
		
		int day = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int y = curr[0];
			int x = curr[1];
			int cday = day = curr[2];
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(nx<0 || ny<0 || nx>=W || ny>=H || box[ny][nx] != 0)	continue;
				
				q.offer(new int[] {ny, nx, cday+1});
				box[ny][nx] = 1;
			}
		}
		
		for(int i=0; i<H; i++)
			for(int j=0; j<W; j++)
				if(box[i][j] == 0)	day = -1;
		
		System.out.println(day);
	}
}