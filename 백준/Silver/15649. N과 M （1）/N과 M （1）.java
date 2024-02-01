import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] list;

    private static void dfs(int num) {
        if(num == M) {
            for(int value : list) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[num] = i;
                dfs(num + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        list = new int[M];

        dfs(0);

    }
}
