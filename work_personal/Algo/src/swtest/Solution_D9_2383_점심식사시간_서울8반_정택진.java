package swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D9_2383_점심식사시간_서울8반_정택진 {
	public static int N, min;
	
	public static int getDis(int[] person, int[] stair) {
		return Math.abs(person[0] - stair[0]) + Math.abs(person[1] - stair[1]);
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_2383.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			ArrayList<int[]> list = new ArrayList<int[]>();
			int[][] stairs = new int[2][3];
			StringTokenizer st;
			int idx = 0;
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num == 1)	list.add(new int[] {i, j});
					else if(num > 1) {
						stairs[idx][0] = i;
						stairs[idx][1] = j;
						stairs[idx++][2] = num;
					}
				}
			}
			int P = list.size();
			int[][] persons = new int[P][2];
			for(int i=0; i<P; i++)	persons[i] = list.remove(0);
			
			int answer = Integer.MAX_VALUE/2;
			for(int n=0; n<Math.pow(2, P); n++) {
				int maxTime = 0;
				for(int t=0; t<2; t++) {
					int[] distances = new int[N*2+2];
					int[] timeTable = new int[N*2 + N*N];
					int nowTime = Integer.MAX_VALUE/2;
					int stairTime = stairs[t][2];
					
					for(int i=0; i<P; i++) {
						if(((n>>i)&1) != t)	continue;
						int dis_to_stair = getDis(persons[i], new int[] {stairs[t][0], stairs[t][1]}) + 1; 
						distances[dis_to_stair]++;
						nowTime = Math.min(nowTime, dis_to_stair) + stairTime;
					}
					if(nowTime == Integer.MAX_VALUE/2)	continue;
					
					for(int i=1; i<distances.length; i++) {
						while(distances[i] > 0) {
							distances[i]--;
							int remain = stairTime;
							for(int j=i; j<timeTable.length; j++) {
								if(timeTable[j] < 3) {
									timeTable[j]++;
									remain--;
								}
								
								if(remain == 0) {
									nowTime = Math.max(nowTime, j+1);
									break;
								}
							}
						}
					}
					maxTime = Math.max(maxTime, nowTime);
				}
				answer = Math.min(answer, maxTime);
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
}
