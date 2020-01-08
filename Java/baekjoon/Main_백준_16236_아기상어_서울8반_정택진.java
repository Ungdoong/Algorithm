package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16236_아기상어_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static int N;
	
	static class MyQueue{
		int size;
		Node head;
		Node tail;

		public MyQueue() {
			this.size = 0;
			this.head = null;
		}

		public void offer(Object o) {
			Node n = new Node(o);
			
			if(size == 0)	{
				head = n;
				tail = n;
			}
			else {
				tail.next = n;
				tail = n;
			}
			
			size++;
		}
		
		public Object poll() {
			Node n = head;
			size--;
			if(size == 0)	head = null;
			else			head = n.next;
			
			return n.content;
		}
		
		public boolean isEmpty() {
			return (size == 0)? true:false;
		}

		static class Node{
			Object content;
			Node next;
			
			public Node(Object content) {
				this.content = content;
				this.next = null;
			}
		}
	}
	
	public static void replaceMin(int[] min, int y, int x, int count) {
		min[0] = y;
		min[1] = x;
		min[2] = count;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] shark = new int[4];
		int fish_num = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
					shark[2] = 2;
				}else if(map[i][j] != 0) fish_num++;
			}
		}
		
		int time = 0;
		while(fish_num > 0) {
			//최소값 찾기
			MyQueue q = new MyQueue();
			q.offer(new int[] {shark[0], shark[1], 0});
			boolean[][] visit = new boolean[N][N];
			visit[shark[0]][shark[1]] = true;
			
			int[] min = new int[3];
			min[2] = Integer.MAX_VALUE;
			while(!q.isEmpty()) {
				int[] curr = (int[]) q.poll();
				int y = curr[0];
				int x = curr[1];
				int count = curr[2];
				
				if(count > min[2])	break;
				
				if(map[y][x] != 0 && map[y][x] != 9 && map[y][x] < shark[2]) {
					if(min[2] > count) {
						replaceMin(min, y, x, count);
					}else if(min[2] == count) {
						if(min[0] > y) {
							replaceMin(min, y, x, count);
						}else if(min[0] == y) {
							if(min[1] > x)	replaceMin(min, y, x, count);
						}
					}
				}
				
				
				//주변 탐색
				for(int d=0; d<4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(nx<0 || ny<0 || nx>=N || ny>=N || visit[ny][nx] || map[ny][nx] > shark[2])	continue;
					
					visit[ny][nx] = true;
					q.offer(new int[] {ny, nx, count+1});
				}
			}
			
			if(min[2] == Integer.MAX_VALUE)	break;
			
			//최소값 제거
			int ny = min[0];
			int nx = min[1];
			//상어위치 0으로 만들고 이동
			map[shark[0]][shark[1]] = 0;
			map[ny][nx] = 9;
			shark[0] = ny;
			shark[1] = nx;
			shark[3]++;
			if(shark[3] == shark[2]) {
				shark[2]++;
				shark[3] = 0;
			}
			fish_num--;
			//시간증가
			time += min[2];
		}
		
		System.out.println(time);
	}
}