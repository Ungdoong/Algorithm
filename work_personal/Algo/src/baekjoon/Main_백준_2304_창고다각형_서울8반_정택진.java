package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2304_창고다각형_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_2304.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[1001];
		int max=-1, max_hp=-1, max_lp = -1;
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			arr[p] = h;
			
			if(max < h) {
				max = h;
				max_hp = p;
				max_lp = p;
			}else if(max == h) {
				max_hp = Math.max(max_hp, p);
				max_lp = Math.min(max_lp, p);
			}
		}
		
		int height=0, result=0, i=0;
		while(i++ < max_lp) {
			if(height < arr[i])	height = arr[i];
			result += height; 
		}
		
		height=0; i=1001;
		while(i-- > max_hp) {
			if(height < arr[i])	height = arr[i];
			result += height;
		}
		
		if(max_lp == max_hp)	result -= arr[max_lp];
		else {
			result += arr[max_hp]*(max_hp - max_lp - 1);
		}
		System.out.println(result);
	}
}
