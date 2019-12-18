package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_1234_비밀번호_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1234.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			ArrayList<Integer> numbers=new ArrayList<Integer>(); 
			st.nextToken();
			String line=st.nextToken();
			for(int i=0; i<line.length(); i++) {
				int num=line.charAt(i)-'0';
				if(numbers.isEmpty())
					numbers.add(num);
				else {
					if(numbers.get(numbers.size()-1) == num)
						numbers.remove(numbers.size()-1);
					else
						numbers.add(line.charAt(i)-'0');
				}
			}
			
			
			bw.write("#"+tc+" ");
			for(int i :numbers)
				bw.write(i+"");
			bw.write("\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}