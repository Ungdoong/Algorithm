package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_2805.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N=Integer.parseInt(br.readLine());
			
			int line_count=0;
			int result=0;
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					if(j >= (N/2-line_count) && j <= (N/2+line_count))
						result += line.charAt(j)-'0';
				}
				if(i<N/2)	line_count++;
				else		line_count--;
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}