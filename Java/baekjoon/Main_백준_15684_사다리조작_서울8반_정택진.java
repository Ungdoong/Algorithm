package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15684_사다리조작_서울8반_정택진 {
	public static int N, M, H, min;
	
	public static boolean checkResult(int[][] hor_line) {
		for(int i=0; i<N; i++) {
			int ver_pos = i;
			int hor_pos = 0;
			while(hor_pos < H) {
				if((ver_pos-1) >= 0 && hor_line[hor_pos][ver_pos-1] == 1) {
					ver_pos--;
				}else if((ver_pos) < N-1 && hor_line[hor_pos][ver_pos] == 1) {
					ver_pos++;
				}
				hor_pos++;
			}
			
			if(ver_pos != i) {
				return false;
			}
		}

		return true;
	}
	
	public static void drawLine(int[][] changed, int num, int count) {
		if(min != Integer.MAX_VALUE)	return;
		if(count == num) {
			if(checkResult(changed))
				min = count;
			
			return;
		}
		
		for(int j=0; j<N-1; j++) {
			for(int i=0; i<H; i++) {
				if(changed[i][j] == 1)	continue;
				//양옆에 가로선이 있는지 체크
				if((j-1)>=0 && changed[i][j-1] == 1)	continue;
				if((j+1)<N-1 && changed[i][j+1] == 1)	continue;
				//가로선을 그림
				changed[i][j] = 1;
				drawLine(changed, num, count+1);
				//다시 되돌림
				changed[i][j] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int[][] hor_line = new int[H][N-1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			hor_line[a][b] = 1;
		}
		
		min = Integer.MAX_VALUE;
		for(int add=0; add<=3; add++) {
			int[][] changed = new int[H][N-1];
			//배열 복사
			for(int i=0; i<H; i++)
				for(int j=0; j<N-1; j++)	
					changed[i][j] = hor_line[i][j];
			
			drawLine(changed, add, 0);
		}
		
		if(min == Integer.MAX_VALUE)	min = -1;
		System.out.println(min);
	}
}