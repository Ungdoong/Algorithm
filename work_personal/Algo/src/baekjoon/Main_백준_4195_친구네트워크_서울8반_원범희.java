package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_4195_친구네트워크_서울8반_원범희 {
	public static int par[];

	public static void union(int a, int b) {
		int para = par(a);
		int parb = par(b);
		if (para > parb) {
			par[para] = parb;
		} else
			par[parb] = para;
	}

	public static int par(int a) {
		if (par[a] == a)
			return a;
		return par[a] = par(par[a]);
	}

	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> hm = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int F = Integer.parseInt(br.readLine());

			int[] par = new int[F + F];
			for (int i = 0; i < par.length; i++) {
				par[i] = i;
			}

			System.out.println(Arrays.toString(par));
			StringTokenizer st;
			int cnt = -1;
			for (int i = 0; i < F; i++) {
				int a = 0;
				int b = 0;
				st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if (!hm.containsKey(name1)) {
					hm.put(name1, ++cnt);
				}

				a = hm.get(name1);
				if (!hm.containsKey(name2)) {
					hm.put(name2, ++cnt);
				}
				b = hm.get(name2);

				if (par(a) != par(b)) {
					union(a, b);
				}
			}

			int ans = 0;
			for (int i = 0; i < par.length; i++) {
				ans = 0;
				for (int j = i + 1; j < par.length; j++) {
					if (par[i] == par(j))
						ans++;
				}
				System.out.println(ans);
			}

		}
	}
}