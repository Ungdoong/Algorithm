package exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_AD_0002_원자소멸시뮬레이션_서울8반_정택진 {
	public static final int dx[] = { 0, 0, -1, 1};
	public static final int dy[] = { 1, -1, 0, 0};
	public static int N, result, count, atom[][];
	public static int map[][] = new int[4001][4001];
	public static ArrayList<Integer> boom;
	
	public static void process() {
		for(int i=1; i<=N; i++) {
			if(atom[i][4] == 1) {
				int ny = atom[i][0] + dy[atom[i][2]];
				int nx = atom[i][1] + dx[atom[i][2]];
				//좌표범위 밖으로 벗어나 충돌하는 경우가 사라짐
				if(ny < 0 || ny >= 4001 || nx <0 || nx >= 4001) {
					map[atom[i][0]][atom[i][1]] = 0;
					count--;
					atom[i][4] = 0;
					continue;
				}
				
				//이동하려는 자리에 이미 원소가 존재
				if(map[ny][nx] != 0) {
					count--;
					result+=atom[i][3];
					atom[i][4] = 0;
					//첫 충돌일 경우
					if(!boom.contains(map[ny][nx])) {
						count--;
						result+=atom[map[ny][nx]][3];
						atom[map[ny][nx]][4] = 0;
						boom.add(map[ny][nx]);
					}
				}else	map[ny][nx] = i;
				
				map[atom[i][0]][atom[i][1]] = 0;
				atom[i][0] = ny;
				atom[i][1] = nx;
			}
		}
		
		while(!boom.isEmpty()) {
			int curr = boom.remove(0);
			map[atom[curr][0]][atom[curr][1]] = 0;
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_원자소멸시뮬레이션2019(2).txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			atom = new int[N+1][5];
			for(int i=1; i<=N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				atom[i][1]=Integer.parseInt(st.nextToken())*2+2000;
				atom[i][0]=Integer.parseInt(st.nextToken())*2+2000;
				atom[i][2]=Integer.parseInt(st.nextToken());
				atom[i][3]=Integer.parseInt(st.nextToken());
				atom[i][4]=1;
				map[atom[i][0]][atom[i][1]] = i;
			}
			
			result=0;
			count=N;
			boom = new ArrayList<>();
			while(count > 0)	process();
			
			System.out.println("#"+tc+" "+result);
		}
		br.close();
	}
}