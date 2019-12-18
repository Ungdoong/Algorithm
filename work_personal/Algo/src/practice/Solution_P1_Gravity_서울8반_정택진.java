package practice;
import java.util.Random;

public class Solution_P1_Gravity_서울8반_정택진{
	public static void build_data(int[] data) {
		Random r = new Random();
		for(int i = 0; i < 100; i++) {
			data[i] = r.nextInt(100);
		}
	}
	public static void main(String args[]) throws Exception{
		int[] data = new int[100];
		int max, count;
		
		for(int i = 0; i < 10; i++) {
			build_data(data);
			max = 0;
			
			for(int j = 0; j < data.length; j++) {
				count = 0;
				for(int k = j + 1; k < data.length; k++) {
					if(data[j] > data[k])
						count++;
				}
				
				if(max<count) {
					max = count;
				}
			}
			
			System.out.printf("#%d %d\n",i+1,max);
		}
	}
}