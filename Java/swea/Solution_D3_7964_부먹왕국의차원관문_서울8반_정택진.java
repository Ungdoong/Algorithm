package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_7964_부먹왕국의차원관문_서울8반_정택진 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_7964.txt"));
		Scanner sc = new Scanner(System.in);
		int tn = sc.nextInt();
		
		for(int tc=1;tc<=tn; tc++) {
			int num_city = sc.nextInt();
			int lim_dis = sc.nextInt();
			int[] dimention = new int[num_city];
			
			for(int i=0; i<num_city; i++)
				dimention[i] = sc.nextInt();
				
			int count=0;
			int make=0;
			for(int i=0; i<num_city; i++) {
				if(dimention[i] == 1)
					count = 0;
				else if(dimention[i] == 0)
					count++;
				
				if(count == lim_dis) {
					make++;
					count=0;
				}
			}
			
			System.out.println("#"+tc+" "+make);
		}
		
		sc.close();
	}
}
