package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1828.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[0] == o2[0])? (o1[1] - o2[1]):(o1[0] - o2[0]);
			}
		});
		int result=1;
		int max=arr[0][1];
		for(int i=0; i<N-1; i++) {
			if(max < arr[i+1][0])	{ result++; max=arr[i+1][1]; }
			else if(max > arr[i+1][1]){ max=arr[i+1][1]; }
		}
		
		System.out.println(result);
	}
}
