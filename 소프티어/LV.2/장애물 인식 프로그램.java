// https://softeer.ai/practice/6282

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[][] visited;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) {
                if(input.charAt(j) == '0') visited[i][j] = true;
            }
        }

        PriorityQueue<Integer> answer = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }

        System.out.println(answer.size());
        while(!answer.isEmpty()){
            System.out.println(answer.poll());
        }
    }

    private static int bfs(int x, int y) {
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            for(int i=0; i<4; i++) {
                int tempX = temp[0] + dx[i];
                int tempY = temp[1] + dy[i];
    
                if(tempX >=0 && tempY >=0 && tempX<N && tempY<N && !visited[tempX][tempY]) {
                    visited[tempX][tempY] = true;
                    cnt++;
                    q.add(new int[]{tempX, tempY});
                }
            }
        }
        return cnt;
    }
}
