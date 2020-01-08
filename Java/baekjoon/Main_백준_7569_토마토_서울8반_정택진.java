package baekjoon;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Coor{
    int x;
    int y;
    int z;
    
    Coor(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
 
public class Main_백준_7569_토마토_서울8반_정택진 {
    static int n;
    static int m;
    static int l;
    static int[][][] matrix;
    static int[][][] tomato;
    static Queue<Coor> q = new LinkedList<Coor>();
    
    static int[] dx = {0,0,1,-1,0,0};
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    
    private static void BFS() {
        // TODO Auto-generated method stub
        while(!q.isEmpty()) {
            Coor c = q.poll();
            int x = c.x;
            int y = c.y;
            int z = c.z;
 
            for(int k=0; k<dx.length; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nz = z + dz[k];
                
                if(nx >= 0 && ny >= 0  && nz>=0 && nx<n && ny<m && nz<l) {
                    if(matrix[nx][ny][nz] == 0 && tomato[nx][ny][nz]==-1) {
                        matrix[nx][ny][nz] = 1;
                        tomato[nx][ny][nz] = tomato[x][y][z] + 1;
                        q.add(new Coor(nx,ny,nz));
                    }
                }
            }
        }
    }
    
    private static void lastCheck() {
        // TODO Auto-generated method stub
        int rs = 1;
        for(int k=0; k<l; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                
                    if(matrix[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                    
                    if(tomato[i][j][k] > rs) {
                        rs = tomato[i][j][k];
                    }
                }
            }            
        }
        System.out.println(rs);
    }
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
    	System.setIn(new FileInputStream("res/input_baekjun_7569.txt"));
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        
        n = sc.nextInt(); //행
        m = sc.nextInt(); //열
        l = sc.nextInt();
        
        matrix = new int [n][m][l];
        tomato = new int[n][m][l];
        
        for(int k=0; k<l; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                
                    matrix[i][j][k] = sc.nextInt();
                    tomato[i][j][k] = -1;
                    
                    if(matrix[i][j][k]==1) {
                        tomato[i][j][k] = 0;
                        q.add(new Coor(i,j,k));
                    }
                    
                    if(matrix[i][j][k]==0 && check) {
                        check = true;
                    }
                }
            }
        }
        
        if(check) System.out.println(0);
        else {
            BFS();
            lastCheck();
        }
        
        sc.close();
    }
}