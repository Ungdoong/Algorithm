package programmers;

import java.util.HashMap;

public class Solution_PG_lv2_영어끝말잇기 {
	
	public static int[] solution(int n, String[] words) {
		HashMap<String, Integer> map = new HashMap<>();
		int count = 0;
		boolean flag = false;
		map.put(words[0], 1);
		for(int i=1; i<words.length; i++) {
			count++;
			if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)
					|| map.containsKey(words[i])) {
				flag = true;
				break;
			}
			map.put(words[i], 1);
		}
		
		int[] answer = { count%n+1, count/n+1 };
		if(!flag) {
			answer[0] = 0;
			answer[1] = 0;
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] result = solution(3, words);
		
		System.out.println(result[0]+"/"+result[1]);
	}

}
