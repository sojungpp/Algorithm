import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        boolean[][] box = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int tomatoNum = sc.nextInt();
                if(tomatoNum == 0) continue;
                if(tomatoNum == 1) q.add(new int[]{i, j, 0});
                box[i][j] = true;
            }
        }
        
        int day = 0;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            day = temp[2];
            
            for(int i=0; i<4; i++){
                int nowX = temp[0]+dx[i];
                int nowY = temp[1]+dy[i];
                if(isValid(nowX, nowY) && !box[nowX][nowY]) {
                    box[nowX][nowY] = true;
                    q.add(new int[]{nowX, nowY, day+1});
                }
            }
            
        }

        boolean isRipen = true;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!box[i][j]) isRipen = false;
            }
        }
        if(isRipen) System.out.println(day);
        else System.out.println(-1);
    }
}