package algorithm;

public class TrieNode_p {
	private char ch;
	private TrieNode_p[] children = new TrieNode_p[26];
	private boolean isEnd;
	private Integer contentKey;

	TrieNode_p[] getChildren() { return children; }
	
	boolean isEnd() { return isEnd; }
	
	void setEnd(boolean e) { this.isEnd = e; }
	
	public Integer getContentKey() { return contentKey; }
	
	public void setContentKey(Integer i) { this.contentKey = i; }

	public char getCh() { return ch; }

	public void setCh(char ch) { this.ch = ch; }
}
