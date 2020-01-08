package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1226_미로1_Bfs_서울8반_정택진 {
	public static int[][] miro=new int[16][16];
	public static final int[] dx= {0,1,0,-1};
	public static final int[] dy= {-1,0,1,0};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1226.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			
			String str;
			int start_x=-1; int start_y=-1;
			for(int y=0; y<miro.length; y++) {
				str=br.readLine();
				for(int x=0; x<miro[0].length; x++) {
					miro[y][x] = str.charAt(x) - '0';
					if(str.charAt(x) == '2') { start_x=x;	start_y=y; }
				}
			}
			if(bfs(start_x, start_y))
				System.out.println("#"+tc+" "+1);
			else
				System.out.println("#"+tc+" "+0);
		}
	}
	
	public static boolean bfs(int cur_x, int cur_y) {
		Queue<String> q=new LinkedList<String>();
		
		q.add(cur_x+" "+cur_y);
		miro[cur_y][cur_x]=1;
		while(!q.isEmpty()) {
			StringTokenizer st=new StringTokenizer(q.poll());
			int cy=Integer.parseInt(st.nextToken());
			int cx=Integer.parseInt(st.nextToken());
			for(int i=0; i<4; i++) {
				int nx=cx+dx[i];
				int ny=cy+dy[i];
				if(nx>0 && nx<16 && ny>0 && ny<16 && miro[ny][nx] == 3)
					return true;
				if(nx>0 && nx<16 && ny>0 && ny<16 && miro[ny][nx] != 1) {
					q.add(ny+" "+nx);
					miro[ny][nx]=1;
				}
			}
		}		
		return false;
	}
}