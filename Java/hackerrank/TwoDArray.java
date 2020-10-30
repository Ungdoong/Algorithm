package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoDArray {
	
	static int hourglassSum(int[][] arr) {
		final int N = arr.length;
		
		int max = -(Integer.MAX_VALUE-1);
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<N-2; j++) {
				int sum = arr[i][j] + arr[i][j+1]+ arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				
				max = Math.max(max, sum);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = { { -9, -9, -9, 1, 1, 1 }, { 0, -9, 0, 4, 3, 2 }, { -9, -9, -9, 1, 2, 3 }, { 0, 0, 8, 6, 6, 0 },
				{ 0, 0, 0, -2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		
		System.out.println(hourglassSum(arr));
	}
}
