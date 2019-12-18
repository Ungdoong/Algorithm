package algorithm;

public class BruteForce {
	
	public static int bruteForce(char[] p, char[] t) {
		int i=0;		int j=0;
		int N=p.length;	int M=t.length;
		while(i<N && j<M) {
			if(p[i] != t[j]) { i = i-j; j = -1; }
			i++; j++;
		}
		if (j == M)	return i-M;
		else return i;
	}
	
	public static void main(String[] args) {
		char[] a = {'b', 'c', 'a', 'd', 'a', 'b', 'c', 'e'};
		char[] b = {'a', 'b', 'c'};
		System.out.println(bruteForce(a, b));
	}
}