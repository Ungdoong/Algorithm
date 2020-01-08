package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_4406_모음이보이지않는사람_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_4406.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String word = br.readLine();
			StringBuilder result = new StringBuilder("#"+tc+" ");
			for(int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					continue;
				result.append(c);
			}
			
			System.out.println(result.toString());
		}
	}
}