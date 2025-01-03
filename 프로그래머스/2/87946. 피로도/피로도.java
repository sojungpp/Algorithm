import java.util.*;

class Solution {
    // 최소 필요 피로도, 소모 피로도
    boolean[] visited;
    int answer;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        int now = k;
        
        for(int i=0; i<dungeons.length; i++) {
            now = k;
            visited = new boolean[dungeons.length];
            if(now >= dungeons[i][0]) {
                visited[i] = true;
                now -= dungeons[i][1];
                dfs(now, 1);
            }
        }
        return answer;
    }
    
    private void dfs(int now, int cnt) {
        
        answer = Math.max(cnt, answer);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && now >= dungeons[i][0]) {
                visited[i] = true;
                now -= dungeons[i][1];
                dfs(now, cnt+1);
                visited[i] = false;
                now += dungeons[i][1];
            }
        }
    }
}