package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1258.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			//변수초기화
			int N=Integer.parseInt(br.readLine());
			
			int[][] arr=new int[N][N];
			int[][] check=new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			//가로확인
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] != 0) {
						if(j-1 >= 0) {
							check[i][j] = check[i][j-1]+1;
							check[i][j-1] = 0;
						}
						else check[i][j] = 1;
					}
				}
			}
			
			//세로 확인
			ArrayList<int[]> list=new ArrayList<int[]>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(check[i][j] != 0) {
						int cols = check[i][j];
						int rows = 0;
						int y=i;
						while(y < N && check[y][j] == cols) {
							rows++;
							check[y++][j] = 0;
						}
						list.add(new int[] {cols, rows});
					}
				}
			}
			
			//정렬
			Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]*o1[1] == o2[0]*o2[1])	return Integer.compare(o1[1], o2[1]);
					return Integer.compare(o1[0]*o1[1], o2[0]*o2[1]);
				}
			});
			
			
			//출력
			System.out.print("#"+tc+" "+list.size());
			for(int i=0; i<list.size(); i++) {
				System.out.print(" "+list.get(i)[1]);
				System.out.print(" "+list.get(i)[0]);
			}
			System.out.println();
		}
	}
}
