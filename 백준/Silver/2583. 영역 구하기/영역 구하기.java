import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int M;
    static int N;
    static int K;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Integer> answer = new ArrayList<>();
    static int size;

    private static int dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if(isValid(nowX, nowY) && !visited[nowX][nowY]){
                size++;
                dfs(nowX, nowY);
            }
        }
        return size;
    }

    private static boolean isValid(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        visited = new boolean[N][M];

        for(int i=0; i<K; i++){
            int[] left = {sc.nextInt(), sc.nextInt()};
            int[] right = {sc.nextInt(), sc.nextInt()};
            for(int x=left[0]; x<right[0]; x++){
                for(int y=left[1]; y<right[1]; y++){
                    visited[x][y] = true;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]) {
                    size = 1;
                    answer.add(dfs(i, j));
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i) + " ");
        }
    }
}