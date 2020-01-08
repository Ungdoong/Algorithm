package d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_d6_1252_단순도금비용_서울8반_정택진 {
	static class Plating{
		int x;
		int y;
		int width;
		public Plating(int x, int y, int width) {
			this.x = x;
			this.y = y;
			this.width = width;
		}
		@Override
		public String toString() {
			return " " + y + " " + x + " " + width;
		}
	}
	
	public static int S, N;
	public static boolean[][] map;
	public static ArrayList<Plating> result;
	
	public static int calPrice(int width) {
		return (int) Math.floor(Math.pow(width, 2)/2.0 + 2*width/3.0 + 1.0);
	}
	
	public static double getAver(int y, int x, int width) {
		double count=0;
		for(int i=y; i<y+width; i++) {
			for(int j=x; j<x+width; j++) {
				if(map[i][j]) count++;
			}
		}
		
		return calPrice(width)/count;
	}
	
	public static void erase(int y, int x, int width) {
		for(int i=y; i<y+width; i++) {
			for(int j=x; j<x+width; j++) {
				if(map[i][j]) map[i][j] = false;
			}
		}
	}
	
	public static void findMin(int y, int x) {
		double min=2;
		int width=2, min_x=x, min_width=1;
		
		while(width <= N) {
			for(int i=x-width+1; i<=x; i++) {
				if(i >= 0 && i+width <= S && y+width <= S) {
					double next=getAver(y,i,width);
					if(next <= min) {
						min=next;
						min_x=i;
						min_width=width;
					}
				}
			}
			width++;
		}

		erase(y,min_x,min_width);
		result.add(new Plating(min_x+1, y+1, min_width));
	}
	
	public static void run() {
		for(int i=0; i<S; i++) {
			for(int j=0; j<S; j++) {
				if(map[i][j])	findMin(i,j);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d6_1252.txt"));
		FileReader fr=new FileReader("output.txt");
		BufferedReader br2=new BufferedReader(fr);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			S=Integer.parseInt(br.readLine());
			N=Integer.parseInt(br.readLine());
			
			map=new boolean[S][S];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=true;
			}
			
			
			result=new ArrayList<Plating>();
			run();
			
			System.out.print("#"+tc+" "+result.size());
			int sum=0;
			for(Plating p: result) {
				System.out.print(p.toString());
				sum += calPrice(p.width);
			}
			System.out.println();
			System.out.println("sum = " + sum);
			
			int sum2=0;
			st = new StringTokenizer(br2.readLine());
			while(st.hasMoreTokens()) {
				st.nextToken();
				st.nextToken();
				sum2 += calPrice(Integer.parseInt(st.nextToken()));
			}
			System.out.println("output = " + sum2);
		}
	}

}
