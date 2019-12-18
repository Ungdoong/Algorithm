package B_1768_숫자야구게임;

import B_1768_숫자야구게임.Solution.Result;

public class UserSolution {
	static class MyQ{
		static class Node{
			int[] numbers;
			Node next;
			public Node(int[] numbers) {
				this.numbers = numbers;
				this.next = null;
			}
		}
		
		int size;
		Node root;
		Node tail;
		public MyQ() {
			this.size = 0;
			this.root = null;
			this.tail = null;
		}
		
		boolean isEmpty() {
			return (size == 0)? true:false;
		}
		
		void offer(int[] arr) {
			Node curr = new Node(arr);
			
			if(size == 0) {
				this.root = curr;
				this.tail = curr;
			}else {
				this.tail.next = curr;
				this.tail = curr;
			}
			
			size++;
		}
		
		int[] poll() {
			if(size == 0)	return null;
			int[] arr = root.numbers;
			this.root = this.root.next;
			
			size--;
			
			return arr;
		}
		
		int[] peek() {
			if(size == 0)	return null;
			return root.numbers;
		}
	}
	
	public final static int N = 4;

    public void doUserImplementation(int guess[]) {
    	Result res;
    	int time = 0;
    	int[] cur = new int[4];
    	MyQ q = new MyQ();
    	qInit(q, new int[4], new boolean[10], 0);
    	
    	guess[0]=1;
    	guess[1]=2;
    	guess[2]=3;
    	guess[3]=4;
    	res = Solution.query(guess);
    	System.out.println(res);
//    	do{
//    		if(time == 0) {
//    			for(int i=1; i<=4; i++)
//    				cur[i-1] = i;
//    		}else {
//    			cur = q.peek();
//    		}
//    		res = Solution.query(guess);
//    		check(q, res, cur);
//    	}while(res.strike < N);
    }
    
    public void check(MyQ q, Result res, int[] target) {
    	int size = q.size;
    	for(int z=0; z<size; z++) {
    		int[] curr = q.poll();
    		Result cur_r = compare(target, curr);
    		
    		if(cur_r.ball != res.ball || cur_r.strike != res.strike)	continue;
    		q.offer(curr);
    	}
    }
    
    public Result compare(int[] a, int[] b) {
    	Result res = new Result();
    	
    	for(int i=0; i<4; i++) {
    		for(int j=0; j<4; j++) {
    			if(a[i] == b[j]) {
    				if(i == j)	res.strike++;
    				else		res.ball++;
    			}
    		}
    	}
    	
    	return res;
    }
    
    public void qInit(MyQ q, int[] arr, boolean[] v, int i) {
    	if(i == 4) {
    		int[] copy = new int[4];
    		for(int a=0; a<4; a++)	copy[a] = arr[a];
    		q.offer(copy);
    		
    		return;
    	}
    	
    	for(int n=1; n<=9; n++) {
    		if(v[n])	continue;
    		arr[i] = n;
    		v[n] = true;
    		qInit(q, arr, v, i+1);
    		v[n] = false;
    	}
    }
}
