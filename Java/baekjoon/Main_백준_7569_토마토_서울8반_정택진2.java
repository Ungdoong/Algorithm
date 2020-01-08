package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7569_토마토_서울8반_정택진2 {
	public static final int[] dx = { 0, 1, 0, -1, 0, 0 };
	public static final int[] dy = { -1, 0, 1, 0, 0, 0 };
	public static final int[] dh = { 0, 0, 0, 0, 1, -1 };
	public static int[] box;
	public static Queue<Integer> q=new LinkedList<Integer>();

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_baekjun_7569.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		FileWriter fw=new FileWriter("result.txt");
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int X=Integer.parseInt(st.nextToken());
		int Y=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		
		box=new int[H*Y*X];
		for(int k=0; k<H; k++) {
			for(int i=0; i<Y; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<X; j++) {
					int index=k*(Y*X)+i*X+j;
					box[index] = Integer.parseInt(st.nextToken());
					if(box[index] == 1)	q.offer(index);
				}
			}
		}
		int day=0;
		int size=q.size();
		boolean flag = false;
		int tmp_day=day;
		while(!q.isEmpty()) {
			int cur=q.poll();
			size--;
			for(int i=0; i<6; i++) {
				int nh=cur/(X*Y)+dh[i];
				int ny=(cur%(X*Y))/X+dy[i];
				int nx=(cur%(X*Y))%X+dx[i];
				int nindex = nh*(X*Y)+ny*X+nx;
				if(nh >= 0 && nh < H &&
				   ny >= 0 && ny < Y &&
				   nx >= 0 && nx < X &&
				   box[nindex] == 0) {
					box[nindex]=1;
					q.offer(nindex);
					flag = true;
				}
			}
			if(size == 0 && flag) {
				size=q.size();
				day++;
				flag=false;
			}
			
			if(tmp_day != day) {
				tmp_day=day;
				for(int k=0; k<H; k++) {
					for(int i=0; i<Y; i++) {
						for(int j=0; j<X; j++) {
							fw.append(box[k*X*Y+i*X+j]+" ");
						}
						fw.append("\n");
					}
					fw.append("\n");
				}
				fw.append("day = "+tmp_day);
				fw.append("\n");
				fw.append("\n");
			}
		}
		
		for(int k=0; k<H; k++)
			for(int i=0; i<Y; i++)
				for(int j=0; j<X; j++)
					if(box[(k*(X+Y))+(i*X)+j] == 0)	day=-1;
		
		bw.write(day+"\n");
		bw.flush();
		
		br.close();
		bw.close();
		fw.close();
	}
}