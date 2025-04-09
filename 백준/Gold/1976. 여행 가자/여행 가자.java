import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[][] city;
    static int N, M;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new boolean[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) city[i][j] = true;
            }
        }

        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            plan[i] = Integer.parseInt(st.nextToken())-1;
            
        }
        
        boolean isPossible = true;
        for(int i=1; i<M; i++) {
            visited = new boolean[N];
            if(find(plan[i-1], plan[i])) continue;
            else {
                isPossible = false;
                break;
            }
        }
        if(isPossible) System.out.println("YES");
        else System.out.println("NO");
    }

    // dfs
    private static boolean find(int start, int end) {
        if(start == end) return true;
        visited[start] = true;
        for(int i=0; i<N; i++) {
            if(city[start][i] && !visited[i]) {
                if(find(i, end)) return true;
            }
        }
        return false;
    }
}