package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_4613_러시아국기같은깃발_서울8반_정택진 {
	
	public static int min, N;
	
	public static void run(int[][] needs, int flag, int row, int sum) {
		if(row == N-1) {
			if(flag == 0)	return;
			min = Math.min(min, sum+needs[0][0]+needs[N-1][2]);
			return;
		}
		//1
		run(needs, flag, row+1, sum+needs[row][flag]);
		//2
		if(flag < 2)
			run(needs, flag+1, row+1, sum+needs[row][flag+1]);
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_4613.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] needs = new int[N][3];
			
			for(int i=0; i<N; i++) {
				Arrays.fill(needs[i], M);
				String line = br.readLine();
				for(int j=0; j<M; j++) {
					char c = line.charAt(j);
					if(c == 'W')		needs[i][0]--;
					else if(c == 'B')	needs[i][1]--;
					else				needs[i][2]--;
				}
			}
			
			min = Integer.MAX_VALUE;
			run(needs, 0, 1, 0);
			
			System.out.println("#"+tc+" "+min);
		}
	}
}
