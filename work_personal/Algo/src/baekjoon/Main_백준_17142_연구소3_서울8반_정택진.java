package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17142_연구소3_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static int N, M, V, result;
	public static ArrayList<int[]> virus;
	public static boolean picked[];
	
	public static void bfs(int[][] map) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visit = new boolean[N][N];
		for(int i=0; i<V; i++) {
			if(picked[i]) {
				int[] v = virus.get(i);
				q.offer(new int[] {v[0], v[1], 0});
				visit[v[0]][v[1]] = true;
			}
		}
		
		int max = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int y = curr[0];
			int x = curr[1];
			int count = curr[2];
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(nx<0 || nx>=N || ny<0 || ny>=N || map[ny][nx] == 1 || visit[ny][nx])	continue;
				visit[ny][nx] = true;
				q.offer(new int[] {ny, nx, count+1});
				if(map[ny][nx] != 2)
					max = Math.max(max, count+1);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0 && !visit[i][j])
					max = -1;
			}
		}
		if(max != -1)
			result = Math.min(result, max);
	}
	
	public static void pick(int[][] map, int start, int count) {
		if(result == -1)	return;
		if(count == M) {
			bfs(map);
			return;
		}
		
		for(int i=start; i<V; i++) {
			picked[i] = true;
			pick(map, i+1, count+1);
			picked[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		virus = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)	virus.add(new int[] {i, j});
			}
		}
		
		V = virus.size();
		picked = new boolean[V];
		result = Integer.MAX_VALUE;
		pick(map, 0, 0);
		
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else	System.out.println(result);
	}
}