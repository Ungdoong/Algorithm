package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2_서울8반_정택진 {
	static class Brg{
		int start;
		int end;
		int count;
		public Brg(int start, int end, int count) {
			this.start = start;
			this.end = end;
			this.count = count;
		}
	}
	
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	public static int H, W, map[][], w[];
	public static boolean visit[][];
	public static ArrayList<Brg> list;
	
	public static void masking(int index, int cx, int cy) {
		for(int d=0; d<4; d++) {
			int ny = cy + dy[d];
			int nx = cx + dx[d];
			if(nx<0 || nx>=W || ny<0 || ny>=H)	continue;
			if(map[ny][nx] == 1) {
				map[ny][nx] = index;
				masking(index, nx, ny);
			}
		}
	}
	
	public static void findBridge(int cx, int cy) {
		for(int d=0; d<4; d++) {
			int ny = cy + dy[d];
			int nx = cx + dx[d];
			if(nx<0 || nx>=W || ny<0 || ny>=H)	continue;
			if(map[ny][nx] == 0) {
				int nextY = ny;
				int nextX = nx;
				int count = 0;
				while(nextX >= 0 && nextX < W && nextY >= 0 && nextY < H && map[nextY][nextX] == 0) {
					count++;
					nextY += dy[d];
					nextX += dx[d];
				}
				if(nextX >= 0 && nextX < W && nextY >= 0 && nextY < H && count > 1) {
					int start = map[cy][cx]/10;
					int end = map[nextY][nextX]/10;
					list.add(new Brg(start, end, count));
				}
			}
			else if(!visit[ny][nx] && map[ny][nx] == 1) {
				visit[ny][nx] = true;
				findBridge(nx, ny);
			}
		}
	}
	
	public static int findSet(int a) {
		if(w[a] == a)	return a;
		else	return w[a] = findSet(w[a]);
	}
	
	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a < b)	w[b] = a;
		else 		w[a] = b;
	}
	
	public static int primPQ() {
		PriorityQueue<Brg> pq = new PriorityQueue<>(new Comparator<Brg>() {
			@Override
			public int compare(Brg o1, Brg o2) {
				return o1.count - o2.count;
			}
		});
		for(int i=0; i<list.size(); i++) {
			Brg curr = list.get(i);
			if(curr.start == 1)	pq.offer(curr);
		}
		
		int result = 0;
		while(!pq.isEmpty()) {
			Brg curr = pq.poll();
			int start = curr.start;
			int end = curr.end;
			if(findSet(start) != findSet(end)) {
				union(start, end);
				result += curr.count;
				for(int i=0; i<list.size(); i++) {
					Brg temp = list.get(i);
					if(temp.start == end) pq.offer(temp);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//섬 넘버링
		int index = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] == 1) {
					index += 10;
					map[i][j] = index;
					masking(index, j, i);
				}
			}
		}
		
		//간선 구하기
		index = index/10;
		list = new ArrayList<Brg>();
		visit = new boolean[H][W];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] != 0) {
					visit[i][j] = true;
					findBridge(j, i);
				}
			}
		}
		
		//최솟값 구하기
		w = new int[index+1];
		for(int i=0; i<index+1; i++) w[i] = i;
		int result = primPQ();
		for(int i=2; i<index+1; i++)
			if(findSet(1) != findSet(i))	result = -1;
		
		System.out.println(result);
	}
}