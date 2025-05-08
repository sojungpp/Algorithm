import java.util.*;

class Solution {
    int answer = 0;
    Set<Integer>[] set;
    boolean[] visited;
    int[] arr = new int[5];
    
    public int solution(int n, int[][] q, int[] ans) {
        visited = new boolean[n+1];
        set = new HashSet[q.length];
        for(int i=0; i<q.length; i++) {
            set[i] = new HashSet<>();
            for(int j=0; j<q[i].length; j++) {
                set[i].add(q[i][j]);
            }
        }
        
        combination(0, 1, n, q, ans);
        return answer;
    }
    
    private void combination(int cnt, int now, int n, int[][] q, int[] ans) {
        if(cnt == 5) {
            if(isPossible(q, ans)) answer++;
            return;
        }
        
        for(int i=now; i<=n; i++) {
            if(visited[i]) continue;
            arr[cnt] = i;
            visited[i] = true;
            combination(cnt+1, i+1, n, q, ans);
            visited[i] = false;
        }
    }
    
    private boolean isPossible(int[][] q, int[] ans) {
        for(int i=0; i<q.length; i++) {
            int sum = 0;
            for(int num : arr) {
                if(set[i].contains(num)) sum++;
            }
            if(ans[i] != sum) return false;
        }
        return true;
    }
}