import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewYearChaos {
	// 1 2 3 4 5 6 7 8
	// 1 2 3 5 4 6 7 8
	// 1 2 5 3 4 6 7 8
	// 1 2 5 3 4 7 6 8
	// 1 2 5 3 7 4 6 8
	// 1 2 5 3 7 6 4 8
	// 1 2 5 3 7 6 8 4
	// 1 2 5 3 7 8 6 4
	// 1 2 5 3 7 8 6 4
	// 1 2 3 5 7 8 6 4 - [3]:1
	// 1 2 3 5 7 6 8 4 - [3]:1, [6]:1
	// 1 2 3 5 7 6 4 8 - [3]:1, [6]:1, [4]:1
	// 1 2 3 5 6 7 4 8 - [3]:1, [6]:2, [4]:1
	static void minimumBribes(int[] q) {
		final int N = q.length;
		int[] send_bribe = new int[N + 1];

		int incorrect = 0;
		for (int i = 0; i < N; i += 1) {
			if (q[i] != i + 1)
				incorrect++;
		}

		int result = 0;
		while (incorrect > 0) {
			for (int i = 0; i < N - 1; i += 1) {
				// �� �ڸ��� �ƴϰ� �ش� ���� ���� ������ Ŭ ��
				if (q[i] != (i + 1) && q[i] > q[i + 1]) {
					int change = (q[i + 1] == (i + 2)) ? 1 : 0;

					swap(q, i, i + 1);
					
					if (q[i] == (i + 1))
						change--;
					if (q[i + 1] == (i + 2))
						change--;

					result++;
					incorrect += change;
					send_bribe[q[i+1]]++;
					if (send_bribe[q[i+1]] > 2) {
						System.out.println("Too chaotic");
						return;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			if(q[i] != i+1)	System.out.println(i);
		}
		
		System.out.println(result);
	}

	static void swap(int[] q, int first, int second) {
		q[first] = q[first] + q[second];
		q[second] = q[first] - q[second];
		q[first] = q[first] - q[second];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc += 1) {
			int N = Integer.parseInt(br.readLine());
			
			String[] customers = br.readLine().split(" ");
			int[] customers_i = new int[N];
			for(int i=0; i<N; i++)	customers_i[i] = Integer.parseInt(customers[i]);
			
			minimumBribes(customers_i);
		}

	}

}
