import java.util.*;
import java.lang.*;
import java.io.*;

// 트리 경로 중 가장 긴 것
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(0);
            return;
        }

        Map<Integer, List<Node>> map = new HashMap<>();
        for(int i=1; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.get(start).add(new Node(end, value));
            map.get(end).add(new Node(start, value));
        }

        int answer = 0;
        int distance = 0;
        int mid = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        q.add(new Node(1, 0));

        // 1에서 거리 가장 먼 노드
        while(!q.isEmpty()) {
            Node temp = q.poll();
            List<Node> list = map.get(temp.num);
            for(Node node : list) {
                if(!visited[node.num]) {
                    visited[node.num] = true;
                    q.add(new Node(node.num, temp.value+node.value));
                    if(distance <= temp.value + node.value) {
                        mid = node.num;
                        distance = temp.value + node.value;
                    }
                }
            }
        }

        // 먼 노드에서 총 길이 찾기
        visited = new boolean[n+1];
        visited[mid] = true;
        q.add(new Node(mid, 0));

        while(!q.isEmpty()) {
            Node temp = q.poll();
            List<Node> list = map.get(temp.num);
            for(Node node : list) {
                if(!visited[node.num]) {
                    visited[node.num] = true;
                    q.add(new Node(node.num, temp.value+node.value));
                    answer = Math.max(answer, temp.value + node.value);
                }
            }
        }
        System.out.println(answer);
    }

    public static class Node {
        int num;
        int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}