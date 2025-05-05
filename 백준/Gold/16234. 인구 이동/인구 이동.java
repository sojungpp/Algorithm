import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, L, R;
    static boolean[][] visited;
    static int[][] country;
    static boolean isMove;
    
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        country = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = move();
        System.out.println(answer);
    }

    // 인구 이동
    private static int move() {
        int cnt = 0;
        while(true) {
            isMove = false;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if(isMove) cnt++;
            else break;
        }
        return cnt;
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        int sum = country[x][y];
        q.add(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        // 연합 찾기
        while(!q.isEmpty()) {
            Node temp = q.poll();
            for(int i=0; i<4; i++) {
                int tempX = temp.x+dx[i];
                int tempY = temp.y+dy[i];

                if(!isValid(tempX, tempY) || visited[tempX][tempY]) continue;
                int diff = Math.abs(country[temp.x][temp.y] - country[tempX][tempY]);
                if(diff >= L && diff <= R) {
                    visited[tempX][tempY] = true;
                    q.add(new Node(tempX, tempY));
                    list.add(new Node(tempX, tempY));
                    sum += country[tempX][tempY];
                }
            }
        }

        // 연합 내 이동
        if(list.size() > 1) {
            isMove = true;
            int value = sum / list.size();
            for(Node n : list) {
                country[n.x][n.y] = value;
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<N;
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}