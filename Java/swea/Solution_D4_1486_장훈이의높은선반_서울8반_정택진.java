package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1486_장훈이의높은선반_서울8반_정택진 {
	public static int N, B, arr[];
	public static int min;
	
	public static void dfs(int start, int sum) {
		if(sum >= B) {
			min = Math.min(min, sum-B);
			return;
		}
		
		for(int i=start; i<N; i++) {
			dfs(i+1, sum+arr[i]);
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1486.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			arr=new int[N];
			for(int i=0; i<N; i++)
				arr[i]=Integer.parseInt(st.nextToken());
			
			min=Integer.MAX_VALUE;
			dfs(0,0);
			
			System.out.println("#"+tc+" "+min);
		}
	}
}
