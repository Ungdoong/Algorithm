import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MInimumSwaps2 {

  static int minimumSwaps(int[] arr) {
    final int N = arr.length;
    int[] numbers = new int[N];
    int[] where = new int[N];

    for(int i=0; i<N; i+=1){
      numbers[i] = arr[i] - 1;
      where[numbers[i]] = i;
    }

    int result = 0;
    for(int i=0; i<N; i+=1){
      if(numbers[i] == i) continue;
      
      final int cur_num = numbers[i];
      numbers[where[i]] = cur_num;
      numbers[i] = i;
      where[cur_num] = where[i];
      where[i] = i;

      result++;
    }

    return result;
  }

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // 배열을 입력받음
    int[] arr = new int[N]; // 실제 값이 들어있는 배열
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for(int i=0; i<N; i+=1){
      final int number = Integer.parseInt(st.nextToken());
      arr[i] = number;
    }

    System.out.println(minimumSwaps(arr));
  }
}