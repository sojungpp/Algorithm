import java.util.*;

class Main {

    static int answer = 0;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int M;
    static int N;
    static int count = 0;

    private static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            if(nowX>=0 && nowY>=0 && nowX<M && nowY<N && !visited[nowY][nowX] && matrix[nowY][nowX] == 1){
                dfs(nowX, nowY);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
          M = sc.nextInt(); // 가로
          N = sc.nextInt(); // 세로
          int K = sc.nextInt();
          matrix = new int[N][M];
          visited = new boolean[N][M];
        
          for(int i=0; i<K; i++){
              int x = sc.nextInt();
              int y = sc.nextInt();
              matrix[y][x] = 1;
          }

          count = 0;
          for(int j=0; j<N; j++){
              for(int p=0; p<M; p++){
                  if(!visited[j][p] && matrix[j][p] == 1){
                      count++;
                      dfs(p, j);
                  }
              }
          }
          System.out.println(count);
        }
    }
}