package algorithm;

import java.util.Arrays;
import java.util.Scanner;

// 중복순열 nPIr=n^r 5PI3=5*5*5=125
// 순열 nPr=n*(n-1)*...*(n-r) 5P3=5*4*3=60
// 중복조합 nHr=n+r-1Cr 56H3=5+3-1C3=7C3=7P3/3!=7*6*5/3*2*1=35
// 조합 nCr=nPr/r! 5C3=5*4*3/3*2*1=10
public class PermComb {
    public static int n, r, cnt;
    public static int[] d = { 1, 2, 3, 4, 5 };
    public static int[] a, v;
    
    public static void permcomb(int start, int count) {
        if (count == r) {
            cnt++;
            System.out.println(Arrays.toString(a));
            return;
        }
        for (int i = start; i < n; i++) {
            if (v[i] == 0) {
                v[i] = 1;
                a[count] = d[i];
                permcomb(i, count + 1);
                v[i] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = 5; // n=sc.nextInt();
        r = 3; // r=sc.nextInt();
        v = new int[n];
        a = new int[r];
        permcomb(0, 0);
        System.out.println(cnt);
        sc.close();
    }
}