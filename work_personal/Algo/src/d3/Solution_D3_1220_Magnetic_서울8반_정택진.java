package d3;

import java.util.*;
import java.io.*;

public class Solution_D3_1220_Magnetic_서울8반_정택진 {
	static int[][] table;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1220.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc < 10; tc++) {
			int N = sc.nextInt();
			table = new int[N][N];
			int check = 0;
			int cnt=0;
			int[][] temp = new int[N*N][3];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
					if (table[i][j] == 1 || table[i][j] == 2) {
						temp[check][0] = i;
						temp[check][1] = j;
						temp[check][2] = table[i][j];
						check++;
					}
				}
			}
			
			for (int i = 0; i < check; i++) {
				System.out.println(i);
				if (temp[i][2] == 1) {
					for (int j = i + 1; j < check; j++) {
						if(temp[i][1]==temp[j][1] && temp[j][2]==2) {
							i=j+1;
							cnt++;
							break;
						}
					}
				}
			}
			
			
			System.out.println("#"+tc+" "+cnt);

		}
		sc.close();
	}

}