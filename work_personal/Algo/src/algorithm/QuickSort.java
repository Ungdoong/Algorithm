package algorithm;

import java.util.Arrays;

public class QuickSort {
	public static int[] a = {69,10,30,2,16,8,31,22,57,86,78,12,78,6,8,7,3,248,89};
	
	public static void quick(int start, int end) {
		int left = start;
		int right = end;
		int pivot = a[(start+end)/2];
		
		do {
			while(a[left] < pivot) left++;
			while(a[right] > pivot) right--;
			
			if(left <= right) {
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				if(left == right) right++;
				left++;
				right--;
			}
		}while(left <= right);
		
		if(start < right) quick(start, right);
		if(end > left) quick(left, end);
	}
	
	public static void main(String[] args) {
		quick(0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}