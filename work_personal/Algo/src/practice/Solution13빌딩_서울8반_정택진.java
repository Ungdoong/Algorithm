package practice;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution13빌딩_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution13빌딩.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tn= sc.nextInt();
		
		for(int tc=1; tc<=tn; tc++) {
			int N=sc.nextInt();
			char[][] area = new char[N][N];
			int max=0;
			
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++)
				area[y][x] = sc.next().charAt(0);
			}
						
			int[] dx= {-1,0,1,1,1,0,-1,-1};
			int[] dy= {-1,-1,-1,0,1,1,1,0};
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					int height=0; int dft_hgt=1;
					
					//인접검사
					for(int d=0; d<dx.length; d++) {
						int nx=x+dx[d];
						int ny=y+dy[d];
						if(nx>=0 && nx<N && ny>=0 && ny<N) {
							if(area[ny][nx] == 'G')
								dft_hgt=2;
						}
					}
					
					//상하좌우 검사
					if(dft_hgt !=2) {
						for(int i=0; i<N; i++) {
							if(area[y][i] == 'B' && i != x)
								height++;
							if(area[i][x] == 'B' && i != y)
								height++;
						}
					}
					
					if(max<(dft_hgt + height))
						max = dft_hgt + height;
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
		
		sc.close();
	}
}