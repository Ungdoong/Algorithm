package d5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1245_균형점_서울8반_정택진 {
	
	static class Magnetic implements Comparable<Magnetic>{
		int pos;
		int weight;
		
		
		public Magnetic(int pos) {
			this.pos = pos;
			this.weight = 0;
		}

		@Override
		public int compareTo(Magnetic o) {
			return this.pos-o.pos;
		}
	}
	
	public static Magnetic[] mag_arr;
	public static double[] result;
	public static final double mu=Math.pow(10, -12);
	public static int N, point, escape;
	
	public static double f(double x) {
		double r=0;
		for(int i=0; i<point; i++)
			r += mag_arr[i].weight/Math.pow(x-mag_arr[i].pos, 2);
		for(int i=point; i<mag_arr.length; i++)
			r -= mag_arr[i].weight/Math.pow(x-mag_arr[i].pos, 2);
		
		return r;
	}
	
//	public static double fprime(double x) {
//		double r=0;
//		for(int i=0; i<point; i++)
//			r -= 2*mag_arr[i].weight/Math.pow(Math.abs(x-mag_arr[i].pos), 3);
//		for(int i=point; i<mag_arr.length; i++)
//			r += 2*mag_arr[i].weight/Math.pow(Math.abs(x-mag_arr[i].pos), 3);
//		
//		return r;
//	}
	
//	public static double newtonMethod(double x1) {
//		return x1- (f(x1)/fprime(x1));
//	}
	
	public static double findMethod(double x1, double x2) {
		return (x1*f(x2) - x2*f(x1))/(f(x2)-f(x1));
	}
	
	public static void findX(double x1, double x2) {
//		//뉴턴 메소드 허용오차
//		if(Math.abs(x2)/Math.abs(x1)<mu) {
//			result[point-1]=x2;
//			point++;
//			return;
//		}
		//할선법 허용오차
		if(Math.abs(x2-x1)/Math.abs(x2)<mu) {
			result[point-1]=x2;
			point++;
			return;
		}
		findX(x2, findMethod(x1, x2));
	}
	
	public static void cal() {
		while(point < N) {
			findX(mag_arr[point-1].pos+0.01, mag_arr[point].pos-0.01);
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d5_1245.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			mag_arr=new Magnetic[N];
			result=new double[N-1];
			point=1;
			
			//입력값 초기화
			for(int i=0; i<N; i++)
				mag_arr[i]=new Magnetic(Integer.parseInt(st.nextToken()));
			for(int i=0; i<N; i++)
				mag_arr[i].weight=Integer.parseInt(st.nextToken());
			
			//정렬
			Arrays.sort(mag_arr);
			
			cal();

			System.out.print("#"+tc);
			for(int i=0; i<result.length; i++)
				System.out.printf(" %.10f",result[i]);
			System.out.println();
		}
	}
}