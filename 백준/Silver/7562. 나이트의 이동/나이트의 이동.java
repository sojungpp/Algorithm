import java.util.*;
import java.lang.*;
import java.io.*;
class Main {

    static int N;
    static int[] now, target;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            now = new int[2];
            target = new int[2];

            st = new StringTokenizer(br.readLine());
            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{now[0], now[1], 0});
            visited[now[0]][now[1]] = true;

            int result = Integer.MAX_VALUE;
            while(!q.isEmpty()){
                int[] temp = q.poll();
                if(result < temp[2]) continue;
                
                if(temp[0] == target[0] && temp[1] == target[1]){
                    result = Math.min(temp[2], result);
                    break;
                }

                for(int j=0; j<dx.length; j++){
                    int nowX = temp[0] + dx[j];
                    int nowY = temp[1] + dy[j];
                    if(isValid(nowX, nowY) && !visited[nowX][nowY]) {
                        q.add(new int[]{nowX, nowY, temp[2]+1});
                        visited[nowX][nowY] = true;
                    }
                }
            }
            if(result == Integer.MAX_VALUE) result = 0;
            System.out.println(result);
        }
    }

    private static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<N && y<N;
    }
}