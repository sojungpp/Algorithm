import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] result = new int[n+1][n+1];
        for(int[] r : results) {
            result[r[0]][r[1]] = 1;
            result[r[1]][r[0]] = -1;
        }
        
        for(int i=1; i<=n; i++) {
            result[i][i] = 0;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(result[i][k] == 1 && result[k][j] == 1) {
                        result[i][j] = 1;
                        result[j][i] = -1;
                    }
                    if(result[i][k] == -1 && result[k][j] == -1) {
                        result[i][j] = -1;
                        result[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(result[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        return answer;
    }
}