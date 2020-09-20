package array2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Babygin1 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tn = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=tn; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] counts = new int[10];
			boolean result = true;
			
			for(int i=0; i<6; i++)
				counts[Integer.parseInt(st.nextToken())]++;
			
			//triplet 판별
			for(int i=0; i<counts.length; i++) {
				if(counts[i] >= 3) {
					counts[i] -= 3;
					i--;
				}
				//run 판별
				else if((i-2)>=0 && counts[i] != 0
						&& counts[i-1] != 0 && counts[i-2] != 0) {
					counts[i]--;
					counts[i-1]--;
					counts[i-2]--;
					i--;
				}
			}
			
			//babygin 확인
			for(int i=0; i<counts.length; i++) {
				if(counts[i] != 0) {
					result = false;
				}		
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}