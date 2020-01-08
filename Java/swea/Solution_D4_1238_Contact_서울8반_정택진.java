package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_Contact_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1238.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int start_node=Integer.parseInt(st.nextToken());
			Map<Integer, ArrayList<Integer>> map=new HashMap<Integer, ArrayList<Integer>>();
			Boolean[] visit=new Boolean[101];
			Queue<Integer> q=new LinkedList<Integer>();
			
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int src=Integer.parseInt(st.nextToken());
				int dst=Integer.parseInt(st.nextToken());
				if(!map.containsKey(src))
					map.put(src, new ArrayList<>());
				map.get(src).add(dst);
			}
			
			int count1=1, count2=0, result=0;
			q.offer(start_node);
			visit[start_node]=true;
			while(!q.isEmpty()) {
				int cur=q.poll(); count1--;
				if(result < cur)
					result = cur;
				
				if(map.containsKey(cur)) {
					for(int i :map.get(cur)) {
						if(visit[i] == null) {
							visit[i] = true;
							q.offer(i);
							count2++;
						}
					}
				}
				if(count1 == 0 && count2 != 0) {
					count1 = count2;
					count2 = 0;
					result = 0;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}