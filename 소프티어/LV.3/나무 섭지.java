// https://softeer.ai/practice/7726

import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static boolean[][] visited;
    static int n, m;
    static int[][] mapNum;
    static char[][] road;
    static boolean answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        road = new char[n][m];
        List<int[]> ghosts = new ArrayList<>();
        int[] goal = new int[2];
        int[] start = new int[2];
        mapNum = new int[n][m];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<m; j++) {
                road[i][j] = input.charAt(j);
                mapNum[i][j] = Integer.MAX_VALUE;
                if(road[i][j]=='G') ghosts.add(new int[]{i, j});
                if(road[i][j]=='N') start = new int[]{i, j};
                if(road[i][j]=='D') goal = new int[]{i, j};
            }
        }
        // 유령 움직이기
        moveGhost(ghosts);

        // 남우 움직이기
        if(bfs(start[0], start[1], 0)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean bfs(int x, int y, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, cnt});
        visited = new boolean[n][m];
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tx = temp[0];
            int ty = temp[1];
            int tc = temp[2];

            if(road[tx][ty]=='D') return true;

            for(int i=0; i<4; i++) {
                int tempX = tx+dx[i];
                int tempY = ty+dy[i];
                if(tempX>=0 && tempY>=0 && tempX<n && tempY<m && road[tempX][tempY]!='#' && !visited[tempX][tempY] && mapNum[tempX][tempY] > tc+1) {
                    visited[tempX][tempY] = true;
                    q.add(new int[]{tempX, tempY, tc+1});
                }
            }
        }
        return false;
     }

    private static void moveGhost(List<int[]> ghosts) {
        Queue<int[]> q = new LinkedList<>();
        for(int[] g : ghosts) {
            q.add(new int[]{g[0], g[1], 0});
            mapNum[g[0]][g[1]] = 0;
        }

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tx = temp[0];
            int ty = temp[1];
            int tc = temp[2];

            for(int i=0; i<4; i++) {
                int tempX = tx+dx[i];
                int tempY = ty+dy[i];
                if(tempX>=0 && tempY>=0 && tempX<n && tempY<m && mapNum[tempX][tempY] > tc+1) {
                    mapNum[tempX][tempY] = tc+1;
                    q.add(new int[]{tempX, tempY, tc+1});
                }
            }
            
        }
        
    }
}
