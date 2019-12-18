package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_범희 {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
		int t=Integer.parseInt(br.readLine());
		
		char[][]arr=new char[8][8];
		for(int i=0;i<8;i++) {
			String s=br.readLine();
			for(int j=0;j<8;j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		System.out.println(arr[0][1]);
		}
		
	}

}
