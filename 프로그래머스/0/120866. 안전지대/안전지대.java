class Solution {
    public int N;
    public int[][] board;
    public int answer;
    
    private boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N){
            if(board[x][y] != 1 && board[x][y] != -1) {
                answer--;
                return true;
            }
        }
        return false;
    }
    public int solution(int[][] board) {
        N = board.length;
        this.board = board;
        
        answer = N*N;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 1){
                    answer--;
                    //위
                    if(check(i-1, j)) board[i-1][j] = -1;
                    //아래
                    if(check(i+1, j)) board[i+1][j] = -1;
                    //좌
                    if(check(i, j-1)) board[i][j-1] = -1;
                    //우
                    if(check(i, j+1)) board[i][j+1] = -1;
                    //대각선
                    if(check(i-1, j-1)) board[i-1][j-1] = -1;
                    if(check(i+1, j-1)) board[i+1][j-1] = -1;
                    if(check(i-1, j+1)) board[i-1][j+1] = -1;
                    if(check(i+1, j+1)) board[i+1][j+1] = -1;
                }
            }
        }
        
        return answer;
    }
}