
import java.util.*;

public class Main {
    static int answer = 0;
    static int N, M;
    static int[][] matrix;
    static boolean[] visited;

    private static void dfs(int index) {
        visited[index] = true;
        answer += 1;

        for (int i=1; i<=N; i++) {
            if (matrix[index][i] == 1 && !visited[i]) dfs(i);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrix[a][b] = matrix[b][a] = 1;
        }

        dfs(1);
        System.out.println(answer-1);
    }
}