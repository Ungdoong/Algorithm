package d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_d4_4796_의석이의우뚝선산_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_4796.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N=sc.nextInt();
		
			int result = 0;
			int count = 0;
			boolean flag = false;
			int cur = sc.nextInt();
			for(int i=1; i<N; i++) {
				int next = sc.nextInt();
				if(cur < next)	{
					if(flag) {
						flag = false;
						count = 0;
					}
					count++;
				}
				else if(cur > next && count != 0) {
					flag = true;
					result += count;
				}
				
				cur = next;
			}
			
			System.out.println("#"+tc+" "+result);
		}
		
		sc.close();
	}

}
