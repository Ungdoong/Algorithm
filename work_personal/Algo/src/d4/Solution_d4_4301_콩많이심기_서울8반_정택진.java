package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_4301_콩많이심기_서울8반_정택진 {
	public static final int dx[] = { 0, 0, -2, 2 };
	public static final int dy[] = { -2, 2, 0, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4301.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];
			int sum1 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 1) {
						map[i][j] = 1;
						sum1++;
						for (int d = 0; d < 4; d++) {
							int nx = j + dx[d];
							int ny = i + dy[d];
							if (nx >= 0 && nx < M && ny >= 0 && ny < N)
								map[ny][nx] = 1;
						}
					}
				}
			}
//			map = new int[N][M];
//			int sum2 = 0;
//			map[0][0] = 1;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if (map[i][j] != 1) {
//						map[i][j] = 1;
//						sum2++;
//						for (int d = 0; d < 4; d++) {
//							int nx = j + dx[d];
//							int ny = i + dy[d];
//							if (nx >= 0 && nx < M && ny >= 0 && ny < N)
//								map[ny][nx] = 1;
//						}
//					}
//				}
//			}

//			int result = Math.max(sum1, sum2);

			System.out.println("#" + tc + " " + sum1);
		}
	}
}
