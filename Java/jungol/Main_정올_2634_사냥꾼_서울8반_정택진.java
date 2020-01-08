package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_2634.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		
		int[] sni=new int[M];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++)	{
			sni[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sni);
		
		//사냥꾼이 만명 이상일때 32팀으로 나눔
		int[] boundary = new int[32];
		if( M >= 10000) {
			for(int j=1; j<=32; j++) {
				boundary[j-1] = sni[((M*j)>>5)-1];
			}
		}
		
		int result=0;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(y > L)	continue;
			
			int sec_start = 0, sec_end = M;
			if( M >= 10000) {
				sec_start = (M*31)>>5;
				for(int j=0; j<32; j++) {
					if(x < boundary[j]) {
						if(j == 0)	sec_start = 0;
						else		sec_start = ((M*j)>>5)-1;
						sec_end = ((M*(j+1))>>5);
						break;
					}
				}
			}
			
			for(int j=sec_start; j<sec_end; j++)
				if(Math.abs(x-sni[j])+y <= L) { result++; break; }
		}
		
		System.out.println(result);
	}
}
