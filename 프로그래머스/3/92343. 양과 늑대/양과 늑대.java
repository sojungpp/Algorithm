import java.util.*;

class Solution {
    int[][] edges;
    int[] info;
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        this.info = info;
        this.edges = edges;
        
        dfs(0, 1, 0, visited);
        
        return answer;
    }
    
    private void dfs(int idx, int sheep, int wolf, boolean[] visited) {
        visited[idx] = true;
        if(wolf >= sheep) return;
        
        for(int[] edge : edges) {
            if(visited[edge[0]] && !visited[edge[1]]) {
                boolean[] tempVisited = visited.clone();
                if(info[edge[1]] == 0) dfs(edge[1], sheep+1, wolf, tempVisited);
                else dfs(edge[1], sheep, wolf+1, tempVisited);
            }
        }
        
        answer = Math.max(answer, sheep);
    }
}