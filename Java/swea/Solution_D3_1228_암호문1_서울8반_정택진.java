package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1228.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			StringTokenizer st=new StringTokenizer(br.readLine());
			List<Integer> numbers=new ArrayList<Integer>();
			while(st.hasMoreTokens()) 
				numbers.add(Integer.parseInt(st.nextToken()));
			
			br.readLine();
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				st.nextToken();
				int pos=Integer.parseInt(st.nextToken());
				int C=Integer.parseInt(st.nextToken());
				
				for(int i=pos; i<pos+C; i++)
					numbers.add(i, Integer.parseInt(st.nextToken()));
			}
			
			System.out.print("#"+tc);
			for(int i=0; i<10; i++)
				System.out.print(" "+numbers.get(i));
			System.out.println();
		}
	}
}