package d7;

import java.util.Scanner;
 
public class test {
    /*
     * -문제
     * 손상된 도금 금속판을 다시 도금하여 수리하는 문제
     * 복구는 NxN 정사각형 크기로 다시 도금하는 방식
     * 도금 처리 비용은 floor((n^2)/2  + 2*n/3 + 1)
     * 최소 비용으로 모든 부분을 도금할 수 있는 복구 비용을 계산하는 프로그램
     * 
     * -입력
     * 테스트 케이스
     * s 금속판의 가로 길이
     * n 손상된 부분의 수
     * 손상된 부분이 존재하는 행/열
     * 
     * -출력
     * 복구된 갯수, 행, 열, 도금 처리 범위
     * 
     * -풀이
     * 정오해가 아니라, 근사해
     * 제한시간내에 문제를 풀기위해, 검사 간격을 간헐적으로 줄인다. (n-1, n/2, n/4)
     */
    public static final int ROW = 0;
    public static final int COL = 1;
    public static final int GILDSIZE = 2;
    public static int s, n, ansCnt;
    public static int[][] map = new int[100][100];
    public static int[] cost = new int[101];
    public static int[][] Answer = new int[10000][3];
         
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        System.setIn(new java.io.FileInputStream("res/input_d7_1253.txt"));
        Scanner in = new Scanner(System.in);
         
