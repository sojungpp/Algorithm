import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] answer;
    static List<Node>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        list = new List[V+1];
        answer = new int[V+1];
        
        // 1. 최대 비용으로 거리 초기화
        for(int i=1; i<=V; i++) {
            list[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        // 1. 출발 노드 설정
        dijkstra(K);

        for(int i=1; i<=V; i++) {
            if(answer[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(answer[i]);
        }
    }

    private static void dijkstra(int start) {
        // 2. 비용 기준 오름차순 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        answer[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            int now = temp.idx;
            int cost = temp.cost;
            
            if(cost > answer[now]) continue;
            // 3. 이웃 노드 간의 거리 확인
            for(Node n : list[now]) {
                int tempCost = answer[now] + n.cost;
                // 4. 최소 비용 갱신
                if(tempCost < answer[n.idx]) {
                    answer[n.idx] = tempCost;
                    pq.add(new Node(n.idx, tempCost));
                }
            }
        }
    }

    public static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}