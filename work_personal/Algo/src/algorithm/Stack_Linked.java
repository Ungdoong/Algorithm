package algorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack_Linked implements Iterable<Object>{
	private Node mLastNode;
	private int top = -1;
	
	public void push(Object d) {
		Node newNode=new Node(d);
		Node oldNode=mLastNode;
		mLastNode=newNode;
		
		if(top != -1)
			mLastNode.next=oldNode;
		
		top++;
	}
	
	public Object pop() {
		if(top == -1)
			throw new NoSuchElementException();
		
		Node node=mLastNode;
		mLastNode=node.next;
		
		top--;
		return node.data;
	}
	
	private class Node{
		private Object data;
		private Node next;
		
		public Node(Object data) { this.data=data; }
	}
	
	@Override
	public Iterator<Object> iterator() {
		return new Stack_LinkedIterator(mLastNode);
	}
	
	private final class Stack_LinkedIterator implements Iterator<Object>{
		private Node current;
		
		public Stack_LinkedIterator(Node cur) {
			this.current=cur;
		}
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Object next() {
			if(current == null)
				throw new NoSuchElementException();
			
			Node node=current;
			current=node.next;
			return node.data;
		}
		
	}
}
