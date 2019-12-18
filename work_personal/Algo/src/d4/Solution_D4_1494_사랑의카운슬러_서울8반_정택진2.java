package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1494_사랑의카운슬러_서울8반_정택진2 {
	static long min;
	static int n;
	static int[][] map;
	static boolean[] visit;
	public static void find(int start, int count) {
		if (count == n / 2) {
			long vx = 0;
			long vy = 0;
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					vx += map[i][0];
					vy += map[i][1];
				} else {
					vx -= map[i][0];
					vy -= map[i][1];
				}
			}
			min = Math.min(min, vx * vx + vy * vy);
			return;
		}
		for (int i = start; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				find(i, count + 1);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1494.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][2];
			visit = new boolean[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			min = Long.MAX_VALUE;
			find(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
}