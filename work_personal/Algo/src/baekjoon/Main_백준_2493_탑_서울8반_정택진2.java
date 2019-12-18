package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class datas{
	private data node;
	private int count;
	
	private datas() {
		this.count=-1;
		this.node=new data(Integer.MAX_VALUE);
		this.node.setIndex(count);
	}
	
	private static class Singleton{
		private static final datas INSTANCE=new datas();
	}
	
	public static datas getInstace() { return Singleton.INSTANCE; }
	
	public void push(data d) {
		data newData=d;
		data oldData=node;
		
		node=newData;
		node.setPrev(oldData);
		node.setIndex(++count);
	}
	
	public data peek() {
		return this.node;
	}
}
class data{
	private int value;
	private int index;
	private data prev;
	private int resultV;
	private int resultI;
	
	public data(int value) {
		this.value=value;
	}
	
	public int getValue() { return this.value; }
	public void setIndex(int index) { this.index=index; }
	public int getIndex() { return this.index; }
	public void setPrev(data d) { this.prev=d; }
	public data getPrev() { return this.prev; }
	public int getResult() { return this.resultV; }
	public int getResultI() { return this.resultI; }
	
	public int calcResult() {
		data prevD=this.prev;
		if(prevD.getValue() >= this.value) {
			this.resultV=prevD.getValue();
			this.resultI=prevD.getIndex();
		}
		else if(prevD.getResult() >= this.value) {
			this.resultV=prevD.getResult();
			this.resultI=prevD.getResultI();
		}
		else {
			data d=prevD.getPrev().calcResult(this.value);
			this.resultV=d.getValue();
			this.resultI=d.getIndex();
		}
		return this.resultI;
	}
	public data calcResult(int v) {
		if(this.value >= v)
			return this;
		else if(this.resultV >= v) {
			data d=new data(this.resultV);
			d.setIndex(this.resultI);
			return d;
		}
		else {
			return this.prev.calcResult(v);
		}
	}
}

public class Main_백준_2493_탑_서울8반_정택진2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jungol_1809.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		
		//숫자를 배열에 입력
		StringTokenizer st=new StringTokenizer(br.readLine());
		datas db = datas.getInstace();

		db.push(new data(Integer.MAX_VALUE));
		for(int i=1; i<N+1; i++) {
			db.push(new data(Integer.parseInt(st.nextToken())));
			System.out.print(db.peek().calcResult() + " ");
		}
	}
}