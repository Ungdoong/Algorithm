package array2;

import java.util.Arrays;
import java.util.Scanner;
//순열 nPr=n*(n-1)*...*(n-r) 6P3=6*5*4=120
public class Permutation2 {
    public static int n,r,caseCount,data[];
    
    public static void permutation(int start, int flag, int count) {
        if(count==r) {
            caseCount++;
            System.out.println(Arrays.toString(data));
            return;
        }
        for(int i=1;i<=n;i++) {
            if((flag&1<<i)==0) {
            	data[count]=i;
            	permutation(i+1,flag|1<<i,count+1);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=6;//sc.nextInt();
        r=3;//sc.nextInt();
        data=new int[r];
        permutation(1,0,0);
        System.out.println(caseCount);
        sc.close();
    }

}