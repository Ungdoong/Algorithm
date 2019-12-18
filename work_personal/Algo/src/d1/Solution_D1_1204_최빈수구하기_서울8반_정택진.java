package d1;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D1_1204_최빈수구하기_서울8반_정택진{
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d1_1204.txt"));
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		
		String[] strings;
		int[] numbers = new int[1000];
		int count, max_count, number;
		String line = sc.nextLine();
		for(int i = 1; i <= tc; i++){
			line = sc.nextLine();
			line = sc.nextLine();
			strings = line.split(" ");
			max_count = 0;
			number = 0;
			
			for(int j = 0; j < strings.length; j++) {
				numbers[j] = Integer.parseInt(strings[j]);
			}
			
			for(int j = 0; j < numbers.length; j++) {
				count = 0;
				for(int k = j+1; k < numbers.length; k++) {
					if(numbers[j] == numbers[k])
						count++;
				}
				if(count > max_count) {
					max_count = count;
					number = numbers[j];
				}
			}
			
			System.out.println("#" + i + " " + number);
		}
		
		sc.close();
	}
}