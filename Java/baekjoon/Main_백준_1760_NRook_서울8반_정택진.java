package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1760_NRook_서울8반_정택진 {
	static final int dx[] = {0, 0, -1, 1};
	static final int dy[] = {-1, 1, 0, 0};
	static int M, N; 

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[][] map_origin = new int[M][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map_origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
}
