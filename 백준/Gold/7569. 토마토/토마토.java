import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int M, N, H;
    static int[][][] tomato;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[N][M][H];
        boolean isFinished = true;
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                    tomato[j][k][i] = Integer.parseInt(st.nextToken());
                    if(tomato[j][k][i] == 1) q.add(new Node(j, k, i));
                    if(tomato[j][k][i] == 0) isFinished = false;
                }
            }
        }

        if(isFinished) {
            System.out.println(0);
            return;
        }
        int answer = 0;
        int[] dx = {0, 0, 1, 0, -1, 0};
        int[] dy = {0, 0, 0, 1, 0, -1};
        int[] dz = {1, -1, 0, 0, 0, 0};
        
        while(!q.isEmpty()) {
            answer++;

            if(isFinished()) {
                System.out.println(answer-1);
                return;
            }
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node temp = q.poll();
                for(int j=0; j<6; j++) {
                    int tempX = temp.x + dx[j];
                    int tempY = temp.y + dy[j];
                    int tempZ = temp.z + dz[j];
                    if(isValid(tempX, tempY, tempZ) && tomato[tempX][tempY][tempZ] == 0) {
                        tomato[tempX][tempY][tempZ] = 1;
                        q.add(new Node(tempX, tempY, tempZ));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isFinished() {
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(tomato[j][k][i] == 0) return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int x, int y, int z) {
        return x>=0 && y>=0 && z>=0 && x<N && y<M && z<H;
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