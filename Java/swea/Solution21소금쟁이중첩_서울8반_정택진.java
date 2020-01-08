package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution21소금쟁이중첩_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution21소금쟁이중첩.txt"));
		Scanner sc = new Scanner(System.in);
		int tn=sc.nextInt();
		int[] d = {0, 3, 5, 6};
		
		for(int tc=1; tc<=tn; tc++) {
			int N=sc.nextInt();
			int[][] area=new int[N][N];
			int num_ins=sc.nextInt();
			int ins_number=0;
			
			for(int ins=0; ins<num_ins; ins++) {
				int y=sc.nextInt();
				int x=sc.nextInt();
				int dir=sc.nextInt();
				
				if(ins_number == 0) {
					switch(dir) {
					case 1:
						for(int i=0; i<d.length; i++) {
							if(y+d[i] < N) {
								if(area[y+d[i]][x] == 1) {
									ins_number = ins+1;
								}
								else
									area[y+d[i]][x]++;
							}
						}
						break;
					case 2:
						for(int i=0; i<d.length; i++) {
							if(x+d[i] < N) {
								if(area[y][x+d[i]] == 1) {
									ins_number = ins+1;
								}
								else
									area[y][x+d[i]]++;
							}
						}
						break;
					}
				}
			}
			
			System.out.println("#"+tc+" "+ins_number);
		}
		
		sc.close();
	}
}