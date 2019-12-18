package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17822_원판돌리기_서울8반_정택진2 {
	static int n, m;
	static boolean flag;
	static int[][] map;

	public static void delete(int x, int y) {
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		Queue<int[]> q = new LinkedList<>();
		int target = map[x][y];
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int tmp[] = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if(ny == m)	ny = 0;
				else if(ny == -1) ny = m-1;
				if (1 <= nx && nx <= n && map[nx][ny] != 0 && target == map[nx][ny]) {
					flag = true;
					map[tmp[0]][tmp[1]] = 0;
					map[nx][ny] = 0;
					q.add(new int[] { nx, ny });
				}
			}
		}
	} 

	public static void rotate(int index, int dir, int count) {
		int[] tmp = new int[m];
		count %= m;
		if (dir == 0)
			for (int i = 0; i < m; i++)
				tmp[(i + count) % m] = map[index][i]; // 값 갱신 후
		else {
			for (int i = 0; i < m; i++) {
				tmp[(i + (m-count))%m] = map[index][i];
			}
		}
		for (int i = 0; i < m; i++)
			map[index][i] = tmp[i];// 값 넣기
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int tt = 0; tt < k; tt++) {
			st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= n; i++) { // 회전
				if (i % index == 0)
					rotate(i, dir, count);
			}
			// 회전 후 delete
			flag = false;
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0)
						delete(i, j);
				}
			}
			// delete 후 보정할 것인지
			if (!flag) {
				int sum = 0;
				int cnt = 0;
				for (int i = 1; i <= n; i++) {
					for (int j = 0; j < m; j++) {
						if (map[i][j] != 0) {
							cnt++;
							sum += map[i][j];
						}
					}
				}
				if (cnt != 0) { // 0으로 나누는 것은 안되니
					double avg = (double) sum / cnt;
					for (int i = 1; i <= n; i++) {
						for (int j = 0; j < m; j++) {
							if (map[i][j] == 0)
								continue;
							if (map[i][j] < avg)
								map[i][j]++;
							else if (map[i][j] > avg)
								map[i][j]--;
						}
					}
				}
			}
		}
		int result = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++)
				result += map[i][j];
		}
		System.out.println(result);
	}
}