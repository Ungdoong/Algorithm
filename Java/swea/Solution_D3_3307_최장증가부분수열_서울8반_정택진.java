package d3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D3_3307_최장증가부분수열_서울8반_정택진{
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_3307.txt"));
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		int[] numbers = new int[1000];
		int[] dp = new int[1000];
		String[] str_numbers = new String[1000];
		
		String line = br.readLine();
		int num_test = Integer.parseInt(line);
		int length_numbers, max_count;
		
		for (int n = 0; n < num_test; n++) {
			max_count = 0;
			try {
				//숫자를 입력받아 인트형 배열에 저장
				length_numbers = Integer.parseInt(br.readLine());
				line = br.readLine();
				str_numbers = line.split(" ");
				for(int i = 0; i < length_numbers; i++) {
					numbers[i] = Integer.parseInt(str_numbers[i]);
					dp[i] = 0;
				}
				
				//함수를 이용하여 연산
				for(int i = 0; i < length_numbers; i++) {
					if(dp[i] == 0 )
						dp[i] = 1;
					for(int j = i + 1 ; j < length_numbers; j++) {
						if(numbers[i] < numbers[j] && dp[j] < dp[i]+1) {
							dp[j] = dp[i] + 1;
						}
						if(dp[j] > max_count)
							max_count = dp[j];
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			bw.write("#" + (n+1) + " " + max_count + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}