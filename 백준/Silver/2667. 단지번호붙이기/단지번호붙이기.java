import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int cnt, N;
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int[][] house;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        house = new int[N][N];
        for(int i=0; i<N; i++) {
            String line = sc.next(); 
            for(int j=0; j<N; j++) {
                house[i][j] = line.charAt(j)-'0';
            }
        }
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && house[i][j] == 1){
                    cnt = 1;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    private static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            if(nowX >= 0 && nowY >= 0 && nowX < N && nowY < N && !visited[nowX][nowY] && house[nowX][nowY] == 1){
                cnt++;   
                dfs(nowX, nowY);
            }
        }
    }
}