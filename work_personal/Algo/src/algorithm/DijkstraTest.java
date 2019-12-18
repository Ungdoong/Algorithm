package algorithm;

import java.util.Arrays;

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
public class DijkstraTest {
	public static int getSmallIndex() {
		int min = INF;
		int index = 0;
 		for(int i = 0; i < N; i++) {
 			if(d[i] < min && !v[i]) {
 				min = d[i];
 				index = i;
 			}
 		}
 		return index;
	}
	public static void Dijkstra(int start) {
		for(int i = 0; i < N; i++) {
			d[i] = a[start][i];
		}
		v[start] = true;
		for(int i = 0; i < N - 2; i++) {
			int curr = getSmallIndex();
			v[curr] = true;
			for(int j = 0; j < N; j++) {
				if(!v[j]) {
					if(d[j] > d[curr] + a[curr][j]) {
						d[j] = d[curr] + a[curr][j];
					}
				}
			}
			System.out.println(Arrays.toString(d));
		}
	}
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
	public static int[] d; // 가중치 배열
	public static boolean[] v;
	
	public static void main(String[] args) {
		v = new boolean[N];
		d = new int[N];
		Dijkstra(0);
		for(int i = 0; i < N; i++) {
			System.out.println(d[i] + " ");
		}
		
	}
}
