package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_4261_빠른휴대전화키패드_서울8반_정택진 {
	
	static class MyStr{
		static class Ch{
			char c;
			Ch next;
			
			public Ch(char c) {
				this.c = c;
				this.next = null;
			}
		}
		
		int size;
		Ch head;
		Ch tail;
		
		public MyStr(String s) {
			this.size = 0;
			this.head = null;
			this.tail = null;
			addString(s);
		}
		
		public void add(char c) {
			Ch ch = new Ch(c);
			
			if(size == 0) {
				this.head = ch;
				this.tail = ch;
			}else {
				this.tail.next = ch;
				this.tail = ch;
			}
			
			size++;
		}
		
		public void addString(String s) {
			for(int i=0; i<s.length(); i++)
				add(s.charAt(i));
		}
		
		public void removeF() {
			this.head = this.head.next;
			size--;
		}
		
		public char getF() {
			return this.head.c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_4261.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		final char arr[][] = {{'\u0000', '\u0000', '\u0000', '\u0000'},
							{'\u0000', '\u0000', '\u0000', '\u0000'}, 
							{'a', 'b', 'c', '\u0000'},
							{'d', 'e', 'f', '\u0000'},
							{'g', 'h', 'i', '\u0000'},
							{'j', 'k', 'l', '\u0000'},
							{'m', 'n', 'o', '\u0000'},
							{'p', 'q', 'r', 's'},
							{'t', 'u', 'v', '\u0000'},
							{'w', 'x', 'y', 'z'}};
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			
			//번호 받기
			char[] chars = st.nextToken().toCharArray();
			int L = chars.length;
			int[] numbers = new int[L];
			for(int i=0; i<L; i++)	numbers[i] = chars[i]-'0';	
			int N=Integer.parseInt(st.nextToken());
			
			//비교배열
			char[][] char_arr = new char[L][4];
			for(int i=0; i<L; i++) {
				for(int j=0; j<4; j++) {
					char_arr[i][j] = arr[numbers[i]][j];
				}
			}
			
			Queue<MyStr> q = new LinkedList<MyStr>();
			st=new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++)	{
				String s = st.nextToken();
				if(s.length() != L)	continue;
				
				q.offer(new MyStr(s));
			}
			
			int result=0;
			
			while(!q.isEmpty()) {
				MyStr curr = q.poll();
				
				if(curr.size == 0) {
					result++;
					continue;
				}
				
				char c = curr.getF();
				for(int i=0; i<4; i++) {
					int index = L-curr.size;
					if(char_arr[index][i] == c) {
						curr.removeF();
						q.offer(curr);
						break;
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
