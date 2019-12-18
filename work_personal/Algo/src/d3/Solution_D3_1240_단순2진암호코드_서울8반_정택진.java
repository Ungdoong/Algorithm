package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1240_단순2진암호코드_서울8반_정택진 {
	public static final String[] numbers= {"0001101","0011001","0010011"
			,"0111101","0100011","0110001","0101111","0111011","0110111","0001011"}; 
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1240.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			StringBuilder sb=new StringBuilder();
			int Y=Integer.parseInt(st.nextToken());
			int X=Integer.parseInt(st.nextToken());
			
			int[] code=new int[8]; int count=0; 
			boolean flag=true;
			for(int i=0; i<Y; i++) {
				String[] line=br.readLine().split("");
				if(flag) {
					for(int j=0; j<X; j++) {
						sb.append(line[j]);
						if(sb.length()>7) sb.delete(0, 1);
						for(int k=0; k<numbers.length; k++) {
							if(sb.toString().equals(numbers[k]) 
									&& (((j+1)<X && line[j+1].equals("0")) || (j+1>=X))) {
								code[count++] = k;
								sb.delete(0, sb.length());
							}
						}
						if(count==8) { flag=false; break; }
					}
				}
			}
			
			//유효성 검사
			int sum1=0; int sum2=0; int sum3=0;
			for(int i=0; i<7; i++) {
				if(i%2==0)	sum1+=code[i];
				else		sum2+=code[i];
				sum3+=code[i];
			}
			
			
			if((sum1*3+sum2+code[7])%10 == 0)
				System.out.println("#"+tc+" "+(sum3+code[7]));
			else
				System.out.println("#"+tc+" 0");
		}
	}
}