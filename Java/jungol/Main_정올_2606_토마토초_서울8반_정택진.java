package jungol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_정올_2606_토마토초_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1, 0, 0};
	public static final int dy[] = {-1, 1, 0, 0, 0, 0};
	public static final int dz[] = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int H = sc.nextInt();
		
		int[][][] box = new int[H][M][N];
		Queue<int[]> q = new LinkedList<int[]>();
		for(int k=0; k<H; k++) {
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					box[k][i][j] = sc.nextInt();
					if(box[k][i][j] == 1) {
						q.offer(new int[] {i, j, k, 0});
					}
				}
			}
		}
		
		int day = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int y = curr[0];
			int x = curr[1];
			int z = curr[2];
			int cday = day = curr[3];
			
			for(int d=0; d<6; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				int nz = z + dz[d];
				
				if(nx<0 || ny<0 || nz<0 || nx>=N || ny>=M || nz>=H || box[nz][ny][nx] != 0)	continue;
				
				q.offer(new int[] {ny, nx, nz, cday+1});
				box[nz][ny][nx] = 1;
			}
		}
		
		for(int k=0; k<H; k++)
			for(int i=0; i<M; i++)
				for(int j=0; j<N; j++)
					if(box[k][i][j] == 0)	day = -1;
		
		System.out.println(day);
	}
}