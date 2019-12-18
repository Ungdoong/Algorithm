package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_2543_타일채우기_서울8반_정택진 {
	public static int[][] map;
	public static void tile(int sx, int sy, int ex, int ey, int hx, int hy, int hc) {
		int my = (sy+ey)/2;
		int mx = (sx+ex)/2;
		
		if(sy == ey) {
			map[sy][sx] = hc;
			return;
		}
		
		if(sx <= hx && hx <= mx && sy <= hy && hy <= my) {
			map[my][mx+1] = 1;
			map[my+1][mx] = 1;
			map[my+1][mx+1] = 1;
			tile(sx, sy, mx, my, hx, hy, hc);
			tile(mx+1, sy, ex, my, mx+1, my, 1);
			tile(sx, my+1, mx, ey, mx, my+1, 1);
			tile(mx+1, my+1, ex, ey, mx+1, my+1, 1);
		}else if(mx+1 <= hx && hx <= ex && sy <= hy && hy <= my) {
			map[my][mx] = 2;
			map[my+1][mx] = 2;
			map[my+1][mx+1] = 2;
			tile(sx, sy, mx, my, mx, my, 2);
			tile(mx+1, sy, ex, my, hx, hy, hc);
			tile(sx, my+1, mx, ey, mx, my+1, 2);
			tile(mx+1, my+1, ex, ey, mx+1, my+1, 2);
		}else if(sx <= hx && hx <= mx && my+1 <= hy && hy <= ey) {
			map[my][mx] = 3;
			map[my][mx+1] = 3;
			map[my+1][mx+1] = 3;
			tile(sx, sy, mx, my, mx, my, 3);
			tile(mx+1, sy, ex, my, mx+1, my, 3);
			tile(sx, my+1, mx, ey, hx, hy, hc);
			tile(mx+1, my+1, ex, ey, mx+1, my+1, 3);
		}else if(mx+1 <= hx && hx <= ex && my+1 <= hy && hy <= ey) {
			map[my][mx] = 4;
			map[my][mx+1] = 4;
			map[my+1][mx] = 4;
			tile(sx, sy, mx, my, mx, my, 4);
			tile(mx+1, sy, ex, my, mx+1, my, 4);
			tile(sx, my+1, mx, ey, mx, my+1, 4);
			tile(mx+1, my+1, ex, ey, hx, hy, hc);
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_2543.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		tile(1, 1, N, N, x+1, y+1, 0);
		
		for(int i=0; i<N+1; i++)
			System.out.println(Arrays.toString(map[i]));
	}

}
