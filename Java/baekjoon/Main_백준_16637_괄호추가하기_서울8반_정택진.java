package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_16637_괄호추가하기_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_16637.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] quest = new char[2*N+1];
		String line = br.readLine();
		for(int i=1; i<=N; i++) {
			quest[2*i-1] = line.charAt(i-1);
		}
		System.out.println(Arrays.toString(quest));
	}
}
