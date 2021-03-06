package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Kruskal_서울8반_정택진 {
	public static int N, p[];
	public static ArrayList<double[]> bridges;
	public static double result;

	
	public static int findSet(int i) {
		if(p[i] == i)	return i;
		return p[i] = findSet(p[i]);
	}
	
	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a < b)	p[b] = a;
		else		p[a] = b;
	}
	
	public static double kruskal() {
		Collections.sort(bridges, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return ((o1[2] - o2[2]) < 0)? -1:((o1[2] - o2[2]) == 0)? 0:1;
			}
		});
		
		double sum=0;
		for(int i=0; i<bridges.size(); i++) {
			double[] v=bridges.get(i);
			if(findSet((int)v[0]) != findSet((int)v[1])) {
				sum += v[2];
				union((int)v[0], (int)v[1]);
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
			bridges=new ArrayList<>();
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
					double[] tmp= {i,j,dis};
					bridges.add(tmp);
				}
			}
			
			p = new int[N];
			for(int i=0; i<N; i++) p[i] = i;
			
			System.out.println("#"+tc+" "+Math.round(E*kruskal()));
		}
	}
}
