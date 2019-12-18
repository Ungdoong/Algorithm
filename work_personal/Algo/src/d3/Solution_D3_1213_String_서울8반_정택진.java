package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1213_String_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			String[] target = br.readLine().split("");
			String[] src = br.readLine().split("");
			int count=0;
			
			for(int i=0; i<src.length; i++) {
				if(src[i].equals(target[0])) {
					for(int j=1; j<target.length; j++) {
						if((i+j) < src.length) {
							if(!src[i+j].equals(target[j]))
								break;
							else if(j == target.length-1) {
								count++;
							}
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+count);
		}
	}
}