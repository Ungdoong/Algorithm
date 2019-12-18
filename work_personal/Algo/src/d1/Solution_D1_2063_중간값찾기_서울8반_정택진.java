package d1;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D1_2063_중간값찾기_서울8반_정택진{
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d1_2063.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int num_numbers = T;
		int[] numbers = new int[num_numbers];

		for(int i = 0; i < num_numbers; i++){
			numbers[i] = Integer.parseInt(sc.next());
		}
		
		Arrays.sort(numbers);
		System.out.println(numbers[num_numbers/2]);
		sc.close();
	}
}