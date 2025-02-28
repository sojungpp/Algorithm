import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        q.add(N);
        int time = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
        
            for(int i=0; i<size; i++) {
                int temp = q.poll();
                if(temp == K) {
                    System.out.println(time);
                    return;
                }
                if(temp*2 <= 100000 && !visited[temp*2]) {
                    visited[temp*2] = true;
                    q.add(temp*2);
                }
                if(temp+1 <= 100000 && !visited[temp+1]) {
                    visited[temp+1] = true;
                    q.add(temp+1);
                }
                if(temp-1 >= 0 && !visited[temp-1]) {
                    visited[temp-1] = true;
                    q.add(temp-1);
                }
            }
            time++;
        }
        return;
    }
}