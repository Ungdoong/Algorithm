package d1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D1_2056_연월일달력_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d1_2056.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int[] max_day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int tc=1; tc<=T; tc++) {
			String line = br.readLine();
			StringBuilder sb = new StringBuilder("#"+tc+" ");
			if(line.length() != 8)	{
				sb.append(-1);
				System.out.println(sb.toString());
				continue;
			}
			
			String[] date_str = new String[3];
			int[] date = new int[3];
			date_str[0] = line.substring(0, 4);
			date_str[1] = line.substring(4, 6);
			date_str[2] = line.substring(6, 8);
			for(int i=0; i<3; i++)	date[i] = Integer.parseInt(date_str[i]);
			
			if(date[1] < 1 || date[1] > 12 || date[2] < 1) {
				sb.append(-1);
			}else {
				if(max_day[date[1]] < date[2])	sb.append(-1);
				else {
					sb.append(date_str[0])
					  .append("/")
					  .append(date_str[1])
					  .append("/")
					  .append(date_str[2]);
				}
			}
			
			System.out.println(sb.toString());
		}
	}

}
