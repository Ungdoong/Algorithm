package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1233.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1; tc<=10; tc++) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st;
			int result=1;
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				if(st.countTokens() > 2) {
					st.nextToken();
					char c=st.nextToken().charAt(0);
					if(c >= '0' && c <= '9') result=0;
				}else {
					st.nextToken();
					char c=st.nextToken().charAt(0);
					if(c < '0' || c > '9') result=0;
				}
			}			
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}