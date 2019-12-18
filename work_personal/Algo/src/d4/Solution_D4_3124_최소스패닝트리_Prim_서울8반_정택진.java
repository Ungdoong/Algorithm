package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_Prim_서울8반_정택진 {
	static class Bridge{
		int dst;
		int weight;
		public Bridge(int dst, int weight) {
			this.dst = dst;
			this.weight = weight;
		}
	}
	
	public static int V, E;
	public static List<Bridge>[] entry;

	public static long prim() {
		PriorityQueue<Bridge> pq = new PriorityQueue<>(new Comparator<Bridge>() {
			@Override
			public int compare(Bridge o1, Bridge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		boolean v[] = new boolean[V+1];
		
		for(int i=0; i<entry[1].size(); i++)	pq.add(entry[1].get(i));
		v[1] = true;
		
		long sum = 0;
		int count = 1;
		while(!pq.isEmpty()) {
			int dst=pq.peek().dst;
			int weight=pq.poll().weight;
			if(!v[dst]) {
				v[dst] = true;
				sum += weight;
				count++;
				
				if(count == V)	break;
				
				for(int i=0; i<entry[dst].size(); i++)	pq.add(entry[dst].get(i));
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
			entry = new ArrayList[V+1];
			
			for(int i=0 ; i<E; i++) {
				st=new StringTokenizer(br.readLine());
				int src=Integer.parseInt(st.nextToken());
				int dst=Integer.parseInt(st.nextToken());
				int weight=Integer.parseInt(st.nextToken());
				if(entry[src] == null)	entry[src] = new ArrayList<Bridge>();
				entry[src].add(new Bridge(dst, weight));
				if(entry[dst] == null)	entry[dst] = new ArrayList<Bridge>();
				entry[dst].add(new Bridge(src, weight));
			}
			
			System.out.println("#"+tc+" "+prim());
		}
	}
};