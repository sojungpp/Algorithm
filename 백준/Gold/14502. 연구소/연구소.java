import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    // 바이러스는 상하좌우 인접한 빈 칸으로 모두 퍼짐
    // 벽의 개수는 3개
    // 0 = 빈 칸, 1 = 벽, 2 = 바이러스
    static int N, M, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] area = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 3개 세우기
        dfs(0, area);
        System.out.println(answer);
    }

    private static int[][] copyArea(int[][] area) {
        int[][] tempArea = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tempArea[i][j] = area[i][j];
            }
        }
        return tempArea;
    }

    private static void dfs(int sum, int[][] tempArea) {
        if(sum == 3) {
            answer = Math.max(answer, checkSafeArea(tempArea));
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tempArea[i][j] == 0) {
                    int[][] newArea = copyArea(tempArea);
                    newArea[i][j] = 1;
                    dfs(sum+1, newArea);
                }
            }
        }
    }

    private static int checkSafeArea(int[][] tempArea) {
        int sum = 0;
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tempArea[i][j] == 0) sum++;
                if(tempArea[i][j] == 2) q.add(new Node(i, j));
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while(!q.isEmpty()) {
            Node temp = q.poll();
            for(int i=0; i<4; i++) {
                int tempX = temp.x+dx[i];          
                int tempY = temp.y+dy[i];
                if(isValid(tempX, tempY) && tempArea[tempX][tempY] == 0) {
                    tempArea[tempX][tempY] = 2;
                    sum--;
                    q.add(new Node(tempX, tempY));
                }
            }
        }
        return sum;
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<N && y<M;
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