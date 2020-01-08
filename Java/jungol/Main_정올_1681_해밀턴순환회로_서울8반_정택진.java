package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로_서울8반_정택진 {
	public static final int INF = Integer.MAX_VALUE/2;
	public static int N;
	
	public static boolean bitCheck(int b, int k) {
		return (((b >> k) & 1) == 1)? true:false;
	}
	
	public static int bitClear(int b, int k) {
		return (((b >> k) & 1) == 1)? (int)(b-Math.pow(2, k)):b;
	}
	
	public static int held_Karp(int[][] cost, int[][] D) {
		int limits = (1 << N) - 1;
		
		for(int bits=7; bits <= limits; bits+=2) {
			for(int last=1; last<N; last++) {
				
				if(!bitCheck(bits, last))	continue;
				if(D[bits][last] != 0)		continue;
				
				D[bits][last] = INF;
				
				int prevbits = bitClear(bits, last);
				
				for(int prevlast=1; prevlast<N; prevlast++) {
					
					if(!bitCheck(prevbits, prevlast))	continue;
					if(D[prevbits][prevlast] == INF)	continue;
					if(cost[prevlast][last] == INF)		continue;
					
					D[bits][last] = Math.min(D[bits][last]
										   , D[prevbits][prevlast] + cost[prevlast][last]);
				}
			}
		}
		
		int min = INF;
		
		for(int last=1; last<N; last++) {
			if(D[limits][last] == INF)	continue;
			if(cost[last][0] == INF)	continue;
			
			min = Math.min(min, D[limits][last] + cost[last][0]);
		}
		
		return min;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N][N];
		int[][] D = new int[1<<N][N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
				cost[i][j] = (cost[i][j] == 0)? INF:cost[i][j];
			}
		}
		
		for(int i=1; i<N; i++)
			D[(1<<i)|1][i] = cost[0][i];
		
		System.out.println(held_Karp(cost, D));
	}
}
