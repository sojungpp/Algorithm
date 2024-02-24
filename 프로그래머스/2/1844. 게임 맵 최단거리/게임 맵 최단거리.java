import java.util.*;

class Solution {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int answer = -1;
    public static int n, m;
    public static int[][] maps;
    
    private void dfs(int x, int y, boolean[][] visited){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int temp[] = q.poll();
            x = temp[0];
            y = temp[1];
            int cnt = temp[2];
        
            if(x == n-1 && y == m-1){
                answer = cnt;
                break;
            }
        
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isValid(nx, ny) && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cnt+1});
                }
            }
        }
    }
    
    private boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= m) return false;
        return true;
    }
    
    public int solution(int[][] maps) {
        this.maps = maps;
        this.n = maps.length; 
        this.m = maps[0].length; 
        boolean[][] visited = new boolean[n][m];
        
        dfs(0, 0, visited);

        return answer;
    }
}