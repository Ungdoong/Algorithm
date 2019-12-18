package algorithm;

public class Selection {
	public static final int[] a= {9,8,7,6,5,4,3,2,1,0,10,11,12,13};
	
	public static int select(int key) {
		for(int i=0; i<key; i++) {
			int minIndex=i;
			int minValue=a[i];
			for(int j=i+1; j<a.length;j++) {
				if(a[j] < minValue) {
					minIndex=j;
					minValue = a[j];
				}
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
		return a[key-1];
	}
	
	public static void main(String[] args) {
		System.out.println(select(8));
	}
}