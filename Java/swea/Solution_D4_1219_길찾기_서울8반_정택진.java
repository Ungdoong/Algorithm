package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_1219_길찾기_서울8반_정택진 {
	public static int[][] route;
	
	public static int searchPath(int cur_pos) {
		if(route[cur_pos][0] == 99 || route[cur_pos][1] == 99)
			return 1;
		else {
			if(route[cur_pos][0] != 0 && searchPath(route[cur_pos][0]) == 1)
				return 1;
			if(route[cur_pos][1] != 0 && searchPath(route[cur_pos][1]) == 1)
				return 1;
			return 0;
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			Integer.parseInt(br.readLine().split(" ")[1]);
			route = new int[100][2];
			String[] tmp_str = br.readLine().split(" ");
			
			//맵 초기화
			for(int i=0; i<tmp_str.length/2; i++) {
				int src = Integer.parseInt(tmp_str[2*i]);
				int dst= Integer.parseInt(tmp_str[2*i+1]);
				
				if(route[src][0] == 0)	route[src][0] = dst;
				else	route[src][1] = dst;
			}

			int result = searchPath(0);
			
			System.out.println("#"+tc+" "+result);
		}
	}
}