import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M, V;
    static boolean[][] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][N+1];
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = true;
            graph[end][start] = true;
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    private static void dfs(int target) {
        visited[target] = true;
        System.out.print(target + " ");

        if(isFinished()) return;
        
        for(int i=1; i<=N; i++) {
            if(graph[target][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static boolean isFinished() {
        for(int i=1; i<=N; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }

    private static void bfs(int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(target);
        visited[target] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");
            
            for(int i=1; i<=N; i++) {
                if(graph[temp][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}