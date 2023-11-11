import java.util.*;

class Solution {
    int[][] maps;
    int answer = -1;
    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};
    boolean[][] visited;
    int m; // maps[0].length 열
    int n; // maps.length 행
    
    void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{x, y, 1});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int temp[] = q.poll();
            x = temp[0];
            y = temp[1];
            int count = temp[2];
                
            if (x == n-1 && y == m-1) {
                answer = count;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny >= m || ny <0 || nx >=n || nx <0) continue;
                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count+1});
                }
            }
        }

    }
    
    public int solution(int[][] maps) {
        // maps (0 = 벽), (1=길)
        this.maps = maps;
        this.n = maps.length;
        this.m = maps[0].length;
        visited = new boolean[n][m];
        
        bfs(0, 0);
        // 지나가야 하는 칸의 개수의 최솟값 (도착 못 하면 -1)
        return answer;
    }
}