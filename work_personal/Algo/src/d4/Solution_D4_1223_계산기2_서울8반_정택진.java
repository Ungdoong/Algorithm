package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1223_계산기2_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			StringTokenizer st=new StringTokenizer(br.readLine(), "+");
			
			int sum=0;
			while(st.hasMoreTokens()) {
				String token=st.nextToken();
				if(token.contains("*")) {
					String[] str=token.split("[*]");
					int result=Integer.parseInt(str[0]);
					for(int i=1; i<str.length; i++)
						result *= Integer.parseInt(str[i]);
					sum += result;
				}
				else 
					sum += Integer.parseInt(token);
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}