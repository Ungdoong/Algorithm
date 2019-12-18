package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_정올_2483_마방진_서울8반_정택진 {
	public static int N, targetS, zero_num;
	public static final int H = 0;
	public static final int V = 1;
	public static final int D = 2;
	public static boolean visit[], finish;
	
	public static boolean checkR(int[][] check) {
		for(int i=0; i<N; i++) {
			if(check[H][i] != targetS || check[V][i] != targetS) return false; 
		}
		if(check[D][0] != targetS || check[D][1] != targetS)	return false;
		
		return true;
	}
	
	public static void process(int[][] map, ArrayList<int[]> list, int[][] check, int count) {
		if(finish)	return;
		if(count == zero_num) {
			if(!checkR(check))	return;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			finish = true;
			return;
		}
		System.out.println(count);
		int[] curr = list.get(count);
		int cy = curr[0];
		int cx = curr[1];
		for(int i=1; i<visit.length; i++) {
			if(visit[i] || check[H][cy]+i > targetS
						|| check[V][cx]+i > targetS)	
				continue;
			if(cy == cx && check[D][0]+i > targetS)	continue;
			if((cy+cx) == N-1 && check[D][1]+i > targetS)	continue;
			
			visit[i] = true;
			map[cy][cx] = i;
			check[H][cy] += i;
			check[V][cx] += i;
			if(cy == cx)	check[D][0] += i;
			if((cy+cx) == N-1)	check[D][1] += i;
			process(map, list, check, count+1);
			if((cy+cx) == N-1)	check[D][1] -= i;
			if(cy == cx)	check[D][0] -= i;
			check[V][cx] -= i;
			check[H][cy] -= i;
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		targetS = ((N*N+1)*N)/2; 
				
		int[][] map = new int[N][N];
		int[][]	check = new int[3][N];
		visit = new boolean[N*N+1];
		ArrayList<int[]> list = new ArrayList<int[]>();
		zero_num = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					check[H][i] += map[i][j];
					check[V][j] += map[i][j];
					if(i == j)	check[D][0] += map[i][j];
					if((i+j) == N-1)	check[D][1] += map[i][j];
					visit[map[i][j]] = true;
				}else {
					list.add(new int[] {i, j});
					zero_num++;
				}
			}
		}
		
		finish = false;
		process(map, list, check, 0);
	}
}
