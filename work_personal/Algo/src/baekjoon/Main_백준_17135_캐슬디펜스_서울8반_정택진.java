package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_17135_캐슬디펜스_서울8반_정택진 {
	public static int N, M, D, result;
	public static boolean ar[];
	public static List<int[]> list;
	
	public static void process() {
		List<int[]>	shooter = new LinkedList<>();
		List<int[]> enermy = new LinkedList<>();
		for(int i=0; i<list.size(); i++)	enermy.add(list.get(i));
		
		int[][] dead = new int[3][4];
		for(int i=0; i<3; i++)	dead[i][2] = D+1;
				
		for(int i=0; i<M; i++)
			if(ar[i])	shooter.add(new int[] {N, i});
		
		int sum = 0;
		while(!enermy.isEmpty()) {
			//궁수기준 한마리씩 족치기
			for(int i=0; i<3; i++) {
				int[] sh=shooter.get(i);
				for(int j=0; j<enermy.size(); j++) {
					int[] en=enermy.get(j);
					
					if(N - en[0] > D)	continue;
					
					int distance = Math.abs(en[0]-sh[0])+Math.abs(en[1]-sh[1]);
					
					if(distance <= D && distance < dead[i][2]) {
						dead[i][0] = en[0];
						dead[i][1] = en[1];
						dead[i][2] = distance;
						dead[i][3] = 1;
					}
				}
			}
			
			//점찍어 놓은애들 삭제 시키기
			for(int i=0; i<3; i++) {
				if(dead[i][3] == 0)	continue;
				for(int j=0; j<enermy.size(); j++) {
					int[] curr=enermy.get(j);
					if(curr[0] == dead[i][0] && curr[1] == dead[i][1]) {
						enermy.remove(j);
						sum++;
						break;
					}
				}
				dead[i][3] = 0;
			}
			for(int i=0; i<3; i++)	dead[i][2] = D+1;
			
			//한턴 지남
			int len= enermy.size();
			for(int i=0; i<len; i++) {
				int[] curr=enermy.remove(0);
				int ny = curr[0] + 1;
				int nx = curr[1];
				if(ny < N)	enermy.add(new int[] {ny,nx});
			}
		}
		
		result = Math.max(result, sum);
	}
	
	public static void comb(int start, int count) {
		if(count == 3) {
			process();
		}
		
		for(int i=start; i<M; i++) {
			if(!ar[i]) {
				ar[i] = true;
				comb(i+1, count+1);
				ar[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		list = new ArrayList<>(); 
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1)
					list.add(new int[] {i, j});
			}
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])	return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		ar=new boolean[M];
		result=0;
		comb(0, 0);
		System.out.println(result);
	}		
}
