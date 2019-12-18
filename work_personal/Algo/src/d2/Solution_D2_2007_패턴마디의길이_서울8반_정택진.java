package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_2007_패턴마디의길이_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d2_2007.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String line=br.readLine();
			
			int result=0;
			for(int i=1; i<=10; i++) {
				String word=line.substring(0,i);
				int flag=1;
				for(int j=1; j<line.length()/i; j++) {
					if(!word.equals(line.substring(i*j, i*j+i)))
						flag=0;
				}
				
				if(flag==1) {
					result=i;
					break;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}