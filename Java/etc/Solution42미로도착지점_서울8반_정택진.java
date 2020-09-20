package practice;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution42미로도착지점_서울8반_정택진 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution42미로도착지점.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tn=sc.nextInt();
		
		for(int tc=1; tc<=tn; tc++) {
			int N = sc.nextInt()+1;	//배열크기
			boolean[][] miro=new boolean[N][N];
			int y = sc.nextInt();
			int x = sc.nextInt();
			int num_jumper = sc.nextInt();
			
			for(int jumper=0; jumper<num_jumper; jumper++) {
				int jy=sc.nextInt();
				int jx=sc.nextInt();
				miro[jy][jx]=true;
			}
			
			int num_dir=sc.nextInt();
			System.out.println(num_dir);
			for(int round=0;round<num_dir;round++) {
				int dir=sc.nextInt();
				int dis=sc.nextInt();
				if(!miro[y][x]) {
					while(dis > 0) {
						switch(dir) {
						case 1:
							if(y-1>=1 &&!miro[y-1][x]) { y=y-1; dis--; }
							else{ x=0; y=0; }
							break;
						case 2:
							if(x+1<N && !miro[y][x+1]) { x=x+1; dis--; }
							else{ x=0; y=0; }
							break;
						case 3:
							if(y+1<N &&!miro[y+1][x]) { y=y+1; dis--; }
							else{ x=0; y=0; }
							break;
						case 4:
							if(x-1>=1 && !miro[y][x-1]) { x=x-1; dis--; }
							else{ x=0; y=0; }
							break;
						}
						if(x==0 && y==0)
							break;
					}
				}
				else {
					x=0; y=0;
				}
				
				if(x==0 && y==0)
					break;
			}
			
			System.out.println("#"+tc+" "+y+" "+x);
		}
		
		sc.close();
	}
}