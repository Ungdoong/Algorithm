package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_서울8반_정택진 {
	public static final int dx[] = { 0, 0, -1, 1};
	public static final int dy[] = { -1, 1, 0, 0};
	public static int N, rooms[][], max, root_max, tmp_root;
	
	public static void dfs(int y, int x, int count) {
		int target = rooms[y][x]+1;
		
		if(max < count) {
			max = count;
			root_max = tmp_root;
		}else if(max == count && root_max > tmp_root)	root_max = tmp_root;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(rooms[ny][nx] == target) {
				dfs(ny, nx, count+1);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			rooms = new int[N+2][N+2];
			for(int i=1; i<=N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++)
					rooms[i][j] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++) {
					tmp_root = rooms[i][j];
					dfs(i,j, 1);
				}
			
			System.out.println("#"+tc+" "+root_max+" "+max);
		}
	}
}
