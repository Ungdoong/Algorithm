package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D3_2806_NQeen_서울8반_정택진 {
	public static int N, result, col[];
	
	public static boolean promise(int i) {
		for(int j=0; j<i; j++)
			if(col[i]==col[j] | (Math.abs(col[i] - col[j])==(i-j)))
				return false;
		return true;
	}
	
	public static void nqueen(int i) {
		if(i==N)
			result++;
		else {
			for(int j=0; j<N; j++) {
				col[i]=j;
				if(promise(i)) nqueen(i+1);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_2806.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			result=0;
			col=new int[N];
			nqueen(0);
			
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}