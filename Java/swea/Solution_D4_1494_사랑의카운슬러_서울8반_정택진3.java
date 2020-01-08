package d4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_1494_사랑의카운슬러_서울8반_정택진3 {

	static int n, sumX, sumY;
	static Long min;
	static int[][] m;
	static int[] set;

	public static void comb(int n, int r) {
		if (n < r)
			return;
		if (r == 0) {
			int sumSelectX = 0, sumSelectY = 0;
			for(int i=0; i<set.length; i++) {
				sumSelectX+=m[set[i]][0];
				sumSelectY+=m[set[i]][1];
			}
			int sumUnselectX = sumX-sumSelectX;
			int sumUnselectY = sumY-sumSelectY;
			
			long vx = sumSelectX - sumUnselectX;
			long vy = sumSelectY - sumUnselectY;
			min = Math.min(min, vx*vx+vy*vy);
			return;
		}
		set[r-1]=n-1;
//		System.out.println(Arrays.toString(set));
		comb(n-1,r-1);
		comb(n-1,  r);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1494.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			m = new int[n][2];
			sumX = 0;
			sumY = 0;
			for (int i = 0; i < n; i++) {
				m[i] = new int[] { sc.nextInt(), sc.nextInt() };
				sumX += m[i][0];
				sumY += m[i][1];
			}
			set = new int[n / 2];
			min = Long.MAX_VALUE;
			comb(n, n / 2);
			System.out.println("#"+t+" " + min);
		}
	}
}