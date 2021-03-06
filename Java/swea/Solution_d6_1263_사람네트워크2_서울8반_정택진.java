package d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d6_1263_사람네트워크2_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d6_1263.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int[][] briges = new int[N+1][N+1];
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++)
					briges[i][j] = Integer.parseInt(st.nextToken());
			
			Queue<int[]> q=new LinkedList<int[]>();
			int[] result = new int[N+1];
			int min = Integer.MAX_VALUE/2;
			for(int num=1; num<=N; num++) {
				q.offer(new int[] {num, 0});
				int count = 0;
				int dis[] = new int[N+1];
				dis[num] = -1;
				while(!q.isEmpty()) {
					int[] curr=q.poll();
					if(dis[curr[0]] == 0) {
						dis[curr[0]] = curr[1];
						count++;
						result[num] += curr[1];
					}
					if(count == N-1)	break;
					
					for(int col=1; col<=N; col++) {
						if(dis[col] == 0 && briges[curr[0]][col] == 1) {
							q.offer(new int[] {col, curr[1]+1});
						}
					}
				}
				
				min = Math.min(min, result[num]);
				q.clear();
			}
			
			System.out.println(Arrays.toString(result));
			System.out.println("#"+tc+" "+min);
		}
	}

}
