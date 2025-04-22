import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        boolean[] visited = new boolean[101];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(1, 0));
        visited[1] = true;

        while(!q.isEmpty()) {
            Node temp = q.poll();

            if(temp.now == 100) {
                System.out.println(temp.num);
                return;
            }

            for(int i=1; i<=6; i++) {
                int next = temp.now + i;
                if(next > 100) continue;
                
                if(map.containsKey(next)) {
                    next = map.get(next);
                }

                if(visited[next]) continue;
                else {
                    q.add(new Node(next, temp.num+1));
                    visited[next] = true;
                }
            }
        }

        
    }

    public static class Node {
        int now;
        int num;

        public Node(int now, int num) {
            this.now = now;
            this.num = num;
        }
    }
}