package d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1266_소수완제품확률_서울8반_정택진 {
	public static int A, B;
	public static final int[] sosu= {2,3,5,7,11,13,17};

	public static double nCr(int n, int r) {
		if(r==0) return 1.0;
		return 1.0*n/r*nCr(n-1, r-1);
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d6_1266.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			
			//A가 소수 개수를 만들 확률
			double prob_a=0;
			for(int i=0; i<sosu.length; i++) {
				prob_a+=nCr(18, sosu[i])*Math.pow(A/100.0, sosu[i])*Math.pow(1.0-A/100.0, 18-sosu[i]);
			}
			//B가 소수 개수를 만들 확률
			double  prob_b=0;
			for(int i=0; i<sosu.length; i++) {
				prob_b+=nCr(18, sosu[i])*Math.pow(B/100.0, sosu[i])*Math.pow(1.0-B/100.0, 18-sosu[i]);
			}
			
			//A와 B중 하나가 소수 개수를 만들 확률
			double result = prob_a+prob_b-prob_a*prob_b;

			System.out.printf("#%d %.6f\n",tc,result);
		}
	}
}