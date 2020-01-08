package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_7701_염라대왕의이름정렬_서울8반_정택진 {
	static class Taekjin{
		Node[] arr;

		public Taekjin() {
			this.arr = new Node[50];
		}
		
		public void insert(String s) {
			int index = s.length()-1;
			Node curr = new Node();
			curr.value = s;
			if(arr[index] == null)	{
				arr[index] = curr;
				return;
			}
			
			Node target = arr[index];
			while(true) {
				int result = target.value.compareTo(curr.value);
				//target의 앞에 삽입
				if(result > 0) {
					if(target.prev == null) {
						arr[index] = curr;
					}else {
						target.prev.next = curr;
						curr.prev = target.prev;
					}
					target.prev = curr;
					curr.next = target;
					return;
				//다음 타겟으로 넘어감
				}else if(result < 0) {
					if(target.next == null) {
						target.next = curr;
						return;
					}
					target = target.next;
				//타겟과 값이 같아 리턴
				}else {
					return;
				}
			}
		}
		
		public void print() {
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != null) {
					Node curr = arr[i];
					while(curr != null) {
						System.out.println(curr.value);
						curr = curr.next;
					}
				}
			}
		}
	}
	static class Node{
		Node prev;
		Node next;
		String value;
		public Node() {
			this.prev = null;
			this.next = null;
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_D4_7701.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		//테스트 케이스 루프
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Taekjin taek = new Taekjin();
			for(int i=0; i<N; i++) {
				taek.insert(br.readLine());
			}
			System.out.println("#"+tc);
			taek.print();
		}
	}
}