import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n+1];
        boolean[][] edgeVisited = new boolean[n+1][n+1];
        boolean[][] edgeWay = new boolean[n+1][n+1];
        int[] answer = new int[n+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[1] = 0;
        
        for(int[] e : edge) {
            edgeWay[e[0]][e[1]] = true;
            edgeWay[e[1]][e[0]] = true;
        }
        
        visited[1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        
        int max = 0;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            visited[temp[0]] = true;
            
            for(int i=1; i<=n; i++) {
                if(edgeWay[temp[0]][i] && !visited[i]) {
                    edgeWay[temp[0]][i] = false;
                    edgeWay[i][temp[0]] = false;
                    q.add(new int[]{i, temp[1]+1});
                }
            }
            if(max < temp[1]) {
                if(answer[temp[0]] < temp[1]) continue;
                answer[temp[0]] = Math.min(temp[1], answer[temp[0]]);
                max = temp[1];
            } else if(max == temp[1]) answer[temp[0]] = Math.min(temp[1], answer[temp[0]]);
        }
        
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            // System.out.println(answer[i]);
            if(answer[i] == max) {
                cnt++;
            }
        }
        // System.out.println(max);
        return cnt;
    }
}