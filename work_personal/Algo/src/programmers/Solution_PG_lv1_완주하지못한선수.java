package programmers;

import java.util.HashMap;

public class Solution_PG_lv1_완주하지못한선수 {
	
	static class Hash{
		class Node{
			int count;

			public Node() {
				this.count = 1;
			}
		}
		
		Node[] arr;
		int size;
		public Hash() {
			this.arr = new Node[100000];
			this.size = 0;
		}
		
		int getKey(String s) {
			int h = 5381;
			
			for(int i=0; i<s.length(); i++) {
				h = ((h<<5)+h+(s.charAt(i)-'a'));
			}
			
			if(h<0) h*=-1;
			
			return (h % 100000);
		}
		
		void add(String s) {
			int key = getKey(s);
			if(arr[key] == null) {
				arr[key] = new Node();
			}else {
				arr[key].count++;
			}
			
			size++;
		}
		
		boolean isExist(String s) {
			int key = getKey(s);
			if(arr[key] == null)	return false;
			else if(arr[key].count == 0)	return false;
			else {
				discount(key);
				return true;
			}
		}
		
		void discount(int key) {
			arr[key].count--;
		}
	}

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		Hash hash = new Hash();
		
		for(int i=0; i<completion.length; i++) {
			hash.add(completion[i]);
		}
		String res = "";
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<participant.length; i++) {
			if(!hash.isExist(participant[i])) {
				res = participant[i];
				break;
			}
		}
		System.out.println(res);
	}

}
