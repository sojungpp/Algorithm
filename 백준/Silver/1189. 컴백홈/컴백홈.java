import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int R, C, K, answer;
    static boolean[][] map, visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        visited = new boolean[R][C];
        answer = 0;
        
        for(int i=0; i<R; i++) {
            String input = br.readLine();
            String[] inputs = input.split("");
            for(int j=0; j<C; j++) {
                if(inputs[j].equals(".")) {
                    map[i][j] = true;
                    continue;
                }
                else map[i][j] = false;
            }
        }
        visited[R-1][0] = true;
        dfs(R-1, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int cnt) {
        if(cnt > K) return;
        
        if(x == 0 && y == C-1) {
            if(cnt == K) answer += 1;
            return;
        }

        for(int i=0; i<4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            
            if(isValid(tempX, tempY) && map[tempX][tempY] && !visited[tempX][tempY]) {
                visited[tempX][tempY] = true;
                dfs(tempX, tempY, cnt+1);
                visited[tempX][tempY] = false;
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<R && y<C;
    }
}