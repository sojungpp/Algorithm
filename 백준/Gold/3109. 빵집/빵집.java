import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static char[][] road;
    static int R, C;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        road = new char[R][C];
        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for(int j=0; j<C; j++) {
                road[i][j] = input.charAt(j);
            }
        }
        
        // 출발 지점 별 체크
        int answer = 0;
        for(int i=0; i<R; i++) {
            if(isPossible(i, 0)) answer++;
        }
        System.out.println(answer);
    }

    private static boolean isPossible(int x, int y) {
        // 방문 체크
        road[x][y] = '*';
        
        // 빵집에 도착
        if(y == C-1) return true;

        // 오른쪽 위
        if(x > 0 && road[x-1][y+1] == '.') if(isPossible(x-1, y+1)) return true;
        // 오른쪽
        if(road[x][y+1] == '.') if(isPossible(x, y+1)) return true;
        // 오른쪽 아래
        if(x+1 < R && road[x+1][y+1] == '.') if(isPossible(x+1, y+1)) return true;
        return false;
    }
}