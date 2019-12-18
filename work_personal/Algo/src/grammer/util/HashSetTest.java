package grammer.util;

import java.util.HashSet;
//Set: 데이터 중복 x, 순서 x
public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("bill");
		set.add("jane");
		set.add("robert");
		set.add("jane");
		set.add("kim");
		
		System.out.println(set.toString());
		
		for(String name :set)
			System.out.println(name);
	}
}