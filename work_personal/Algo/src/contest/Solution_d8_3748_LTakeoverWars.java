package contest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d8_3748_LTakeoverWars {
	
	public static int N, M;
	
	public static void quickSort(long[] arr, int start, int end) {
		int left = start;
		int right = end;
		long pivot = arr[(start+end)/2];
		
		do {
			while(arr[left] > pivot)	left++;
			while(arr[right] < pivot)	right--;
			
			if(left<=right) {
				long tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				if(left == right)	right++;
				left++;
				right--;
			}
		}while(left <= right);
		
		if(left < end)	quickSort(arr, left, end);
		if(right > start) quickSort(arr, start, right);
	}
	
	public static long getMax(long[] arr) {
		long max = 0;
		for(int i=0; i<arr.length; i++)
			max = Math.max(max, arr[i]);
		
		return max;
	}
	
	public static void friendly(long[] arr) {
		arr[0] += arr[1];
		arr[1] = 0;
	}
	
	public static void hostile(long[] arr) {
		arr[0] = 0;
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d8_3748.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			long[] takeover = new long[N];
			long[] buyout = new long[M];
			st=new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++)
				takeover[i] = Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++)
				buyout[i] = Integer.parseInt(st.nextToken());
			
			int size_takeover = takeover.length;
			int size_buyout = buyout.length;
			while(size_takeover > 0 && size_buyout > 0) {
				quickSort(takeover, 0, takeover.length-1);
				quickSort(buyout, 0, buyout.length-1);
				
				//takeover turn
				if(takeover[0] <= buyout[0]) {
					friendly(takeover);
					size_takeover--;
				}else {
					hostile(buyout);
					size_buyout--;
				}
				
				if(size_takeover == 0 || size_buyout == 0)	break;
				
				quickSort(takeover, 0, takeover.length-1);
				quickSort(buyout, 0, buyout.length-1);
				
				//buyout turn
				if(takeover[0]>= buyout[0]) {
					friendly(buyout);
					size_buyout--;
				}else {
					hostile(takeover);
					size_takeover--;
				}
			}
			
			if(size_takeover == 0)
				System.out.println("#"+tc+" Buyout Limited");
			else if(size_buyout == 0)
				System.out.println("#"+tc+" Takeover Incorporated");
		}
	}

}
