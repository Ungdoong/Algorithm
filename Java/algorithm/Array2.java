package array2;

public class Array2 {

	public static void main(String[] args) {
		
//		//지그재그
//		int[][] a= {{1,2,3,4,5},
//				{5,4,3,2,1},
//				{2,1,3,5,4},
//				{2,3,6,1,2},
//				{7,2,8,3,2}};
//		for(int i=0; i<a.length; i++) {
//			for(int j=0; j<a[i].length; j++)
//				System.out.printf(a[i][j+(a[i].length-1-2*j)*(i%2)] + " ");
//		}
//		System.out.println();
//		
//		//전치행렬
//		int[][] b=new int[a.length][];
//		for(int i=0; i<a.length; i++) {
//			b[i]=Arrays.copyOf(a[i], a[i].length);
//		}
//		for(int i=0; i<b.length; i++) {
//			for(int j=0; j<b[i].length; j++) {
//				if(i<j) {
//					int T=b[i][j];
//					b[i][j]=b[j][i];
//					b[j][i]=T;
//				}
//			}
//		}
//		for(int[] w:a) System.out.println(Arrays.toString(w));
//		System.out.println();
//		for(int[] w:b) System.out.println(Arrays.toString(w));
//		System.out.println();
//		
		// +4방: (5)2 -> 6 -> 8 -> 4
		int[][] a= {{1,2,3},
				{4,5,6},
				{7,8,9}};
		int N=a.length;
		int M=a.length;
//		int[] di= {-1,0,1,0};
//		int[] dj= {0,1,0,-1};
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(a[i][j]==5) {
					System.out.println(a[i-1][j+1]);//3
					System.out.println(a[i+1][j+1]);//9
					System.out.println(a[i+1][j-1]);//7
					System.out.println(a[i-1][j-1]);//1
					
					//2->6->8->4
//					for(int d=0; d<di.length; d++) {
//						int ni=i+di[d];
//						int nj=j+dj[d];
//						if(0<=ni && ni<N && 0<=nj && nj<M)
//							System.out.print(a[ni][nj] + " ");
//					}
//					System.out.println();
				}
			}
		}
	}

}
