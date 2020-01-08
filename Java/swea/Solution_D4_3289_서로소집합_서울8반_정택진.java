package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합_서울8반_정택진 {
	 public static int getParent(int[] p, int x) {
	        if(p[x] == x) return x;
	        return p[x] = getParent(p, p[x]);
	    }
	    public static void union(int[] arr, int a, int b) {
	        a = getParent(arr,a);
	        b = getParent(arr,b);
	        if(a < b) arr[b] = a;
	        else arr[a] = b;
	    }
	    public static boolean find(int[] arr, int a, int b) {
	        a = getParent(arr, a);
	        b = getParent(arr, b);
	        if(a == b)
	            return true;
	        else
	            return false;
	    }
	    public static void main(String[] args)throws Exception {
	    	System.setIn(new FileInputStream("res/input_d4_3289.txt"));
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine());
	        
	        for(int tc=1; tc<=T; tc++) {
	            StringBuilder sb = new StringBuilder();
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int n = Integer.parseInt(st.nextToken());
	            int m = Integer.parseInt(st.nextToken());
	            
	            int[] numbers = new int[n];
	            for(int i=0; i<n; i++)
	                numbers[i] = i;
	            
	            for(int i=0; i<m; i++) {
	                st = new StringTokenizer(br.readLine());
	                int k = Integer.parseInt(st.nextToken());                
	                int a = Integer.parseInt(st.nextToken())-1;                
	                int b = Integer.parseInt(st.nextToken())-1;                
	                if(k == 0) {
	                    union(numbers, a, b);
	                }
	                else {
	                    if(find(numbers, a, b)) sb.append(1);
	                    else sb.append(0);
	                }
	            }
	            System.out.println("#"+tc+" "+sb.toString());
	        }
	    }
}