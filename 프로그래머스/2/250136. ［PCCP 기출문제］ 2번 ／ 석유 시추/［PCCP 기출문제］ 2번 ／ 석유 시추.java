import java.util.*;

class Solution {
    
    int[] dx = {0 ,1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int n, m;
    int[][] land;
    boolean[][] visited;
    Map<Integer, Integer> landSize;
    
    public int solution(int[][] land) {
        this.land = land;
        m = land[0].length;
        n = land.length;
        visited = new boolean[n][m];
        int landNum = 2;
        landSize = new HashMap<>();
        
        // 구역 별 석유량 체크
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    bfs(i, j, landNum);
                    landNum++;
                }
            }
        }
        
        // 최대 위치 찾기
        int answer = 0;
        for(int i=0; i<m; i++) {
            boolean[] checked = new boolean[landNum];
            int sum = 0;
            for(int j=0; j<n; j++) {
                if(land[j][i] > 0 && !checked[land[j][i]]) {
                    checked[land[j][i]] = true;
                    sum += landSize.get(land[j][i]);
                }
            }
            answer = Math.max(sum, answer);
        }
        
        return answer;
    }
    
    private void bfs(int x, int y, int landNum) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 0;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            land[temp[0]][temp[1]] = landNum;
            
            for(int i=0; i<4; i++) {
                int tempX = temp[0] + dx[i];
                int tempY = temp[1] + dy[i];
                
                if(isValid(tempX, tempY) && land[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                    q.add(new int[]{tempX, tempY});
                    visited[tempX][tempY] = true;
                    size++;
                }
            }
        }
        landSize.put(landNum, size+1);
    }
    
    private boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<n && y<m;
    }
}