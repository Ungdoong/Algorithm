package grammer.util;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<String> tset = new TreeSet<>();
		tset.add("hello");
		tset.add("123");
		tset.add("안녕하세요");
		tset.add("GOOD");
		tset.add("banana");
		tset.add("100");
		
		System.out.println(tset);
		System.out.println(tset.first());
		System.out.println(tset.last());
		System.out.println(tset.pollFirst());
		System.out.println(tset.pollLast());
		System.out.println(tset);
	}
}