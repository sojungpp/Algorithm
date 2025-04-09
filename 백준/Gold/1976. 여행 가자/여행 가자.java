import java.util.*;
import java.io.*;

class Main {
    static boolean[][] city;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    city[i][j] = true;
                }
            }
        }

        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        boolean isPossible = true;
        for (int i = 1; i < M; i++) {
            boolean[] visited = new boolean[N];
            if (!dfs(plan[i - 1], plan[i], visited)) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "YES" : "NO");
    }

    private static boolean dfs(int start, int end, boolean[] visited) {
        if (start == end) return true;
        visited[start] = true;

        for (int i = 0; i < N; i++) {
            if (city[start][i] && !visited[i]) {
                if (dfs(i, end, visited)) return true;
            }
        }

        return false;
    }
}
