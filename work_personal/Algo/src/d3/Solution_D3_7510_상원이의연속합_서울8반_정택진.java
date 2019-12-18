package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_7510_상원이의연속합_서울8반_정택진 {
	public static int hap(int x) {
        int cnt=0;
        int sum=0;int i=1;int n=1;
        while(i<=x) {
            sum+=i;
            if(sum>x) {sum=0;n++;i=n;continue;}
            else if(sum==x) cnt++;
            i++;
        }
        return cnt;
    }
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_7510.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			 int N=Integer.parseInt(br.readLine());
	         System.out.println("#"+tc+" "+hap(N));
		}
	}
}