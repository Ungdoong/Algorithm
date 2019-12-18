package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_17140_이차월배열과연산_서울8반_정택진 {
	public static int r, c, k, row_max, col_max;
	
	public static void drawing(int[][] A, HashMap<Integer, Integer> map, int i, boolean isRow) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[1] != o2[1])?Integer.compare(o1[1], o2[1]):Integer.compare(o1[0], o2[0]);
			}
		});

		Set<Integer> keys = map.keySet();
		for(int key: keys) {
			pq.offer(new int[] {key, map.get(key)});
		}
		for(int z=0; z<100; z++) {
			if(isRow)	A[i][z] = 0;
			else		A[z][i] = 0;
		}
		
		int j = 0;
		while(!pq.isEmpty() && j < 100) {
			int[] curr = pq.poll();
			if(isRow) {
				A[i][j++] = curr[0];
				if(j>=100)	break;
				A[i][j++] = curr[1];
			}else {
				A[j++][i] = curr[0];
				if(j>=100)	break;
				A[j++][i] = curr[1];
			}
		}
		
		if(isRow)	col_max = Math.max(col_max, j);
		else		row_max = Math.max(row_max, j);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[100][100];
		
		for(int i=0; i<3; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		int row_num = 3;
		int col_num = 3;
		int time = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while(A[r][c] != k && time <= 100) {
			time++;
			boolean isRow = (row_num >= col_num)? true:false;
			if(isRow) {
				col_max = 0;
				for(int i=0; i<row_num; i++) {
					for(int j=0; j<col_num; j++) {
						if(A[i][j] == 0)	continue;
						if(map.containsKey(A[i][j]))
							map.put(A[i][j], map.get(A[i][j])+1);
						else
							map.put(A[i][j], 1);
					}
					drawing(A, map, i, isRow);
					map.clear();
				}
				col_num = col_max;
			}else {
				for(int j=0; j<col_num; j++) {
					for(int i=0; i<row_num; i++) {
						if(A[i][j] == 0)	continue;
						if(map.containsKey(A[i][j]))
							map.put(A[i][j], map.get(A[i][j])+1);
						else
							map.put(A[i][j], 1);
					}
					drawing(A, map, j, isRow);
					map.clear();
				}
				row_num = row_max;
			}
		}
		
		if(time > 100)	time = -1;
		System.out.println(time);
	}
}