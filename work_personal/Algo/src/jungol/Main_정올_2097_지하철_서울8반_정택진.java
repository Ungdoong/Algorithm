package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_2097_지하철_서울8반_정택진 {
	public static int N, M;
	
	public static void dijkstra(int[][] bridges, int[][] dist, boolean[] visit, int count) {
		if(count == N) {
			System.out.println(dist[M-1][0]);
			StringBuilder sb=new StringBuilder();
			sb.append(M);
			int index = dist[M-1][1];
			while(index != -1) {
				sb.insert(0, (index+1)+" ");
				index = dist[index][1];
			}
			System.out.println(sb.toString());
			
			return;
		}
		
		int min_node = 0;
		int min_dist = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			if(!visit[i])	continue;
			for(int j=0; j<N; j++) {
				if(visit[j] || bridges[i][j] == 0)	continue;
				
				if(dist[j][0] > dist[i][0] + bridges[i][j]) {
					dist[j][0] = dist[i][0] + bridges[i][j];
					dist[j][1] = i;
				}
				
				if(min_dist > dist[j][0]) {
					min_dist = dist[j][0];
					min_node = j;
				}
			}
		}
		
		visit[min_node] = true;
		dijkstra(bridges, dist, visit, count+1);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		int[][] bridges = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				bridges[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dist = new int[N][2];
		boolean[] visit = new boolean[N];
		
		dist[0][0] = 0;
		dist[0][1] = -1;
		visit[0] = true;
		for(int i=1; i<N; i++)	dist[i][0] = Integer.MAX_VALUE;
		
		dijkstra(bridges, dist, visit, 1);
		for(int i=0; i<N; i++)
		System.out.println(Arrays.toString(dist[i]));
	}

}
