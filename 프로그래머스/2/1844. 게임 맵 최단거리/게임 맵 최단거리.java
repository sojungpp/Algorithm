import java.util.*;

class Solution {
    int[][] maps;
    boolean[][] visited;
    int n, m;
    int answer = Integer.MAX_VALUE;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        this.maps = maps;
        this.n = maps.length;
        this.m = maps[0].length;
        this.visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            if(temp[0] == n-1 && temp[1] == m-1) {
                return temp[2] + 1;
            }
            
            for(int i=0; i<4; i++) {
                int tempX = temp[0] + dx[i];
                int tempY = temp[1] + dy[i];

                if(isValid(tempX, tempY) && !visited[tempX][tempY] && maps[tempX][tempY] == 1) {
                    visited[tempX][tempY] = true;
                    q.add(new int[]{tempX, tempY, temp[2]+1});
                }
            }
        }
        return -1;
    }
    
    private boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<n && y<m;
    }
}