package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크_서울8반_정택진 {
	public static int N, min;
	
	public static void cal(int[][] map, int[] indexes, int start, int count) {
		if(count == N/2) {
			int sum1 = 0;
			int sum2 = 0;
			int[] team = new int[N];
			for(int i=0; i<N/2; i++)	team[indexes[i]] = 1;
			for(int i=0; i<N-1; i++) {
				int a = team[i];
				for(int j=i+1; j<N; j++) {
					int b = team[j];
					if(a != b) continue;
					
					if(a == 0) {
						sum1 += map[i][j];
						sum1 += map[j][i];
					}else {
						sum2 += map[i][j];
						sum2 += map[j][i];
					}
				}
			}
			
			min = Math.min(min, Math.abs(sum1-sum2));
			return;
		}
		
		for(int i=start; i<N; i++) {
			indexes[count] = i;
			cal(map, indexes, i+1, count+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int[] indexes = new int[N/2];
		min = Integer.MAX_VALUE;
		cal(map, indexes, 0, 0);
		
		System.out.println(min);
	}
}