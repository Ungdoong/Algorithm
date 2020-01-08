package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1841_월드컵_서울8반_정택진 {
	public static boolean result;
	
	public static void dfs(int[][] score, int a, int b) {
		if(b >= 6) {
			if(a + 1 < 5) {
				dfs(score, a+1, a+2);
				return;
			}else {
				for(int i=0; i<score.length; i++)
					if(score[i][0] != 0 || score[i][1] != 0 || score[i][2] != 0)
						return;
				result = true;
			}
		}
		if(score[a][0] != 0 && score[b][2] != 0) {
			score[a][0]--; score[b][2]--;
			dfs(score, a, b+1);
			score[a][0]++; score[b][2]++;
		}
		
		if(score[a][1] != 0 && score[b][1] != 0) {
			score[a][1]--; score[b][1]--;
			dfs(score, a, b+1);
			score[a][1]++; score[b][1]++;
		}
		
		if(score[a][2] != 0 && score[b][0] != 0) {
			score[a][2]--; score[b][0]--;
			dfs(score, a, b+1);
			score[a][2]++; score[b][0]++;
		}
		return;
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1841.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=4; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int num_nation = 6;
			int[][] score = new int[num_nation][3];
			for(int i=0; i<num_nation; i++) {
				score[i][0] = Integer.parseInt(st.nextToken());
				score[i][1] = Integer.parseInt(st.nextToken());
				score[i][2] = Integer.parseInt(st.nextToken());
			}
			
			result = false;
			dfs(score, 0, 1);
			
			if(result)	System.out.print("1 ");
			else		System.out.print("0 ");
		}
	}

}
