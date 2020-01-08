package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D9_1952_수영장_서울8반_정택진 {
    public static final int jump[] = {1, 1, 3, 12};
    public static int prices[], min;
     
    public static void findMin(int[] use, int cur, int price) {
        if(cur > 11) {
            min = Math.min(min, price);
            return;
        }
         
        if(use[cur] == 0) {
            findMin(use, cur+1, price);
            return;
        }
         
        for(int i=0; i<4; i++) {
            int next_price = (i == 0)? use[cur]*prices[i]:prices[i];
            findMin(use, cur+jump[i], price+next_price);
        }
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st=new StringTokenizer(br.readLine(), " ");
            prices = new int[4];
            for(int i=0; i<4; i++)
                prices[i] = Integer.parseInt(st.nextToken());
             
            st=new StringTokenizer(br.readLine(), " ");
            int[] use = new int[12];
            for(int i=0; i<12; i++)
                use[i] = Integer.parseInt(st.nextToken());
             
            min = Integer.MAX_VALUE/2;
            findMin(use, 0, 0);
             
            System.out.println("#"+tc+" "+min);
        }
    }
 
}
