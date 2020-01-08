package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울_서울8반_정택진 {
	public static long result;
	
	public static void cal(int[] items, int count, int sum, boolean[] visit, int N) {
		if(count == N) {
			result++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i])	continue;
			visit[i]=true;
			cal(items, count+1, sum+items[i], visit, N);
			if(sum-items[i] >= 0)
				cal(items, count+1, sum-items[i], visit, N);
			visit[i]=false;
		}
	}
	

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_3234.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N=Integer.parseInt(br.readLine());
			int[] items = new int[N];
			boolean[] visit = new boolean[N];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)
				items[i] = Integer.parseInt(st.nextToken());
			
			result=0;
			cal(items, 0, 0, visit, N);
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
