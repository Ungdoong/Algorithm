package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_정올_2606_토마토초_서울8반_이재은 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		int dx[] = {0, 0, 1, -1, -N, N};
		int dy[] = {1, -1, 0, 0, 0, 0};
		int tomato[][] = new int[N * H][M];
		Queue<int[]> q = new LinkedList<int[]>();
		int cnt = 0;
		for (int i = 0; i < N * H; i++) {
			for (int j = 0; j < M; j++) {
				tomato[i][j] = sc.nextInt();
				if (tomato[i][j] == 1)
					q.add(new int[]{i, j});
				if (tomato[i][j] == 0)
					cnt++;
			}
		} // 입력
		
		int max = 1;
		while (!q.isEmpty()) {
			int temp[] = q.poll();
			int x = temp[0];
			int y = temp[1];
			for (int k = 0; k < 6; k++) {
				int ni = x + dx[k];
				int nj = y + dy[k];
				
				if (ni >= 0 && ni < N * H && nj >= 0 && nj < M) {
					if (tomato[ni][nj] != 0)
						continue;
					else {
						tomato[ni][nj] = tomato[x][y] + 1;
						q.offer(new int[]{ni, nj});
						cnt--;
						max = tomato[ni][nj];
					}
				}
			}
		}
		
		if (cnt > 0)
			System.out.println("-1");
		else
			System.out.println(max - 1);

		sc.close();
	}
}
