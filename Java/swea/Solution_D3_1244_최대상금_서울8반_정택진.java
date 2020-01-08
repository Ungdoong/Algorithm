package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_서울8반_정택진 {
	public static int N, stop, result;
	public static int[] numbers;
	public static int sorted;
	public static ArrayList<Integer> list;
	
	public static void swap(int i, int j) {
		int tmp=numbers[i]; numbers[i]=numbers[j]; numbers[j]=tmp;
	}
	
	public static void findSolution(int start,int round) {
		StringBuilder sb = new StringBuilder();
		for(int i :numbers)
			sb.append(i);
		
		if(round == N) {
			result = Math.max(result, Integer.parseInt(sb.toString()));
			return;
		}
		if(Integer.parseInt(sb.toString()) == sorted) {
			stop = Math.max(stop, round);
			return;
		}
		
		int max=0;
		for(int i=start; i<numbers.length; i++)
			if(max < numbers[i])
				max=numbers[i];
		
		for(int i=start; i<numbers.length; i++) {
			if(i!=start && numbers[i] == max) {
				swap(start, i);
				findSolution(start+1, round+1);
				swap(i,start);
			}else if(i==start && numbers[i] == max)
				findSolution(start+1, round);
		}
	}
	
	public static void sort(String number) {
		StringBuilder n=new StringBuilder(number);
		for(int i=0; i<n.length()-1; i++) {
			for(int j=i+1; j<n.length(); j++) {
				if(n.charAt(i)-'0' < n.charAt(j)-'0') {
					char ch1=n.charAt(i);
					char ch2=n.charAt(j);
					n.deleteCharAt(i);
					n.insert(i, ch2);
					n.deleteCharAt(j);
					n.insert(j, ch1);
				}
			}
		}
		sorted=Integer.parseInt(n.toString());
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1244.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			String number=st.nextToken();
			N=Integer.parseInt(st.nextToken());
			numbers=new int[number.length()];
			stop=-1;
			result=Integer.MIN_VALUE;
			sorted=0;

			for(int i=0; i<number.length(); i++)
				numbers[i] = number.charAt(i) - '0';
			
			sort(number);
			
			findSolution(0, 0);
			
			if(stop != -1 && stop < N) {
				if((N-stop)%2 == 0)
					result=sorted;
				else {
					boolean flag=true;
					for(int i=0; i<numbers.length-1; i++)
						if(numbers[i] == numbers[i+1])	flag=false;
					if(flag) {
						int a=sorted%10;
						int b=sorted%100-a;
						result=sorted-a-b+a*10+b/10;
					}else result = sorted;
				}
			}
			
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}