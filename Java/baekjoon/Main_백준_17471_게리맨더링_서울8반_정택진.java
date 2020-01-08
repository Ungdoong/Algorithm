package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17471_게리맨더링_서울8반_정택진 {
	public static int N, popul[], w[], min, sumAll;
	public static boolean bridges[][];
	
	public static int findSet(int a) {
		if(w[a] == a) return a;
		else	return w[a] = findSet(w[a]);
	}
	
	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a < b)	w[b] = a;
		else		w[a] = b;
	}
	
	public static boolean linkCheck(int n) {
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				int a = 1 & (n>>i);
				int b = 1 & (n>>j);
				if(a == b && findSet(i) != findSet(j))
					return false;
			}
		}
		return true;
	}
	
	public static void divide(int n) {
		w = new int[N];
		for(int i=0; i<N; i++)	w[i] = i;
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			int a = 1 & (n>>i);
			if(a == 0)	sum += popul[i];
			
			for(int j=i+1; j<N; j++) {
				int b = 1 & (n>>j);
				if(a != b)	continue;
				if(bridges[i][j] && findSet(i) != findSet(j))
					union(i, j);
			}
		}
		
		if(linkCheck(n))
			min = Math.min(min, Math.abs(sumAll - (2 * sum)));
	}
	
	public static void powerSet() {
		for(int i=1; i<Math.pow(2, N)-1; i++) {
			divide(i);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		popul = new int[N];
		bridges = new boolean[N][N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		sumAll = 0;
		for(int i=0; i<N; i++)	{
			popul[i] = Integer.parseInt(st.nextToken());
			sumAll += popul[i];
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j=0; j<M; j++) {
				bridges[i][Integer.parseInt(st.nextToken())-1] = true;
			}
		}

		min = Integer.MAX_VALUE;
		powerSet();
		if(min == Integer.MAX_VALUE)	min = -1;
		System.out.println(min);
	}
}