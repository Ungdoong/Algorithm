package practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Solution {
    static int ans;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input_d4_3234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            ans = 0;
            int[] arr = new int[N];
            boolean[] visit = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            perm(arr, visit, 0, 0, N);
            System.out.println("#" + tc + " " + ans);
        }
    }
    
    public static void perm(int[] arr, boolean[] visit, int count, int left, int N) {
        if(count == N) {
            ans++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
            	visit[i] = true;
                perm(arr, visit, count + 1, left + arr[i], N);
                if(left - arr[i] >= 0)
                	perm(arr, visit, count + 1, left - arr[i], N);
                visit[i] = false;
            }
        }
    }
    
}