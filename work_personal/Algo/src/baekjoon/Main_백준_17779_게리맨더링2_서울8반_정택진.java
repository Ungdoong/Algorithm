package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17779_게리맨더링2_서울8반_정택진 {
	
	public static int N, result;
	
	public static void numbering(int[][] population, int x, int y, int d1, int d2) {
		int[][] numbers = new int[N+2][N+2];
		//5구역
		for(int a=0; a<=d1; a++) {
			for(int b=0; b<=d2; b++) {
				//1
				numbers[x+a][y-a] = 5;
				//2
				numbers[x+b][y+b] = 5;
				//3
				numbers[x+d1+b][y-d1+b] = 5;
				//4
				numbers[x+d2+a][y+d2-a] = 5;
			}
		}
		
		for(int i=1; i<=N; i++) {
			int start_y = 0;
			int end_y = 0;
			for(int j=1; j<=N; j++) {
				if(numbers[i][j] == 5) {
					if(start_y == 0)	start_y = j;
					else				end_y = j;
				}
			}
			
			if(start_y != 0 && end_y != 0) {
				while(start_y < end_y) {
					numbers[i][start_y] = 5;
					start_y++;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(numbers[i][j] == 5)	continue;
				
				//1구역
				if(i < x+d1 && j <= y)				numbers[i][j] = 1;
				//2구역
				else if(i <= x+d2 && j > y)			numbers[i][j] = 2;
				//3구역
				else if(i >= x+d1 && j < y-d1+d2)	numbers[i][j] = 3;
				//4구역
				else								numbers[i][j] = 4;
			}
		}
		checkResult(population, numbers);
	}
	
	public static void checkResult(int[][] population, int[][] numbers) {
		int[] section = new int[6];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				section[numbers[i][j]] += population[i][j];
			}
		}

		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=5; i++) {
			max = Math.max(max, section[i]);
			min = Math.min(min, section[i]);
		}
		
		result = Math.min(result, max - min);
	}
	
	public static void decideCondition(int[][] population) {
		for(int x=1; x<=N; x++) {
			for(int y=1; y<=N; y++) {
				for(int d1=1; d1+x<=N; d1++) {
					for(int d2=1; x+d1+d2<=N; d2++) {
						if(y-d1 < 1 || y+d2 > N)	continue;
						
						numbering(population, x, y, d1, d2);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] population = new int[N+2][N+2];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MAX_VALUE;
		decideCondition(population);
		
		System.out.println(result);
	}
}