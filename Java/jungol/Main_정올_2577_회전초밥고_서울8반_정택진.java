package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2577_회전초밥고_서울8반_정택진 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		int N=Integer.parseInt(st.nextToken());
		int D=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		int[] arr_sushi = new int[N];
		for(int i=0; i<N; i++)
			arr_sushi[i] = Integer.parseInt(br.readLine());
		
		int count = 0;
		int max = 0;
		int selection = 0;
		int[] numbers = new int[D+1];
		int coupon = 0;
		for(int i=0; i<N+K; i++) {
			int index = i%N;
			int sushi = arr_sushi[index];
			
			if(numbers[sushi] == 0)	selection++;
			numbers[sushi]++;
			count++;
			
			//쿠폰스시이면 쿠폰 변수값 증가
			if(sushi == C)	coupon++;
			
			if(count == K) {
				//최대값 확인
				max = Math.max(max, (coupon == 0)? selection+1:selection);
				
				//제거할 초밥
				int eli_index = (index-K+1 < 0)?index-K+1+N:index-K+1;
				int eliminate = arr_sushi[eli_index];
				
				//제거
				numbers[eliminate]--;
				if(numbers[eliminate] == 0)	selection--;
				//제거된 것이 쿠폰에 있는 것이면 쿠폰 변수 감소
				if(eliminate == C)	coupon--;
				//카운트 감소
				count--;
			}
		}
		
		System.out.println(max);
	}

}
