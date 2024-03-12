import java.util.*;

class Main {
    
    static int N;
    static int M;
    static int[][] ways;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    private static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        
        while(!q.isEmpty()){
            int[] target = q.poll();
            int targetX = target[0];
            int targetY = target[1];

            for(int i=0; i<4; i++){
                int nextX = targetX + dx[i];
                int nextY = targetY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(visited[nextX][nextY] || ways[nextX][nextY] == 0) continue;

                q.add(new int[] {nextX, nextY});
                ways[nextX][nextY] = ways[targetX][targetY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ways = new int[N][M];
        visited = new boolean[N][M];  
        visited[0][0] = true; 

        for(int i=0; i<N; i++){
            String s = sc.next();
            for(int j=0; j<M; j++){
                ways[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(ways[N-1][M-1]);
    }
}