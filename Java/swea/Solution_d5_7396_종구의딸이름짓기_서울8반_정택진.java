package d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d5_7396_종구의딸이름짓기_서울8반_정택진 {
	static class Current{
		int y;
		int x;
		char c;
		public Current(int y, int x, char c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}
	public static final int dx[] = {1, 0};
	public static final int dy[] = {0, 1};
	public static int N, M;
	public static char map[][];
	public static Queue<Current> q;
	public static boolean visit[][];
	
	public static char cal() {
		PriorityQueue<Current> pq = new PriorityQueue<Current>(new Comparator<Current>() {
			@Override
			public int compare(Current o1, Current o2) {
				return o1.c - o2.c;
			}
		});

		
		while(!q.isEmpty()) {
			Current curr = q.poll();
			for(int d=0; d<2; d++) {
				int ny=curr.y+dy[d];
				int nx=curr.x+dx[d];
				char c = map[ny][nx];
				if(c == '\u0000')	continue;
				if(!visit[ny][nx]) {
					visit[ny][nx] = true;
					pq.offer(new Current(ny, nx, c));
				}
			}
		}
		
		Current curr = pq.poll();
		char min = curr.c;
		q.offer(curr);
		while(!pq.isEmpty()) {
			curr = pq.poll();
			if(curr.c > min) {
				pq.clear();
				break;
			}
			q.offer(curr);
		}
		
		return min;
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d5_7396.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N+2][M+2];
			for(int i=1; i<=N; i++) {
				String line = br.readLine();
				for(int j=1; j<=M; j++) {
					map[i][j] = line.charAt(j-1);
				}
			}
				
			q = new LinkedList<Current>();
			q.offer(new Current(1, 1, '\u0000'));
			visit = new boolean[N+2][M+2];
			System.out.print("#"+tc+" "+map[1][1]);
			for(int i=1; i<N+M-1; i++) {
				System.out.print(cal());
			}
			System.out.println();
		}
	}
}