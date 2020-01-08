package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_1218_괄호짝짓기_서울8반_정택진 {
	public static final String left = "[{(<";
	public static final String right = "]})>";
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] ch_arr= br.readLine().split("");
			String[] ch_tmp = new String[N];
			
			int i_list=0;
			int result=1;
			for(int i=0; i<ch_arr.length; i++) {
				if(left.contains(ch_arr[i]))
					ch_tmp[i_list++] = ch_arr[i];
				else if(right.contains(ch_arr[i])) {
					switch(ch_arr[i]) {
					case "]":
						if(!ch_tmp[i_list-1].equals("["))	result=0;
						else i_list--;
						break;
					case "}":
						if(!ch_tmp[i_list-1].equals("{")) 	result=0;
						else i_list--;
						break;
					case ")":
						if(!ch_tmp[i_list-1].equals("(")) 	result=0;
						else i_list--;
						break;
					case ">":
						if(!ch_tmp[i_list-1].equals("<")) 	result=0;
						else i_list--;
						break;
					}
				}
				
				if(result == 0)
					break;
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}