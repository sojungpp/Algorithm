import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node temp = q.poll();

            if(temp.x == N-1 && temp.y == M-1) {
                System.out.println(temp.cnt);
                return;
            }

            for(int i=0; i<4; i++) {
                int tempX = temp.x+dx[i];
                int tempY = temp.y+dy[i];

                if(isValid(tempX, tempY) && map[tempX][tempY] == '1' && !visited[tempX][tempY]) {
                    visited[tempX][tempY] = true;
                    q.add(new Node(tempX, tempY, temp.cnt+1));
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<M;
    }

    public static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}