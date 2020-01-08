package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1157_단어공부_서울8반_정택진 {
	static class Hash{
		private int size;
		private Entry[] hTable;
		
		public Hash() {
			this.size = 26;
			this.hTable = new Entry[size];
		}
		
		public boolean containsKey(char c) {
			return (hTable[c-'a'] == null)? false:true;
		}
		
		public void put(char c, int v) {
			int index = c - 'a';
			if(!containsKey(c)) {
				hTable[index] = new Entry();
			}
			hTable[index].value = v;
		}
		
		public Entry get(char c) {
			return hTable[c-'a'];
		}
	}
	static class Entry{
		int value;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine().toLowerCase();
		Hash hash = new Hash();
		int max = 0;
		char max_alpha = '\u0000';
		boolean duple_flag = false;
		for(int i=0; i<line.length(); i++) {
			char cur = line.charAt(i);
			if(hash.containsKey(cur)) {
				hash.put(cur, hash.get(cur).value+1);
			}else {
				hash.put(cur, 1);
			}
			
			if(max < hash.get(cur).value) {
				max = hash.get(cur).value;
				max_alpha = cur;
				duple_flag = false;
			}else if(max == hash.get(cur).value)
				duple_flag = true;
		}
		
		if(duple_flag)	System.out.println("?");
		else			System.out.println((char)(max_alpha-'a'+'A'));
	}
}