import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n+1][n+1];
        boolean[][] lose = new boolean[n+1][n+1];
        
        for(int[] result : results) {
            win[result[0]][result[1]] = true;
            lose[result[1]][result[0]] = true;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(win[j][i] && win[i][k]) win[j][k] = true;
                    if(lose[j][i] && lose[i][k]) lose[j][k] = true;
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(win[i][j] || lose[i][j]) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        
        return answer;
    }
}