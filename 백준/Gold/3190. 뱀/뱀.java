import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        boolean[][] isApple = new boolean[N][N];
        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            isApple[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        int[] dx = {0, 1, 0, -1}; // 우하좌상
        int[] dy = {1, 0, -1, 0};
        int idx = 0;
        int x = 0;
        int y = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        int answer = 0;

        while(!q.isEmpty()) {
            x += dx[idx];
            y += dy[idx];
            if(!isValid(x, y) || visited[x][y]) break;
            visited[x][y] = true;
            if(isApple[x][y]) {
                isApple[x][y] = false;
            } else {
                Node temp = q.poll();
                visited[temp.x][temp.y] = false;
            }
            q.add(new Node(x, y));
            answer++;

            if(map.containsKey(answer)) {
                String direction = map.get(answer);
                if(direction.equals("L")) {
                    idx = (idx-1+4)%4;
                } else {
                    idx = (idx+1+4)%4;                
                }
            }
        }
        
        System.out.println(answer+1);
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