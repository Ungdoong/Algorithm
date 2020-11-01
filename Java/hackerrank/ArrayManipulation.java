import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ArrayManipulation {

  static long arrayManipulation(int n, int[][] queries) {
    final int m = queries.length;
    Arrays.sort(queries, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    for (int i = 0; i < m; i += 1)
      System.out.println(Arrays.toString(queries[i]));

    PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    for (int i = 0; i < m; i += 1) {
      int[] cur = queries[i];

      for (int j = i + 1; j < m; j += 1) {
        int[] compare = queries[j];
        if (cur[1] >= compare[0]) {
          cur[0] = compare[0];
          cur[2] += compare[2];
        }
      }

      q.add(cur[2]);
    }

    return q.peek();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] queries = new int[M][3];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      queries[i][0] = Integer.parseInt(st.nextToken());
      queries[i][1] = Integer.parseInt(st.nextToken());
      queries[i][2] = Integer.parseInt(st.nextToken());
    }

    System.out.println(arrayManipulation(N, queries));
  }
}
