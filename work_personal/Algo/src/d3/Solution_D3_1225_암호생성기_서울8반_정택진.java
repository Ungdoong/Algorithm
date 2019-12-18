package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			StringTokenizer st=new StringTokenizer(br.readLine());
			Queue<Integer> queue=new LinkedList<Integer>();
			
			while(st.hasMoreTokens())
				queue.add(Integer.parseInt(st.nextToken()));
			
			int plus=1;
			while(true) {
				if(plus == 6) plus = 1;
				int num=queue.poll()-plus++;
				if(num <= 0 ) {
					queue.offer(0);
					break;
				}else
					queue.offer(num);
			}
			
			bw.write("#" + tc);
			for(int n :queue)
				bw.write(" "+n);
			bw.write("\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}