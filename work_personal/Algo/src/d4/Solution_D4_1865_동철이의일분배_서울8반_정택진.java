package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1865_동철이의일분배_서울8반_정택진 {
	public static int N, map[][];
	public static double max;
	
	public static void dfs(int count, double sum, int visit) {
		if(count == N) {
			max = sum;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((visit & (1<<i)) == 0) {
				double next_sum = sum*(map[count][i]/100.0);
				if(max < next_sum)	dfs(count+1, next_sum, visit|(1<<i));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map=new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			max = 0;
			dfs(0, 1, 0);

			System.out.printf("#%d %.6f\n",tc,max*100);
		}
	}

}
