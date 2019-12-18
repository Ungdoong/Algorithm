package d1;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D1_2046_스탬프찍기_서울8반_정택진{
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d1_2046.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++){
			System.out.print("#");
		}
		
		sc.close();
	}
}