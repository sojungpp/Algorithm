import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, X;
    static int[][] map, r_map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        r_map = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            map[start][end] = time;
            r_map[end][start] = time;
        }

        int[] go = dijkstra(map);
        int[] back = dijkstra(r_map);

        int answer = 0;
        for(int i=1; i<=N; i++) {
            answer = Math.max(answer, go[i] + back[i]);
        }
        System.out.println(answer);
    }

    private static int[] dijkstra(int[][] map) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{X, 0});
        int[] answer = new int[N+1];
        Arrays.fill(answer, 987654321);
        answer[X] = 0;

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            for(int i=1; i<=N; i++) {
                if(i == temp[0]) continue;
                if(map[temp[0]][i] != 0 && answer[i] > answer[temp[0]] + map[temp[0]][i]) {
                    answer[i] = answer[temp[0]] + map[temp[0]][i];
                    pq.add(new int[]{i, answer[i]});
                }
            }
        }

        return answer;
    }
}