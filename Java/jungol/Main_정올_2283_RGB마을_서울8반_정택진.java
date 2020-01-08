package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2283_RGB마을_서울8반_정택진 {
	public static int N, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] houses = new int[N][3];
		int[][] dp = new int[N][3];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			houses[i][0] = Integer.parseInt(st.nextToken());
			houses[i][1] = Integer.parseInt(st.nextToken());
			houses[i][2] = Integer.parseInt(st.nextToken());
			if(i == 0) {
				dp[i][0] = houses[i][0];
				dp[i][1] = houses[i][1];
				dp[i][2] = houses[i][2];
			}else {
				dp[i][0] = houses[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = houses[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = houses[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			}
		}
		
		int result = dp[N-1][0];
		for(int i=1; i<=2; i++)
			result = Math.min(result, dp[N-1][i]);
		
		System.out.println(result);
	}
}
