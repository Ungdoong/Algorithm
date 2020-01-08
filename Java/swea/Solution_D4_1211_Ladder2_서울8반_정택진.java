package d4;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_1211_Ladder2_서울8반_정택진 {
	static int[][] ladder;
	static int dis;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_D4_1211.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		//테스트 케이스 루프
		for(int tc=1; tc<=10; tc++) {
			sc.nextLine();
			ladder = new int[100][100];
			
			//사다리 2차원 배열 초기화
			for(int i=0; i<100; i++) {
				String[] str_arr=sc.nextLine().split(" ");
				for(int j=0; j<100; j++)
					ladder[i][j] = Integer.parseInt(str_arr[j]);
			}
			
			//첫행 루프
			int pos_x=0, min=Integer.MAX_VALUE;
			for(int x=0; x<100; x++) {
				int state=0; //0:대기상태 1:아래로이동 2:우로이동 3:좌로이동
				dis=0;
				if(ladder[0][x] == 1) {
					state=1;
					findDst(x, 0, state);
					
					if(min>dis) {
						min=dis;
						pos_x=x;
					}
				}
			}
			
			System.out.println("#"+tc+" "+pos_x);
		}
		
		sc.close();
	}
	
	static boolean findDst(int x, int y, int state) {
		dis++;
		switch(state) {
		case 1:
			if((x+1)<100 && ladder[y][x+1] >= 1) {
				state=2;
				if(ladder[y][x+1] == 2)
					return true;
				else
					return findDst(x+1, y, state);
			}
			else if((x-1)>=0 && ladder[y][x-1] >= 1) {
				state=3;
				if(ladder[y][x-1] == 2)
					return true;
				else
					return findDst(x-1, y, state);
			}
			else if((y+1)<100 && ladder[y+1][x] >= 1) {
				if(ladder[y+1][x] == 2)
					return true;
				else
					return findDst(x, y+1, state);	
			}
			else
				return false;
		case 2:
			if((x+1)<100 && ladder[y][x+1] >= 1) {
				if(ladder[y][x+1] == 2)
					return true;
				else
					return findDst(x+1, y, state);
			}
			else if((y+1)<100 && ladder[y+1][x] >= 1) {
				state=1;
				if(ladder[y+1][x] == 2)
					return true;
				else
					return findDst(x, y+1, state);	
			}
			else
				return false;
		case 3:
			if((x-1)>=0 && ladder[y][x-1] >= 1) {
				if(ladder[y][x-1] == 2)
					return true;
				else
					return findDst(x-1, y, state);
			}
			else if((y+1)<100 && ladder[y+1][x] >= 1) {
				state=1;
				if(ladder[y+1][x] == 2)
					return true;
				else
					return findDst(x, y+1, state);	
			}
			else
				return false;
		default:
			return false;
		}
	}
}