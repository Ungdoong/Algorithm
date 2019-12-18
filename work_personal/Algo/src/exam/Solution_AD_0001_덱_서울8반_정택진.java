package exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_AD_0001_덱_서울8반_정택진 {
	public static int N, numbers[], min;
	
	public static int[] shuffle(int[] arr, int x) {
		ArrayList<Integer> left=new ArrayList<>();
		ArrayList<Integer> right=new ArrayList<>();
		for(int i=1; i<=N; i++) {
			if(i <= N/2) left.add(arr[i]);
			else		 right.add(arr[i]);
		}
		
		int tmp=N/2 - x; int i=1;
		while(tmp > 0)	{ arr[i++] = left.remove(0); tmp--; }
		while(tmp < 0)	{ arr[i++] = right.remove(0); tmp++; }

		while(i <= N) {
			if(right.size() > 0)	arr[i++] = right.remove(0);
			if(left.size() > 0)		arr[i++] = left.remove(0);
		}
		
		return arr;
	}
	
	public static boolean check(int[] arr) {
		for(int i=1; i<=N; i++)
			if(arr[i] != i) return false;
		return true;
	}
	
	public static boolean checkR(int[] arr) {
		for(int i=1; i<=N; i++) {
			if(arr[i] != N+1-i) return false;
		}
		return true;
	}
	
	public static void search(int[] arr, int count) {
		if(count > 5)	return;
		if(check(arr) || checkR(arr)) {
			min = Math.min(min, count);
			return;
		}
		
		for(int i=1; i<N-1; i++) {
			search(shuffle(arr, i), count+1);
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_ShuffleOMatic2019.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			numbers=new int[N+1];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++)	
				numbers[i] = Integer.parseInt(st.nextToken());
			
			min=6;
			search(numbers, 0);
			if(min == 6)	min=-1;
			System.out.println("#"+tc+" "+min);
		}
	}
}
