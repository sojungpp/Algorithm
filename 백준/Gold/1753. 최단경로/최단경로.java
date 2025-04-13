import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dist;
    static List<Node>[] list;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i=1; i<V+1; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        dijkstra(K);

        for(int i=1; i<V+1; i++) {
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.target;
            int cost = node.cost;

            if(cost > dist[now]) continue;

            for(Node n : list[now]) {
                int tempCost = dist[now] + n.cost;

                if(tempCost < dist[n.target]) {
                    dist[n.target] = tempCost;
                    pq.add(new Node(n.target, tempCost));
                }
            }
        }
    }
    
    public static class Node {
        int target;
        int cost;

        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
}