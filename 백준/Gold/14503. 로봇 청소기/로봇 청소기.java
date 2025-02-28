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

        boolean[][] cleaned = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        Node robot = new Node(Integer.parseInt(st.nextToken()), 
                              Integer.parseInt(st.nextToken()), 
                              Integer.parseInt(st.nextToken())
                            );
        int[][] road = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(robot);
        road[robot.x][robot.y] = -1;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 1;
        
        while(!q.isEmpty()) {
            Node temp = q.poll();
            int direction = temp.z;
            
            boolean isNotCleaned = false;
            for(int i=0; i<4; i++) {
                int tempZ = (direction+3)%4;
                int tempX = temp.x+dx[tempZ];
                int tempY = temp.y+dy[tempZ];

                if(isValid(tempX, tempY) && road[tempX][tempY] == 0) {
                    isNotCleaned = true;
                    road[tempX][tempY] = -1;
                    answer++;
                    q.add(new Node(tempX, tempY, tempZ));
                    break;
                }
                direction = tempZ;
            }

            if(!isNotCleaned) {
                direction = (direction+2)%4;
                int tempX = temp.x + dx[direction];
                int tempY = temp.y + dy[direction];

                if(isValid(tempX, tempY) && road[tempX][tempY] != 1) {
                    q.add(new Node(tempX, tempY, temp.z));
                } else {
                    System.out.println(answer);
                    return;
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
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}