package algorithm;

import java.util.Arrays;

public class SelectionSort {
	public static final int[] a= {2,8,4,7,4,34,7,4,6,4,6,7,3,8,45};
	
	public static void selectionSort(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			int min=arr[i];
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					arr[j] = arr[i];
					arr[i] = min;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}
}