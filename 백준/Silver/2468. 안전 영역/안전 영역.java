import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[][] visited;
    static int[][] area;
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        int maxHeight = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(area[i][j], maxHeight);
            }
        }

        int answer = 0;
        while(maxHeight != 0) {
            int temp = 0;
            maxHeight--;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(area[i][j] > maxHeight && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j, maxHeight);
                        temp++;
                    }
                }
            }
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int height) {
        for(int i=0; i<4; i++) {
            int tempX = x+dx[i];
            int tempY = y+dy[i];

            if(isValid(tempX, tempY) && area[tempX][tempY] > height && !visited[tempX][tempY]) {
                visited[tempX][tempY] = true;
                dfs(tempX, tempY, height);
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<N;
    }

}