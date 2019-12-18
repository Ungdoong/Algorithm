package programmers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.StringTokenizer;

public class Solution_PG_lv5_추석트래픽2 {
	static class Traffic implements Comparable<Traffic>{
		double start;
		double end;
		public Traffic(double end, double time) {
			this.end = end;
			this.start = this.end - (long)(time * 1000);
		}
		@Override
		public int compareTo(Traffic o) {
			return (end == o.end)? 0:(end < o.end)? -1:1;
		}
	}
	
	public static boolean check(double a, double b) {
		return (a > b)? false:true; 
	}

	public static int solution(String[] lines) {
		ArrayList<Traffic> list = new ArrayList<>();
		int answer = 0;
		StringTokenizer st;
		for(int i=0; i<lines.length; i++) {
			st = new StringTokenizer(lines[i], " ");
			String dateString = st.nextToken() + " " + st.nextToken();
			try {
				Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
				double end = endDate.getTime();
				double time = Double.parseDouble(st.nextToken().replace("s", ""));
				list.add(new Traffic(end, time-0.001));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		Collections.sort(list);
		Traffic[] arr = new Traffic[list.size()];
		int N = arr.length;
		for(int i=0; i<N; i++) arr[i] = list.remove(0);
		for(int i=0; i<N; i++) {
			int num1 = 1;
			int num2 = 1;
			int index = i-1;
			double pivot = arr[i].end - 999;
			while(index >= 0) {
				if(check(pivot, arr[index--].end)) {
					num1++;
				}else	break;
			}
			index = i+1;
			pivot = arr[i].end;
			double pivot2 = arr[i].end + 999;
			while(index < N) {
				if(check(arr[index].start, pivot))	num1++;
				if(check(arr[index].start, pivot2))	num2++;
				index++;
			}
			
			answer = Math.max(answer, num1);
			answer = Math.max(answer, num2);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"2016-09-15 01:00:04.002 2.0s",
									 "2016-09-15 01:00:07.000 2s"}));
	}

}
