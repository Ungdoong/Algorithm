package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15651_N과M3_서울8반_정택진 {
	static StringBuilder sb;
	public static void comb(int[] arr, int N, int M, int depth) {		// 4 2 depth
		if(depth == M) {
			for(int b : arr)
				sb.append(b + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			arr[depth] = i;
			comb(arr, N, M, depth+1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		sb = new StringBuilder();
		comb(arr, N, M, 0);
		System.out.println(sb.toString());
	}
}