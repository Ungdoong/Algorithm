package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_PG_lv5_추석트래픽 {
	static class Traffic implements Comparable<Traffic>{
		double[] start;
		double[] end;
		public Traffic(double[] end, double time) {
			this.end = end;
			this.start = plus(end, -time);
		}
		@Override
		public int compareTo(Traffic o) {
			if(this.end[0] == o.end[0]) {
				if(this.end[1] == o.end[1]) {
					if(this.end[2] == o.end[2])	return 0;
					else	return (this.end[2] < o.end[2])? -1: 1;
				}else
					return (this.end[1] < o.end[1])? -1: 1;
			}else
				return (this.end[0] < o.end[0])? -1: 1;
		}
		@Override
		public String toString() {
			return "Traffic [end=" + Arrays.toString(start) + "]";
		}
	}
	
	public static double[] plus(double[] time, double move) {
		double[] after = new double[3];
		after[0] = time[0];
		after[1] = time[1];
		after[2] = time[2] + move;
		
		if(after[2] >= 60) {
			after[1]++;
			after[2] -= 60;
			if(after[1] >= 60) {
				after[0]++;
				after[1] -= 60;
			}
		}else if(after[2] < 0) {
			after[1]--;
			after[2] += 60;
			if(after[1] < 0) {
				after[0]--;
				after[1] += 60;
			}
		}
		
		return after;
	}
	
	public static boolean check(double[] a, double[] b) {
		if(a[0] == b[0]) {
			if(a[1] == b[1]) {
				if(a[2] > b[2])	return false;
			}else if(a[1] > b[1])	return false;
		}else if(a[0] > b[0])	return false;
		
		return true; 
	}

	public static int solution(String[] lines) {
		ArrayList<Traffic> list = new ArrayList<>();
		int answer = 0;
		StringTokenizer st;
		for(int i=0; i<lines.length; i++) {
			st = new StringTokenizer(lines[i], " ");
			st.nextToken();
			String[] complete_str = st.nextToken().split(":");
			double[] complete = new double[3];
			for(int j=0; j<3; j++)	complete[j] = Double.parseDouble(complete_str[j]);
			double time = Double.parseDouble(st.nextToken().replace("s", ""));
			list.add(new Traffic(complete, time-0.001));
		}
		Collections.sort(list);
		Traffic[] arr = new Traffic[list.size()];
		int N = arr.length;
		for(int i=0; i<N; i++) arr[i] = list.remove(0);
		for(int i=0; i<N; i++) {
			int num1 = 1;
			int num2 = 1;
			int index = i-1;
			double[] pivot = plus(arr[i].end, -0.999);
			while(index >= 0) {
				if(check(pivot, arr[index--].end)) {
					num1++;
				}else	break;
			}
			index = i+1;
			pivot = arr[i].end;
			double[] pivot2 = plus(arr[i].end, 0.999);
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
		System.out.println(solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
									 "2016-09-15 01:00:07.000 2s"}));
	}

}
