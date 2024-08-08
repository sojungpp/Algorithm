import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] area = new char[N][N];
        char[][] rgArea = new char[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++){
            String input = br.readLine();
            char[] inputs = input.toCharArray();
            for(int j=0; j<N; j++){
                area[i][j] = inputs[j];
                rgArea[i][j] = inputs[j];
                if(inputs[j] == 'G'){
                    rgArea[i][j] = 'R';
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]) {
                    dfs(i, j, area);
                    cnt++;
                }
            }
        }
        System.out.print(cnt + " ");

        visited = new boolean[N][N];
        cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]) {
                    dfs(i, j, rgArea);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int x, int y, char[][] area){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nowX = x+dx[i];
            int nowY = y+dy[i];

            if(isValid(nowX, nowY) && area[nowX][nowY] == area[x][y] && !visited[nowX][nowY]){
                dfs(nowX, nowY, area);
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<N;
    }

}