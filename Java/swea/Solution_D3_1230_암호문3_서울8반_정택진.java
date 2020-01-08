package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_1230_암호문3_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1230.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1; tc<=10; tc++) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			List<Integer> numbers=new ArrayList<Integer>();
			for(int i=0; i<N; i++) 
				numbers.add(Integer.parseInt(st.nextToken()));
			
			br.readLine();
			st=new StringTokenizer(br.readLine());
			int pos, C;
			while(st.hasMoreTokens()) {
				char command = st.nextToken().charAt(0);
				
				if(command == 'I') {
					pos=Integer.parseInt(st.nextToken());
					C=Integer.parseInt(st.nextToken());
					for(int i=pos; i<pos+C; i++)
						numbers.add(i, Integer.parseInt(st.nextToken()));
				}else if(command == 'D'){
					pos=Integer.parseInt(st.nextToken());
					C=Integer.parseInt(st.nextToken());
					for(int i=0; i<C; i++)
						numbers.remove(pos);
				}else {
					C=Integer.parseInt(st.nextToken());
					for(int i=0; i<C; i++) {
						numbers.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			bw.write("#"+tc);
			for(int i=0; i<10; i++)
				bw.write(" "+numbers.get(i));
			bw.write("\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}