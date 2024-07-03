import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int answer = Integer.MAX_VALUE;
    static int N, M;
    static int[][] ways;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ways = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                ways[i][j] = sc.nextInt();
            }
        }

        Queue<int[]> q = new LinkedList<>();
        // 첫 번째 가능한 경우
        for(int i=0; i<M; i++){
            if(i != 0) q.add(new int[]{0, i, ways[0][i], 0});
            q.add(new int[]{0, i, ways[0][i], 1});
            if(i != M-1)  q.add(new int[]{0, i, ways[0][i], 2});
        }
        
        // 가능한 방향
        int[] dy = new int[]{-1, 0, 1};
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            for(int i=0; i<dy.length; i++){
                int tempX = temp[0] + 1;
                int tempY = temp[1] + dy[i];
                if(tempX == N){
                    answer = Math.min(answer, temp[2]);
                    continue;
                }
                // 연속 같은 방향으로 가려는 경우 제외
                if(temp[3] == i) continue;
                if(tempY >= 0 && tempY < M) q.add(new int[]{tempX, tempY, temp[2] + ways[tempX][tempY], i});
            }
        }
        System.out.println(answer);
    }
}