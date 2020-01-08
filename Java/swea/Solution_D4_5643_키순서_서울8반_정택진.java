package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_5643_키순서_서울8반_정택진 {
	public static final int INF = Integer.MAX_VALUE;
	public static int N;
	
	public static void floyd_warshall(int[][] compare) {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(compare[i][k] == INF || compare[k][j] == INF)	continue;
					if(compare[i][j] > compare[i][k] + compare[k][j])
						compare[i][j] = compare[i][k] + compare[k][j];
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_5643.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			int[][] compare = new int[N+1][N+1];
			for(int i=0; i<=N; i++)
				Arrays.fill(compare[i], INF);
			
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int low = Integer.parseInt(st.nextToken());
				int high = Integer.parseInt(st.nextToken());
				
				compare[low][high] = 1;
			}
			
			floyd_warshall(compare);
			
			int[] count = new int[N+1];
			int result = 0;
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(compare[i][j] != INF) {
						count[i]++;
						count[j]++;
						if(count[i] == N-1)	result++;
						if(count[j] == N-1)	result++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
