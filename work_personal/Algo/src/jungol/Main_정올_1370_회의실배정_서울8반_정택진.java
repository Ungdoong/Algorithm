package jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_1370_회의실배정_서울8반_정택진 {
	public static int N, start[], end[];
	public static boolean visit[];
	public static int maxCount;
	public static ArrayList<Integer> list;
	
//	public static boolean isPossible(BigInteger hours, int index) {
//		for(int i=start[index]+1; i<end[index]; i++) {
//			if((hours.and(BigInteger.valueOf()) == 1<<i)
//				return false;
//		}
//		return true;
//	}
//	
//	public static boolean isFull(BigInteger hours) {
//		for(int i=1; i<=N; i++) {
//			if(!visit[i]) {
//				for(int j=start[i]+1; j<=end[i]; j++) {
//					if(j==end[i])	return false;
//					else if((hours & 1<<j) == 1<<j) break;
//				}
//			}
//		}
//		return true;
//	}
//	
//	public static void findSol(BigInteger hours, int count) {
//		maxCount = (maxCount>count)? maxCount:count;
//		if(count == N) {
//			list.clear();
//			for(int i=1; i<=N; i++)	list.add(i);
//			return;
//		}
//		if(isFull(hours)) {
//			list.clear();
//			for(int i=1; i<=N; i++) {
//				if(visit[i])	list.add(i);
//			}
//		}
//		
//		for(int i=1; i<=N; i++) {
//			System.out.println(Arrays.toString(visit));
//			if(!visit[i] && isPossible(hours, i)) {
//				BigInteger next_h=hours;
//				for(int j=start[i]; j<=end[i]; j++)	next_h = next_h | 1<<j;
//				System.out.println(next_h);
//				visit[i]=true;
//				findSol(next_h, count+1);
//				visit[i]=false;
//			}
//		}
//	}
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_jungol_1370.txt"));
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		N=Integer.parseInt(br.readLine());
//		start=new int[N+1];
//		end	 =new int[N+1];
//		visit=new boolean[N+1];
//		for(int i=1; i<=N; i++) {
//			StringTokenizer st=new StringTokenizer(br.readLine());
//			int index=Integer.parseInt(st.nextToken());
//			start[index]=Integer.parseInt(st.nextToken());
//			end[index]=Integer.parseInt(st.nextToken());
//		}
//		
//		maxCount=Integer.MIN_VALUE;
//		list=new ArrayList<Integer>();
//		
//		findSol(0L, 0);
//		
//		Collections.sort(list, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if(start[o1]<start[o2])	return -1;
//				else if(start[o1]>start[2])	return 1;
//				else return 0;
//			}
//		});
//		
//		bw.write(maxCount+"\n");
//		for(int i=0; i<list.size(); i++)
//			bw.write(list.get(i)+" ");
//		bw.write("\n");
//		bw.flush();
//		
//		br.close();
//		bw.close();
	}
}