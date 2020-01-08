package d4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_D4_4408_자기방으로돌아가기_서울8반_정택진 {
	
	public static boolean movedCheck(boolean[] moved) {
		for(int i=0; i<moved.length; i++)
			if(!moved[i]) return false;
		return true;
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_4408.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N=sc.nextInt();
			ArrayList<int[]> students=new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				int[] tmp = new int[2];
				tmp[0] = (a < b)? a:b;
				tmp[1] = (a < b)? b:a;
				students.add(tmp);
			}
			
			Collections.sort(students, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			int result=0;
			while(students.size() > 0) {
				result++;
				int[] prev = students.remove(0);
				int prev_end = (prev[1]%2 == 0)? prev[1]:prev[1]+1;
				int len = students.size();
				while(len-- > 0) {
					int[] next = students.remove(0);
					if(next[0] <= prev_end)	students.add(next);
					else prev_end = (next[1]%2 == 0)? next[1]:next[1]+1;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
		sc.close();
	}
}