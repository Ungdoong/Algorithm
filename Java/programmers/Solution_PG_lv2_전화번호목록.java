package programmers;

public class Solution_PG_lv2_전화번호목록 {
	
	static class Hash{
		class Node{
			Node[] next;
			int val;

			public Node() {
				this.next = new Node[10];
			}
		}
		
		Node[] first;

		public Hash(Node[] first) {
			this.first = new Node[10];
		}
		
		
	}
	
	public static void main(String[] args) {
		
	}

}
