package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d2_1928_Base64Decoder_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d2_1928.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String line = br.readLine();
			StringBuilder sb = new StringBuilder();
			StringBuilder result= new StringBuilder();
			for(int i=0; i<line.length(); i++) {
				char cur = line.charAt(i);
				byte cur_i=0;
				if(cur >= 'A' && cur <= 'Z')
					cur_i = (byte) (cur-'A');
				else if(cur >= 'a' && cur <= 'z')
					cur_i = (byte) (cur-'a'+26);
				else if(cur >= '0' && cur <= '9')
					cur_i = (byte) (cur-'0'+52);
				else if(cur == '+')
					cur_i = (byte) 62;
				else if(cur == '-')
					cur_i = (byte) 63;
				for(int j=5; j>=0; j--) {
					sb.append((cur_i >> j)&1);
				}
				
				if(sb.length() >= 8) {
					result.append((char)Integer.parseInt(sb.substring(0, 8), 2));
					sb.delete(0, 8);
				}
			}
			
			System.out.println("#"+tc+" "+result.toString());
		}
	}
}