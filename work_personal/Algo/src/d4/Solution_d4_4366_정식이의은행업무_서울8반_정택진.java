package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d4_4366_정식이의은행업무_서울8반_정택진 {
	public static final String YI[] = {"1", "0"};
	public static final String SAM[][] = {{"1", "2"},
										  {"0", "2"},
										  {"0", "1"}};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_4366.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String yi_str = br.readLine();
			String sam_str = br.readLine();
			
			//계산
			int result = -1;
			for(int i=0; i<yi_str.length(); i++) {
				StringBuilder sb=new StringBuilder(yi_str);
				char c=sb.charAt(i);
				sb.delete(i, i+1);
				sb.insert(i, YI[c-'0']);
				int bin = Integer.valueOf(sb.toString(), 2);
				
				//3진수 바꾸기
				for(int j=0; j<sam_str.length(); j++) {
					sb = new StringBuilder(sam_str);
					c = sb.charAt(j);
					for(int k=0; k<2; k++) {
						sb.delete(j, j+1);
						sb.insert(j, SAM[c-'0'][k]);
						int tri = Integer.valueOf(sb.toString(), 3);
						if(bin == tri) {
							result = tri;
							break;
						}
					}
					if(result != -1)	break;
				}
				if(result != -1) break;
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
