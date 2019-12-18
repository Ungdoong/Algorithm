package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플_서울8반_정택진2 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_3499.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			br.readLine();
			ArrayList<String> list=new ArrayList<String>();
			StringTokenizer st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				list.add(st.nextToken());
			
			int mid;
			if(list.size()%2 == 0) mid=list.size()/2;
			else				   mid=list.size()/2+1;
			for(int i=0; i<list.size()/2; i++) {
				list.add(2*i+1, list.get(mid++));
				list.remove(mid);
			}
			
			bw.write("#"+tc+" ");
			for(int i=0; i<list.size(); i++)
				bw.write(list.get(i)+" ");
			bw.write("\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}