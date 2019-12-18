package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1231_중위순회_서울8반_정택진 {
	static String[] tree;
	
	static String calc(int cur) {
		String[] s=tree[cur].split(" ");
		switch(s.length) {
			case 1:
				return s[0];
			case 2:
				return calc(Integer.parseInt(s[1]))+s[0];
			case 3:
				return calc(Integer.parseInt(s[1]))+s[0]+calc(Integer.parseInt(s[2]));
			default:
				return "error";
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1231.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N=Integer.parseInt(br.readLine());
			tree=new String[N+1];
			//트리 초기화
			StringTokenizer st;
			StringBuilder sb;
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				sb=new StringBuilder();
				int index=Integer.parseInt(st.nextToken());
				while(st.hasMoreTokens())
					sb.append(st.nextToken()+" ");
				tree[index] = sb.toString();
			}
			
			System.out.println("#"+tc+" "+calc(1));
		}
		br.close();
	}
}