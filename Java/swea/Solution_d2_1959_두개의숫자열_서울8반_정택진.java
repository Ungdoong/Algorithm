package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1959_두개의숫자열_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d2_1959.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] tmp=br.readLine().split(" ");
			int N=Integer.parseInt(tmp[0]);
			int M=Integer.parseInt(tmp[1]);
			
			int[] A=new int[N];
			int[] B=new int[M];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)
				A[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++)
				B[i] = Integer.parseInt(st.nextToken());
		
			int max=0;
			if(N<M){
				for(int i=0; i<M-N+1; i++) {
					int sum=0;
					for(int j=0; j<N; j++) {
						sum += A[j] * B[i+j];
					}
					if(sum>max)
						max=sum;
				}
			}
			else {
				for(int i=0; i<N-M+1; i++) {
					int sum=0;
					for(int j=0; j<M; j++) {
						sum += B[j] * A[i+j];
					}
					if(sum>max)
						max=sum;
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}