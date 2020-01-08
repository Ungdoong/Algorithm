package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_5601_쥬스나누기_서울8반_정택진 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_5601.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			System.out.print("#"+tc);
			for(int i=0; i<N; i++)
				System.out.print(" 1/"+N);
			System.out.println();
		}
	}
}