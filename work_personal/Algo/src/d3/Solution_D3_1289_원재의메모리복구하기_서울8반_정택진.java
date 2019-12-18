package d3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D3_1289_원재의메모리복구하기_서울8반_정택진{
	public static void main(String args[]) throws Exception{
		//System.setIn(new FileInputStream("res/input_d1_2046.txt"));
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		int[] numbers = new int[50];
		String[] str_numbers = new String[50];
		
		String line = br.readLine();
		int num_test = Integer.parseInt(line);
		int change = 0;
		
		for (int n = 0; n < num_test; n++) {
			change = 0;
			try {
				//숫자를 입력받아 인트형 배열에 저장
				line = br.readLine();
				str_numbers = line.split("");
				for(int i = 0; i < line.length(); i++) {
					numbers[i] = Integer.parseInt(str_numbers[i]);
				}

				for(int j = 0; j < str_numbers.length - 1; j++) {
					if(j == 0 && numbers[j] == 1)
						change++;
					
					if(numbers[j] != numbers[j+1]) {
							change++;
					}
				}
				bw.write("#" + (n+1) + " " + change + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		bw.flush();
		bw.close();
	}
}