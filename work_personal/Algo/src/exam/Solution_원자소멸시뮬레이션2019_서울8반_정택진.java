package exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution_원자소멸시뮬레이션2019_서울8반_정택진 {
	public static int N, result, map[][];
	public static double atom[][];
	public static boolean boom[];
	public static final int[] dy = {1,-1,0,0};
	public static final int[] dx = {0,0,-1,1};
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2);
	}
	
	public static boolean awayCheck() {
		for(int i=0; i<N; i++) {
			if(boom[i]) continue;
			
			for(int j=i+1; j<N; j++) {
				if(boom[j]) continue;
				
				double x1=atom[i][0];
				double y1=atom[i][1];
				double x2=atom[j][0];
				double y2=atom[j][1];
				double nx1=x1-dx[(int)atom[i][2]];
				double ny1=y1-dy[(int)atom[i][2]];
				double nx2=x2-dx[(int)atom[j][2]];
				double ny2=y2-dy[(int)atom[j][2]];
				if(distance(x1,y1,x2,y2) < distance(nx1,ny1,nx2,ny2))
					return false;
			}
		}
		
		return true;
	}
	
	public static boolean boomCheck() {
		for(int i=0; i<N; i++)
			if(!boom[i]) return false;
		return true;
	}
	
	public static void collisionCheck() {
		for(int i=0; i<N; i++) {
			if(boom[i]) continue;
			int sum=0;
			double x=atom[i][0], y=atom[i][1];
			for(int j=i+1; j<N; j++) {
				if(boom[j]) continue;
				if(x == atom[j][0] && y == atom[j][1]) {
					sum += atom[j][3];
					boom[j]=true;
				}
			}
			
			if(sum > 0) {
				sum += atom[i][3];
				boom[i]=true;
				result += sum;
			}
		}
	}
	
	public static void moveStep(double m) {
		for(int i=0; i<N; i++) {
			if(boom[i]) continue;
			atom[i][0] += dx[(int)atom[i][2]]*m;
			atom[i][1] += dy[(int)atom[i][2]]*m;
		}
	}
	
	public static void run() {
		while(!boomCheck() && !awayCheck()) {
			collisionCheck();
			moveStep(0.5);
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_원자소멸시뮬레이션2019.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			atom = new double[N][4];
			boom = new boolean[N];
			for(int i=0; i<N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				atom[i][0]=Integer.parseInt(st.nextToken());
				atom[i][1]=Integer.parseInt(st.nextToken());
				atom[i][2]=Integer.parseInt(st.nextToken());
				atom[i][3]=Integer.parseInt(st.nextToken());
			}
			
			result=0;
			run();
			System.out.println("#"+tc+" "+result);
		}
	}
}