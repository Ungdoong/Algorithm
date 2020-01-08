package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1_서울8반_정택진 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_D4_1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//테스트 케이스 루프
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			int[][] ladder = new int[100][102];
			
			int Xx=-1;
			//사다리 2차원 배열 초기화
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j] == 2)
						Xx=j;
				}
			}
			
			int height=99;
			while(height > 0) {
				if(ladder[height][Xx+1] == 1) {
					while(ladder[height][Xx+1] == 1)
						Xx++;
					height--;
				}
				else if(ladder[height][Xx-1] == 1) {
					while(ladder[height][Xx-1] == 1)
						Xx--;
					height--;
				}
				else	height--;
			}
			
			System.out.println("#"+tc+" "+(Xx-1));
		}
	}
}