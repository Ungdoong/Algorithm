package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1206_View_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1206.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int num = sc.nextInt();
			sc.nextLine();
			int[] buildings = new int[num];
			String[] str_array = sc.nextLine().split(" ");
			for(int i=0; i<str_array.length; i++)
				buildings[i] = Integer.parseInt(str_array[i]);
			
			int result=0;
			
			for(int i=2; i<buildings.length-2;i++) {
				int max = 0;
				for(int j=i-2; j<=i+2; j++) {
					if(buildings[j] > max && j != i)
						max = buildings[j];
				}
				
				if(max < buildings[i])
					result += buildings[i] - max;
			}
			
			System.out.println("#"+tc+" "+result);
		}
		
		sc.close();
	}
}