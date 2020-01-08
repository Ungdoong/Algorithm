package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2817_부분수열의합_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_2817.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] tmp=br.readLine().split(" ");
			int N=Integer.parseInt(tmp[0]);
			int K=Integer.parseInt(tmp[1]);
			
			int[] numbers = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count=0;
			for(int i=0; i<N; i++)
				numbers[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<(1<<numbers.length); i++) {
				int sum=0;
				for(int j=0; j<numbers.length; j++) {
					if((i&(1<<j)) > 0)
						sum += numbers[j];
				}
				if(sum == K)
					count++;
			}
			
			System.out.println("#"+tc+" "+count);
		}
	}
}