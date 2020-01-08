package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_3459_승자예측하기_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_3459.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		final String[] name = {"Alice", "Bob"};
		
		for(int tc=1; tc<=T; tc++) {
			long N=Long.parseLong(br.readLine());
			
			long x = 1;
			long round = 0;
			while(x <= N) {
				long tmp=x*2;
				boolean me=true;
				while(N-tmp >= 0) {tmp *= 2; me = !me;}
				if(!me)	x *= 2;
				else	x = 2*x+1;
				
				round++;
			}
			
			System.out.println("#"+tc+" "+name[(int)round%2]);
		}
	}
}
