package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16235_나무재테크_서울8반_정택진 {
	static class Section{
		int nutri;
		int init_nutri;
		long size;
		Tree root;
		
		public Section(int init_nutri) {
			this.nutri = 5;
			this.init_nutri = init_nutri;
			this.size = 0;
			this.root = null;
		}
		
		//1살짜리 트리 추가
		public void addTree() {
			addTree(1);
		}
		
		//트리를 나이를 주어서 추가
		public void addTree(int age) {
			Tree tmp = new Tree(age);
			if(size != 0)	tmp.next = root;
			root = tmp;
			size++;
		}

		//여러 트리 추가
		public void addTrees(int num) {
			for(int i=0; i<num; i++)	addTree();
		}
		
		//밥먹임
		public void feeding() {
			Tree curr = root;
			Tree prev = null;
			if(size == 0)	return;
			
			//가장 어린애보다 양분이 적으면 루트를 null로
			if(root.age > nutri) root = null;
			
			//양분을 먹일수 있는 곳까지 먹임
			while(curr != null) {
				if(curr.age <= nutri) {
					nutri -= curr.age;	//양분에서 나이만큼 감소
					curr.grow();		//한살 먹음
				}else	break;
				
				prev = curr;
				curr = curr.next;
			}
			
			//먹일 수 없는 부분부터 떼어냄
			if(curr != null && prev != null)	prev.next = null;
			double dead = 0;
			while(curr != null) {
				dead += curr.age/2;
				size--;
				curr = curr.next;
			}
			
			addNutri((int)dead);
			dead = 0;
		}
		
		//나이가 5의 배수인 나무의 수를 리턴
		public int autumn() {
			int count = 0;
			
			Tree curr = root;
			while(curr != null) {
				if((curr.age%5) == 0)	count++;
				curr = curr.next;
			}
			
			return count;
		}
		
		//양분 추가
		public void addNutri(int num) {
			this.nutri += num;
		}
		
		public void winter() {
			this.nutri += init_nutri;
		}

		public long getSize() {
			return this.size;
		}
		
		static class Tree{
			int age;
			Tree next;
			
			public Tree(int age) {
				this.age = age;
				this.next = null;
			}
			
			public void grow() { this.age++; }
		}
	}
	public static final int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static final int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int N, M, K;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Section[][] A = new Section[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				A[i][j] = new Section(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			A[x][y].addTree(z);
		}
		
		while(K > 0) {
			//봄, 여름
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					A[i][j].feeding();
				}
			}
			
			//가을, 겨울
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int num = A[i][j].autumn();
					for(int d=0; d<8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if(nx<0 || nx>=N || ny<0 || ny>=N || num == 0)	continue;
						A[ny][nx].addTrees(num);
					}
					
					//겨울
					A[i][j].winter();
				}
			}
			K--;
		}
		
		long result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result += A[i][j].getSize();
			}
		}
		
		System.out.println(result);
	}
}