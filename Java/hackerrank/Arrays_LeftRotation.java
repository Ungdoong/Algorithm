import java.util.Arrays;

public class Arrays_LeftRotation {

	static int[] rotLeft(int[] a, int d) {
		final int N = a.length;
		int rot = d % N;
		int[] result = new int[N];

		for (int i = 0; i < N; i += 1) {
			int next_i = i - rot;

			if (next_i < 0)
				next_i += N;

			result[next_i] = a[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(rotLeft(arr, 4)));
	}

}
