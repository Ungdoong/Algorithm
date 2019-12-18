package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14890_경사로_서울8반_정택진 {
	public static int N, L, result;
	public static void check(int[][] map) {
		result = 0;
		for(int i=0; i<N; i++) {
			boolean[] stair = new boolean[N];
			boolean[] stair2 = new boolean[N];
			//행 검사
			for(int j=0; j<N-1; j++) {
				int start = map[i][j];
				if(j+1 < N && start != map[i][j+1]) {
					int next = map[i][j+1];
					//한칸 내려갔을 때
					if(start - next == 1) {
						int tmp_L = L-1;
						int tmp_num = map[i][j+1];
						int index = j+2;
						while(index < N && tmp_L > 0) {
							if(map[i][index] == tmp_num) {
								index++;
								tmp_L--;
							}else	break;
						}
						if(tmp_L == 0) {
							tmp_L = L;
							while(tmp_L > 0)	stair[j+tmp_L--] = true;
						}else break;
					}
					//한칸 올라갔을 때
					else if(start - next == -1) {
						int tmp_L = L;
						int tmp_num = map[i][j];
						int index = j;
						while(index >= 0 && tmp_L > 0) {
							if(stair[index])	break;
							if(map[i][index] == tmp_num) {
								index--;
								tmp_L--;
							}else break;
						}
						
						if(tmp_L == 0)	tmp_L = L;
						else break;
					}else break;
				}
				
				if(j == N-2)	result++;
			}
			//열 검사
			for(int j=0; j<N-1; j++) {
				int start = map[j][i];
				if(j+1 < N && start != map[j+1][i]) {
					int next = map[j+1][i];
					//한칸 내려갔을 때
					if(start - next == 1) {
						int tmp_L = L-1;
						int tmp_num = map[j+1][i];
						int index = j+2;
						while(index < N && tmp_L > 0) {
							if(map[index][i] == tmp_num) {
								index++;
								tmp_L--;
							}else	break;
						}
						if(tmp_L == 0) {
							tmp_L = L;
							while(tmp_L > 0)	stair2[j+tmp_L--] = true;
						}else break;
					}
					//한칸 올라갔을 때
					else if(start - next == -1) {
						int tmp_L = L;
						int tmp_num = map[j][i];
						int index = j;
						while(index >= 0 && tmp_L > 0) {
							if(stair2[index])	break;
							if(map[index][i] == tmp_num) {
								index--;
								tmp_L--;
							}else break;
						}
						if(tmp_L == 0)	tmp_L = L;
						else break;
					}else break;
				}
				
				if(j == N-2)	result++;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(map);
		
		System.out.println(result);
	}
}