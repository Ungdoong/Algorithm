package algorithm;

import java.util.NoSuchElementException;

public class Stack_Dynamic {
	private int top;
	private Object[] stackArray;
	private int stackSize;
	
	public Stack_Dynamic() {
		this.top=-1;
		this.stackSize=10;
		this.stackArray=new Object[this.stackSize];
	}
	
	public void push(Object data) {
		if(this.isFull())
			this.increaseCap();
		
		this.stackArray[++top]=data;
	}
	
	public boolean isFull() {
		return (top == stackSize-1);
	}
	
	private void increaseCap() {
		this.stackSize *= 2;
		Object[] newArray=new Object[stackSize];
		
		for(int i=0; i<=top; i++)
			newArray[i]=this.stackArray[i];
		
		this.stackArray = newArray;
	}
	
	public Object pop() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		
		Object value = this.stackArray[top];
		this.stackArray[top--]=null;
		
		return value;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
}