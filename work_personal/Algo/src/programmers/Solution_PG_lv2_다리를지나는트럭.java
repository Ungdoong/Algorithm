package programmers;

public class Solution_PG_lv2_다리를지나는트럭 {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int count = truck_weights.length;
		int start_index = 0;
		int next = 0;
		int cur_weight = 0;
		boolean enter = false;
		int[] arr = new int[count];
		for(int i=0; i<count; i++)	arr[i] = bridge_length+1;
		boolean in[] = new boolean[count];
		
		while(count > 0) {
			answer++;
			enter = false;
			if(next < truck_weights.length 
					&& cur_weight + truck_weights[next] <= weight) {
				in[next] = true;
				cur_weight += truck_weights[next++];
				enter = true;
			}
			for(int i=start_index; i<next; i++) {
				if(in[i]) {
					arr[i]--;
					
					if(arr[i] == 0) {
						in[i] = false;
						cur_weight -= truck_weights[i];
						count--;
						start_index++;
						if(!enter && next<truck_weights.length
								&& cur_weight + truck_weights[next] <= weight) {
							in[next] = true;
							cur_weight += truck_weights[next++];
						}
					}
				}else	break;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
	}

}