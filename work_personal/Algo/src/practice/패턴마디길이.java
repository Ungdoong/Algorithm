package practice;

import java.io.FileInputStream;
import java.util.Scanner;

public class 패턴마디길이 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_2007.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String s = sc.next();
			char s2[] = new char[s.length()];
			int s2_length = 1;

			s2[0] = s.charAt(0);
			Loop: for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) != s.charAt(0)) {
					s2[i] = s.charAt(i);
					s2_length++;
				} else {
					for (int j = 0; j < s.length(); j++) {
						System.out.print(s2[j]);
						if (s2[j % s2_length] != s.charAt(j)) {
							s2[s2_length] = s.charAt(i);
							s2_length++;
							continue Loop;
						}
					}
					break Loop;
				}
			}
			System.out.println(s2_length);
		}
		sc.close();
	}
}