import java.util.*;

class Solution {
    static String[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] end;
    static int[] lever;
    static int n;
    static int m;
    
    private int[] bfs(int x, int y, int targetX, int targetY){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int nowX = temp[0];
            int nowY = temp[1];
            int cnt = temp[2];
            
            if(nowX == targetX && nowY == targetY){
                return new int[]{nowX, nowY, cnt};
            }
            
            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if(isValid(nextX, nextY) && !matrix[nextX][nextY].equals("X") && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY, cnt+1});
                }
            }
        }
        return new int[]{0, 0, -1};
    }
    
    private boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
    
    public int solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].split("").length;
        int[] start = new int[2];
        end = new int[2];
        lever = new int[2];
        matrix = new String[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            String[] str = maps[i].split("");
            for(int j=0; j<m; j++){
                matrix[i][j] = str[j];
                if(str[j].equals("S")){
                    start[0] = i;
                    start[1] = j;
                }
                if(str[j].equals("L")){
                    lever[0] = i;
                    lever[1] = j;
                }
                if(str[j].equals("E")){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        int[] temp = bfs(start[0], start[1], lever[0], lever[1]);
        visited = new boolean[n][m];
        int[] answer = bfs(temp[0], temp[1], end[0], end[1]);
        if(temp[2]==-1 || answer[2]==-1) return -1;
        return answer[2]+temp[2];
    }
}