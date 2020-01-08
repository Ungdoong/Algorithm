package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15686_치킨배달_서울8반_정택진 {
	public static boolean v[];
	public static int N, M, cnt;

	public static void Comb(int[][] home, int chicken[][], int[] geori, int r, int depth) {
		if (depth == r) {
			geori = new int[home.length];
			int sum = 0;
			for (int ii = 0; ii < chicken.length; ii++) {
				if (v[ii]) {
					for (int i = 0; i < home.length; i++) {
						int dis = Math.abs(home[i][0] - chicken[ii][0]) + Math.abs(home[i][1] - chicken[ii][1]);
						if (geori[i] == 0) {
							geori[i] = dis;
							sum += geori[i];
						} else if (geori[i] != 0 && dis < geori[i]) {
							sum = sum - geori[i] + dis;
							geori[i] = dis;
						}
					}
				}
			}
			if (cnt > sum)
				cnt = sum;
			return;
		}
		for (int i = depth; i < chicken.length; i++) {
			v[i] = true;
			Comb(home, chicken, geori, r, depth + 1);
			v[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집
		int map[][] = new int[N + 1][N + 1];
		int hcnt = 0, ccnt = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					hcnt++;
				if (map[i][j] == 2)
					ccnt++;
			}
		} // 입력끝
		int[][] home = new int[hcnt][2];
		int[][] chicken = new int[ccnt][3];
		v = new boolean[ccnt];
		int c = 0, cc = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					home[c][0] = i;
					home[c][1] = j;
					c++;
				} else if (map[i][j] == 2) {
					chicken[cc][0] = i;
					chicken[cc][1] = j;
					cc++;
				}
			}
		}
		
		cnt = Integer.MAX_VALUE;
//		int[] geori = new int[home.length];
//		Comb(home, chicken, geori, M, 0);
		comb2(home, chicken, 0, 0);
		System.out.println(cnt);
	}
	
	public static void comb2(int[][] home, int[][] chicken, int count, int start) {
		if(count == M) {
			int[][] selected = new int[M][2];
			int index = 0;
			for(int i=0; i<chicken.length; i++)
				if(chicken[i][2] == 1) {
					selected[index][0] = chicken[i][0];
					selected[index++][1] = chicken[i][1];
				}
			check(home, selected);
			return;
		}
		
		for(int i=start; i<chicken.length; i++) {
			if(chicken[i][2] == 0) {
				chicken[i][2] = 1;
				comb2(home, chicken, count+1, i+1);
				chicken[i][2] = 0;
			}
		}
	}
	
	public static void check(int[][] home, int[][] chicken) {
		int sum = 0;
		for(int i=0; i<home.length; i++) {
			int hy = home[i][0];
			int hx = home[i][1];
			
			int min = Integer.MAX_VALUE;
			for(int j=0; j<chicken.length; j++) {
				int dis = Math.abs(hy - chicken[j][0]) + Math.abs(hx - chicken[j][1]);
				min = Math.min(min, dis);
			}
			sum += min;
		}
		
		cnt = Math.min(cnt, sum);
	}
}