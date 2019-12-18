package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1658_최대공약수와최소공배수_서울8반_정택진 {
	
	public static int gcd(int a, int b) {
		int tmp;
		while(b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		
		return a;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = gcd(a,b);
		System.out.println(gcd);
		System.out.println((a*b)/gcd);
	}
}
