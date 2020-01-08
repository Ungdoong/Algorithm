package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1719_별삼각형2_서울8반_정택진 {
	public static void print(int s, int b) {
		for(int i=0; i<b; i++)
			System.out.print("  ");
		for(int i=0; i<s; i++)
			System.out.print("* ");
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken())-1;
		
		if(n < 0 || n > 100 || n%2 == 0 || m < 0 || m > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int[][] star = new int[4][n];
		int[][] blank = new int[4][n];
		
		int p = n/2;
		for(int i=0; i<n; i++) {
			star[0][i] = star[1][i] = p-Math.abs(p-i)+1;
			blank[1][i] = Math.abs(p-i);
			star[2][i] = n-2*(star[0][i]-1);
			blank[2][i] = star[0][i] - 1;
			star[3][i] = p-star[0][i]+2;
			blank[3][i] = Math.min(i, p);
		}
		
		for(int i=0; i<n; i++) {
			print(star[m][i], blank[m][i]);
		}
	}
}
