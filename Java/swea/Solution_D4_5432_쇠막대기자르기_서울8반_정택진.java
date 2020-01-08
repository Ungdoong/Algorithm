package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_5432_쇠막대기자르기_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_5432.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			char[] arr=br.readLine().toCharArray();
			boolean lazer=false;
			int sum=0;
			int cnt=0;
			
			for(int i=0; i<arr.length; i++) {
				if(lazer) {
					if(arr[i] == '(') { lazer = false; cnt++; }
					else { sum++; cnt--; }
				}else {
					if(arr[i] == '(') cnt++;
					else {
						cnt--;
						sum += cnt;
						lazer = true;
					}
				}
				
				if(cnt == 0)
					lazer=false;
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}