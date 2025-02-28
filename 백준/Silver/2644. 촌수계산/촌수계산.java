import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static boolean[][] family;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] target = new int[2];
        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        family = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            family[parent][child] = true;
            family[child][parent] = true;
        }

        visited[target[0]] = true;
        dfs(target[0], target[1], 0);

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void dfs(int now, int target, int cnt) {

        if(now == target) {
            answer = Math.min(cnt, answer);
            return;
        }
        
        for(int i=1; i<=n; i++) {
            if(family[now][i] && !visited[i]) {
                visited[i] = true;
                dfs(i, target, cnt+1);
                visited[i] = false;
            }
        }
    }
}