        for(int i = 1; i <= 100; i++)
        {
            cost[i] = (int)(i*i/2.0 + 2*i/3.0 + 1.0);
        }
        int tcNum = in.nextInt();
        for(int tc = 1; tc <= tcNum; tc++)
        {
            s = in.nextInt();
            n = in.nextInt();
            for(int i = 0; i < s; i++)
            {
                for(int j = 0; j < s; j++)
                {
                    map[i][j] = 0;
                }
            }
            for(int i = 0; i < n; i++)
            {
                int r = in.nextInt() - 1;
                int c = in.nextInt() - 1;
                map[r][c] = 1;
            }
             
            ansCnt = 0;
            solve(0, 0, s, s, true);
            System.out.print("#"+tc+" "+ansCnt);
            for(int i = 0; i < ansCnt; i++)
            {
                System.out.print(" "+Answer[i][ROW]+" "+Answer[i][COL]+" "+Answer[i][GILDSIZE]);
            }
            System.out.println();
        }
    }
    /**
     * 주어진 영역내에, 손상된 영역이 몇개 있는지 반환하는 함수
     * @param row 검사 영역의 행 시작점
     * @param col 검사 영역의 열 시작점
     * @param size 검사 영역의 사이즈, size*size
     * @return 손상된 영역의 갯수
     */
    public static int countDamage(int row, int col, int size)
    {
        int cnt = 0;
        for(int i = row; i < row + size; i++)
        {
            for(int j = col; j < col + size; j++)
            {
                if(map[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
    /**
     * 주어진 영역에 대해, gildSize 도금처리할 때, 복구되는 영역의 좌표와 최대 갯수를 반환하는 함수
     * @param row 도금처리 영역의 행 시작점
     * @param col 도금처리 영역의 열 시작점
     * @param size 도금처리할 맵의 크기
     * @param gildSize 도금처리범위 (3x3, 2x2, 1x1)
     * @return 가장 많이 도금되어진 영역의 행 (maxR),열 (maxC) 값과 도금처리되어진 갯수 (maxCnt)
     */
    public static GildResult gilding(int row, int col, int size, int gildSize)
    {
        int maxCnt = 0, maxRow = -1, maxCol = -1;
        for(int i = row; i <= row + size - gildSize; i++)
        {
            for(int j = col; j <= col + size - gildSize; j++)
            {
                int cnt = countDamage(i, j, gildSize);
                if(cnt > maxCnt)
                {
                    maxCnt = cnt;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new GildResult(maxRow, maxCol, maxCnt);
    }
    /**
     * 주어진 영역에서 currentValue를 찾아 newValue로 마킹해주는 함수
     * @param row 마킹 영역의 행 시작점
     * @param col 마킹 영역의 열 시작점
     * @param size 마킹 영역의 크기 size*size
     * @param currentValue 마킹으로 바꿔질 target
     * @param newValue 새로 마킹할 값
     */
    public static void setMark(int row, int col, int size, int currentValue, int newValue)
    {
        for(int i = row; i < row + size; i++)
        {
            for(int j = col; j < col + size; j++)
            {
                if(map[i][j] == currentValue)
                    map[i][j] = newValue;
            }
        }
    }
    /**
     * gildSize를 줄여가면서 계산하여, 최소비용을 반환하는 함수
     * @param row 문제 풀 영역의 행 시작점
     * @param col 문제 풀 영역의 열 시작점
     * @param mapSize 문제 풀 영역의 크기
     * @param gildSize 도금영역 크기 (3x3, 2x2, 1x1)
     * @param first 재귀호출을 구분하기 위한 flag, 재귀호출은 더 작은 도금영역과 비용 비교를 위해 사용됨
     * @return
     */
    public static int solve(int row, int col, int mapSize, int gildSize, boolean first)
    {
        int sumCost = 0, currentSizeGildingCost, smallerSizeGildingCost;
        while(gildSize > 1) // while문 한번에 하나의 도금영역만 처리
        {
            GildResult gildByCurrentSize = gilding(row, col, mapSize, gildSize);
            if(gildByCurrentSize.cntGild == 0) break; // 도금처리된게 아무것도 없으면, 종료
            currentSizeGildingCost = cost[gildSize]; // gildSize로 1회 도금처리한 비용
                                     
            smallerSizeGildingCost = 0;
            if(gildSize > 2) // N-1의 비용
            {
                GildResult gildBySmallerSize = gilding(gildByCurrentSize.r, gildByCurrentSize.c, gildSize, gildSize-1);
                smallerSizeGildingCost = cost[gildSize - 1];
                setMark(gildBySmallerSize.r, gildBySmallerSize.c, gildSize - 1, 1, 2);
                 
                // 2x2 영역 찾아, 도금후 비용 누적
                GildResult gildBy2x2;
                do
                {
                    gildBy2x2 = gilding(gildByCurrentSize.r, gildByCurrentSize.c, gildSize, 2);
                    if(gildBy2x2.cntGild > 1)
                    {
                        smallerSizeGildingCost += cost[2];
                        setMark(gildBy2x2.r, gildBy2x2.c, 2, 1, 2); // 2x2 마킹
                    }
                } while(gildBy2x2.cntGild > 1);
            }           
            // 자투리로 남은 1x1 영역에 대한 복구비용 계산 후 누적
            smallerSizeGildingCost += cost[1] * countDamage(gildByCurrentSize.r, gildByCurrentSize.c, gildSize);
            setMark(gildByCurrentSize.r, gildByCurrentSize.c, gildSize, 2, 1); // 마킹 복구
             
            // n/2, n/4 단위로 줄여서 검사
            int halfGildSize = 0, quaterGildSize = 0;
            int halfSizeGildingCost = Integer.MAX_VALUE, quarterSizeGildingCost = Integer.MAX_VALUE;
            if(first && gildSize > 6)
            {
                halfGildSize = (gildSize + 1) / 2;
                halfSizeGildingCost = solve(row, col, mapSize, halfGildSize, false);
                quaterGildSize = (gildSize + 1) / 4;
                quarterSizeGildingCost = solve(row, col, mapSize, quaterGildSize, false);
            }
             
            // NxN 비용 vs (N-1)x(N-1) 비용 + 자투리 1x1 비용, N/2 비용, N/4 비용
            if(currentSizeGildingCost <= smallerSizeGildingCost && currentSizeGildingCost <= halfSizeGildingCost && currentSizeGildingCost <= quarterSizeGildingCost)
            {
                setMark(gildByCurrentSize.r, gildByCurrentSize.c, gildSize, 1, first ? 3 : 4);
                sumCost += currentSizeGildingCost;
                if(first)
                {
                    Answer[ansCnt][ROW] = gildByCurrentSize.r + 1;
                    Answer[ansCnt][COL] = gildByCurrentSize.c + 1;
                    Answer[ansCnt++][GILDSIZE] = gildSize;
                }
            }
            else if(smallerSizeGildingCost <= currentSizeGildingCost && smallerSizeGildingCost <= halfSizeGildingCost && smallerSizeGildingCost <= quarterSizeGildingCost)
                gildSize--;
            else if(halfSizeGildingCost <= currentSizeGildingCost && halfSizeGildingCost <= smallerSizeGildingCost && halfSizeGildingCost <= quarterSizeGildingCost)
                gildSize = halfGildSize;
            else
                gildSize = quaterGildSize;
        }
         
        // 남은 1x1 도금 처리
        for(int i = row; i < row + mapSize; i++)
        {
            for(int j = col; j < col + mapSize; j++)
            {
                if(map[i][j] == 1)
                {
                    sumCost += cost[1];
                    if(first)
                    {
                        Answer[ansCnt][ROW] = i + 1;
                        Answer[ansCnt][COL] = j + 1;
                        Answer[ansCnt++][GILDSIZE] = gildSize;
                    }
                }
            }
        }
        if(!first)
            setMark(row, col, mapSize, 4, 1); // 재귀함수용 복구
        return sumCost;
    }
 
}
class GildResult{
    int r, c, cntGild;
 
    public GildResult(int r, int c, int cntGild) {
        super();
        this.r = r;
        this.c = c;
        this.cntGild = cntGild;
    }
}