package d3;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1208_Flatten_서울8반_정택진{

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		Scanner sc =new Scanner(System.in);
		int tc = 10;
		int[] blocks = new int[100];
		
		for(int i = 0; i < tc; i++) {
			int[] counts = new int[101];
			//입력 받아서 변수 초기화
			int num_dump = Integer.parseInt(sc.nextLine());
			String[] line = sc.nextLine().split(" ");
			int sum_to_aver=0;
			for(int j = 0; j < line.length; j++) {
				blocks[j] = Integer.parseInt(line[j]);
				counts[blocks[j]]++;
				sum_to_aver += blocks[j];
			}
			sum_to_aver = sum_to_aver/100;
			
			//평균보다 높은 수의 카운트 계산
			int up_count=0, up_index=-1;
			for(int j = 100; j > sum_to_aver; j--) {
				if((up_count+counts[j]) <= num_dump) {
					counts[j-1] += counts[j];
					up_count += counts[j];
					counts[j] = 0;
				}
				else {
					counts[j] -= num_dump - up_count;
					counts[j-1] += num_dump - up_count;
					up_index = j;
					up_count = num_dump;
					break;
				}
				
				if((up_count+counts[j]) <= num_dump && j == sum_to_aver+1)
					up_index = j-1;
			}
			
			//평균보다 낮은 수의 카운트 계산
			int down_count=0, down_index = -1;
			for(int j = 1; j < sum_to_aver;j++) {
				if((down_count+counts[j]) <= up_count) {
					counts[j+1] += counts[j];
					down_count += counts[j];
					counts[j] = 0;
				}
				else {
					counts[j] -= num_dump - down_count;
					counts[j+1] += num_dump - down_count;
					down_index = j;
					break;
				}
				
				if ((down_count+counts[j]) <= up_count && j == sum_to_aver-1)
					down_index = j+1;
			}
			
			System.out.println("#" + (i+1) + " " + (up_index - down_index));
		}
		
		sc.close();
	}

}