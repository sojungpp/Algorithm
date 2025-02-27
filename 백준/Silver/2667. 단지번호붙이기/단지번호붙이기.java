import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<Integer> answer = new ArrayList<>();
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int temp = 1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] == '1') {
                    visited[i][j] = true;
                    dfs(i, j);
                    answer.add(temp);
                    temp = 1;
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for(Integer a : answer) {
            System.out.println(a);
        }
    }

    private static void dfs(int x, int y) {
        for(int i=0; i<4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if(isValid(tempX, tempY) && !visited[tempX][tempY] && map[tempX][tempY] == '1') {
                visited[tempX][tempY] = true;
                temp++;
                dfs(tempX, tempY);
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<N;
    }
}