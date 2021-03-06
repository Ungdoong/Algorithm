package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_D9_1953_탈주범검거_서울8반_정택진 {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        final int dx[] = { 0, 0, -1, 1};
        final int dy[] = { -1, 1, 0, 0};
        final int opposit[] = {1, 0, 3, 2};
        final boolean load[][] = {{false, false, false, false},
                                {true, true, true, true},
                                {true, true, false, false},
                                {false, false, true, true},
                                {true, false, false, true},
                                {false, true, false, true},
                                {false, true, true, false},
                                {true, false, true, false}};
         
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
             
            int[][] map = new int[N][M];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            int result = 0;
            Queue<int[]> q = new LinkedList<int[]>();
            q.offer(new int[] {Y, X, map[Y][X], 1});
            map[Y][X] = 0;
             
            while(!q.isEmpty()) {
                int[] curr = q.poll();
                int cy = curr[0];
                int cx = curr[1];
                int style = curr[2];
                int chour = curr[3];
                result++;
                 
                if(chour == L)  continue;
                 
                for(int d=0; d<4; d++) {
                    if(!load[style][d]) continue;
                    int ny = cy + dy[d];
                    int nx = cx + dx[d];
                     
                    if(nx<0 || ny<0 || nx>=M || ny>=N || map[ny][nx] == 0)  continue;
                    if(!load[map[ny][nx]][opposit[d]])  continue;
                     
                    q.offer(new int[] {ny, nx, map[ny][nx], chour+1});
                    map[ny][nx] = 0;
                }
            }
             
            System.out.println("#"+tc+" "+result);
        }
    }
}
