import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i=0; i<N; i++) {
            boolean[][] visited = new boolean[N][N];
            visited[0][i] = true;
            dfs(1, visited);
        }
        System.out.println(answer);
    }

    private static void dfs(int cnt, boolean[][] visited) {
        if(cnt == N) {
            answer++;
            return;
        }
        
        for(int i=0; i<N; i++) {
            if(!visited[cnt][i] && isValid(cnt, i, visited)) {
                visited[cnt][i] = true;
                dfs(cnt+1, visited);
                visited[cnt][i] = false;
            }
        }
    }

    private static boolean isValid(int x, int y, boolean[][] visited) {
        // 같은 열
        for(int i=0; i<x; i++) {
            if(visited[i][y]) return false;
        }
        
        // / 대각선
        for(int i=x-1, j=y+1; i>=0 && j<N; i--, j++) {
            if(visited[i][j]) return false;
        }
        
        // \ 대각선
        for(int i=x-1, j=y-1; i>=0 && j>=0; i--, j--) {
            if(visited[i][j]) return false;
        }
        
        return true;
    }

}