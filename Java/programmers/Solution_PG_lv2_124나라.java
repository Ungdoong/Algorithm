package programmers;

public class Solution_PG_lv2_124나라 {

	public static String solution(int n) {
		String num_arr[] = {"1", "2", "4"};
		StringBuilder sb = new StringBuilder();
		long number = n;
		
		while(number-- > 0) {
			sb.append(num_arr[(int)number%3]);
			number = number/3;
		}
		sb.reverse();
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(8));
	}
}
