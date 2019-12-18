package grammer.util;

import java.util.HashMap;
//Map : key-value 쌍(Entry)으로 저장되는 구조. 키 중복 x, 순서 x
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("num", "12345");
		map.put("name", "tomes");
		map.put("address", "london");
		map.put("address", "paris");
		System.out.println(map);
		
		String val = map.get("num");
		String val2 = map.get("address");
		
		System.out.println(val + "--" + val2);
	}
}