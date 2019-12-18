package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1217_거듭제곱_서울8반_정택진 {
	
	public static long pow(int under, int upper) {
		if(upper == 1)	return (long)under;
		else {
			return (long)under*pow(under, upper-1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1217.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			
			String line = br.readLine();
			int under = Integer.parseInt(line.split(" ")[0]);
			int upper = Integer.parseInt(line.split(" ")[1]);
			
			System.out.println("#"+tc+" "+pow(under,upper));
		}
	}
}