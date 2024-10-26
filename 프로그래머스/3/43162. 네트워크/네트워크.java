import java.util.*;

class Solution {
    boolean[] visited;
    int answer, n;
    int[][] computers;
    
    public int solution(int n, int[][] computers) {
        this.answer = 0;
        this.computers = computers;
        this.visited = new boolean[n];
        this.n = n;
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int x) {
        visited[x] = true;
        
        for(int i=0; i<n; i++) {
            if(computers[x][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}