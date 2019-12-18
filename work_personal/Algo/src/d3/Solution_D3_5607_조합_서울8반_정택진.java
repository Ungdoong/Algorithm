package d3;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution_D3_5607_조합_서울8반_정택진{
	public static final int P = 1234567891;
	
	//1
	public static long power(long x, long y, long p) {
		long r=1L;
		x=x%p;
		while(y>0) {
			if(y%2==1) r=(r*x)%p;
			y=y>>1;
			x=(x*x)%p;
		}
		return r;
	}
	public static long modInverse(long n, long p) {
		return power(n,p-2,p);
	}
	public static long nCr(int n, int r, int p) {
		if(r == 0)	return 1L;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		for(int i=1; i<=n; i++)	fac[i] = fac[i-1]*i%p;
		
		return (fac[n]*modInverse(fac[r],p)%p*modInverse(fac[n-r],p)%p)%p;
	}
	
	//2
	public static long fermat(long n, int x) {
		if(x==0)	return 1;
		long tmp=fermat(n, x/2);
		long ret=(tmp*tmp)%P;
		if(x%2==0)	return ret;
		else return (ret*n)%P;
	}
	
	//3
	static BigInteger nCr2(int n, int r, int p) {
		long[] fac=new long[n+1];
		fac[0]=1;
		for(int i=1; i<=n; i++) fac[i]=fac[i-1]*i%p;
		
		BigInteger P=BigInteger.valueOf(p);
		BigInteger A=BigInteger.valueOf(fac[n]);
		BigInteger B=BigInteger.valueOf(fac[r]).modInverse(P).remainder(P);
		BigInteger C=BigInteger.valueOf(fac[n-r]).modInverse(P).remainder(P);
		return A.multiply(B).multiply(C).remainder(P);
	}
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_5607.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			// 1 <= N <= 100만
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			//1
			System.out.println("#"+tc+" "+nCr(N,R,P));
			
//			//2
//			long fac[] = new long[N+1];
//			fac[0]=1;
//			for(int i=1; i<=N; i++)	fac[i]=(fac[i-1]*i)%P;
//			long bottom=(fac[R]*fac[N-R])%P;
//			bottom=fermat(bottom,P-2);
//			System.out.println("#"+tc+" "+(fac[N]*bottom)%P);
//			
//			//3
//			System.out.println("#"+tc+" "+nCr2(N, R, P));
		}
	}
}