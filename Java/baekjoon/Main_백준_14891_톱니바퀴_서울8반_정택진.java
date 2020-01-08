package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14891_톱니바퀴_서울8반_정택진 {
	public static void flagCheck(String[] arr, int[] start, boolean[] flag) {
		for(int i=0; i<3; i++) {
			int a = (start[i] > 5)? start[i]-6:start[i]+2;
			int b = (start[i+1] < 2)? start[i+1]+6:start[i+1]-2;
			if(arr[i].charAt(a) != arr[i+1].charAt(b))
				flag[i] = true;
		}
	}
	
	public static void rotate(int[] start, int index, int dir) {
		if(dir == 1) {
			start[index]--;
			if(start[index] < 0)	start[index] = 7;
		}else if(dir == -1) {
			start[index]++;
			if(start[index] > 7)	start[index] = 0;
		}
	}
	
	public static void sequence(int[] start, boolean[] flag, int index, int dir) {
		rotate(start, index, dir);
		
		int i = index-1;
		int tmp_dir = -dir;
		while(i >= 0 && flag[i]) {
			rotate(start, i, tmp_dir);
			i--;
			tmp_dir = -tmp_dir;
		}
		
		i = index;
		tmp_dir = -dir;
		while(i < 3 && flag[i]) {
			rotate(start, i+1, tmp_dir);
			i++;
			tmp_dir = -tmp_dir;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = new String[4];
		for(int i=0; i<4; i++)	arr[i] = br.readLine();
		
		int N = Integer.parseInt(br.readLine());
		boolean[] flag;
		int[] start = new int[4];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			flag = new boolean[3];
			flagCheck(arr, start, flag);
			sequence(start, flag, index, dir);
		}
		
		int result = 0;
		for(int i=0; i<4; i++) {
			if(arr[i].charAt(start[i]) == '1')	result += Math.pow(2, i);
		}
		
		System.out.println(result);
	}
}