package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1733_오목_서울8반_정택진 {
	
	public static final int N = 20;
	public static final int dx[][] = {{0, 0}, {-1, 1}, {-1, 1}, {-1, 1}};
	public static final int dy[][] = {{-1, 1}, {1, -1}, {-1, 1}, {0, 0}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[N][N];
		
		for(int i=1; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		int y = Integer.MAX_VALUE;
		int x = Integer.MAX_VALUE;
		for(int i=1; i<N; i++) {
			for(int j=1; j<N; j++) {
				if(map[i][j] == 0 || result != 0)	continue;
				
				int value = map[i][j];
				for(int d=0; d<4; d++) {
					int ny1 = i + dy[d][0];
					int ny2 = i + dy[d][1];
					int nx1 = j + dx[d][0];
					int nx2 = j + dx[d][1];
					int count1 = 0;
					int count2 = 0;
					
					while(nx1>0 && nx1<N && ny1>0 && ny1<N && map[ny1][nx1] == value) {
						count1++;
						ny1 += dy[d][0];
						nx1 += dx[d][0];
					}
					
					while(nx2>0 && nx2<N && ny2>0 && ny2<N && map[ny2][nx2] == value) {
						count2++;
						ny2 += dy[d][1];
						nx2 += dx[d][1];
					}
					
					if(count1 + count2 + 1 == 5) {
						result = value;
						
						int a = i;
						int b = j;
						
						if(count1 != 0) {
							a = ny1 - dy[d][0];
							b = nx1 - dx[d][0];
						}
						
						if(x > b) {
							y = a;
							x = b;
						}else if(x == b) {
							if(y > a) {
								y = a;
								x = b;
							}
						}
						
						break;
					}
				}
			}
		}
		
		System.out.println(result);
		if(result != 0)
			System.out.println(y+" "+x);
	}
}