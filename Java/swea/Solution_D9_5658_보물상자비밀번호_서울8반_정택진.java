package swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D9_5658_보물상자비밀번호_서울8반_정택진 {
	
	static class MyList{
		static class Node{
			int num;
			Node next;
			public Node(int num) {
				this.num = num;
				this.next = null;
			}
		}
		
		int size;
		Node head;
		Node tail;
		
		public MyList() {
			this.size = 0;
			this.head = null;
			this.tail = null;
		}
		
		public void add(int num) {
			Node nNode = new Node(num);
			if(this.size == 0) {
				this.head = nNode;
				this.tail = nNode;
			}
			else {
				this.tail.next = nNode;
				this.tail = nNode;
			}
			
			size++;
		}
		
		public int get(int i) {
			if(size < i)	return -1;
			int k = i;
			Node cur = head;
			
			while(k-- > 0)	{
				cur = cur.next;
			}
			
			return cur.num;
		}
		
		public boolean contains(int num) {
			Node cur = this.head;
			
			while(cur != null) {
				if(cur.num == num)	return true;
				cur = cur.next;
			}
			
			return false;
		}
		
		public void sort() {
			int[] arr = new int[size];
			Node curr = this.head;
			
			for(int i=0; i<size; i++) {
				arr[i] = curr.num;
				curr = curr.next;
			}
			
			quickSort(arr, 0, size-1);
			
			this.head = new Node(arr[0]);
			curr = this.head;
			for(int i=1; i<size; i++) {
				curr.next = new Node(arr[i]);
				curr = curr.next;
			}
		}
		
		public void quickSort(int[] arr, int start, int end) {
			int left = start;
			int right = end;
			int pivot = arr[(start+end)/2];
			
			do {
				while(arr[left] > pivot)	left++;
				while(arr[right] < pivot)	right--;
				
				if(left <= right) {
					int tmp = arr[left];
					arr[left] = arr[right];
					arr[right] = tmp;
					if(left == right)	right++;
					left++;
					right--;
				}
			}while(left <= right);
			
			if(left < end)	quickSort(arr, left, end);
			if(right > start) quickSort(arr, start, right);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("[");
			Node curr = head;
			while(curr != null) {
				sb.append(curr.num+", ");
				curr = curr.next;
			}
			sb.append("]");
			
			return sb.toString();
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_5658.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			char[] nums = br.readLine().toCharArray();
			
			int m = N/4;
			
			MyList list = new MyList();
			
			StringBuilder sb;
			for(int start=0; start<m; start++) {
				for(int section=0; section<4; section++) {
					int sec_start = start + m*section;
					int sec_end = sec_start + m;
					sb = new StringBuilder();
					for(int i=sec_start; i<sec_end; i++) {
						sb.append(nums[i%N]);
					}
					int toDec = Integer.parseInt(sb.toString(), 16);
					if(!list.contains(toDec))
						list.add(toDec);
				}
			}

			list.sort();
			System.out.println("#"+tc+" "+list.get(K-1));
		}
	}
}
