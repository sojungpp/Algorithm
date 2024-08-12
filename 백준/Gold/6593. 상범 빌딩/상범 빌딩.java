import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int L, R, C;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            if(L == 0) break;
            
            boolean[][][] building = new boolean[R][C][L];
            boolean[][][] visited = new boolean[R][C][L];
            int[] end = new int[3];
            Queue<int[]> q = new LinkedList<>();
            int answer = Integer.MAX_VALUE;
             
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String input = sc.next();
                    for(int k=0; k<C; k++){
                        if(input.charAt(k) == '.') building[j][k][i] = true;
                        else if(input.charAt(k) == 'S') {
                            q.add(new int[]{j, k, i, 0});
                            visited[j][k][i] = true;
                        }
                        else if(input.charAt(k) == 'E') {
                            end[0] = j;
                            end[1] = k;
                            end[2] = i;
                            building[j][k][i] = true;
                        }
                    }
                }
            }

            while(!q.isEmpty()){
                int[] temp = q.poll();
                if(temp[0] == end[0] && temp[1] == end[1] && temp[2] == end[2]) {
                    answer = Math.min(answer, temp[3]);
                    continue;
                }

                for(int i=0; i<6; i++){
                    int nowX = temp[0] + dx[i];
                    int nowY = temp[1] + dy[i];
                    int nowZ = temp[2] + dz[i];

                    if(isValid(nowX, nowY, nowZ) && building[nowX][nowY][nowZ] && !visited[nowX][nowY][nowZ]){
                        visited[nowX][nowY][nowZ] = true;
                        q.add(new int[]{nowX, nowY, nowZ, temp[3]+1});
                    }
                }
            }

            if(answer == Integer.MAX_VALUE) System.out.println("Trapped!");
            else System.out.println("Escaped in " + answer + " minute(s).");
            
        }
        
    }

    private static boolean isValid(int x, int y, int z){
        return x>=0 && y>=0 && z>=0 && x<R && y<C && z<L;
    }
}