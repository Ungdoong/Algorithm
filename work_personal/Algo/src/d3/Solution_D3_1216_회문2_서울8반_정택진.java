package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1216_회문2_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1216.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			char[][] ch_arr = new char[100][];
			int result=-1;
			
			//배열 초기화
			for(int i=0; i<100; i++)
				ch_arr[i] = br.readLine().toCharArray();
			
			for(int N=3; N<=99; N++) {
				for(int y=0; y<ch_arr.length; y++) {
					for(int x=0; x<ch_arr[0].length; x++) {
						//수평검사
						if((x+(N-1)) < ch_arr[0].length) {
							for(int k=0; k<N/2; k++) {
								if(ch_arr[y][x+k] != ch_arr[y][x+(N-1)-k])
									break;
								else if(k==(N/2)-1)
									result=N;
							}
						}
						
						//수직검사
						if((y+(N-1)) < ch_arr.length) {
							for(int k=0; k<N/2; k++) {
								if(ch_arr[y+k][x] != ch_arr[y+(N-1)-k][x])
									break;
								else if(k==(N/2)-1)
									result=N;
							}
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+ result);
		}
	}
}