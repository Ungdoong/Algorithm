package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Prim_서울8반_정택진 {
	public static int N;
	public static double w[], bridges[][];
	
	public static double prim() {
		w=new double[N];
		Arrays.fill(w, -1);
		w[0]=0;
		for(int k=1; k<N; k++) {
			double minW=Double.MAX_VALUE/2;
			int minV=0;
			for(int i=0; i<N; i++) {
				if(w[i] < 0)	continue;
				for(int j=0; j<N; j++) {
					if(w[j] >= 0)	continue;
					if(bridges[i][j] < minW) {
						minW = bridges[i][j];
						minV = j;
					}
				}
				
			}
			w[minV] = minW;
		}
		double sum=0;
		for(int i=0; i<N; i++)	sum += w[i];
		
		return sum;
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			
			int[][] nodes = new int[N][2];
			bridges=new double[N][N];
			StringTokenizer st=new StringTokenizer(br.readLine());
			StringTokenizer st2=new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nodes[i][0]=Integer.parseInt(st.nextToken());
				nodes[i][1]=Integer.parseInt(st2.nextToken());
			}
				
			
			double E=Double.parseDouble(br.readLine());
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int x1=nodes[i][0];
					int y1=nodes[i][1];
					int x2=nodes[j][0];
					int y2=nodes[j][1];
					double dis=Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2);
					bridges[i][j]=dis;
					bridges[j][i]=dis;
				}
			}
			
			System.out.println("#"+tc+" "+Math.round(E*prim()));
		}
	}
}
