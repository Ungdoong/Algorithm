package grammer.util;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<Integer> v3=new Vector<Integer>();
		v3.add(new Integer(100));
		v3.add(new Integer(200));
		v3.add(new Integer(300));
		v3.add(new Integer(100));
		
		for(Integer ii: v3)
			System.out.println(ii);
		
		Vector<String> v2=new Vector<String>();
		v2.add("white");
		v2.add("green");
		v2.add("yellow");
		v2.add("yellow");
		v2.add("red");
		
		for(String ss: v2)
			System.out.println(ss);
		
		Vector<Object> v1=new Vector<Object>(2, 2);
		System.out.println(v1.capacity());
		v1.add(123);
		v1.add("hello");
		v1.add(2.78);
		v1.add('x');
		v1.add(true);
		v1.add("hello");

		for(int i=0; i<v1.size(); i++)
			System.out.println(v1.get(i));
		
		System.out.println("---------------");
		
		v1.remove(0);
		v1.remove("hello");
		v1.set(0, "red");
		
		for(int i=0; i<v1.size(); i++)
			System.out.println(v1.get(i));
		
		v1.clear();
		System.out.println(v1.size());
		System.out.println(v1.isEmpty());
	}
}