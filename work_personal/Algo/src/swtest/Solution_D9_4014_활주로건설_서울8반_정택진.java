package swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D9_4014_활주로건설_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_4014.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for(int i=0; i<N; i++) {
				int[] ing = {1, 1};
				boolean[] fail = new boolean[2];
				for(int j=1; j<N; j++) {
					int[] interval = {map[i][j] - map[i][j-1], map[j][i] - map[j-1][i]};
					
					for(int k=0; k<2; k++) {
						if(fail[k])	continue;
						
						if(interval[k] == 0) {
							ing[k]++;
						}
						//한칸 올라감
						else if(interval[k] == 1) {
							if(ing[k] < X)	fail[k] = true;
							ing[k] = 1;
						}
						//한칸 내려감
						else if(interval[k] == -1) {
							if(ing[k] < 0)	fail[k] = true;
							ing[k] = -X+1;
						}else {
							fail[k] = true;
						}
						
						if(j == N-1 && !fail[k] && ing[k] >= 0) {
							result++;
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
