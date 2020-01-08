package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17825_주사위윷놀이_서울8반_정택진 {
	public static final int R = 10;
	public static int result;
	public static boolean flag;
	
	static class Game{
		
		static class Node{
			int score;
			Node first;
			Node second;
			boolean isEmpty;
			
			public Node(int score) {
				this.score = score;
				this.first = null;
				this.second = null;
				this.isEmpty = true;
			}
		}
		
		static class Player{
			Node curr;
			int total_score;
			
			public Player(Node curr) {
				this.curr = curr;
				this.total_score = 0;
			}
			
		}
		
		Player[] player;
		Node start;
		Node end;
		
		public Game() {
			this.player = new Player[4];
			this.start = new Node(-1);
			this.end = new Node(0);
			for(int i=0; i<4; i++)
				this.player[i] = new Player(start);
			mapInit();
		}
		
		//맵 초기화
		public void mapInit() {
			//1번 루트
			Node cur = this.start;
			Node cur2 = null;
			Node cur3 = null;
			Node cur4 = null;
			Node cur5 = null;
			Node cur6 = null;
			Node tmp = null;
			for(int i=1; i<=20; i++) {
				cur.first = new Node(i*2);
				cur = cur.first;
				if(i==5)	cur2 = cur;
				else if(i==10)	cur3 = cur;
				else if(i==15)	cur4 = cur;
				else if(i==20)	cur5 = cur;
			}
			cur.first = this.end;

			//2번 루트
			cur2.second = new Node(13);
			cur2 = cur2.second;
			cur2.first = new Node(16);
			cur2 = cur2.first;
			cur2.first = new Node(19);
			cur2 = cur2.first;
			cur2.first = new Node(25);
			cur2 = cur2.first;
			cur6 = cur2;
			cur2.first = new Node(30);
			cur2 = cur2.first;
			cur2.first = new Node(35);
			cur2 = cur2.first;
			cur2.first = cur5;
			
			//3번 루트
			cur3.second = new Node(22);
			cur3 = cur3.second;
			cur3.first = new Node(24);
			cur3 = cur3.first;
			cur3.first = cur6;
			
			//4번 루트
			cur4.second = new Node(28);
			cur4 = cur4.second;
			cur4.first = new Node(27);
			cur4 = cur4.first;
			cur4.first = new Node(26);
			cur4 = cur4.first;
			cur4.first = cur6;
		}
	
		
		public int getScore() {
			int score = 0;
			for(int i=0; i<4; i++)
				score += player[i].total_score;
			
			return score;
		}
		
		public void run(int[] numbers, int count) {
			if(count == R) {
				result = Math.max(result, getScore());
				return;
			}
			
			for(int i=0; i<4; i++) {
				Player p = player[i];
				Node origin = p.curr;
				int jump = numbers[count]-1;
				
				if(p.curr.score == 0)	continue;
				
				if(p.curr.second != null)	p.curr = p.curr.second;
				else						p.curr = p.curr.first;
				
				while(p.curr.score != 0 && jump-- > 0)	p.curr = p.curr.first;
				
				if(!p.curr.isEmpty) {
					p.curr = origin;
					continue;
				}
				
				p.total_score += p.curr.score;
				origin.isEmpty = true;
				p.curr.isEmpty = (p.curr.score == 0)? true:false;
				run(numbers, count+1);
				p.curr.isEmpty = true;
				p.total_score -= p.curr.score;
				p.curr = origin;
				p.curr.isEmpty = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] numbers = new int[10];
		for(int i=0; i<10; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Game gm = new Game();
		result = 0;
		flag = false;
		gm.run(numbers, 0);
		System.out.println(result);
	}
}