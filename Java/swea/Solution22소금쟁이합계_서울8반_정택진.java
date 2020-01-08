package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;
public class Solution22소금쟁이합계_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution22소금쟁이합계.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tn= sc.nextInt();
		
		for(int tc=1; tc<=tn; tc++) {
			int N=sc.nextInt();
			boolean[][] area = new boolean[N][N];
			int num_so=sc.nextInt();
			int count = 0;
			
			for(int num=0; num<num_so; num++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int dir = sc.nextInt(); //상:1하:2좌:3우:4
				
				if(area[y][x] == false) {
					switch(dir) {
					case 1:
						if(y-6 >= 0) {
							if(area[y-3][x] == false 
								&& area[y-5][x] == false 
								&& area[y-6][x] == false) {
								area[y-6][x] = true;
								count++;
							}
						}
						break;
					case 2:
						if(y+6 < N) {
							if(area[y+3][x] == false 
								&& area[y+5][x] == false 
								&& area[y+6][x] == false) {
								area[y+6][x] = true;
								count++;
							}
						}
						break;
					case 3:
						if(x-6 >= 0) {
							if(area[y][x-3] == false 
								&& area[y][x-5] == false 
								&& area[y][x-6] == false) {
								area[y][x-6] = true;
								count++;
							}
						}
						break;
					case 4:
						if(x+6 < N) {
							if(area[y][x+3] == false 
								&& area[y][x+5] == false 
								&& area[y][x+6] == false) {
								area[y][x+6] = true;
								count++;
							}
						}
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + count);
			
		}		
		sc.close();
	}
}