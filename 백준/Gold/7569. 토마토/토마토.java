import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int answer, M, N, H;
    static int[][][] tomato;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        tomato = new int[N][M][H];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    tomato[j][k][i] = sc.nextInt();
                    if(tomato[j][k][i] == 1) q.add(new int[]{j, k, i, 0});
                }
            }    
        }

        if(q.isEmpty()){
            System.out.println(-1);
            return;
        }
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            answer = Math.max(temp[3], answer);
            
            for(int i=0; i<6; i++){
                int nowX = temp[0] + dx[i];
                int nowY = temp[1] + dy[i];
                int nowZ = temp[2] + dz[i];

                if(isValid(nowX, nowY, nowZ) && tomato[nowX][nowY][nowZ] == 0){
                    tomato[nowX][nowY][nowZ] = 1;
                    q.add(new int[]{nowX, nowY, nowZ, temp[3]+1});
                }
            }
        }

        if(check()) System.out.println(answer);
        else System.out.println(-1);        
    }

    private static boolean check() {
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(tomato[j][k][i] == 0) return false;
                }
            }    
        }
        return true;
    }

    private static boolean isValid(int x, int y, int z) {
        return x>=0 && y>=0 && z>=0 && x<N && y<M && z<H;
    }
}