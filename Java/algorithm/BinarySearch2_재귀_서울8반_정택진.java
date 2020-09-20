package array2;

public class BinarySearch2_재귀_서울8반_정택진 {
	public static boolean binarySearch(int[] arr, int low, int high, int key) {
		if(low > high) return false;
		int middle = (low+high)/2;
		if(key == arr[middle]) return true;
		else if( key < arr[middle]) return binarySearch(arr, low, middle-1, key);
		else return binarySearch(arr, middle+1, high, key);
	}
	
	public static void main(String[] args) throws Exception{
		int[] arr= {2,4,7,9,11,19,23};
		
		int key = 7;
		System.out.println(binarySearch(arr, 0, arr.length-1, key));
	}
}