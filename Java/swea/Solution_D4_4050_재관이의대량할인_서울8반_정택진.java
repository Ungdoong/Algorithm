package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4050_재관이의대량할인_서울8반_정택진 {
	
	public static int N;
	
	public static void quickSort(int[] prices, int start, int end) {
		int left = start;
		int right = end;
		int pivot = prices[(start+end)/2];
		
		do {
			while(prices[left] > pivot)	left++;
			while(prices[right] < pivot) right--;
			
			if(left<=right) {
				int tmp = prices[left];
				prices[left] = prices[right];
				prices[right] = tmp;
				if(left == right)	right++;
				left++;
				right--;
			}
			
		}while(left <= right);
		
		if(left < end)	quickSort(prices, left, end);
		if(right > start) quickSort(prices, start, right);
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_4050.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int[] prices = new int[N];
			for(int i=0; i<N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			quickSort(prices, 0, N-1);
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(i%3 == 2)	continue;
				sum += prices[i];
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}
