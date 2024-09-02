import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static boolean[] visited;
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] way;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        way = new int[N+1];
        Arrays.fill(way, Integer.MAX_VALUE);

        for(int i=0; i<=N; i++) {
            graph.add(new LinkedList<>());
        }
                
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cowNum = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, cowNum});
            graph.get(end).add(new int[]{start, cowNum});
        }

        dijkstra(1);
        System.out.println(way[N]);
    }

    private static void dijkstra(int start) {
        // 소의 수 기준 오름차순
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        way[start] = 0;
        q.add(new int[]{start, way[start]});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int end = temp[0];
            int num = temp[1];

            // 방문하지 않고
            if(!visited[end]) {
                visited[end] = true;
                List<int[]> list = graph.get(end);
                for(int i=0; i<list.size(); i++) {
                    // 기존 소의 수보다 더 적은 경우 변경
                    if(num + list.get(i)[1] < way[list.get(i)[0]]) {
                        way[list.get(i)[0]] = num + list.get(i)[1];
                        q.add(new int[]{list.get(i)[0], way[list.get(i)[0]]});
                    }
                }
            }
        }
    }
}