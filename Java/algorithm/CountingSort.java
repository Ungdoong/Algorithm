package algorithm;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {
	public static final int SIZE = 20;
	
	public static void main(String[] args) {
		int[] a = new int[SIZE];
		int i;
		//a 배열 생성
		for(i = 0; i < a.length; i++) {
			Random r = new Random();
			a[i] = r.nextInt(SIZE)+1;
		}
		
		int M = Arrays.stream(a).max().getAsInt();
		int[] counting = new int[M+1];
		int[] new_a = new int[a.length];
		
		//counting 배열 초기화
		for(i = 0; i < counting.length; i++) counting[i] = 0;

		//counting 입력
		for(i = 0; i < a.length; i++) counting[a[i]]++;
		
		//counting 누적하여 정제
		for(i = 0; i < counting.length-1; i++)
			counting[i+1] += counting[i];

		//counting을 감소해가며 해당위치에 숫자삽입
		for(i = a.length-1; i >= 0; i--) {
			new_a[counting[a[i]]-1] = a[i];
			counting[a[i]]--;
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(new_a));
	}
}