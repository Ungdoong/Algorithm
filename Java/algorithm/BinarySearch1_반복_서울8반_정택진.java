package array2;

public class BinarySearch1_반복_서울8반_정택진 {
	public static boolean binarySearch(int[] arr, int key) {
		int start=0;
		int end=arr.length-1;
		
		while(start <= end) {
			int middle = (start + end)/2;
			if(arr[middle] == key)	return true;
			else if(arr[middle] > key) end = middle -1;
			else start = middle + 1;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		int[] arr= {2,4,7,9,11,19,23};
		
		int key = 7;
		System.out.println(binarySearch(arr, key));
	}
}