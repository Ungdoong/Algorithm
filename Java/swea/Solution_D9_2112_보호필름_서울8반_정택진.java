package swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D9_2112_보호필름_서울8반_정택진 {
	public static int K, D, W;
	
	public static boolean check(int[][] map) {
		for(int j=0; j<W; j++) {
			for(int i=0; i<D; i++) {
				int cur = map[i][j];
				int count = 1;
				int index = i+1;
				
				while(index < D && cur == map[index][j]) {
					count++;
					index++;
					if(count == K)	break;
				}
				
				if(count == K)	break;
				if(i == D-1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void insection(int[][] map, int y, int c) {
		for(int j=0; j<W; j++)
			map[y][j] = c;
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_2112.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[D][W];
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<W; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int result = Integer.MAX_VALUE/2;
			for(int n=0; n<Math.pow(2, D); n++) {
				for(int c=0; c<2; c++) {
					int[][] copy = new int[D][W];
					for(int i=0; i<D; i++)
						for(int j=0; j<W; j++)
							copy[i][j] = map[i][j];
					
					int count = 0;
					for(int i=0; i<D; i++) {
						if(((n>>i) & 1) == 0)	continue;
						count++;
						insection(copy, i, c);
					}
					
					if(result > count && check(copy)) {
						result = count;
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
