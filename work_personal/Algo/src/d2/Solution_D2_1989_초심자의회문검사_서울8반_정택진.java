package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_1989_초심자의회문검사_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d2_1989.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] str=br.readLine().split("");
			
			int flag=1;
			for(int i=0; i<str.length/2; i++) {
				if(!str[i].equals(str[str.length-1-i]))
					flag=0;
			}
			
			System.out.println("#"+tc+" "+flag);
		}
	}
}