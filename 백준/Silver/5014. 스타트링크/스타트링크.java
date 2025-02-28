import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // 전체 층수
        int S = Integer.parseInt(st.nextToken()); // 현재 위치
        int G = Integer.parseInt(st.nextToken()); // 목표 위치
        int U = Integer.parseInt(st.nextToken()); // 윗층
        int D = Integer.parseInt(st.nextToken()); // 아래층

        boolean[] visited = new boolean[F+1];
        Queue<Node> q = new LinkedList<>();
        visited[S] = true;
        q.add(new Node(S, 0));

        while(!q.isEmpty()) {
            Node temp = q.poll();
            if(temp.stair == G) {
                System.out.println(temp.cnt);
                return;
            }

            if(temp.stair+U <= F && !visited[temp.stair+U]) {
                visited[temp.stair+U] = true;
                q.add(new Node(temp.stair+U, temp.cnt+1));
            }
            if(temp.stair-D >= 1 && !visited[temp.stair-D]) {
                visited[temp.stair-D] = true;
                q.add(new Node(temp.stair-D, temp.cnt+1));
            }
        }
        System.out.println("use the stairs");
        
    }

    static class Node {
        int stair;
        int cnt;

        public Node(int stair, int cnt) {
            this.stair = stair;
            this.cnt = cnt;
        }
    }
}