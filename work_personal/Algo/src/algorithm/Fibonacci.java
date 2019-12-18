package algorithm;

public class Fibonacci {
	//recursive
	public static int fibo1(int n) {
		if(n>=2) {
			return fibo1(n-1) + fibo1(n-2);
		}else return n;
	}
	
	//array
	public static int[] m;
	public static int fibo2(int n) {
		m[0]=0;
		m[1]=1;
		for(int i=2; i<=n; i++) {
			m[i] = m[i-1] + m[i-2]; 
		}
		return m[n];
	}
	
	//dp
	public static int fibo3(int n) {
		if(n >= 2 && m[n] == 0) {
			m[n] = fibo3(n-1) + fibo3(n-2);
			return m[n];
		}else return m[n];
	}
	
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		int result=fibo1(40);
		long end=System.currentTimeMillis();
		System.out.println("method1 - "+result+ " / "+(end-start)+"ms");
		
		m=new int[41];
		start=System.nanoTime();
		result=fibo2(40);
		end=System.nanoTime();
		System.out.println("method2 - "+result+ " / "+(end-start)+"ns");
		
		m=new int[41];
		m[0]=0;
		m[1]=1;
		start=System.nanoTime();
		result=fibo3(40);
		end=System.nanoTime();
		System.out.println("method3 - "+result+ " / "+(end-start)+"ns");
	}
}