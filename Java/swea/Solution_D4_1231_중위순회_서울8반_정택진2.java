package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tree{
	private Node root;
	
	
	public Tree() {	}
	
	public void setRoot(Node n) { this.root = n; }
	public Node getRoot() { return this.root; }
	
	public Node checkNode(int index) {
		return checkNode(root, index);
	}
	
	public Node checkNode(Node n, int i) {
		return (n.getIndex() == i)?n:
			(n.getLeft() != null && checkNode(n.getLeft(), i) != null)?checkNode(n.getLeft(),i):
				(n.getRight() != null && checkNode(n.getRight(), i) != null)?checkNode(n.getRight(),i):null;
	}
}

class Node{
	private int index;
	private char value;
	private Node left;
	private Node right;
	
	public Node(int index) {
		this(index, '\u0000', null, null);
	}
	
	public Node(int index, char value, Node left, Node right) {
		this.index = index;
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public int getIndex() { return this.index; }
	
	public char getValue() { return this.value; }
	public void setValue(char c) { this.value=c; }
	
	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
}
public class Solution_D4_1231_중위순회_서울8반_정택진2 {
	
	public static String inorder(Node n) {
		if(n.getLeft() == null && n.getRight() == null)	return n.getValue()+"";
		else if(n.getLeft() == null)
			return n.getValue() + inorder(n.getRight());
		else if(n.getRight() == null)
			return inorder(n.getLeft()) + n.getValue();
		else
			return inorder(n.getLeft()) + n.getValue() + inorder(n.getRight());
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1231.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N=Integer.parseInt(br.readLine());

			//트리 초기화
			StringTokenizer st;
			Tree tree=new Tree();
			st=new StringTokenizer(br.readLine());
			tree.setRoot(new Node(Integer.parseInt(st.nextToken())
								, st.nextToken().charAt(0)
								, new Node(Integer.parseInt(st.nextToken()))
								, new Node(Integer.parseInt(st.nextToken()))));
			for(int i=1; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				int index=Integer.parseInt(st.nextToken());
				char value=st.nextToken().charAt(0);
				Node new_node, left=null, right=null;
				if(st.hasMoreTokens())
					left = new Node(Integer.parseInt(st.nextToken()));
				if(st.hasMoreTokens())
					right = new Node(Integer.parseInt(st.nextToken()));
				new_node = tree.checkNode(index);
				new_node.setValue(value);
				new_node.setLeft(left);
				new_node.setRight(right);
			}
			
			System.out.println("#"+tc+" "+inorder(tree.getRoot()));
		}
		br.close();
	}
}