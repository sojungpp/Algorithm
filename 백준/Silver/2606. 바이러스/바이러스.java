import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] computers = new boolean[N+1][N+1];
        boolean[] worms = new boolean[N+1];
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            computers[start][end] = true;
            computers[end][start] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        worms[1] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();

            for(int i=1; i<=N; i++) {
                if(computers[temp][i] && !worms[i]) {
                    worms[i] = true;
                    q.add(i);
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(worms[i]) answer++;
        }
        System.out.println(answer-1);
    }
}