package array2;

import java.util.Arrays;
import java.util.Random;

public class PermutationLoop {
	public static void main(String[] args) {
		int[] data= new int[3];
		Random r=new Random();
		for(int i=0; i<data.length; i++)
			data[i]=r.nextInt(10);
		
		System.out.println(Arrays.toString(data));
	}
}