class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    private void dfs(int exp, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && exp >= dungeons[i][0]){
                visited[i] = true;
                dfs(exp - dungeons[i][1], dungeons, cnt+1);
                visited[i] = false;
            }
        }
        answer = Math.max(cnt, answer);
    }
    
    public int solution(int k, int[][] dungeons) {
        // 최소 필요 피로도 (시작 전 필요한 피로도)
        // 소모 피로도 (탐험 후 소모되는 피로도)
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0); 
        return answer;
    }
}