package programmers;

public class Solution_PG_lv3_가장긴팰린드롬 {

	public static int solution(String s) {
		int answer = 1;
		int N = s.length();
		for(int i=0; i<N-1; i++) {
			if(i+1 < N && s.charAt(i) == s.charAt(i+1)) {
				int start = i;
				int end = i+1;
				while(start >= 0 && end < N && s.charAt(start) == s.charAt(end)) {
					start--;
					end++;
				}
				answer = Math.max(answer, end-start-1);
			}
			if(i+2 < N && s.charAt(i) == s.charAt(i+2)) {
				int start = i;
				int end = i+2;
				while(start >= 0 && end < N && s.charAt(start) == s.charAt(end)) {
					start--;
					end++;
				}
				answer = Math.max(answer, end-start-1);
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("aaabaaaaaaaaaaaaaaabaaaaaaaaaa"));
	}

}
