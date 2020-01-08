package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_3074_입국심사_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_3074.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			long N=Long.parseLong(st.nextToken());
			long M=Long.parseLong(st.nextToken());
			int[] table = new int[(int)N];
			long min=0;
			long max=0;
			for(int i=0; i<N; i++) {
				table[i] = Integer.parseInt(br.readLine());
				max = Math.max(max, table[i]);
			}
			
			max = max * M;
			long result = Long.MAX_VALUE/2;
			
			while(min < max) {
				long mid = (min + max) / 2;
				
				long pass = 0;
				for(int i=0; i<N; i++)
					pass += mid / table[i];
				
				if(pass < M)
					min = mid + 1;
				else {
					result = Math.min(result, mid);
					max = mid;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

}
