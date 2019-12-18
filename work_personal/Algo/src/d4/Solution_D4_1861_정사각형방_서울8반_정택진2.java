package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_서울8반_정택진2 {
	public static final int dx[] = { 0, 0, -1, 1 };
	public static final int dy[] = { -1, 1, 0, 0 };
	
	static class Room{
		int x;
		int y;
		int value;
		int count;
		public Room(int x, int y, int value, int count) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int rooms[][] = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++)
					rooms[i][j] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			int start_value = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int root = rooms[i][j];
					Stack<Room> stack=new Stack<Room>();
					stack.push(new Room(j, i, root, 1));
					
					while(!stack.isEmpty()) {
						Room curr=stack.pop();
						if(max < curr.count) {
							max = curr.count;
							start_value = root;
						}else if(max == curr.count && start_value > root)	start_value = root;
						
						for(int d=0; d<4; d++) {
							int ny = curr.y + dy[d];
							int nx = curr.x + dx[d];
							if(rooms[ny][nx] == curr.value+1)
								stack.push(new Room(nx, ny, rooms[ny][nx], curr.count+1));
						}
					}
				}
			}

			System.out.println("#"+tc+" "+start_value+" "+max);
		}
	}
}
