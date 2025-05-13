import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=1; i<=N; i++) {
            map.put(i, new PriorityQueue<>());
        }

        int[] cnt = new int[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> tempMap = map.get(front);
            tempMap.add(back);
            map.put(front, tempMap);
            cnt[back]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1; i<=N; i++) {
            if(cnt[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");

            PriorityQueue<Integer> pq = map.get(temp);
            while(!pq.isEmpty()) {
                int tempPQ = pq.poll();
                cnt[tempPQ]--;
                if(cnt[tempPQ] == 0) q.add(tempPQ);
            }
        }

    }
}