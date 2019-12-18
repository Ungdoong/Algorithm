package grammer.util;

public class GenericTest<X> {

	private int num;
	private X what;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num=num;
	}
	public X getWhat() {
		return what;
	}
	public void setWhat(X what) {
		this.what=what;
	}
	public static void main(String[] args) {
		GenericTest<String> g1 = new GenericTest<>();
		GenericTest<Integer> g2 = new GenericTest<>();
		GenericTest<Character> g3 = new GenericTest<>();
		
		g1.setWhat("hello");
		g2.setWhat(new Integer(456));
		
		System.out.println(g1.getWhat());
		System.out.println(g2.getWhat());
	}

}
