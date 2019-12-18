package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_정올_2074_홀수마방진_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_2074.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		int cy = 0;
		int cx = N/2;
		for(int num=1; num<=N*N; num++) {
			map[cy][cx] = num;
			
			if(map[cy][cx]%N == 0) {
				cy++;
			}else {
				cy--;
				cx--;
				if(cy < 0)	cy = N-1;
				if(cx < 0)	cx = N-1;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
