package d5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_d5_1242_암호코드스캔_서울8반_정택진 {
	public static final String[] numbers = {"0001101","0011001","0010011"
			,"0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
	public static String[] numbers2=new String[10];
	public static Map<Character, String> hextobin = new HashMap<Character, String>();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d5_1242.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());

		init();

		//알고리즘
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int Y=Integer.parseInt(st.nextToken());
			st.nextToken();
			
			//암호코드를 잘라서 큐에 삽입
			Queue<String> codes=new LinkedList<String>();
			Pattern p=Pattern.compile("[1-9A-F]");
			Matcher m;
			
			for(int i=0; i<Y; i++) {
				String s=br.readLine();
				m=p.matcher(s);
				//코드가 들어있는 라인 체크 및 앞뒤 0 삭제
				if(m.find()) {
					s = delZero(s,false);
					if(!codes.contains(s))	codes.add(s);
				}
			}
			//서로 중복되는 코드 삭제
			codes = truncate(truncate(truncate(codes)));
			
			//2진수로 변환 후 앞 뒤의 0 삭제
			StringBuilder sb=new StringBuilder();
			int len=codes.size();
			while(len-- > 0) {
				String code=codes.poll();
				for(int j=0; j<code.length(); j++)
					sb.append(hextobin.get(code.charAt(j)));
				sb = new StringBuilder(delZero(sb.toString(),false));
				
				if(!codes.contains(sb.toString()))
					codes.offer(sb.toString());
				sb.delete(0, sb.length());
			}
			
			//암호 해석
			int n=codes.size();
			ArrayList<String> result = new ArrayList<String>();
			while(n-- > 0) {
				String s=codes.poll();
				s = delZero(s, true);
				for(String r :deCrypt(s)) {
					if(!result.contains(r))	result.add(r);
				}
			}
			
			//암호 검증
			int sum1=0, sum2=0, answer=0;
			for(String r :result) {
				sum1=0; sum2=0;
				for(int i=0; i<r.length(); i++) {
					if(i%2==0)	sum1 += (r.charAt(i) - '0')*3;
					else		sum1 += r.charAt(i) - '0';
					sum2 += r.charAt(i) - '0';
				}
				
				if(sum1 % 10 == 0)	answer += sum2;
			}
			
			bw.write("#"+tc+" "+answer+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	
	public static void init() {
		//16진수의 2진수로의 변환에 필요한 변수 초기화
		hextobin.put('0', "0000");
		hextobin.put('1', "0001");
		hextobin.put('2', "0010");
		hextobin.put('3', "0011");
		hextobin.put('4', "0100");
		hextobin.put('5', "0101");
		hextobin.put('6', "0110");
		hextobin.put('7', "0111");
		for(int i=8; i<16; i++) {
			char index=Integer.toHexString(i).toUpperCase().charAt(0);
			hextobin.put(index, Integer.toBinaryString(i));
		}
	}
	
	public static String delZero(String s, boolean flag) {
		StringBuilder sb=new StringBuilder(s);
		while(sb.length() > 0 && sb.charAt(0)=='0')
			sb.deleteCharAt(0);
		while(sb.length() > 0 && sb.charAt(sb.length()-1)=='0')
			sb.deleteCharAt(sb.length()-1);
		if(flag) {
			int len = ((sb.length()/56)+1)*3; 
			for(int i=0; i<len; i++)
				sb.insert(0, "0");
		}
		return sb.toString();
	}
	
	public static Queue<String> truncate(Queue<String> q) {
		String[] arr=new String[q.size()];
		int size=q.size();
		for(int i=0; i<size; i++)	arr[i]=q.poll();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(i!=j) {
					String s1=arr[i];
					String s2=arr[j];
					if(!s1.isEmpty() && s2.contains(s1)) {
						s2 = s2.replace(s1, "");
						s2 = (s2.length() != 0)? delZero(s2, false) : "";
						arr[j]=s2;
					}else if(!s2.isEmpty() && s1.contains(s2)) {
						s1 = s1.replace(s2, "");
						s1 = (s1.length() != 0)? delZero(s1, false) : "";
						arr[i]=s1;
					}
				}
			}
		}
		
		for(String s: arr)	if(s.length() != 0 && !q.contains(s)) q.offer(s);
		return q;
	}
	
	public static void setNumbers2(int mul) {
		StringBuilder sb;
		String s;
		for(int i=0; i<numbers2.length; i++) {
			sb=new StringBuilder();
			s=numbers[i];
			for(int j=0; j<s.length(); j++) {
				for(int m=0; m<mul; m++) {
					sb.append(s.charAt(j));
				}
			}
			numbers2[i]=sb.toString();
		}
	}
	
	public static ArrayList<String> deCrypt(String s) {
		StringBuilder sb=new StringBuilder();
		ArrayList<String> list=new ArrayList<String>();
		ArrayList<String> result=new ArrayList<String>();
		int mul=1; int count=0; int len=s.length();
		setNumbers2(mul);
		while(len-- > 0) {
			sb.insert(0, s.charAt(len));
			count++;
			if(count == 7*mul) {
				for(int i=0; i<numbers2.length; i++) {
					if(sb.toString().equals(numbers2[i])) {
						list.add(i+"");
						sb.delete(0, sb.length());
						count=0;
					}
					
				}
				if(count != 0) {
					mul++;
					setNumbers2(mul);
				}
			}
			
			if(list.size() == 8) {
				for(String num: list)	sb.insert(0, num);
				result.add(sb.toString());
				list.clear();
			}
		}
		
		return result;
	}
}