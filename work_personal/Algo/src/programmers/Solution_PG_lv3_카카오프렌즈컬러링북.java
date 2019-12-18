package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_PG_lv3_카카오프렌즈컬러링북 {
	public static final int dx[] = {0, 0, -1, 1};
	public static final int dy[] = {-1, 1, 0, 0};
	
	static class Que{
		Node head;
		Node tail;
		int size;
		
		public Que() {
			head = null;
			tail = null;
			size = 0;
		}
		
		public boolean isEmpty() {
			return (size == 0)? true:false;
		}
		
		public void offer(Node n) {
			if(isEmpty()) {
				head = n;
				tail = n;
			}else {
				tail.next = n;
				tail = n;
			}
			
			size++;
		}
		
		public Node poll() {
			if(isEmpty())	return null;
			
			Node n = head;
			head = (head.next == null)? null:head.next;
			size--;
			return n;
		}
		
	}
	static class Node{
		int x;
		int y;
		Node next;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.next = null;
		}
	}
	
	
	public static int bfs(int[][] picture, int m, int n, int cx, int cy) {
		Que q = new Que();
		q.offer(new Node(cx, cy));
		int source = picture[cy][cx];
		int count = 0;
		picture[cy][cx] = 0;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int y = curr.y;
			int x = curr.x;
			count++;
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(nx<0 || nx>=n || ny<0 || ny>=m)	continue;
				if(picture[ny][nx] == source) {
					picture[ny][nx] = 0;
					q.offer(new Node(nx, ny));
				}
			}
		}
		
		return count;
	}
	
	public static int M, N, result;
	public static boolean visit[][];
	public static void dfs(int[][] picture, int n, int cx, int cy) {
		for(int d=0; d<4; d++) {
			int ny = cy + dy[d];
			int nx = cx + dx[d];
			if(nx<0 || nx>=N || ny<0 || ny>=M)	continue;
			if(picture[ny][nx] == n) {
				result++;
				picture[ny][nx] = 0;
				dfs(picture, n, nx, ny);
			}
		}
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		//dfs
		M = m;
		N = n;
		long start = System.nanoTime();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(picture[i][j] != 0) {
					numberOfArea++;
					//bfs
//					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(picture, m, n, j, i));
					//dfs
					result = 0;
					dfs(picture, picture[i][j], j, i);
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, result);
				}
			}
		}
		long end = System.nanoTime();
		System.out.println("실행 시간: "+(end-start)/1000.0);
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		int[][] picture = {{1,1,1,0},
						   {1,2,2,0},
						   {1,3,3,1},
						   {0,1,3,1},
						   {0,2,3,3},
						   {0,0,0,3}};
		System.out.println(Arrays.toString(solution(6, 4, picture)));
	}

}
