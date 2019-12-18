package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_1695_단지번호붙이기_Bfs_서울8반_정택진 {
	public static final int[] dx= {0,1,0,-1};
	public static final int[] dy= {-1,0,1,0};
	public static int N, count, size;
	public static boolean town[][], visit[][];
	public static ArrayList<Integer> result=new ArrayList<Integer>();
	public static Queue<String> q=new LinkedList<String>();
	
	public static void bfs(boolean flag) {
		if(flag) {
			StringTokenizer st;
			while(size-- > 0) {
				st=new StringTokenizer(q.poll());
				int y=Integer.parseInt(st.nextToken());
				int x=Integer.parseInt(st.nextToken());
				for(int i=0; i<4; i++) {
					int ny= y + dy[i];
					int nx= x + dx[i];
					if(nx>=0 && nx<N && ny>=0 && ny<N &&
							town[ny][nx] && !visit[ny][nx]) {
						visit[ny][nx] = true;
						count++;
						q.offer(ny+" "+nx);
					}
				}
			}
			size=q.size();
			if(size != 0)
				bfs(true);
			flag=false;
		}else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(town[i][j] && !visit[i][j]) {
						visit[i][j] = true;
						count++;
						q.offer(i+" "+j);
						size=q.size();
						bfs(true);
						result.add(count);
						count=0;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1695.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		town=new boolean[N][N];
		for(int i=0; i<N; i++) {
			String s=br.readLine();
			for(int j=0; j<N; j++) {
				town[i][j]=(s.charAt(j)=='1')? true:false;
			}
		}
		visit=new boolean[N][N];
		bfs(false);
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int r: result)
			System.out.println(r);
	}
}