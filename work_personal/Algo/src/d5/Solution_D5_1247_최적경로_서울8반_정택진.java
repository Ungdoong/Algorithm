package d5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로_서울8반_정택진 {
	public static int N, min, path[], pos[][];
	
	public static int calDis(int prev, int next) {
		int x1=pos[prev][0];
		int x2=pos[next][0];
		int y1=pos[prev][1];
		int y2=pos[next][1];
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	public static void perm(int cur, int visit, int dis) {
		if(cur == N+1)	{
			dis += calDis(path[cur-1], 1);
			min = Math.min(min, dis);
		}
		
		for(int i=0; i<N; i++) {
			if(((visit>>i) & 1) != 1) {
				path[cur]=i+2;
				perm(cur+1, visit | (1<<i), dis+calDis(path[cur-1], path[cur]));
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d5_1247.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N=Integer.parseInt(br.readLine());
			pos=new int[N+2][2];
			StringTokenizer st=new StringTokenizer(br.readLine());
			int i=0;
			while(st.hasMoreTokens()) {
				pos[i][0]=Integer.parseInt(st.nextToken());
				pos[i++][1]=Integer.parseInt(st.nextToken());
			}
			
			path = new int[N+1];
			path[0] = 0;
			min=Integer.MAX_VALUE;
			perm(1,0,0);
			bw.write("#"+tc+" "+min+"\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}

}
