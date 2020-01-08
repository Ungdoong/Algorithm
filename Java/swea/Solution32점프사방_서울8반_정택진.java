package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution32점프사방_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution32점프사방.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tn=sc.nextInt();
		
		for(int tc=1; tc<=tn; tc++) {
			int Ny=sc.nextInt();
			int Nx=sc.nextInt();
			int num_user=sc.nextInt();
			
			//맵초기화
			int[][] area=new int[Ny][Nx];
			for(int y=0; y<Ny; y++) {
				for(int x=0; x<Nx; x++) {
					area[y][x]=sc.nextInt();
				}
			}
			
			//유저정보
			int[][] user_stat = new int[num_user][3];
			for(int user=0; user<num_user; user++) {
				user_stat[user][0]=sc.nextInt();
				user_stat[user][1]=sc.nextInt();
				user_stat[user][2]=sc.nextInt();
			}
			
			
			//함정설치
			int num_trap = sc.nextInt();
			for(int i=0; i<num_trap; i++) {
				int y=sc.nextInt()-1;
				int x=sc.nextInt()-1;
				area[y][x] = 0;
			}
			
			//게임
			int price=0;
			for(int user=0; user<num_user; user++) {
				int y = user_stat[user][0]-1;
				int x = user_stat[user][1]-1;
				int cur_number=-1;
				for(int round=0; round<user_stat[user][2]; round++) {
					switch(area[y][x]/10) {
					case 1:
						x = x+(area[y][x]%10);
						if(x >= 0 
							&& x < Nx 
							&& area[y][x] != 0) {
							cur_number=area[y][x];
						}
						else
							cur_number=0;
						break;
					case 2:
						y = y+(area[y][x]%10);
						if(y >= 0 
							&& y < Ny 
							&& area[y][x] != 0) {
							cur_number=area[y][x];
						}
						else
							cur_number=0;
						break;
					case 3:
						x = x-(area[y][x]%10);
						if(x >= 0 
							&& x < Nx 
							&& area[y][x] != 0) {
							cur_number=area[y][x];
						}
						else
							cur_number=0;
						break;
					case 4:
						y = y-(area[y][x]%10);
						if(y >= 0 
							&& y < Ny 
							&& area[y][x] != 0) {
							cur_number=area[y][x];
						}
						else
							cur_number=0;
						break;
					}
					
					if(cur_number == 0) {
						break;
					}
				}
				price += cur_number*100 - 1000; 
			}
			
			System.out.println("#"+tc+" "+price);
		}
		
		sc.close();
	}
}