import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<cnt; i++) {
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a+b);
            pq.add(a+b);
        }

        long answer = 0;
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}