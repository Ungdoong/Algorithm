package algorithm;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		private Object data;
		private Node next;
		public Node(Object data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) tail = head;
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		
		if(size == 0) {
			addFirst(input);
		}else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	Node getNode(int index) {
		Node x = head;
		for(int i=0; i<index; i++)	x = x.next;
		return x;
	}
	
	public void add(int k, Object input) {
		if(k==0) {
			addFirst(input);
		}else if(k == size) {
			addLast(input);
		}else {
			Node prevNode = getNode(k-1);
			Node newNode = new Node(input);
			
			newNode.next = prevNode.next;
			prevNode.next = newNode;
			
			size++;
		}
	}
	
	public Object removeFirst() {
		Object data = head.data;
		head = head.next;
		size--;
		return data;
	}
	
	public Object remove(int k) {
		Node prevNode = getNode(k-1);
		Node nextNode = prevNode.next.next;
		Object data = prevNode.next.data;
		
		prevNode.next = nextNode;
		return data;
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int k) {
		return getNode(k).data;
	}
	
	public int indexOf(Object data) {
		Node temp = head;
		int index = 0;
		
		while(temp.data != data) {
			temp = temp.next;
			index++;
			if(temp == null)	return -1;
		}
		
		return index;
	}
	
	public ListIterator getIterator() {
		return new ListIterator();
	}
	
	public class ListIterator{
		private Node lastReturned;
		private Node next;
		private int nextIndex;
		
		ListIterator(){
			this.next = head;
			nextIndex = 0;
		}
		
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
	}
}
