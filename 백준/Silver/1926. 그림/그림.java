import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] img;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;
    static int count;
    static int total;

    private static void dfs(int x, int y){
        visited[x][y] = true;
        count++;
        for(int i=0; i<dx.length; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX <= n && newY <= m && !visited[newX][newY] && img[newX][newY] == 1)
                dfs(newX, newY);
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        img = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                img[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                count = 0; 
                if (!visited[i][j] && img[i][j] == 1) {
                    dfs(i, j);
                    total++;
                    answer = Math.max(answer, count);
                }
            }
        }
        System.out.println(total);
        System.out.println(answer);
    }
}