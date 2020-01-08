package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_5431_민석이의과제체크하기_서울8반_정택진2{

	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		Scanner sc = new Scanner(System.in);
		int tn = sc.nextInt();
		
		for(int tc = 0; tc < tn; tc++) {
			int num_mem = sc.nextInt();
			int com_mem = sc.nextInt();
			int[] flag = new int[num_mem];
			for(int i = 0; i < com_mem; i++) {
				flag[sc.nextInt()-1] = 1;
			}
			
			System.out.printf("#%d",tc+1);
			for(int i =0; i < flag.length; i++) {
				if(flag[i] != 1)
					System.out.printf(" %d",i+1);
			}
			System.out.println();
		}
		
		sc.close();
	}
}