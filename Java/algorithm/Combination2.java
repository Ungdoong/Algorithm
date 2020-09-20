package array2;

import java.util.Arrays;
import java.util.Scanner;
//조열 nCr=nPr/r! 6C3=6*5*4/3*2*1=20
public class Combination2 {
    public static int n,r,caseCount,data[];
    
    public static void homogeneous(int start, int flag, int count) {
        //재귀 호출 이용
        if(count==r) {
            caseCount++;
            System.out.println(Arrays.toString(data));
            return; // 멈추는 코딩
        }
        for(int i=start;i<=n;i++) {
        	if((flag&1<<i) == 0) {
	        	data[count]=i;
	            homogeneous(i+1,flag|1<<i, count+1);
        	}
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=6;//sc.nextInt();
        r=3;//sc.nextInt();
        data=new int[r];
        homogeneous(1,0,0);
        System.out.println(caseCount);
        sc.close();
    }

}