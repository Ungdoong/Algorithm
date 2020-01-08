package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1183_동전자판기하_서울8반_정택진 {
	public static final int[] price= {500,100,50,10,5,1};

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1183.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t1=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] coins=new int[6];
		for(int i=0; i<6; i++)
			coins[i] = Integer.parseInt(st.nextToken());
	}		
}
