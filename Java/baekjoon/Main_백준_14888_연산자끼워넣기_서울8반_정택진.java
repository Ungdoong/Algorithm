package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기_서울8반_정택진 {
	public static int N, numbers[], max, min;
	
	public static void comb(int[] oper_num, int[] oper, int count) {
		if(count == N-1) {
			int result = numbers[0];
			for(int i=1; i<N; i++) {
				switch(oper[i-1]) {
				case 0:
					result += numbers[i];
					break;
				case 1:
					result -= numbers[i];
					break;
				case 2:
					result *= numbers[i];
					break;
				case 3:
					if(result < 0) {
						int tmp = Math.abs(result);
						tmp /= numbers[i];
						result = -tmp;
					}else
						result /= numbers[i];
					break;
				}
			}
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(oper_num[i] > 0) {
				oper_num[i]--;
				oper[count] = i;
				comb(oper_num, oper, count+1);
				oper_num[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		//숫자 초기화
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)	
			numbers[i] = Integer.parseInt(st.nextToken());
		if(N == 1) {
			System.out.println(numbers[0]);
			System.out.println(numbers[0]);
			return;
		}
		//연산자 수 초기화
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] oper_num = new int[4];
		for(int i=0; i<4; i++)
			oper_num[i] = Integer.parseInt(st.nextToken());
		
		//연산자 조합 생성
		int[] oper = new int[N-1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		comb(oper_num, oper, 0);
		
		System.out.println(max);
		System.out.println(min);
	}
}