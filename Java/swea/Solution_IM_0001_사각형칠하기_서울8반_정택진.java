package exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_IM_0001_사각형칠하기_서울8반_정택진 {
	
	public static boolean check(int[][] map, int m, int x1, int y1, int x2, int y2) {
		for(int i=y1; i<=y2; i++)
			for(int j=x1; j<=x2; j++)
				if(map[i][j] > m) return false;
		return true;
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_사각형칠하기.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			
			int[][] map=new int[N][M];
			int[] result=new int[11];
			
			while(K-- > 0) {
				st=new StringTokenizer(br.readLine());
				int y1=Integer.parseInt(st.nextToken());
				int x1=Integer.parseInt(st.nextToken());
				int y2=Integer.parseInt(st.nextToken());
				int x2=Integer.parseInt(st.nextToken());
				int m=Integer.parseInt(st.nextToken());
				if(check(map,m,x1,y1,x2,y2)) {
					for(int i=y1; i<=y2; i++)
						for(int j=x1; j<=x2; j++)
							map[i][j] = m;
				}
			}
			
			for(int k=0; k<11; k++)
				for(int i=0; i<N; i++)
					for(int j=0; j<M; j++)
						if(map[i][j] == k)	result[k]++;
			int max=0;
			for(int i=0; i<11; i++)
				if(result[i] > max)	max=result[i];
			
			System.out.println("#"+tc+" "+max);
		}
	}
}
