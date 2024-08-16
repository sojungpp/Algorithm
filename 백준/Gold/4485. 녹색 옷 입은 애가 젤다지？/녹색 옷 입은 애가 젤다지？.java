import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] maps;
    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        while(true) {
            index++;
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            maps = new int[N][N];
            visited = new boolean[N][N];
            int[][] answer = new int[N][N];
            
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                    answer[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            q.add(new int[]{0, 0, maps[0][0]});
            visited[0][0] = true;
            

            while(!q.isEmpty()) {
                int[] temp = q.poll();

                for(int i=0; i<4; i++) {
                    int nowX = temp[0] + dx[i];
                    int nowY = temp[1] + dy[i];
                    if(isValid(nowX, nowY) && !visited[nowX][nowY] && answer[nowX][nowY] > (maps[nowX][nowY] + temp[2])) {
                        answer[nowX][nowY] = maps[nowX][nowY] + temp[2];
                        visited[nowX][nowY] = true;
                        q.add(new int[]{nowX, nowY, temp[2]+maps[nowX][nowY]});
                    }
                }
            }

            System.out.println("Problem " + index + ": " + answer[N-1][N-1]);
            
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<N;
    }
}