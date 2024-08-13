import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] maps;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        int areaNum = 2;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && maps[i][j] == 1) {
                    dfs(i, j, areaNum);
                    areaNum++;
                }
            }
        }

        for(int i=2; i<areaNum; i++) {
            visited = new boolean[N][N];
            Queue<int[]> q = new LinkedList<>();

            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    if(maps[j][k] == i) {
                        q.add(new int[]{j, k, 0});
                        visited[j][k] = true;
                    }
                }
            }

            while(!q.isEmpty()) {
                int[] temp = q.poll();

                for(int j=0; j<4; j++) {
                    int nowX = temp[0] + dx[j];
                    int nowY = temp[1] + dy[j];
    
                    if(temp[2] >= answer) continue;
    
                    if(isValid(nowX, nowY) && maps[nowX][nowY] != i && maps[nowX][nowY] != 0) {
                        answer = Math.min(answer, temp[2]);
                    }
                        
                    if(isValid(nowX, nowY) && maps[nowX][nowY] == 0 && !visited[nowX][nowY]) {
                        visited[nowX][nowY] = true;
                        q.add(new int[]{nowX, nowY, temp[2]+1});
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean check(int x, int y, int areaNum) {
        for(int i=0; i<4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if(isValid(nowX, nowY) && maps[nowX][nowY] != 0 && maps[nowX][nowY] != areaNum) return true;
        }
        return false;
    }

    private static void dfs(int x, int y, int areaNum) {
        visited[x][y] = true;
        maps[x][y] = areaNum;

        for(int i=0; i<4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            if(isValid(nowX, nowY) && maps[nowX][nowY] == 1) {
                dfs(nowX, nowY, areaNum);
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<N;
    }
}