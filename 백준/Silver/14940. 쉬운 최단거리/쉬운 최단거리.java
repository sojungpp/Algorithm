import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로

        int[] goal = new int[2];
        int[][] way = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] answer = new int[n][m];
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                way[i][j] = Integer.parseInt(st.nextToken());
                if(way[i][j] == 2){
                    q.add(new int[]{j, i});
                    visited[i][j] = true;
                } else if(way[i][j] == 0){
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i=0; i<4; i++){
                int nowX = temp[0] + dx[i];
                int nowY = temp[1] + dy[i];
                if(nowX >= 0 && nowY >= 0 && nowX < m && nowY < n){
                    if(!visited[nowY][nowX] && way[nowY][nowX] == 1){
                        visited[nowY][nowX] = true;
                        answer[nowY][nowX] = answer[temp[1]][temp[0]] + 1;
                        q.add(new int[]{nowX, nowY});
                    }
                }
            }            
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]) answer[i][j] = -1;
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

        
    }
}