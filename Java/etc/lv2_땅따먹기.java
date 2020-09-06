
class main{
    public static int N;
    public static double max;
    public static int solution(int[][] board){
        int size = board.length;
        for(int i=1; i<size; i++) {
            board[i][0] += Math.max(board[i-1][1], Math.max(board[i-1][2], board[i-1][3]));
            board[i][1] += Math.max(board[i-1][0], Math.max(board[i-1][2], board[i-1][3]));
            board[i][2] += Math.max(board[i-1][0], Math.max(board[i-1][1], board[i-1][3]));
            board[i][3] += Math.max(board[i-1][0], Math.max(board[i-1][1], board[i-1][2]));
        }
        return Math.max(board[size-1][0], Math.max(board[size-1][1], Math.max(board[size-1][2], board[size-1][3])));
    }

    public static void main(String args[]){
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1},{100,0,9,8}};
        int result = solution(land);
        System.out.println(result);
    }
}