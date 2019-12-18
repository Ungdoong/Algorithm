package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
..........[6]
.....13.....73..12
[3].28.............[0]
..24........67.....17
....[1].62.........[4]
...................20
...............45....
..........[5]..37..[2]      
*/
public class PrimTest1 {
	public static int N=7;
	// /2 를 안하면 INF에 + 를 했을때 음수로 넘어갈 수 있기 때문에 반으로 나눠준다.
	public static int INF=Integer.MAX_VALUE/2;
	public static int[][] a={
		{  0, 67,INF, 28, 17,INF, 12},
		{ 67,  0,INF, 24, 62,INF,INF},
		{INF,INF,  0,INF, 20, 37,INF},
		{ 28, 24,INF,  0,INF,INF, 13},
		{ 17, 62, 20,INF,  0, 45, 73},
		{INF,INF, 37,INF, 45,  0,INF},
		{ 12,INF,INF, 13, 73,INF,  0},
	};
	
	public static int prim() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		boolean[] v = new boolean[N];
		
		v[0] = true;
		int sum = 0;
		for(int next = 0; next < N; next++) {
			pq.offer(new int[] {a[0][next], next});
		}
		while(!pq.isEmpty()) {
			int[] curra = pq.poll();
			int weight = curra[0];
			int curr = curra[1];
			if(!v[curr]) {
				v[curr] = true;
				sum += weight;
				System.out.println("curr" + curr + " weight " + weight + " sum= " + sum);
				for(int next = 0; next < N; next++) {
					pq.offer(new int[] {a[curr][next], next});
				}
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(prim());
	}
}
