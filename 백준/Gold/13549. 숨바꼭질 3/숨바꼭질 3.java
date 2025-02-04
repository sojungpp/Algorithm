import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));

        while(!q.isEmpty()) {
            Node temp = q.poll();
            visited[temp.now] = true;
            if(temp.now == K) {
                System.out.println(temp.time);
                break;
            }

            if(temp.now*2<=100000 && temp.now != 0 && !visited[temp.now*2]) q.add(new Node(temp.now*2, temp.time));
            if(temp.now-1>=0 && !visited[temp.now-1]) q.add(new Node(temp.now-1, temp.time+1));
            if(temp.now+1<=100000 && !visited[temp.now+1]) q.add(new Node(temp.now+1, temp.time+1));
        }
    }

    public static class Node {
        int now;
        int time;

        public Node(int now, int time) {
            this.now = now;
            this.time = time;
        }
    }
}