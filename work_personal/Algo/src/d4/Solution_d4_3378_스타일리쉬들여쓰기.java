package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_d4_3378_스타일리쉬들여쓰기 {
	public static final char LEFT[] = {'(','{','['};
	public static final char RIGHT[] = {')','}',']'};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_3378.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			int count[] = new int[3];
			int[][] formulas = new int[3][4];
			
			//전체라인 계산
			int cnt_for=0;
			int R = -1, C = -1, S = -1;
			for(int i=0; i<P; i++) {
				String line = br.readLine();
				int inden = 0;
				//한 라인 계산
				for(int j=0; j<line.length(); j++) {
					char c = line.charAt(j);
					if(j == 0 && c == '.') {
						while(line.charAt(inden) == '.') { inden++; }
						for(int k=0; k<3; k++) {
							if(formulas[k][k] != 0)	continue;
							if(count[k] != 0) {
								formulas[k][0] = count[0];
								formulas[k][1] = count[1];
								formulas[k][2] = count[2];
								formulas[k][3] = inden;
								cnt_for++;
							}
						}
					}else if(c=='(' || c==')'
							 || c=='{' || c=='}'
							 || c=='[' || c==']') {
						for(int k=0; k<3; k++) {
							if(LEFT[k] == line.charAt(j))	count[k]++;
							if(RIGHT[k] == line.charAt(j))	count[k]--;
						}
					}
				}
				for(int j=0; j<3; j++) {
					if(count[j] != 0 && count[(j+1)%3] == 0 && count[(j+2)%3] == 0) {
						
					}
				}
				if(cnt_for >= 3)	break;
			}
			
			//계수가 0이 아닌 것이 먼저 나오면 앞에 위치
			Arrays.sort(formulas, new Comparator<int[]>() {
				
				@Override
				public int compare(int[] o1, int[] o2) {
					int pos1 = Integer.MAX_VALUE/2;
					int pos2 = Integer.MAX_VALUE/2;
					for(int i=0; i<4; i++) {
						if(pos1 == -1 && o1[i] != 0)	pos1 = i;
						if(pos2 == -1 && o2[i] != 0)	pos2 = i;
					}
					return (pos1 - pos2);
				}
			});
			
			for (int i = 0; i < 3; i++) {
				System.out.println(Arrays.toString(formulas[i]));
			}
			System.out.println();
			
			if(cnt_for >= 3){
				// Gauss Elimination
				for (int i = 0; i < 2; i++) {
					int[] pivot = formulas[i];
					if (pivot[i] == 0)
						continue;
					for (int j = i + 1; j < 3; j++) {
						if (formulas[j][i] != 0) {
							float multiple = formulas[j][i] / pivot[i];
							for (int k = 0; k < 4; k++)
								formulas[j][k] -= pivot[k] * multiple;
						}
					}
				}
				
				// R,C,S 계산
				int[] curr = formulas[2];
				S = (curr[2] != 0) ? Math.round(curr[3] / curr[2]) : -1;
				curr = formulas[1];
				C = (curr[1] != 0) ? Math.round((curr[3] - curr[2] * S) / curr[1]) : -1;
				curr = formulas[0];
				R = (curr[0] != 0)? Math.round((curr[3] - curr[2]*S - curr[1]*C)/curr[0]):-1;
			}
			
			System.out.println("R = "+R+"/C = "+C+"/S = "+S);
			
			count = new int[3];
			System.out.print("#"+tc);
			for(int i=0; i<Q; i++) {
				String line = br.readLine();
				int result = count[0]*R+count[1]*C+count[2]*S;
				if(count[0] > 0 && R == -1)			result = -1;
				else if(count[1] > 0 && C == -1)	result = -1;
				else if(count[2] > 0 && S == -1)	result = -1;
				System.out.print(" "+result);
				for(int j=0; j<line.length(); j++) {
					char c = line.charAt(j);
					if(c=='(' || c==')'
							 || c=='{' || c=='}'
							 || c=='[' || c==']') {
						for(int k=0; k<3; k++) {
							if(LEFT[k] == line.charAt(j))	count[k]++;
							if(RIGHT[k] == line.charAt(j))	count[k]--;
						}
					}
				}
			}
			System.out.println();
		}
	}
}
