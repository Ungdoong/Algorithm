package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_2247_도서관_서울8반_정택진 {
	static class Student implements Comparable<Student>{
		int start;
		int end;
		
		public Student(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Student o) {
			return this.start - o.start;
		}
	}
	public static void main(String[] args) throws Exception	{
		System.setIn(new FileInputStream("res/input_jo_2247.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Student[] students = new Student[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			students[i] = new Student(Integer.parseInt(st.nextToken())
									, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(students);
		
		int cur_end = students[0].end;
		int cur_start = students[0].start;
		int longest_in = 0;
		int longest_out = 0;
		for(int i=1; i<students.length; i++) {
			if(cur_end >= students[i].start) {
				cur_end = (cur_end < students[i].end)? students[i].end:cur_end;
				if(i == students.length-1) {
					int cur_in = cur_end - cur_start;
					longest_in = Math.max(longest_in, cur_in);
				}
			}else {
				int cur_in = cur_end - cur_start;
				longest_in = Math.max(longest_in, cur_in);
				int cur_out = students[i].start - cur_end;
				longest_out = Math.max(longest_out, cur_out);
				
				cur_start = students[i].start; 
				cur_end = students[i].end;
			}
		}
		
		System.out.println(longest_in+" "+longest_out);
	}
}
