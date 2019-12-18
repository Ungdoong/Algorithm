package d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_D5_1248_공통조상_서울8반_정택진 {
	public static int map[][], parent, size;
	
	public static void findCP(int t1, int t2) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		int a=t1; int b=t2;
		while(map[a][0] != 0) {
			list.add(map[a][0]);
			a=map[a][0];
		}
		while(!list.contains(b))	b=map[b][0];
		
		parent=b;
		size=map[b][1];
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d5_1248.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int V=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			int t1=Integer.parseInt(st.nextToken());
			int t2=Integer.parseInt(st.nextToken());
			
			map=new int[V+1][2];
			for(int i=1; i<=V; i++)	map[i][1] = 1;
			
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int p=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				map[c][0]=p;
				map[p][1]+=map[c][1];
				int child_c=map[c][1];
				while(map[p][0] != 0) {
					p=map[p][0];
					map[p][1]+=child_c;
				}
			}
			
			findCP(t1, t2);
			
			System.out.println("#"+tc+" "+parent+" "+size);
		}
	}
}