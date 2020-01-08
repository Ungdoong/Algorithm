package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17822_원판돌리기_서울8반_정택진 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static int N, M, T;
	
	static class DataSet{
		Data[][] table;
		
		public DataSet(int N) {
			this.table = new Data[N+1][3];
		}

		public void add(int n, int num) {
			Data d = new Data(num);
			if(table[n][0] == null) {
				table[n][0] = d;
				table[n][1] = d;
			}else {
				table[n][1].next = d;
				d.prev = table[n][1];
				table[n][1] = d;
			}
		}
		
		public void rotate(int pos, int dir, int num) {
			for(int j=1; j*pos <= N; j++) {
				int index = j*pos;
				for(int i=0; i<num; i++) {
					if(dir == 0) {
						Data tmp = table[index][1];
						table[index][1] = tmp.prev;
						table[index][1].next = null;
						tmp.next = table[index][0];
						tmp.prev = null;
						table[index][0].prev = tmp;
						table[index][0] = tmp;
					}else {
						int x = 1;
						Data tmp = table[index][0];
						tmp.next.prev = null;
						table[index][0] = tmp.next;
						tmp.next = null;
						tmp.prev= table[index][1];
						table[index][1].next = tmp;
						table[index][1] = tmp;
					}
				}
			}
		}
		
		public int[][] getArr(){
			int[][] arr = new int[N][M];
			for(int i=1; i<=N; i++) {
				Data cur = table[i][0];
				for(int j=0; j<M; j++) {
					arr[i-1][j] = cur.num;
					cur = cur.next;
				}
			}
			
			return arr;
		}
		
		public double getAver() {
			int aver = 0;
			int number = 0;
			for(int i=1; i<=N; i++) {
				Data cur = table[i][0];
				for(int j=0; j<M; j++) {
					if(cur.num != 0) {
						aver += cur.num;
						number++;
					}
					cur = cur.next;
				}
			}
		
			return (aver/(double)number);
		}
		
		public void adjust() {
			double aver = getAver();
			for(int i=1; i<=N; i++) {
				Data curr = table[i][0];
				for(int j=0; j<M; j++) {
					if(curr.num != 0) {
						curr.num += Double.compare(aver, curr.num);
					}
					curr = curr.next;
				}
			}
		}
		
		public int getSum() {
			int sum = 0;
			for(int i=1; i<=N; i++) {
				Data curr = table[i][0];
				for(int j=0; j<M; j++) {
					if(curr.num != 0) {
						sum += curr.num;
					}
					curr = curr.next;
				}
			}
			
			return sum;
		}
		
		public void setArr(int[][] arr) {
			for(int i=1; i<=N; i++) {
				Data cur = table[i][0];
				for(int j=0; j<M; j++) {
					cur.num = arr[i-1][j];
					cur = cur.next;
				}
			}
		}
		
		public void print() {
			for(int i=1; i<=N; i++) {
				Data cur = table[i][0];
				while(cur != null) {
					System.out.print(cur.num+" ");
					cur = cur.next;
				}
				System.out.println();
			}
		}

		static class Data{
			int num;
			Data next;
			Data prev;
			public Data(int num) {
				this.num = num;
				this.next = null;
				this.prev = null;
			}
		}
	}
	
	public static boolean bfs(int[][] arr, int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		int target = arr[y][x];
		q.offer(new int[] {y, x});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cy = curr[0];
			int cx = curr[1];
			
			for(int d=0; d<4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				
				if(nx == M)	nx = 0;
				else if(nx == -1) nx = M-1;
				
				if(ny<0 || ny>=N || arr[ny][nx] == 0)	continue;
				
				if(arr[ny][nx] == target) {
					arr[cy][cx] = 0;
					arr[ny][nx] = 0;
					q.offer(new int[] {ny, nx});
				}
			}
		}
		
		if(arr[y][x] == 0)	return true;
		else 				return false;
	}
	
	public static void deleteOrAdjust(DataSet ds, int[][] arr) {
		boolean flag = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0)	continue;
				if(bfs(arr, i, j)) {
					flag = true;
				}
			}
		}
		
		ds.setArr(arr);
		if(!flag)	ds.adjust();
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		DataSet ds = new DataSet(N);
		
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				ds.add(i, Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0; i<T; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int pos = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			ds.rotate(pos, dir, num);
			deleteOrAdjust(ds, ds.getArr());
		}

		System.out.println(ds.getSum());
	}
}