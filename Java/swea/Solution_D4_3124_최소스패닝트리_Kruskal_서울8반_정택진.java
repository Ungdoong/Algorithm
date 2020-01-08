package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_Kruskal_서울8반_정택진 {
	static class Bridge{
		int src;
		int dst;
		int weight;
		public Bridge(int src, int dst, int weight) {
			this.src = src;
			this.dst = dst;
			this.weight = weight;
		}
	}
	
	public static int V, E, w[];
	public static List<Bridge> list;
	
	public static int findSet(int a) {
		if(w[a] == a) return a;
		return w[a] = findSet(w[a]);
	}
	
	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if( a < b)	w[b] = a;
		else		w[a] = b;
	}
	
	public static long kruskal() {
		Collections.sort(list, new Comparator<Bridge>() {
			@Override
			public int compare(Bridge o1, Bridge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		
		w = new int[V+1];
		for(int i=1; i<=V; i++)	w[i] = i;
		
		long sum = 0;
		for(int i=0; i<E; i++) {
			Bridge curr = list.get(i);
			if(findSet(curr.src) != findSet(curr.dst)) {
				sum += curr.weight;
				union(curr.src, curr.dst);
			}
		}
		
		return sum;
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_3124.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			list = new ArrayList<Bridge>();
			
			for(int i=0 ; i<E; i++) {
				st=new StringTokenizer(br.readLine());
				int src=Integer.parseInt(st.nextToken());
				int dst=Integer.parseInt(st.nextToken());
				int weight=Integer.parseInt(st.nextToken());
				list.add(new Bridge(src, dst, weight));
			}
			
			System.out.println("#"+tc+" "+kruskal());
		}
	}
};