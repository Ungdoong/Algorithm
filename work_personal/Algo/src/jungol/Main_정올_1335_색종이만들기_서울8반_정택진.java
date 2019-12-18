package jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정올_1335_색종이만들기_서울8반_정택진 {
	public static short[][] paper;
	public static int white, blue;
	
	public static void partition(int x, int y, int N) {
		boolean flag=false;
		short start=paper[y][x];
		for(int i=y; i<y+N; i++) {
			for(int j=x; j<x+N; j++) {
				if(paper[i][j] != start)	flag=true;
			}
		}
		if(flag) {
			partition(x,     y,     N/2);
			partition(x+N/2, y,     N/2);
			partition(x,     y+N/2, N/2);
			partition(x+N/2, y+N/2, N/2);
		}else {
			if(start == 1)	blue++;
			else if(start == 0) white++;
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1335.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=Integer.parseInt(br.readLine());
		paper=new short[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j]=Short.parseShort(st.nextToken());
			}
		}
		
		white=0;
		blue=0;
		partition(0,0,N);
		
		bw.write(white+"\n"+blue);
		
		br.close();
		bw.close();
	}
}