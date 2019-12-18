package algorithm;

public class Hash {
	private class Entry{
		private int value;
		public Entry next;
	}
	
	private int size;
	private Entry[] hTable;
	
	public Hash(int size) {
		this.size = size;
		this.hTable = new Entry[size];
	}
	
	public int hashMethod(int key) {
		return key % size;
	}
	
	public int getKey(int data) {
		return data;
	}
	
	public int add(int data) {
		int key = getKey(data);
		int hashValue = hashMethod(key);
		
		Entry entry = new Entry();
		entry.value = data;
		
		if(hTable[hashValue] == null) {
			hTable[hashValue] = entry;
			return 0;
		}
		
		Entry pre = null;
		Entry cur = hTable[hashValue];
		
		while(true) {
			if(cur.value < key) {
				pre = cur;
				cur = cur.next;
			}else {
				if(cur == hTable[hashValue]) {
					entry.next = cur;
					hTable[hashValue] = entry;
					return 0;
				}else {
					entry.next = cur;
					pre.next = entry;
					return 0;
				}
			}
		}
	}
	
	public int get(int data) {
		int key = getKey(data);
		int hashValue = hashMethod(key);
		
		Entry cur = hTable[hashValue];
		
		if(cur == null) return -1;
		
		while(true) {
			if(cur.value == key)	return hashValue;
			else if(cur.value > key)	return -1;
			else	cur = cur.next;
		}
	}
	
	private Entry getEntry(int data) {
		int key = getKey(data);
		int hValue = hashMethod(key);
		
		Entry pre = hTable[hValue];
		Entry cur = pre.next;
		
		if(cur == null)	return null;
		
		while(true) {
			
		}
	}
}
