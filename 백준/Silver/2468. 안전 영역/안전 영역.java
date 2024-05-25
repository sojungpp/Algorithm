import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] area;
    static boolean[][] visited;
    static int N;

    private static int find(int depth, int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if(isValid(tempX, tempY) && !visited[tempX][tempY] && area[tempX][tempY] > depth){
                find(depth, tempX, tempY);
            }
        }
        return 1;
    }

    private static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<N && y<N;
    }
    
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        area = new int[N][N];
        int maxDepth = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                area[i][j] = sc.nextInt();
                maxDepth = Math.max(area[i][j], maxDepth);
            }
        }

        for(int depth=0; depth<=maxDepth; depth++){
            visited = new boolean[N][N];
            int temp = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(area[i][j] > depth && !visited[i][j]) temp += find(depth,i,j);
                }
            }
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}