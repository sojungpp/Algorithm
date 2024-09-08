import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] maps;
    static boolean[][][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new boolean[N][M];
        visited = new boolean[2][N][M];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            String[] input = line.split("");
            for(int j=0; j<M; j++) {
                if(input[j].equals("0")) maps[i][j] = true;
                else maps[i][j] = false;
            }
        }

        if(N==1 && M==1) {
            System.out.println(1);
            return;
        }

        int answer = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;


        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            if(answer <= temp[2]) continue;

            if(temp[0] == N-1 && temp[1] == M-1) {
                answer = temp[2];
                break;
            }

            for(int i=0; i<4; i++) {
                int nowX = temp[0] + dx[i];
                int nowY = temp[1] + dy[i];

                if(temp[3] == 0 && isValid(nowX, nowY) && !visited[0][nowX][nowY]) {
                    if(maps[nowX][nowY]) {
                        q.add(new int[]{nowX, nowY, temp[2]+1, temp[3]});
                        visited[0][nowX][nowY] = true;
                    }
                    else {
                        q.add(new int[]{nowX, nowY, temp[2]+1, 1});
                        visited[1][nowX][nowY] = true;
                    }
                }

                if(temp[3] == 1 && isValid(nowX, nowY) && !visited[1][nowX][nowY]) {
                    if(maps[nowX][nowY]) {
                        q.add(new int[]{nowX, nowY, temp[2]+1, temp[3]});
                        visited[1][nowX][nowY] = true;
                    }
                }
            }
        }
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer+1);
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<M; 
    }
}