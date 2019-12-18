package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_3499.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			br.readLine();
			StringTokenizer st=new StringTokenizer(br.readLine());
			String[] arr=new String[st.countTokens()];
			int index=0;
			while(st.hasMoreTokens())
				arr[index++]=st.nextToken();
			
			bw.write("#"+tc+" ");
			int second = (arr.length%2 == 0)? arr.length/2: arr.length/2+1;
			for(int i=0; i<arr.length/2; i++) {
				bw.write(arr[i]+" "+arr[second+i]+" ");
			}
			if(arr.length%2 == 1)
				bw.write(arr[arr.length/2]);
			bw.write("\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}