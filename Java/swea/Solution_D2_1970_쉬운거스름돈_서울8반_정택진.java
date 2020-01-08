package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D2_1970_쉬운거스름돈_서울8반_정택진 {
	public static final int[] moneys= {50000,10000,5000,1000,500,100,50,10};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d2_1970.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int target=Integer.parseInt(br.readLine());
			
			bw.write("#"+tc+"\n");
			for(int m :moneys) {
				bw.write(target/m+" ");
				target=target%m;
			}
			bw.write("\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}