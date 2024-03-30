import java.util.*;

class Solution {
    static int n;
    static int m;
    static int[] end;
    static boolean[][] visited;
    static String[][] matrix;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    private int bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int tempX = now[0];
            int tempY = now[1];
            int cnt = now[2];
            
            if(tempX==end[0] && tempY==end[1]) return cnt;
            
            for(int i=0; i<4; i++){
                int nowX = tempX;
                int nowY = tempY;
                
                while(isValid(nowX, nowY) && !matrix[nowX][nowY].equals("D")){
                    nowX += dx[i];
                    nowY += dy[i];
                }
                nowX -= dx[i];
                nowY -= dy[i];
                
                if(visited[nowX][nowY]) continue;
                q.add(new int[]{nowX, nowY, cnt+1});
                visited[nowX][nowY] = true;
            }
        }
        return -1;
    }
    
    private boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].split("").length;
        int[] start = new int[2];
        end = new int[2];
        matrix = new String[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String[] str = board[i].split("");
            for(int j=0; j<m; j++){
                matrix[i][j] = str[j];
                if(str[j].equals("R")){
                    start[0] = i;
                    start[1] = j;
                }
                if(str[j].equals("G")){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        int answer = bfs(start[0], start[1]);
        return answer;
    }
}