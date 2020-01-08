package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1221_GNS_서울8반_정택진 {
	public static final String[] str_numbers = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1221.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			br.readLine();
			String[] str_arr = br.readLine().split(" ");
			int[] counts = new int[10];
			
			for(int i=0; i<str_arr.length; i++) {
				for(int j=0; j<str_numbers.length; j++) {
					if(str_arr[i].equals(str_numbers[j]))
						counts[j]++;
				}
			}
			
			System.out.println("#"+tc);
			for(int i=0; i<10; i++) {
				for(int j=0; j<counts[i]; j++) {
					System.out.print(str_numbers[i]+ " ");
				}
			}
			System.out.println();
		}
	}
}