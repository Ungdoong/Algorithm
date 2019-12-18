package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution_D3_5215_햄버거다이어트_서울8반_정택진2 {
    static int T, N, L, max;
    static int[] cal, point;
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("res/input_d3_5215.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            L = Integer.parseInt(str[1]);
            int len = N;
            max = 0;
            cal = new int[len];
            point = new int[len];
            for(int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                point[N] = Integer.parseInt(str[0]);
                cal[N] = Integer.parseInt(str[1]);
            }
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(max).append("\n");
            bw.write(sb.toString());
        }
        br.close();
        bw.close();
    }
}