package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_서울8반_정택진 {
	static class Node implements Comparable<Node>{
		int index;
		double price;
		public Node(int index, double price) {
			this.index = index;
			this.price = price;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(price, o.price);
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st1=new StringTokenizer(br.readLine());
			StringTokenizer st2=new StringTokenizer(br.readLine());

			int[][] is=new int[N][2];
			for(int i=0; i<N; i++) {
				is[i][0]=Integer.parseInt(st1.nextToken());
				is[i][1]=Integer.parseInt(st2.nextToken());
			}
			double E=Double.parseDouble(br.readLine());
			
			PriorityQueue<Node> pq=new PriorityQueue<Node>();
			boolean[] visit=new boolean[N];
			double sum=0;
			int count=0;
			pq.add(new Node(0, 0));
			while(!pq.isEmpty()) {
				Node cur=pq.poll();
				if(visit[cur.index])	continue;
				visit[cur.index]=true;
				sum += cur.price;
				count++;
				if(count==N) break;
				
				for(int i=0; i<N; i++) {
					if(i!=cur.index) {
						double dis=Math.pow(is[cur.index][0]-is[i][0], 2)+
								Math.pow(is[cur.index][1]-is[i][1], 2);
						pq.offer(new Node(i, dis));
					}
				}
			}
			
			System.out.println("#"+tc+" "+Math.round(sum*E));
		}
	}
}
