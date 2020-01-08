package d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_1486_장훈이의높은선반_서울8반_정택진2 {
	public static int N;
	public static int min;
	public static int height[];

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int perm(int depth, int N, int B) {
		int hap = 0;
		if (depth == N) {
			// System.out.println(Arrays.toString(arr));
			for (int i = 0; i < N; i++) {
				hap += height[i];
				if (B <= hap) {
					min = (hap - B < min) ? hap - B : min;
					break;
				}
			}
		}

		for (int i = depth; i < N; i++) {
			swap(height, depth, i);
			perm(depth + 1, N, B);
			swap(height, depth, i);
		}
		return min;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_height.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			int N = sc.nextInt();
			int B = sc.nextInt();
			height = new int[N + 1];
			for (int i = 0; i < N; i++) {
				height[i] = sc.nextInt();
			}
			// perm(height, 0, N, B);
			Arrays.sort(height);
			System.out.println("#" + tc + " " + perm(0, N, B));

		}
	}

}