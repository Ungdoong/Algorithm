package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution11로봇이동거리_서울8반_정택진 {
	static int T, N;
	static int Answer;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution11로봇이동거리.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)	{
			N = sc.nextInt();
			char[][] map=new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {					
					map[i][j] = sc.next().charAt(0);				
				}
			}
			
			Answer = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					searchPath(map, i, j);
				}
			}
			
			System.out.printf("#%d %d\n",test_case,Answer);
		}
		
		sc.close();
	}
	
	static void searchPath(char[][] map, int y, int x) {
		switch(map[y][x]) {
		case 'A':
			//우로 이동
			for(int i=x+1; i<N; i++) {
				if(map[y][i] == 'S')
					Answer++;
				else
					break;
			}
			break;
		case 'B':
			//우로 이동
			for(int i=x+1; i<N; i++) {
				if(map[y][i] == 'S')
					Answer++;
				else
					break;
			}
			//좌로 이동
			for(int i=x-1; i>=0; i--) {
				if(map[y][i] == 'S')
					Answer++;
				else
					break;
			}
			break;
		case 'C':
			//우로 이동
			for(int i=x+1; i<N; i++) {
				if(map[y][i] == 'S')
					Answer++;
				else
					break;
			}
			//좌로 이동
			for(int i=x-1; i>=0; i--) {
				if(map[y][i] == 'S')
					Answer++;
				else
					break;
			}
			//아래로 이동
			for(int i=y+1; i<N; i++) {
				if(map[i][x] == 'S')
					Answer++;
				else
					break;
			}
			//위로 이동
			for(int i=y-1; i>=0; i--) {
				if(map[i][x] == 'S')
					Answer++;
				else
					break;
			}
			break;
		default:
			break;
		}
	}
}