package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1863_종교_서울8반_정택진 {
	public static int arr[];
	
	public static int findSet(int a) {
		if(arr[a] == a) return a;
		return arr[a] = findSet(arr[a]);
	}
	


	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1863.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for(int i=1; i<=N; i++)	arr[i] = i;
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int src=Integer.parseInt(st.nextToken());
			int dst=Integer.parseInt(st.nextToken());
			int r_src=findSet(src);
			int r_dst=findSet(dst);
			if(r_src != r_dst) {
				if(r_src < r_dst)	arr[r_dst] = r_src;
				else				arr[r_src] = r_dst;
			}
		}
		
		int result = 0;
		for(int i=1; i<=N; i++)	if(arr[i] == i)	result++;
		
		System.out.println(result);
	}
}
