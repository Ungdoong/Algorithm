
public class lv2_가장큰정사각형 {
    public int solution(int [][]board)
    {
        int answer = 0;
        int size_y = board.length;
        int size_x = board[0].length;

        for(int i=0; i<size_y; i++){
            for(int j=0; j<size_x; j++){
                if(board[i][j] == 1){
                    int cx = j+1;
                    int cy = i+1;
                    
                }
            }
        }

        return answer*answer;
    }

    public static void main(String args[]){
        lv2_가장큰정사각형 m = new lv2_가장큰정사각형();
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(m.solution(board));
    }
}