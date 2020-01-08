package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_PrimPq_서울8반_정택진 {
	public static int N;
	public static double bridges[][];
	public static boolean visit[];
	
	public static double prim() {
		visit=new boolean[N];
		PriorityQueue<double[]> pq=new PriorityQueue<>(new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});
		
		visit[0]=true;
		for(int i=1; i<N; i++)	pq.offer(new double[] {0,i,bridges[0][i]});
		
		double sum=0;
		while(!pq.isEmpty()) {
			double[] curr=pq.poll();
			double dis=curr[2];
			int dst=(int) curr[1];
			if(!visit[dst]) {
				visit[dst]=true;
				sum += dis;
				for(int i=0; i<N; i++) pq.offer(new double[] {dst, i, bridges[dst][i]});
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			
			int[][] nodes = new int[N][2];
			bridges=new double[N][N];
			StringTokenizer st=new StringTokenizer(br.readLine());
			StringTokenizer st2=new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nodes[i][0]=Integer.parseInt(st.nextToken());
				nodes[i][1]=Integer.parseInt(st2.nextToken());
			}
				
			
			double E=Double.parseDouble(br.readLine());
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int x1=nodes[i][0];
					int y1=nodes[i][1];
					int x2=nodes[j][0];
					int y2=nodes[j][1];
					double dis=Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2);
					bridges[i][j]=dis;
					bridges[j][i]=dis;
				}
			}
			
			System.out.println("#"+tc+" "+Math.round(E*prim()));
		}
	}
}
