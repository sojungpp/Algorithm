import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static int[][] area;
    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        area = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while(!isMelted()) {
            if(isSeparated()) {
                System.out.println(time);
                return;
            }
            time++;

            int[][] tempArea = new int[N][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(area[i][j] == 0) continue;
                    int waterNum = 0;
                    for(int k=0; k<4; k++) {
                        int tempX = i+dx[k];
                        int tempY = j+dy[k];
                        if(isValid(tempX, tempY) && area[tempX][tempY] == 0) waterNum++;
                    }
                    if(area[i][j] - waterNum < 0) tempArea[i][j] = 0;
                    else tempArea[i][j] = area[i][j] - waterNum;
                }
            }
            area = tempArea;
        }
        System.out.println(0);
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<M;
    }

    private static boolean isSeparated() {
        visited = new boolean[N][M];
        int areaNum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(area[i][j] != 0 && !visited[i][j]) {
                    areaNum++;
                    if(areaNum >= 2) return true;
                    visited[i][j] = true;
                    dfs(i, j);
                }
            }
        }
        return false;
    }

    private static void dfs(int x, int y) {

        for(int i=0; i<4; i++) {
            int tempX = x+dx[i];
            int tempY = y+dy[i];
            if(isValid(tempX, tempY) && !visited[tempX][tempY] && area[tempX][tempY] != 0) {
                visited[tempX][tempY] = true;
                dfs(tempX, tempY);
            }
        }
    }
    
    private static boolean isMelted() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(area[i][j] != 0) return false;
            }
        }
        return true;
    }
}