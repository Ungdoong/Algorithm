package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Maijjyu_서울8반_정택진 {
	public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static Queue<Tuple<Integer, Integer>> queue = new LinkedList<Tuple<Integer, Integer>>();
	public static int candy=0;
	
	static class Tuple<X, Y>{
		public X x;
		public Y y;
		public Tuple(X x, Y y) {
			this.x=x;
			this.y=y;
		}
	}
	static void print(int person) throws IOException {
		bw.write("큐에 있는 사람 수: "+person+"명\n");
		bw.write("<<일인당 나눠주는 사탕의 수>>\n");
		for(int i=0; i<person; i++) {
			Tuple<Integer, Integer> tmp=queue.poll();
			bw.write(tmp.x+"번 : "+tmp.y+"개\n");
			queue.offer(tmp);
		}
		bw.write("현재까지 나눠준 사탕의 수: "+candy+"개\n");
		bw.flush();
	}

	public static void main(String[] args) throws Exception{

		int person=1; int result=0;
		queue.offer(new Tuple<Integer, Integer>(1, 1));
		print(person);
		while(candy <= 20) {
			Tuple<Integer, Integer> t=queue.poll();
			candy += t.y; 
			t.y++;
			if(candy >= 20) {
				candy=20;
				result=t.x;
			}
			
			queue.offer(t);
			person++;
			queue.offer(new Tuple<Integer, Integer>(person, 1));
			
			br.readLine();
			print(person);
		}
		
		
		bw.write("마지막 사탕을 받은 사람: " + result+"번");
		bw.flush();
		br.close();
		bw.close();
	}
}