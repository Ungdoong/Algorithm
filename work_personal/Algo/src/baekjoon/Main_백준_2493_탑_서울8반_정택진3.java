package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_백준_2493_탑_서울8반_정택진3{
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res/input_jungol_1809.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine()), b[]=new int[N], a[] = new int[N];
		int i=0;
		for(String s:br.readLine().split(" "))
			a[i++] = Integer.parseInt(s);
		bw.write("0 ");
		for(i=1;i<N;i++)
			bw.write((b[i] = a[i-1]>a[i] ? i : find(b,a,b[i-1],a[i])) + " ");
		bw.flush();
	}

	static int find(int[] b,int[] a,int i,int n){
		return i>=0 && a[i]>n ? i+1 : i<1 ? 0 : find(b,a,b[i]-1,n);
	}
}