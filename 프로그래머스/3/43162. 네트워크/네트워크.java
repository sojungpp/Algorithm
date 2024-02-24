class Solution {
    
    private void dfs(int i, boolean[] visited, int[][] computers){
        visited[i] = true;
        for(int j=0; j<computers.length; j++){
            if(!visited[j] && computers[i][j] == 1) dfs(j, visited, computers);
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[computers.length];
        int answer = 0;
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i]) {
                answer++;
                dfs(i, visited, computers);
            }
        }
        return answer;
    }
}