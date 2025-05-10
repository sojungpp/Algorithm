import java.util.*;

// 1번 노드에서 가장 멀리 떨어진 노드의 갯수 (최단경로로 이동했을 때 간선의 개수가 가장 많은 노드)
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1];
        for(int[] e : edge) {
            graph[e[0]][e[1]] = true;
            graph[e[1]][e[0]] = true;
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        q.add(1);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int temp = q.poll();
                for(int j=1; j<=n; j++) {
                    if(graph[temp][j] && !visited[j]) {
                        visited[j] = true;
                        q.add(j);
                    }   
                }
            }
            answer = size;
        }
        return answer;
    }
}