import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        
        // 탈출할 수 있는지, 얼마나 빨리 탈출할 수 있는지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> fireQ = new LinkedList<>();
        char[][] road = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        int answer = 0;
        
        for(int i=0; i<R; i++) {
            road[i] = br.readLine().toCharArray();
            for(int j=0; j<C; j++) {
                if(road[i][j] == 'J') {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});   
                }
                else if(road[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            answer++;
            int size = fireQ.size();
            for(int i=0; i<size; i++) {
                int[] tempFire = fireQ.poll();
                for(int j=0; j<4; j++) {
                    int fireX = tempFire[0] + dx[j];
                    int fireY = tempFire[1] + dy[j];
                    if(fireX<0 || fireY<0 || fireX>=R || fireY>=C) continue;
                    if(road[fireX][fireY] == 'J' || road[fireX][fireY] == '.') {
                        road[fireX][fireY] = 'F';
                        fireQ.add(new int[]{fireX, fireY});
                    }
                }
            }

            size = q.size();
            for(int i=0; i<size; i++) {
                int[] temp = q.poll();
                for(int j=0; j<4; j++) {
                    int tempX = temp[0] + dx[j];
                    int tempY = temp[1] + dy[j];

                    if(tempX < 0 || tempX >= R || tempY < 0 || tempY >= C) {
                        System.out.println(answer);
                        return;
                    }
                    
                    if(road[tempX][tempY] == '.' && !visited[tempX][tempY]) {
                        visited[tempX][tempY] = true;
                        q.add(new int[]{tempX, tempY});
                    }
                }   
            }          
        }
        System.out.println("IMPOSSIBLE");
    }
}