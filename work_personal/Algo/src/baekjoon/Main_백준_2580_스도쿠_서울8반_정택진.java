package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_백준_2580_스도쿠_서울8반_정택진 {
	public static final int N = 9;
	public static int L;
	
	public static boolean validation(int[][] map, int num, int y, int x) {
		for(int i=0; i<N; i++) {
			if(i == y)	continue;
			if(map[i][x] == num)	return false;
		}
		
		for(int j=0; j<N; j++) {
			if(j == x)	continue;
			if(map[y][j] == num)	return false;
		}
		
		
		int section_y = y/3;
		int section_x = x/3;
		for(int i=y; i<y+3; i++) {
			int ty = (section_y * 3) + (i % 3);
			
			for(int j=x; j<x+3; j++) {
				int tx = (section_x * 3) + (j % 3);
				
				if(ty == y && tx == x)	continue;
				
				if(map[ty][tx] == num)	return false;
			}
		}
		
		return true;
	}
	
	public static void run(int[][] map, ArrayList<int[]> list, int count) {
		if(count == L) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int cur[] = list.get(count);
		int y = cur[0];
		int x = cur[1];
		
		for(int d=1; d<=9; d++) {
			if(!validation(map, d, y, x))	continue;
			
			map[y][x] = d;
			run(map, list, count+1);
			map[y][x] = 0;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[N][N];
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0)	list.add(new int[] {i,j});
			}
		}
		
		L = list.size();
		run(map, list, 0);
	}
}