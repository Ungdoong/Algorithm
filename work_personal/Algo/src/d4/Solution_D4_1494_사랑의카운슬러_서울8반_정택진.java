package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1494_사랑의카운슬러_서울8반_정택진 {
	public static int N, set[], sumAllX, sumAllY;
	public static long min, worms[][];
	public static boolean visit[];
	
	public static void findMin(int start, int count) {
		if(count == N) {
			long sumX=0;
			long sumY=0;
			for(int i=0; i<N; i++) {
				if(visit[i]) {
					sumX += worms[i][0];
					sumY += worms[i][1];
				}else {
					sumX -= worms[i][0];
					sumY -= worms[i][1];
				}
			}
			
			min = (long) Math.min(min, Math.pow(sumX, 2)+Math.pow(sumY, 2));
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(visit[i])	continue;
			visit[i] = true;
			findMin(i+1, count+2);
			visit[i] = false;
		}
	}
	
	public static void findMin2(int w, int s) {
		if(w < s)	return;
		if(s == 0) {
			long sumselX=0;
			long sumselY=0;
			for(int i=0; i<N/2; i++) {
				sumselX += worms[set[i]][0];
				sumselY += worms[set[i]][1];
			}
			long sumunselX = sumAllX - sumselX;
			long sumunselY = sumAllY - sumselY;
			
			long nx = sumselX - sumunselX;
			long ny = sumselY - sumunselY;
			min = Math.min(min, nx*nx+ny*ny);
			
			return;
		}
		set[s-1] = w-1;
		
		findMin2(w-1, s-1);
		findMin2(w-1, s);
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1494.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			
			worms = new long[N][2];
			set = new int[N/2];
			sumAllX = 0;
			sumAllY = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				worms[i][0] = Long.parseLong(st.nextToken());
				sumAllX += worms[i][0];
				worms[i][1] = Long.parseLong(st.nextToken());
				sumAllY += worms[i][1];
			}
			
			min = Long.MAX_VALUE;

			visit = new boolean[N];
//			findMin(0, 0);
			findMin2(N,N/2);
			
			System.out.println("#"+tc+" "+(long)min);
		}
	}

}
