import java.util.*;

class Solution {
    int n, answer, temp;
    int[][] wires;
    boolean[][] visited;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;
        this.visited = new boolean[n+1][n+1];
        this.answer = Integer.MAX_VALUE;
        this.temp = 1;
        
        for(int[] wire : wires) {
            visited[wire[0]][wire[1]] = true;
            visited[wire[1]][wire[0]] = true;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(visited[i][j]) {
                    visited[i][j] = false;
                    visited[j][i] = false;
                    temp = 1;
                    check(i);
                    answer = Math.min(answer, Math.abs(n - temp - temp));
                    visited[i][j] = true;
                    visited[j][i] = true;
                }
            }
        }
        
        return answer;
    }
    
    private void check(int index) {
        for(int i=1; i<=n; i++) {
            if(i==index) continue;
            if(visited[index][i]) {
                visited[index][i] = false;
                visited[i][index] = false;
                temp++;
                check(i);
                visited[index][i] = true;
                visited[i][index] = true;
            }
        }
    }
}